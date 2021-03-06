package java7.folkJoin.copy;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class WordCounter {    

    String[] wordsIn(String line) {
        return line.trim().split("(\\s|\\p{Punct})+");
    }
    
    Long occurrencesCount(Document document, String searchedWord) {
        long count = 0;
        for (String line : document.getLines()) {
            for (String word : wordsIn(line)) {
                if (searchedWord.equals(word)) {
                    count = count + 1;
                }
            }
        }
        return count;
    }
    
/* ......................................................................................... */
    
    //싱글 스레드용 
    Long countOccurrencesOnSingleThread(Folder folder, String searchedWord) {
        long count = 0;
        for (Folder subFolder : folder.getSubFolders()) {
            count = count + countOccurrencesOnSingleThread(subFolder, searchedWord);
        }
        for (Document document : folder.getDocuments()) {
            count = count + occurrencesCount(document, searchedWord);
        }
        return count;
    }

    //코어수로 하는게 좋은듯?
    private final ForkJoinPool forkJoinPool = new ForkJoinPool();
    
    Long countOccurrencesInParallel(Folder folder, String searchedWord) {
        return forkJoinPool.invoke(new FolderSearchTask(folder, searchedWord));
    }

    class DocumentSearchTask extends RecursiveTask<Long> {
        private final Document document;
        private final String searchedWord;
        
        DocumentSearchTask(Document document, String searchedWord) {
            super();
            this.document = document;
            this.searchedWord = searchedWord;
        }
        
        @Override
        protected Long compute() {
            return occurrencesCount(document, searchedWord);
        }
    }
    class FolderSearchTask extends RecursiveTask<Long> {
        private final Folder folder;
        private final String searchedWord;
        
        FolderSearchTask(Folder folder, String searchedWord) {
            super();
            this.folder = folder;
            this.searchedWord = searchedWord;
        }
        
        @Override
        protected Long compute() {
            long count = 0L;
            List<RecursiveTask<Long>> forks = new LinkedList<>();
            for (Folder subFolder : folder.getSubFolders()) {
                FolderSearchTask task = new FolderSearchTask(subFolder, searchedWord);
                forks.add(task);
                task.fork();
            }
            for (Document document : folder.getDocuments()) {
                DocumentSearchTask task = new DocumentSearchTask(document, searchedWord);
                forks.add(task);
                task.fork();
            }
            for (RecursiveTask<Long> task : forks) {
                count = count + task.join();
            }
            return count;
        }
    }
    public static void main(String[] args) throws IOException {
    	
    	
    	
        WordCounter wordCounter = new WordCounter();
        //Folder folder = Folder.fromDirectory(new File(args[0]));
        Folder folder = Folder.fromDirectory(new File("C:/java/java7/"));
        // final int repeatCount = Integer.decode(args[2]);
        final int repeatCount = 3;
        long counts;
        long startTime;
        long stopTime;
        
        long[] singleThreadTimes = new long[repeatCount];
        long[] forkedThreadTimes = new long[repeatCount];
        
        for (int i = 0; i < repeatCount; i++) {
            startTime = System.currentTimeMillis();
//            counts = wordCounter.countOccurrencesOnSingleThread(folder, args[1]);
            counts = wordCounter.countOccurrencesOnSingleThread(folder, "System");

            stopTime = System.currentTimeMillis();
            singleThreadTimes[i] = (stopTime - startTime);
            System.out.println(counts + " , single thread search took " + singleThreadTimes[i] + "ms");
        }
        
        for (int i = 0; i < repeatCount; i++) {
            startTime = System.currentTimeMillis();
//            counts = wordCounter.countOccurrencesInParallel(folder, args[1]);
            counts = wordCounter.countOccurrencesInParallel(folder, "System");
            stopTime = System.currentTimeMillis();
            forkedThreadTimes[i] = (stopTime - startTime);
            System.out.println(counts + " , fork / join search took " + forkedThreadTimes[i] + "ms");
        }
        
        System.out.println("\nCSV Output:\n");
        System.out.println("Single thread,Fork/Join");        
        for (int i = 0; i < repeatCount; i++) {
            System.out.println(singleThreadTimes[i] + "," + forkedThreadTimes[i]);
        }
        System.out.println();
    }
}


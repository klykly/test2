package java7;
import java.util.*;
import java.util.concurrent.*;

import org.perf4j.StopWatch;

import static java.util.Arrays.asList;

public class Sums {
    
    static class Sum implements Callable<Long> {
        private final long from;
        private final long to;
            Sum(long from, long to) {
            this.from = from;
            this.to = to;
        }
        
        @Override
        public Long call() {
            long acc = 0;
            for (long i = from; i <= to; i++) {
                acc = acc + i;
            }
            return acc;
        }                
    }
    
    public static void main(String[] args) throws Exception {
        
    	// 시작 부분에 아래처럼 현재 시간을 계산하고

    	long start = System.currentTimeMillis();


    	
    	
//        ExecutorService executor = Executors.newFixedThreadPool(100);
//        List <Future<Long>> results = executor.invokeAll(asList(
//        		new Sum(1, 1_000), new Sum(1, 1_000), new Sum(1, 2_000_000_000), new Sum(1, 1_000_000_000), new Sum(1, 2_000_000_000)
//        ));
//        
////        results.add(executor.submit(new Sum(1, 1_000_000_000)));
////        results.add(executor.submit(new Sum(1, 1_000)));
//        executor.shutdown();
//        for (Future<Long> result : results) {
//            System.out.println(result.get());
//        }       
//        
//    	long end = System.currentTimeMillis();
//
//    	System.out.println( "실행 시간 : " + ( end - start )/1000.0 );  
    	
    	
    	
    	
    	
    	
    	
    	 start = System.currentTimeMillis();
    	 
        ForkJoinPool threadPool = new ForkJoinPool();
        List <Future<Long>> results = threadPool.invokeAll(asList(
        		new Sum(1, 1_000), new Sum(1, 1_000), new Sum(1, 2_000_000_000), new Sum(1, 1_000_000_000), new Sum(1, 2_000_000_000)
        ));
        
        for (Future<Long> result : results) {
            System.out.println(result.get());
        }       
            
        long end = System.currentTimeMillis();

    	System.out.println( "실행 시간 : " + ( end - start )/1000.0 );   

        
    	
    	
    	
    	
    	
    	
   
    }    
}
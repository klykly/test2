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
        
        ExecutorService executor = Executors.newFixedThreadPool(100);
        StopWatch stopWatch = new StopWatch();   
        System.out.println("" + stopWatch.getElapsedTime());
        List <Future<Long>> results = executor.invokeAll(asList(
        		new Sum(1, 1_000_000_000), new Sum(1, 1_000_000_000), new Sum(1, 1_000_000_000), new Sum(1, 1_000_000_000), new Sum(1, 1_000_000_000)
        ));
        
        results.add(executor.submit(new Sum(1, 1_000_000_000)));
        System.out.println("" + stopWatch.getElapsedTime());
//        executor.shutdown();
        System.out.println( "" + stopWatch.getElapsedTime());
        stopWatch.stop();
  	  	System.out.println("Elapsed Time: " + stopWatch.getElapsedTime());
        for (Future<Long> result : results) {
            System.out.println(result.get());
        }                
    }    
}
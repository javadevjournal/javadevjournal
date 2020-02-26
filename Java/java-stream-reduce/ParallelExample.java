import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelExample {
   public static void main(String[] args) {
       Random random = new Random();
       final List<Integer> LARGE_LIST = new ArrayList<>(100000000);

       for (int i = 0; i < 100000000; i++)
           LARGE_LIST.add(random.nextInt(10000));

       Instant startTime = Instant.now();
       int largestNumber = LARGE_LIST.stream().reduce(0, (result, current) -> result > current ? result : current);
       long totalTime = Duration.between(startTime,Instant.now()).toMillis();

       Instant parallelStartTime = Instant.now();
       int largestNumberParallel = LARGE_LIST.parallelStream().reduce(0, (result, current) -> result > current ? result : current, Integer::max);
       long totalTimeParallel = Duration.between(parallelStartTime,Instant.now()).toMillis();
       System.out.println("Largest number sequential : " + largestNumber + " time : " + totalTime);
       System.out.println("Largest number parallel : " + largestNumberParallel + " time : " + totalTimeParallel);
   }
}
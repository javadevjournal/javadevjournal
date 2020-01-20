import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class RunnableTask implements Runnable{
    long startTime;

    RunnableTask(){
        startTime = System.currentTimeMillis();
    }
    @Override
    public void run() {
        System.out.println("Seconds : "+((System.currentTimeMillis() - startTime)/1000));
    }
}

public class ScheduledThreadPoolExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleWithFixedDelay(new RunnableTask(), 3, 2, TimeUnit.SECONDS);
    }
}

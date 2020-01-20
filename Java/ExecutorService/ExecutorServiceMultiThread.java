import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskOne implements Runnable{
    @Override
    public void run() {
        System.out.println("Running task 1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TaskTwo implements Runnable{
    @Override
    public void run() {
        System.out.println("Running task 2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TaskThree implements Runnable{
    @Override
    public void run() {
        System.out.println("Running task 3");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExecutorServiceMultiThread {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        TaskOne firstTask = new TaskOne();
        TaskTwo secondTask = new TaskTwo();
        TaskThree thirdTask = new TaskThree();

        service.execute(firstTask);
        service.execute(secondTask);
        service.execute(thirdTask);

        service.shutdown();
    }
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExampleTask implements Runnable{
    private int id;

    ExampleTask(int id){
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Started : "+id);
            Thread.sleep(5000);
            System.out.println("Completed : "+id);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class ExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i = 0; i< 10; i++){
            service.execute(new ExampleTask(i));
        }
        service.shutdown();
    }
}

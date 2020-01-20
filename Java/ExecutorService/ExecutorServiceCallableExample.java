import java.util.concurrent.*;

class CallableTask implements Callable<Integer>{
    private int id;

    CallableTask(int id){
        this.id = id;
    }
    @Override
    public Integer call() {
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return id;
    }
}

public class ExecutorServiceCallableExample {

    static void printFutureData(Future future){
        System.out.println("isDone : "+future.isDone());

        try {
            System.out.println("get : "+future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future future = service.submit(new CallableTask(1));
        service.shutdown();

        while(!future.isDone()){
            try {
                System.out.println("Waiting for the Future to complete ...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printFutureData(future);
    }
}

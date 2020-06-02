

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;

public class SemaphoreExample {

    public static int j=0;
    public static void main(String []args) {

        Semaphore semaphore = new Semaphore(4);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for(int i=1 ; i< 10; i++) {

            executorService.submit(new Runnable(){
                    public void run() {
                        int k = ++j;
                        try {
                            semaphore.acquire();
                            System.out.println(k +"will be there for 5 sec");
                            Thread.sleep(5000);
                        }
                        catch(Exception e) {
                            System.out.print(e.getMessage());
                        }
                        finally {
                            semaphore.release();
                            System.out.println(k +"completed his show, going to exit");
                        }
                    }
                });
        }

    }

}


import java.util.concurrent.CountDownLatch;

public class CountDownExample {

    public static int i=0;
    public static void main(String[] args) throws Exception{

        System.out.println("Show Thread has started ");
        CountDownLatch latches = new CountDownLatch(4);
        for(i=1;i<=4;i++) {
            new Thread(new Runnable() {
                    final int j=i;
                    public void run() {
                        CountDownLatch latch = latches;
                        System.out.println(j+" is watching the play");
                        try {
                            Thread.sleep(j*2000);

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        finally {
                            latch.countDown();
                            System.out.println(j+" going to exit");
                        }

                    }

                }).start();
        }

        System.out.println("Theatre is going to close");
        latches.await();   
        System.out.println("Theatre closed");

    }
}

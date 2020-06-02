
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static int i = 0;
    public static void main(String[] args) throws Exception {
        System.out.println("Participants are on the way, coming in just 4 sec");
        Runnable completion = () -> System.out.println("Everyone reached, now meeting can start");
        CyclicBarrier barrier  = new CyclicBarrier(4, completion);

        for(i=1;i<4;i++) {
            new Thread(new Runnable() {
                    final int j = i;
                    public void run() {
                        System.out.println(j+" is on the way, take 2 sec to reach");
                        try {
                            Thread.sleep(2000);
                            System.out.println(j+" reached waiting for others");
                            barrier.await();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }
                }).start();
            }

            Thread.sleep(4000);
            System.out.println("Last participant is almost reached");
            barrier.await();
    }
}
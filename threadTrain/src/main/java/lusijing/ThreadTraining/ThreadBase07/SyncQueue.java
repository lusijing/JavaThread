package lusijing.ThreadTraining.ThreadBase07;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by hand on 2017/9/14.
 */
public class SyncQueue {

    public static void main(String[] args) {

        
        final SynchronousQueue queue = new SynchronousQueue();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println(queue.take());
                    System.out.println(queue.peek() + "....."+queue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    queue.put("admin");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
    }
}

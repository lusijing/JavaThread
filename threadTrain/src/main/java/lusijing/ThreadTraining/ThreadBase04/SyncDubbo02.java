package lusijing.ThreadTraining.ThreadBase04;

/**
 * Created by hand on 2017/9/11.
 */
public class SyncDubbo02 {

    static class Main{
        public int i = 10;
        public synchronized void op(){
            try {
                i--;
                System.out.println("main 输出 ："+ i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class sub extends Main{
        public synchronized void op2(){
            try {
                while (i>0){
                    i--;
                    System.out.println("sub 输出 ："+ i);
                    Thread.sleep(100);
                    this.op();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                sub sub = new sub();
                sub.op2();
            }
        });
        thread.start();
    }
}

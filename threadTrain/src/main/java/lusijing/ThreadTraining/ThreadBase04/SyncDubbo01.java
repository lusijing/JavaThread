package lusijing.ThreadTraining.ThreadBase04;

/**
 * Created by hand on 2017/9/11.
 * 锁的重入
 */
public class SyncDubbo01 {
    public synchronized void method01(){
        method02();
        System.out.println("method01");
    }
    public synchronized void method02(){
        method03();
        System.out.println("method02");
    }
    public synchronized void method03(){
        System.out.println("method03");
    }

    public static void main(String [] strings){
        final SyncDubbo01 syncDubbo = new SyncDubbo01();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                syncDubbo.method01();
            }
        });
        thread.start();
    }
}

package lusijing.ThreadTraining.ThreadBase07;

/**
 * Created by hand on 2017/9/13.
 */
public class ConnThreadLocal {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public void setThreadLocal(String value){
        threadLocal.set(value);
    }
    public void getThreadLocal(){
        System.out.println("当前：" + Thread.currentThread().getName() + ":" +threadLocal.get());
    }

    public static void main(String[] args) {

        final ConnThreadLocal connThreadLocal = new ConnThreadLocal();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                connThreadLocal.setThreadLocal("lsj");
                connThreadLocal.getThreadLocal();
            }
        },"thread1");

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                connThreadLocal.setThreadLocal("lsj 二号");
                connThreadLocal.getThreadLocal();
            }
        },"thread2");

        thread1.start();
        thread2.start();
    }
}

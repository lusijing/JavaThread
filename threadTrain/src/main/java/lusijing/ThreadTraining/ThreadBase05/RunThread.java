package lusijing.ThreadTraining.ThreadBase05;

/**
 * Created by hand on 2017/9/11.
 * volatile
 */
public class RunThread extends Thread {

    private volatile boolean isRunning = true;

    private void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("我进来了。。。。。");
        while(isRunning == true){

        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) throws InterruptedException {

        RunThread runThread = new RunThread();
        runThread.start();
        Thread.sleep(2000);
        runThread.setRunning(false);
        Thread.sleep(1000);
        System.out.println("我已经把你设置成:"+runThread.isRunning);
    }
}

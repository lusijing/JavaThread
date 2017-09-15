package lusijing.ThreadTraining.ThreadBase03;

/**
 * Created by hand on 2017/9/11.
 * 脏读
 */
public class DirtyRead {

    private String uName = "admin";
    private String pwd = "admin";

    public synchronized void setValue(String uName , String pwd){
        this.uName = uName;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.pwd = pwd;
        System.out.println("setValue的执行结果：  uName = " + uName + ", pwd = "+pwd);
    }

    public void getValue(){
        System.out.println("getValue的执行结果：  uName = " + this.uName + ", pwd = "+ this.pwd);
    }

    public static void main(String[] strings) throws InterruptedException {
        final DirtyRead dirtyRead = new DirtyRead();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                dirtyRead.setValue("lsj","1234");
            }
        });
        thread.start();

        Thread.sleep(1000);

        dirtyRead.getValue();
    }
}

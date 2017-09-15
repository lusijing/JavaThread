package lusijing.ThreadTraining.ThreadBase02;

/**
 * Created by hand on 2017/9/11.
 * 在静态方法上加上 sync ,表示class类级别锁
 */
public class MultiThread {

    private static int num = 0;

    public synchronized static void printNum(String tag){
        try {
            if("a".equals(tag)){
                num = 100;
                System.out.println("tag a , set num over!");
                Thread.sleep(1000);
            }else {
                num = 200;
                System.out.println("tag b , set num over!");
            }
            System.out.println("tag = "+ tag + ", num = " +num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String [] args){

        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                m1.printNum("a");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }
}

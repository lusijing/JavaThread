package lusijing.ThreadTraining.ThreadBase06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hand on 2017/9/11.
 */
public class ListAdd2 {
    private volatile static List list = new ArrayList();

    public void add(){
        list.add("lsj");
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        final ListAdd2 list2 = new ListAdd2();
        final Object lock = new Object();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    synchronized (lock) {
                        System.out.println("t1启动..");
                        for(int i = 0; i <10; i++){
                            list2.add();
                            System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素..");
                            Thread.sleep(500);
                            if(list2.size() == 5){
                                System.out.println("已经发出通知..");
                                lock.notify();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock){
                    System.out.println("t2 启动。。。");
                    if(list2.size() != 5){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前线程名：" + Thread.currentThread().getName() + "我要停了");
                    throw new RuntimeException();
                }
            }
        },"t2");

        thread2.start();
        thread1.start();
    }
}

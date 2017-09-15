package lusijing.ThreadTraining.ThreadBase06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hand on 2017/9/11.
 */
public class ListAdd {

    private volatile static List list = new ArrayList();

    public void add(){
        list.add("lsj");
    }

    public int getSize(){
        return list.size();
    }

    public static void main(String[] args) {

        final ListAdd list1 = new ListAdd();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0 ; i<=10 ; i++){
                    list1.add();
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "添加元素之后 list1 = " +list.size());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1");

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                while (true){
                    if(list1.getSize() == 5){
                        System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " list size = 5 线程停止..");
                        throw new RuntimeException();
                    }
                }
            }
        },"t2");

        thread1.start();
        thread2.start();
    }
}

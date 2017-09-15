package lusijing.ThreadTraining.ThreadBase08;

import java.util.Random;

/**
 * Created by hand on 2017/9/15.
 */
public class Main {

    public static void main(String[] args) {

        //Runtime.getRuntime().availableProcessors()   当前机器可用processor 线程数;

        System.out.println(Runtime.getRuntime().availableProcessors());
        Master master = new Master(new Worker(),Runtime.getRuntime().availableProcessors());

        Random random = new Random();
        for (int i = 0 ; i <= 100 ;i++){
            Task task = new Task();
            task.setId(i);
            task.setName("任务"+i);
            task.setPrice(random.nextInt(1000));
            master.submit(task);
        }

        master.execute();

        Long start = System.currentTimeMillis();

        while (true){
            if(master.isComplete()){
                Long end = System.currentTimeMillis() - start;
                int ret = master.getResult();
                System.out.println("最终结果："+ret+",执行耗时："+end);
                break;
            }
        }
    }
}

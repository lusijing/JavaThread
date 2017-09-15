package lusijing.ThreadTraining.ThreadBase08;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by hand on 2017/9/15.
 */
public class Master {

    //1.应该有一个承载任务的集合
    private ConcurrentLinkedQueue<Task> workerQueue = new ConcurrentLinkedQueue<Task>();

    //2.使用hashMap 承载所有worker对象
    private HashMap<String ,Thread> workers = new HashMap<String, Thread>();

    //3.使用一个容器承载每一个worker并行执行的结果集
    ConcurrentHashMap<String , Object> resultMap = new ConcurrentHashMap<String , Object>();

    //4.构造方法
    public Master(Worker worker,int workerCount){
        worker.setWorkerQueue(this.workerQueue);
        worker.setResultMap(this.resultMap);
        for (int i = 0; i < workerCount ; i++){
            //每一个key代表一个任务
            workers.put("任务子节点"+i,new Thread(worker));
        }
    }

    //5.提交
    public void submit(Task task){
        this.workerQueue.add(task);
    }

    //6.需要有一个执行方法（启动应用程序，让所有的任务开始工作）
    public void execute(){
        for (Map.Entry<String , Thread> map :  workers.entrySet()){
             map.getValue().start();
        }
    }

    //8.判断线程是否执行完毕
    public boolean isComplete(){
        for (Map.Entry<String , Thread> map :  workers.entrySet()){
            if(map.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    //9.结果汇总
    public int getResult(){
        int count = 0;
        for (Map.Entry<String , Object> map :  resultMap.entrySet()){
            count += (Integer)map.getValue();
        }
        return count;
    }
}

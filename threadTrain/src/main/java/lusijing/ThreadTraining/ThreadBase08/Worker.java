package lusijing.ThreadTraining.ThreadBase08;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by hand on 2017/9/15.
 */
public class Worker implements Runnable{

    private ConcurrentLinkedQueue<Task> workerQueue;
    private ConcurrentHashMap<String , Object> resultMap;
    public void setWorkerQueue(ConcurrentLinkedQueue<Task> workerQueue){
            this.workerQueue = workerQueue;
    };

    public void setResultMap(ConcurrentHashMap<String ,Object> resultMap){
        this.resultMap = resultMap;
    };

    public void run() {
        while (true){
            Task input = workerQueue.poll();
            if(input == null ) break;
            Object output = MyWorkerOne.handle(input);
            resultMap.put(Integer.toString(input.getId()),output);
        }

    }

    public static Object handle(Task input ){
        return null;
    }

}

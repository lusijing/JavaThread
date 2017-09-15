package lusijing.ThreadTraining.ThreadBase08;

/**
 * Created by hand on 2017/9/15.
 */
public class MyWorkerOne extends Worker {

    public static Object handle(Task input ){
        Object object = null;
        try {
            object = input.getPrice();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return object;
    }
}

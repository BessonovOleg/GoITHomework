import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class HomeWork32 implements SquareSum{


    public static void main(String[] args) {
        HomeWork32 hw = new HomeWork32();
        List<int[]> list = new ArrayList<>();
        int[] ar = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println(hw.getSquareSum(ar,4));
    }

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {
        long result = 0;
        List<int[]> list = new ArrayList<>();
        list = separationArray(values,numberOfThreads);

        List<Long> listResult = new ArrayList<>();
        Phaser phaser = new Phaser(1);
        Executor executor = Executors.newFixedThreadPool(numberOfThreads);
        for(int i = 0;i < numberOfThreads; i++) {
            executor.execute(new CalculatorSquareInArray(listResult,phaser,list.get(i)));
        }

        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        //System.out.println("Фаза " + phase + " завершена");
        phaser.arriveAndDeregister();

        for(long l:listResult) {
            result = result + l;
        }


        return result;

    }


    public class CalculatorSquareInArray implements Runnable {

        private List<Long> res;
        private Phaser p;
        private int[] ar;
        private long tmpRes = 0;

        public CalculatorSquareInArray(List<Long> res,Phaser p, int[] ar) {
            this.res = res;
            this.p = p;
            this.ar = ar;
            p.register();
        }

        @Override
        public void run() {
            for(long l:ar) {
                tmpRes = tmpRes + (l*l);
            }
            res.add(tmpRes);
            //System.out.println(Thread.currentThread().getName() + " finished. Result = " + tmpRes);
            p.arriveAndDeregister();
        }
    }



    public List<int[]> separationArray(int[] array, int count) {
        List<int[]> result = new ArrayList<>();
        int indexFrom = 0;
        int indexTo = 0;
        int countElements = 0;

        if (array.length > 0 && count > 0) {
            countElements = array.length / count;
        } else {
            return result;
        }

        if (array.length < count) {
            result.add(array);
        } else {
            for (int i = 0; i < count; i++) {
                if ( (indexFrom + countElements) > array.length || i == (count - 1) ) {
                    indexTo = array.length;
                } else {
                    indexTo = indexFrom + countElements;
                }
                result.add(Arrays.copyOfRange(array, indexFrom, indexTo));
                indexFrom = indexTo;
            }
        }
        return result;
    }

}

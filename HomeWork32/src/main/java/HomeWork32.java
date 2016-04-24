import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
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
        Phaser phaser = new Phaser(numberOfThreads + 1);
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<CalculatorSquareInArray> listTask = new ArrayList<>();

        for(int i = 0;i < numberOfThreads; i++) {
            listTask.add(new CalculatorSquareInArray(phaser,list.get(i)));
            executor.execute(listTask.get(i));
        }

        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        executor.shutdown();

        for(CalculatorSquareInArray Cs:listTask) {
            result = result + Cs.getTmpRes();
        }

        return result;

    }


    public class CalculatorSquareInArray implements Runnable {

        private int[] ar;
        private long tmpRes = 0;
        private Phaser p;

        public CalculatorSquareInArray(Phaser p,int[] ar) {
            this.ar = ar;
            this.p = p;
        }
        @Override
        public void run() {
            for(long l:ar) {
                tmpRes = tmpRes + (l*l);
            }
            p.arriveAndAwaitAdvance();
        }

        public long getTmpRes() {
            return tmpRes;
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

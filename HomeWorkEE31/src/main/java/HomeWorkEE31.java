public class HomeWorkEE31 {

    Adjuster adjuster;

    public static void main(String[] args) {
        HomeWorkEE31 hw = new HomeWorkEE31();
        hw.test();
    }


    public void test() {


        adjuster = new Adjuster(10);


        for(int i = 0; i < 100; i++) {
            new Thread(new Worker()).start();
       }
    }

    public class Worker implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " acquire");
            adjuster.acquire();
            System.out.println(Thread.currentThread().getName() + " working");
            adjuster.release();
            System.out.println(Thread.currentThread().getName() + " release");
        }
    }



}

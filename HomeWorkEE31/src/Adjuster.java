
public class Adjuster implements Semaphore {
    private int countPermits;
    private int maxPermits;

    public Adjuster(int permits) {
        countPermits = permits;
        maxPermits = permits;
    }

    @Override
    public synchronized void acquire() {
        // Запрашивает разрешение. Если есть свободное захватывает его.
        // Если нет - приостанавливает поток до тех пор пока не появится свободное разрешение.
        while (true) {
                if (getAvailablePermits() > 0) {
                    maxPermits--;
                    break;
                } else {
                    try {
                        this.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    @Override
    public synchronized void acquire(int permits) {
            for (int i = 0; i < permits; i++) {
                acquire();
            }
    }

    // Отпускает разрешение возвращая его семафору.
    @Override
    public synchronized void release() {
            if (maxPermits < countPermits) {
                maxPermits++;
                this.notify();
            }
    }

    // Отпускает переданое количество разрешений возварщая их семафору.
    @Override
    public synchronized void release(int permits) {
            for (int i = 0; i < permits; i++) {
                release();
            }
    }

    // Возвращает количество свободных разрешений на данный момент.
    @Override
    public synchronized int getAvailablePermits() {
        return maxPermits;
    }
}

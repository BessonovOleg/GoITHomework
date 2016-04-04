
public class Adjuster implements Semaphore {
    private int countPermits;
    private int availablePermits;
    private final Object lock = new Object();

    public Adjuster(int permits) {
        countPermits = permits;
        availablePermits = permits;
    }

    @Override
    public void acquire() {
        // Запрашивает разрешение. Если есть свободное захватывает его.
        // Если нет - приостанавливает поток до тех пор пока не появится свободное разрешение.
        while (true) {
             synchronized (lock) {
                if (getAvailablePermits() > 0) {
                    availablePermits--;
                    break;
                } else {
                    try {
                        lock.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    @Override
    public void acquire(int permits) {
        synchronized (lock) {
            for (int i = 0; i < permits; i++) {
                acquire();
            }
        }
    }

    // Отпускает разрешение возвращая его семафору.
    @Override
    public void release() {
        synchronized (lock) {
            if (availablePermits < countPermits) {
                availablePermits++;
                lock.notify();
            }
        }
    }

    // Отпускает переданое количество разрешений возварщая их семафору.
    @Override
    public void release(int permits) {
        synchronized (lock) {
            for (int i = 0; i < permits; i++) {
                release();
            }
        }
    }

    // Возвращает количество свободных разрешений на данный момент.
    @Override
    public int getAvailablePermits() {
        return availablePermits;
    }
}

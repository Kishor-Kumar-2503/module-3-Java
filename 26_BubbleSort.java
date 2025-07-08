public class BubbleSort {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                System.out.println("Thread 1 - Message " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                System.out.println("Thread 2 - Message " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        t1.start();
        t2.start();
    }
}

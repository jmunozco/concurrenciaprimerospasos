class MiHilo implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " está ejecutando.");
            try {
                Thread.sleep(1000); // El hilo entra en estado de espera
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido.");
            }
        }
    }
}


public class Main1 {
    public static void main(String[] args) {
        MiHilo hilo1 = new MiHilo();
        MiHilo hilo2 = new MiHilo();
        MiHilo hilo3 = new MiHilo();

        Thread t1 = new Thread(hilo1);
        Thread t2 = new Thread(hilo2);
        Thread t3 = new Thread(hilo3);

        t1.start();
        t2.start();
        t3.start();
    }
}
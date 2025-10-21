public class Ej1 {
    public static void main(String[] args) {
        System.out.println("El hilo principal va a dormir durante 1 segundo...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }
        System.out.println("El hilo principal ha despertado.");
    }
}

class Corredor2 implements Runnable {
    private String nombre;

    public void Corredor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println(nombre + " está corriendo...");
        try {
            Thread.sleep((int)(Math.random() * 3000));
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido.");
        }
        System.out.println(nombre + " ha terminado la carrera!");
    }
}

public class Ej3 {
    public static void main(String[] args) {
        Corredor c1 = new Corredor("Corredor 1");
        Corredor c2 = new Corredor("Corredor 2");
        Corredor c3 = new Corredor("Corredor 3");

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);

        t1.start();
        t2.start();
        t3.start();

        System.out.println("La carrera ha comenzado...");
    }
}

class Corredor extends Thread {
    private String nombre;

    public Corredor(String nombre) {
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

public class Ej2 {
    public static void main(String[] args) {
        Corredor c1 = new Corredor("Corredor 1");
        Corredor c2 = new Corredor("Corredor 2");
        Corredor c3 = new Corredor("Corredor 3");

        c1.start();
        c2.start();
        c3.start();
    }
}

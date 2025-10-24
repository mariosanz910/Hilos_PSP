import java.util.ArrayList;
import java.util.List;

class Productora extends Thread {
    private List<Integer> radios;

    public Productora(List<Integer> radios) {
        this.radios = radios;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            radios.add(i);
            System.out.println("Productora generó radio: " + i);
            try {
                Thread.sleep(500); // Simula tiempo de producción
            } catch (InterruptedException e) {
                System.out.println("Error en Productora: " + e.getMessage());
            }
        }
    }
}

class Consumidora extends Thread {
    private List<Integer> radios;

    public Consumidora(List<Integer> radios) {
        this.radios = radios;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            if (!radios.isEmpty()) {
                int radio = radios.remove(0);
                System.out.println("Consumidora creó circunferencia con radio: " + radio);
            } else {
                System.out.println("Consumidora no encontró radio disponible");
            }
            try {
                Thread.sleep(700); // Simula tiempo de consumo
            } catch (InterruptedException e) {
                System.out.println("Error en Consumidora: " + e.getMessage());
            }
        }
    }
}

    class Ej4 {
    public static void main(String[] args) {
        List<Integer> radios = new ArrayList<>();

        Productora p = new Productora(radios);
        Consumidora c = new Consumidora(radios);

        p.start();
        c.start();
    }
}

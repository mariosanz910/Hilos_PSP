import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Caballo extends Thread {
    private String nombre;
    private List<String> resultados;

    public Caballo(String nombre, List<String> resultados) {
        this.nombre = nombre;
        this.resultados = resultados;
    }

    @Override
    public void run() {
        try {
            // Simula el tiempo de carrera aleatorio
            Thread.sleep((int)(Math.random() * 3000));
            synchronized(resultados) {
                resultados.add(nombre);
            }
        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido.");
        }
    }
}

class Carrera implements Runnable {
    private String archivo;
    private String[] nombresCaballos;

    public Carrera(String archivo, String[] nombresCaballos) {
        this.archivo = archivo;
        this.nombresCaballos = nombresCaballos;
    }

    @Override
    public void run() {
        List<String> resultados = Collections.synchronizedList(new ArrayList<>());
        List<Caballo> caballos = new ArrayList<>();

        for (String nombre : nombresCaballos) {
            Caballo c = new Caballo(nombre, resultados);
            caballos.add(c);
            c.start();
        }

        // Esperar a que todos los caballos terminen
        for (Caballo c : caballos) {
            try {
                c.join();
            } catch (InterruptedException e) {}
        }

        // Guardar resultados en fichero
        try (FileWriter fw = new FileWriter(archivo)) {
            for (int i = 0; i < resultados.size(); i++) {
                fw.write((i+1) + "º: " + resultados.get(i) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo en " + archivo);
        }
    }
}

public class Ej5 {
    public static void main(String[] args) {
        String[] carrera1 = {"Rayo", "Tormenta", "Relámpago"};
        String[] carrera2 = {"Trueno", "Centella", "Viento"};

        // Iniciar dos carreras simultáneas
        Thread carreraHilo1 = new Thread(new Carrera("carrera1.txt", carrera1));
        Thread carreraHilo2 = new Thread(new Carrera("carrera2.txt", carrera2));

        carreraHilo1.start();
        carreraHilo2.start();
    }
}

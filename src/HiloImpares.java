import java.util.stream.IntStream;

public class HiloImpares implements Runnable {
    private final String nombre;

    public HiloImpares(String nombre) {
        this.nombre = nombre;
    }

    //Implementacion
    @Override
    public void run() {
        //Usamos Stream
        int suma = IntStream.rangeClosed(1, 10)//Rango de donde hasta donde
                //El filtro con la condicion de impares
                .filter(i -> i % 2 != 0)
                //Mirar que va pasando en cada iteracion y mostrar datos por pantalla
                .peek(i -> {
                    System.out.println("[" + nombre + "] Impar: " + i);
                    //Capturar interrupcion y dormir el hilo 50ms para alternar la CPU
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                })
                //Operacion terminal que suma todos los impares
                .sum();
        System.out.println("[" + nombre + "] Suma total impares: " + suma);
    }
}

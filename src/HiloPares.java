import java.util.stream.IntStream;

public class HiloPares implements Runnable {
    private final String nombre;

    public HiloPares(String nombre) {
        this.nombre = nombre;
    }
    //Implementacion
    @Override
    public void run() {
        //Usamos Stream
        int suma = IntStream.rangeClosed(1, 10)//Rango de que hasta donde
                //El filtro la condicion de salida
                .filter(i -> i % 2 == 0)
                // Mirar que va pasando en cada iteraciòn y aplicar peticiones(imprimir datos)
                .peek(i -> {
                    System.out.println("[" + nombre + "] Par: " + i);
                    //Capaturar errores y duerme el cpu con intinerancia de 50 segundos por procesos(50ms)
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                })
                //Operacion restante para la funcion
                .sum();
        System.out.println("[" + nombre + "] Suma total pares: " + suma);
    }
}

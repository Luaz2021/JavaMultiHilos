public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIO DE EJECUCION MULTIHILO ===");

        // Dos instancias de HiloPares
        Thread pares1 = new Thread(new HiloPares("HiloPares-1"));
        Thread pares2 = new Thread(new HiloPares("HiloPares-2"));

        // Dos instancias de HiloImpares
        Thread impares1 = new Thread(new HiloImpares("HiloImpares-1"));
        Thread impares2 = new Thread(new HiloImpares("HiloImpares-2"));

        // Iniciar los 4 hilos en paralelo
        pares1.start();
        pares2.start();
        impares1.start();
        impares2.start();

        try {
            pares1.join();
            pares2.join();
            impares1.join();
            impares2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Hilo principal interrumpido: " + e.getMessage());
        }

        System.out.println("=== FIN DE EJECUCION (TODOS LOS HILOS FINALIZADOS) ===");
    }
}

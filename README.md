# JavaMultiHilos 🧵

Práctica de programación concurrente y multihilo en Java (Programación de Servicios y Procesos - PSP).

El proyecto demuestra el ciclo de vida de los hilos, la alternancia en el planificador del sistema operativo (Thread Scheduler) y el cálculo acumulativo concurrente mediante la API funcional de Streams (`IntStream`).

---

## 📌 Enunciado y Requisitos

1. **Clases independientes:** Separar la lógica en clases dedicadas (`HiloPares` e `HiloImpares`), implementando la interfaz `Runnable`.
2. **Filtrado y suma:**
   - **Pares:** Filtra números del 1 al 10 y calcula su suma ($2 + 4 + 6 + 8 + 10 = 30$).
   - **Impares:** Filtra números del 1 al 10 y calcula su suma ($1 + 3 + 5 + 7 + 9 = 25$).
3. **Concurrencia real (4 hilos):** Instanciar y arrancar simultáneamente 2 hilos de cada clase compitiendo por la CPU.
4. **Sincronización:** El hilo principal (`main`) coordina la finalización ordenada mediante `join()`.

---

## 🛠️ Arquitectura y Decisiones Técnicas

- **`implements Runnable`:** Desacoplamiento total entre la tarea a ejecutar y el motor de ejecución (`Thread`), siguiendo las buenas prácticas de la JVM y evitando problemas de herencia simple.
- **Streams funcionales (`IntStream`):** Uso de `rangeClosed(1, 10)`, `filter()`, `peek()` para inspección en tránsito y la operación terminal `sum()`.
- **Simulación de latencia (`Thread.sleep(50)`):** Pausa controlada de 50 ms por cada iteración. Fuerza al hilo activo a ceder voluntariamente su turno de CPU, garantizando que el planificador intercale la salida de los 4 hilos en consola.
- **Identificación en consola:** Cada salida incluye el identificador del hilo (`[HiloPares-1]`, `[HiloImpares-2]`, etc.) para verificar la trazabilidad de la concurrencia.

---

## 📂 Estructura del Proyecto

```text
JavaMultiHilos/
├── src/
│   ├── HiloPares.java      # Tarea para cálculo de pares
│   ├── HiloImpares.java    # Tarea para cálculo de impares
│   └── Main.java           # Orquestador: lanza y sincroniza los 4 hilos
├── .gitignore
├── JavaMultiHilos.iml
└── README.md
```

---

## 🚀 Compilación y Ejecución

### Desde Terminal (JDK 17+)

```bash
# 1. Acceder al directorio de fuentes
cd src

# 2. Compilar todas las clases
javac *.java

# 3. Ejecutar la clase principal
java Main
```

### Salida esperada en consola

```text
=== INICIO DE EJECUCION MULTIHILO ===
[HiloImpares-1] Impar: 1
[HiloPares-1] Par: 2
[HiloImpares-2] Impar: 1
[HiloPares-2] Par: 2
[HiloPares-1] Par: 4
...
[HiloImpares-1] Suma total impares: 25
[HiloImpares-2] Suma total impares: 25
[HiloPares-1] Suma total pares: 30
[HiloPares-2] Suma total pares: 30
=== FIN DE EJECUCION (TODOS LOS HILOS FINALIZADOS) ===
```

---

## 📄 Licencia

Proyecto desarrollado con fines académicos para la asignatura de **Programación de Servicios y Procesos (PSP)**.

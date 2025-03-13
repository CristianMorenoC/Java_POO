import java.util.Scanner;

/**
 * Programa de lotería que genera tres números aleatorios
 * y verifica si coinciden con los números 9, 7 y 5.
 * Si los tres números coinciden, el usuario gana.
 */
public class Loteria {
    
    // Números ganadores predefinidos
    private static final int NUMERO_GANADOR_1 = 9;
    private static final int NUMERO_GANADOR_2 = 7;
    private static final int NUMERO_GANADOR_3 = 5;
    
    // Rango de números aleatorios: 0 a RANGO_MAXIMO - 1
    private static final int RANGO_MAXIMO = 10; // Para obtener números del 0 al 9
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== JUEGO DE LOTERÍA ===");
        System.out.println("Números ganadores: " + NUMERO_GANADOR_1 + ", " + NUMERO_GANADOR_2 + ", " + NUMERO_GANADOR_3);
        System.out.println("Generando tres números aleatorios...");
        
        boolean jugarDeNuevo = true;
        
        while (jugarDeNuevo) {
            // Generar tres números aleatorios entre 0 y 9
            int numero1 = generarNumeroAleatorio();
            int numero2 = generarNumeroAleatorio();
            int numero3 = generarNumeroAleatorio();
            
            // Mostrar los números generados
            System.out.println("\nSus números de lotería son:");
            System.out.println("Número 1: " + numero1);
            System.out.println("Número 2: " + numero2);
            System.out.println("Número 3: " + numero3);
            
            // Verificar si los números coinciden con los ganadores
            boolean coincideNumero1 = (numero1 == NUMERO_GANADOR_1);
            boolean coincideNumero2 = (numero2 == NUMERO_GANADOR_2);
            boolean coincideNumero3 = (numero3 == NUMERO_GANADOR_3);
            
            // Mostrar resultados parciales
            System.out.println("\nResultados parciales:");
            System.out.println("Número 1 (" + numero1 + "): " + (coincideNumero1 ? "✓" : "✗") + " - Debe ser " + NUMERO_GANADOR_1);
            System.out.println("Número 2 (" + numero2 + "): " + (coincideNumero2 ? "✓" : "✗") + " - Debe ser " + NUMERO_GANADOR_2);
            System.out.println("Número 3 (" + numero3 + "): " + (coincideNumero3 ? "✓" : "✗") + " - Debe ser " + NUMERO_GANADOR_3);
            
            // Verificar resultado final
            if (coincideNumero1 && coincideNumero2 && coincideNumero3) {
                System.out.println("\n¡GANÓ! ¡Felicidades!");
                System.out.println("Ha acertado los tres números: " + NUMERO_GANADOR_1 + ", " + 
                                 NUMERO_GANADOR_2 + ", " + NUMERO_GANADOR_3);
            } else {
                System.out.println("\nPERDISTE. Sigue intentando.");
                
                // Calcular cuántos números acertó
                int numerosAcertados = 0;
                if (coincideNumero1) numerosAcertados++;
                if (coincideNumero2) numerosAcertados++;
                if (coincideNumero3) numerosAcertados++;
                
                if (numerosAcertados > 0) {
                    System.out.println("Acertaste " + numerosAcertados + " de 3 números.");
                }
            }
            
            // Preguntar si desea jugar de nuevo
            System.out.print("\n¿Desea jugar de nuevo? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            
            jugarDeNuevo = respuesta.equals("s") || respuesta.equals("si");
            
            if (jugarDeNuevo) {
                System.out.println("\nGenerando nuevos números...");
            }
        }
        
        System.out.println("\n¡Gracias por jugar a la lotería!");
        scanner.close();
    }
    
    /**
     * Genera un número aleatorio entre 0 y RANGO_MAXIMO - 1.
     * 
     * @return Un número entero aleatorio
     */
    private static int generarNumeroAleatorio() {
        // Math.random() genera un número entre 0.0 (inclusive) y 1.0 (exclusivo)
        // Multiplicamos por RANGO_MAXIMO y convertimos a entero para obtener un número entre 0 y RANGO_MAXIMO - 1
        return (int) (Math.random() * RANGO_MAXIMO);
    }
}

import java.util.Scanner;

/**
 * Programa para convertir pesos a diferentes divisas internacionales
 */
public class ConversorDivisas {
    // Tasas de cambio (valores ficticios, en una aplicación real deberían actualizarse)
    private static final double TASA_DOLAR = 0.00025;       // 1 peso = 0.00025 USD
    private static final double TASA_EURO = 0.00023;        // 1 peso = 0.00023 EUR
    private static final double TASA_YEN = 0.038;           // 1 peso = 0.038 JPY
    private static final double TASA_LIBRA = 0.00020;       // 1 peso = 0.00020 GBP
    private static final double TASA_FRANCO_SUIZO = 0.00022; // 1 peso = 0.00022 CHF
    private static final double TASA_RUBLO = 0.023;         // 1 peso = 0.023 RUB

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CONVERSOR DE DIVISAS ===");
        System.out.println("Este programa convierte pesos a diferentes monedas internacionales.");
        
        boolean continuar = true;
        
        while (continuar) {
            try {
                System.out.print("\nIngrese la cantidad de pesos a convertir: ");
                double pesos = scanner.nextDouble();
                
                if (pesos < 0) {
                    System.out.println("Por favor, ingrese una cantidad válida (mayor o igual a cero).");
                    continue;
                }
                
                // Realizar las conversiones
                System.out.println("\nResultados de la conversión:");
                System.out.println("---------------------------");
                System.out.printf("%.2f pesos = %.2f dólares (USD)%n", pesos, convertirADolar(pesos));
                System.out.printf("%.2f pesos = %.2f euros (EUR)%n", pesos, convertirAEuro(pesos));
                System.out.printf("%.2f pesos = %.2f yenes (JPY)%n", pesos, convertirAYen(pesos));
                System.out.printf("%.2f pesos = %.2f libras esterlinas (GBP)%n", pesos, convertirALibra(pesos));
                System.out.printf("%.2f pesos = %.2f francos suizos (CHF)%n", pesos, convertirAFrancoSuizo(pesos));
                System.out.printf("%.2f pesos = %.2f rublos rusos (RUB)%n", pesos, convertirARublo(pesos));
                
                // Preguntar si desea realizar otra conversión
                System.out.print("\n¿Desea realizar otra conversión? (s/n): ");
                scanner.nextLine(); // Consumir el salto de línea
                String respuesta = scanner.nextLine().trim().toLowerCase();
                
                if (!respuesta.equals("s") && !respuesta.equals("si")) {
                    continuar = false;
                }
                
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida. Por favor ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        }
        
        System.out.println("\n¡Gracias por usar el conversor de divisas!");
        scanner.close();
    }
    
    // Métodos para convertir a diferentes divisas
    private static double convertirADolar(double pesos) {
        return pesos * TASA_DOLAR;
    }
    
    private static double convertirAEuro(double pesos) {
        return pesos * TASA_EURO;
    }
    
    private static double convertirAYen(double pesos) {
        return pesos * TASA_YEN;
    }
    
    private static double convertirALibra(double pesos) {
        return pesos * TASA_LIBRA;
    }
    
    private static double convertirAFrancoSuizo(double pesos) {
        return pesos * TASA_FRANCO_SUIZO;
    }
    
    private static double convertirARublo(double pesos) {
        return pesos * TASA_RUBLO;
    }
}

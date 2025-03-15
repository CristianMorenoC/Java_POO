import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Programa para calcular la distribución del presupuesto anual
 * de un hospital entre sus diferentes áreas.
 */
public class HospitalAreas {
    // Constantes para los porcentajes asignados a cada área
    private static final double PORCENTAJE_GINECOLOGIA = 0.40; // 40%
    private static final double PORCENTAJE_TRAUMATOLOGIA = 0.15; // 15%
    private static final double PORCENTAJE_PEDIATRIA = 0.15; // 15%
    private static final double PORCENTAJE_URGENCIAS = 0.30; // 30%
    
    public static void main(String[] args) {
        // Scanner para entrada de datos
        Scanner scanner = new Scanner(System.in);
        
        // Formato para valores monetarios
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-CO"));
        
        System.out.println("=== SISTEMA DE DISTRIBUCIÓN DE PRESUPUESTO HOSPITALARIO ===");
        
        try {
            // Solicitar el presupuesto anual
            System.out.print("Ingrese el monto total del presupuesto anual: $");
            double presupuestoTotal = scanner.nextDouble();
            
            // Validar que el presupuesto sea positivo
            if (presupuestoTotal <= 0) {
                System.out.println("Error: El presupuesto debe ser un valor positivo.");
                scanner.close();
                return;
            }
            
            // Calcular la asignación para cada área
            double montoGinecologia = presupuestoTotal * PORCENTAJE_GINECOLOGIA;
            double montoTraumatologia = presupuestoTotal * PORCENTAJE_TRAUMATOLOGIA;
            double montoPediatria = presupuestoTotal * PORCENTAJE_PEDIATRIA;
            double montoUrgencias = presupuestoTotal * PORCENTAJE_URGENCIAS;
            
            // Mostrar los resultados
            System.out.println("\n=== DISTRIBUCIÓN DEL PRESUPUESTO ANUAL ===");
            System.out.println("Presupuesto total: " + formatoMoneda.format(presupuestoTotal));
            System.out.println("\nAsignación por áreas:");
            System.out.println("---------------------------------------");
            System.out.printf("%-20s %10s %15s\n", "ÁREA", "PORCENTAJE", "MONTO ASIGNADO");
            System.out.println("---------------------------------------");
            System.out.printf("%-20s %10s %15s\n", "Ginecología", "40%", formatoMoneda.format(montoGinecologia));
            System.out.printf("%-20s %10s %15s\n", "Traumatología", "15%", formatoMoneda.format(montoTraumatologia));
            System.out.printf("%-20s %10s %15s\n", "Pediatría", "15%", formatoMoneda.format(montoPediatria));
            System.out.printf("%-20s %10s %15s\n", "Urgencias", "30%", formatoMoneda.format(montoUrgencias));
            System.out.println("---------------------------------------");
            System.out.printf("%-20s %10s %15s\n", "Total", "100%", formatoMoneda.format(presupuestoTotal));
            
            // Verificación de la suma (control de calidad)
            double sumaAsignaciones = montoGinecologia + montoTraumatologia + montoPediatria + montoUrgencias;
            if (Math.abs(sumaAsignaciones - presupuestoTotal) > 0.01) {
                System.out.println("\nAdvertencia: Hay una pequeña diferencia en los cálculos debido al redondeo.");
            }
            
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Por favor ingrese un valor numérico para el presupuesto.");
        } finally {
            scanner.close();
        }
    }
}

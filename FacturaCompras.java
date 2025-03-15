import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Programa para generar una factura de compras con cálculo de IVA y descuentos
 */
public class FacturaCompras {
    // Constantes para los cálculos
    private static final double PORCENTAJE_IVA = 0.19; // 19% de IVA
    private static final double PORCENTAJE_DESCUENTO = 0.10; // 10% de descuento
    private static final double UMBRAL_DESCUENTO = 200000.0; // Umbral para aplicar descuento
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Formato para los valores monetarios en pesos colombianos
        NumberFormat formatoPeso = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-CO"));
        
        System.out.println("=== SISTEMA DE FACTURACIÓN TIENDA MI ACA POO ===");
        
        try {
            // Solicitar datos del producto
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            
            System.out.print("Ingrese el precio unitario: ");
            double precioUnitario = scanner.nextDouble();
            
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            
            // Validar datos de entrada
            if (precioUnitario < 0 || cantidad < 0) {
                System.out.println("Error: Los valores de precio y cantidad deben ser positivos.");
                scanner.close();
                return;
            }
            
            // Cálculos de la factura
            double subtotal = precioUnitario * cantidad;
            double iva = subtotal * PORCENTAJE_IVA;
            
            // Determinar si aplica descuento
            double descuento = 0.0;
            if (subtotal > UMBRAL_DESCUENTO) {
                descuento = subtotal * PORCENTAJE_DESCUENTO;
            }
            
            double totalPagar = subtotal + iva - descuento;
            
            // Mostrar la factura con formato
            System.out.println("\n\n");
            System.out.println("=======================================");
            System.out.println("          TIENDA MI ACA POO           ");
            System.out.println("=======================================");
            System.out.println("Producto: \t\t" + nombreProducto);
            System.out.println("Precio: \t\t" + formatoPeso.format(precioUnitario));
            System.out.println("Cantidad: \t\t" + cantidad);
            System.out.println("---------------------------------------");
            System.out.println("Subtotal: \t\t" + formatoPeso.format(subtotal));
            System.out.println("IVA (19%): \t\t" + formatoPeso.format(iva));
            System.out.println("Descuento: \t\t" + formatoPeso.format(descuento));
            System.out.println("---------------------------------------");
            System.out.println("Total a pagar: \t" + formatoPeso.format(totalPagar));
            System.out.println("=======================================");
            
            // Información adicional
            if (descuento > 0) {
                System.out.println("¡Se aplicó un descuento del 10% por compra superior a $200.000!");
            }
            System.out.println("¡Gracias por su compra!");
            
        } catch (Exception e) {
            System.out.println("Error: Entrada no válida. Por favor ingrese valores numéricos correctos.");
        } finally {
            scanner.close();
        }
    }
}

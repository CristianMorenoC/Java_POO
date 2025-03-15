import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Programa para determinar planes de animación para fiestas infantiles en McDonald's
 * según la edad del niño.
 */
public class Mcdonalds {
    // Constantes para precios y horarios
    private static final double PRECIO_BASE = 250000.0; // Precio base de la fiesta
    private static final double PRECIO_TITERES = 120000.0;
    private static final double PRECIO_PAYASOS = 150000.0;
    private static final double PRECIO_CUENTERIA = 100000.0;
    private static final double PRECIO_PONQUE = 80000.0; 
    private static final double PRECIO_CAJITA_FELIZ = 25000.0;
    private static final int DURACION_STANDARD = 3; // Duración estándar en horas
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberFormat formatoPeso = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-CO"));
        
        System.out.println("=== SISTEMA DE PLANES DE FIESTA INFANTIL MCDONALD'S ===");
        System.out.println("Bienvenido al planificador de fiestas infantiles de McDonald's");
        
        try {
            // Recopilar información básica
            System.out.print("Ingrese el nombre del niño/a: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Ingrese la edad del niño/a: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            // Validar edad
            if (edad <= 0) {
                System.out.println("Error: La edad debe ser un número positivo.");
                scanner.close();
                return;
            }
            
            // Variables para determinar el plan
            String tipoAnimacion;
            double precioAnimacion;
            String detallesEspeciales = "";
            double precioTotal;
            
            // Determinar el plan según la edad
            if (edad < 4) {
                tipoAnimacion = "Títeres";
                precioAnimacion = PRECIO_TITERES;
                detallesEspeciales = "- Espectáculo de títeres adaptado para niños pequeños\n" +
                                     "- Área segura para niños menores de 4 años\n" +
                                     "- Asistencia especial para niños pequeños";
            } else if (edad <= 10) {
                tipoAnimacion = "Payasos";
                precioAnimacion = PRECIO_PAYASOS;
                detallesEspeciales = "- Show interactivo de payasos\n" +
                                     "- Juegos grupales dirigidos\n" +
                                     "- Globoflexia y pintacaritas";
            } else {
                tipoAnimacion = "Cuentearía";
                precioAnimacion = PRECIO_CUENTERIA;
                detallesEspeciales = "- Narración de historias interactivas\n" +
                                     "- Actividades temáticas\n" +
                                     "- Juegos de destreza mental y física";
            }
            
            // Calcular precio total
            precioTotal = PRECIO_BASE + precioAnimacion + PRECIO_PONQUE + (PRECIO_CAJITA_FELIZ * 10); // Asumimos 10 invitados
            
            // Información opcional adicional
            System.out.print("¿Desea personalizar el número de invitados? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            
            int numeroInvitados = 10; // Por defecto
            if (respuesta.equals("s") || respuesta.equals("si")) {
                System.out.print("Ingrese el número de invitados: ");
                numeroInvitados = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                
                // Recalcular precio con nuevo número de invitados
                precioTotal = PRECIO_BASE + precioAnimacion + PRECIO_PONQUE + (PRECIO_CAJITA_FELIZ * numeroInvitados);
            }
            
            // Mostrar detalles del plan
            System.out.println("\n\n");
            System.out.println("=========================================================");
            System.out.println("        PLAN DE FIESTA INFANTIL MCDONALD'S              ");
            System.out.println("=========================================================");
            System.out.println("Nombre del cumpleañero: " + nombre);
            System.out.println("Edad: " + edad + " años");
            System.out.println("---------------------------------------------------------");
            System.out.println("INCLUYE:");
            System.out.println("✓ Animación: " + tipoAnimacion);
            System.out.println("✓ Ponqué personalizado");
            System.out.println("✓ Cajitas Felices para " + numeroInvitados + " invitados");
            System.out.println("---------------------------------------------------------");
            System.out.println("DETALLES ESPECIALES DEL PLAN:");
            System.out.println(detallesEspeciales);
            System.out.println("---------------------------------------------------------");
            System.out.println("HORARIOS DISPONIBLES:");
            System.out.println("- Mañana: 10:00 AM - 1:00 PM");
            System.out.println("- Tarde: 2:00 PM - 5:00 PM");
            System.out.println("- Duración: " + DURACION_STANDARD + " horas");
            System.out.println("---------------------------------------------------------");
            System.out.println("DETALLE DE COSTOS:");
            System.out.println("Precio base: " + formatoPeso.format(PRECIO_BASE));
            System.out.println("Animación (" + tipoAnimacion + "): " + formatoPeso.format(precioAnimacion));
            System.out.println("Ponqué personalizado: " + formatoPeso.format(PRECIO_PONQUE));
            System.out.println("Cajitas Felices (" + numeroInvitados + "): " + formatoPeso.format(PRECIO_CAJITA_FELIZ * numeroInvitados));
            System.out.println("---------------------------------------------------------");
            System.out.println("PRECIO TOTAL: " + formatoPeso.format(precioTotal));
            System.out.println("=========================================================");
            System.out.println("¡Gracias por elegir McDonald's para la fiesta de " + nombre + "!");
            System.out.println("Para reservar, comuníquese al 01-8000-MCDONALDS");
            
        } catch (Exception e) {
            System.out.println("Error: Entrada no válida. " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

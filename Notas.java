import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Programa para calcular el promedio de cinco calificaciones
 * y determinar el nivel de desempeño según una escala establecida.
 */
public class Notas {
    // Scanner para entrada de datos
    private static final Scanner scanner = new Scanner(System.in);
    // Formato para redondear a 1 decimal
    private static final DecimalFormat df = new DecimalFormat("#.#");
    
    // Constantes para la escala de calificación
    private static final double NOTA_MINIMA = 1.0;
    private static final double NOTA_MAXIMA = 5.0;
    private static final double UMBRAL_INSUFICIENTE = 2.1;
    private static final double UMBRAL_ACEPTABLE = 3.0;
    private static final double UMBRAL_SOBRESALIENTE = 4.0;
    private static final double UMBRAL_EXCELENTE = 5.0;
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CÁLCULO DE PROMEDIO Y DESEMPEÑO ACADÉMICO ===");
        System.out.println("Por favor, ingrese las cinco calificaciones del alumno (de 1.0 a 5.0)");
        
        try {
            // Array para almacenar las calificaciones
            double[] calificaciones = new double[5];
            double sumaCalificaciones = 0;
            
            // Solicitar las 5 calificaciones
            for (int i = 0; i < 5; i++) {
                boolean notaValida = false;
                
                while (!notaValida) {
                    System.out.print("Ingrese la calificación " + (i + 1) + ": ");
                    double nota = scanner.nextDouble();
                    
                    // Validar que la nota esté dentro del rango permitido
                    if (nota >= NOTA_MINIMA && nota <= NOTA_MAXIMA) {
                        calificaciones[i] = nota;
                        sumaCalificaciones += nota;
                        notaValida = true;
                    } else {
                        System.out.println("Error: La calificación debe estar entre " + 
                                           NOTA_MINIMA + " y " + NOTA_MAXIMA + ". Intente nuevamente.");
                    }
                }
            }
            
            // Calcular el promedio
            double promedio = sumaCalificaciones / 5;
            
            // Determinar el nivel de desempeño
            String desempeno = determinarDesempeno(promedio);
            
            // Mostrar resultados
            System.out.println("\n=== RESULTADO ===");
            System.out.println("Calificaciones ingresadas:");
            for (int i = 0; i < 5; i++) {
                System.out.println("Calificación " + (i + 1) + ": " + calificaciones[i]);
            }
            
            System.out.println("\nPromedio: " + df.format(promedio));
            System.out.println("Nivel de desempeño: " + desempeno);
            
            // Mostrar mensajes adicionales según el desempeño
            if (promedio < UMBRAL_ACEPTABLE) {
                System.out.println("OBSERVACIÓN: El alumno debe mejorar su rendimiento académico.");
            } else if (promedio >= UMBRAL_SOBRESALIENTE) {
                System.out.println("OBSERVACIÓN: ¡Felicitaciones al alumno por su excelente desempeño!");
            }
            
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Determina el nivel de desempeño según el promedio obtenido
     * @param promedio El promedio de las calificaciones
     * @return El nivel de desempeño como texto
     */
    private static String determinarDesempeno(double promedio) {
        if (promedio >= UMBRAL_EXCELENTE) {
            return "EXCELENTE";
        } else if (promedio >= UMBRAL_SOBRESALIENTE) {
            return "SOBRESALIENTE";
        } else if (promedio >= UMBRAL_ACEPTABLE) {
            return "ACEPTABLE";
        } else if (promedio >= UMBRAL_INSUFICIENTE) {
            return "INSUFICIENTE";
        } else {
            return "DEFICIENTE";
        }
    }
}

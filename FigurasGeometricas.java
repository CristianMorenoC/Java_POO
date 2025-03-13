import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Programa para calcular el área de diferentes figuras geométricas
 * - Rombo
 * - Pentágono
 * - Trapecio
 * - Cilindro
 */
public class FigurasGeometricas {
    // Scanner para entrada de datos
    private static final Scanner scanner = new Scanner(System.in);
    // Formato para redondear a 2 decimales
    private static final DecimalFormat df = new DecimalFormat("#.##");
    // Constante PI para cálculos
    private static final double PI = Math.PI;
    
    public static void main(String[] args) {
        boolean continuar = true;
        
        System.out.println("=== CÁLCULO DE ÁREAS DE FIGURAS GEOMÉTRICAS ===");
        
        while (continuar) {
            // Mostrar menú de opciones
            System.out.println("\nSeleccione la figura geométrica:");
            System.out.println("a. Área del Rombo");
            System.out.println("b. Área del Pentágono");
            System.out.println("c. Área del Trapecio");
            System.out.println("d. Área del Cilindro");
            System.out.println("e. Salir");
            
            try {
                System.out.print("Ingrese su opción (a-e): ");
                char opcion = scanner.next().toLowerCase().charAt(0);
                scanner.nextLine(); // Limpiar buffer
                
                if (opcion == 'e') {
                    continuar = false;
                    System.out.println("¡Gracias por usar el calculador de áreas!");
                    break;
                }
                
                switch (opcion) {
                    case 'a':
                        calcularAreaRombo();
                        break;
                    case 'b':
                        calcularAreaPentagono();
                        break;
                    case 'c':
                        calcularAreaTrapecio();
                        break;
                    case 'd':
                        calcularAreaCilindro();
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor seleccione una opción entre a y e.");
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. " + e.getMessage());
                scanner.nextLine(); // Limpiar buffer
            }
        }
        
        scanner.close();
    }
    
    /**
     * Calcula y muestra el área de un rombo
     * Área = (diagonal mayor * diagonal menor) / 2
     */
    private static void calcularAreaRombo() {
        System.out.println("\n--- CÁLCULO DEL ÁREA DEL ROMBO ---");
        System.out.println("El área del rombo se calcula como (diagonal mayor * diagonal menor) / 2");
        
        try {
            System.out.print("Ingrese la longitud de la diagonal mayor: ");
            double diagonalMayor = scanner.nextDouble();
            
            System.out.print("Ingrese la longitud de la diagonal menor: ");
            double diagonalMenor = scanner.nextDouble();
            
            // Validar datos
            if (diagonalMayor <= 0 || diagonalMenor <= 0) {
                System.out.println("Error: Las diagonales deben ser valores positivos.");
                return;
            }
            
            // Calcular área
            double area = calcularAreaRombo(diagonalMayor, diagonalMenor);
            
            // Mostrar resultado
            System.out.println("\nResultado:");
            System.out.println("Diagonal mayor: " + df.format(diagonalMayor));
            System.out.println("Diagonal menor: " + df.format(diagonalMenor));
            System.out.println("Área del rombo: " + df.format(area) + " unidades cuadradas");
            
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Por favor ingrese valores numéricos.");
            scanner.nextLine(); // Limpiar buffer
        }
    }
    
    /**
     * Función para calcular el área de un rombo
     * @param diagonalMayor La diagonal mayor del rombo
     * @param diagonalMenor La diagonal menor del rombo
     * @return El área del rombo
     */
    private static double calcularAreaRombo(double diagonalMayor, double diagonalMenor) {
        return (diagonalMayor * diagonalMenor) / 2;
    }
    
    /**
     * Calcula y muestra el área de un pentágono regular
     * Área = (perímetro * apotema) / 2, donde perímetro = 5 * lado
     */
    private static void calcularAreaPentagono() {
        System.out.println("\n--- CÁLCULO DEL ÁREA DEL PENTÁGONO REGULAR ---");
        System.out.println("El área del pentágono regular se calcula como (perímetro * apotema) / 2");
        
        try {
            System.out.print("Ingrese la longitud del lado del pentágono: ");
            double lado = scanner.nextDouble();
            
            System.out.print("Ingrese la longitud del apotema (distancia del centro a cualquier lado): ");
            double apotema = scanner.nextDouble();
            
            // Validar datos
            if (lado <= 0 || apotema <= 0) {
                System.out.println("Error: El lado y el apotema deben ser valores positivos.");
                return;
            }
            
            // Calcular área
            double area = calcularAreaPentagono(lado, apotema);
            
            // Mostrar resultado
            System.out.println("\nResultado:");
            System.out.println("Lado del pentágono: " + df.format(lado));
            System.out.println("Apotema: " + df.format(apotema));
            System.out.println("Perímetro: " + df.format(5 * lado));
            System.out.println("Área del pentágono: " + df.format(area) + " unidades cuadradas");
            
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Por favor ingrese valores numéricos.");
            scanner.nextLine(); // Limpiar buffer
        }
    }
    
    /**
     * Función para calcular el área de un pentágono regular
     * @param lado La longitud del lado del pentágono
     * @param apotema La longitud del apotema (distancia del centro a cualquier lado)
     * @return El área del pentágono
     */
    private static double calcularAreaPentagono(double lado, double apotema) {
        double perimetro = 5 * lado;
        return (perimetro * apotema) / 2;
    }
    
    /**
     * Calcula y muestra el área de un trapecio
     * Área = ((base mayor + base menor) * altura) / 2
     */
    private static void calcularAreaTrapecio() {
        System.out.println("\n--- CÁLCULO DEL ÁREA DEL TRAPECIO ---");
        System.out.println("El área del trapecio se calcula como ((base mayor + base menor) * altura) / 2");
        
        try {
            System.out.print("Ingrese la longitud de la base mayor: ");
            double baseMayor = scanner.nextDouble();
            
            System.out.print("Ingrese la longitud de la base menor: ");
            double baseMenor = scanner.nextDouble();
            
            System.out.print("Ingrese la altura del trapecio: ");
            double altura = scanner.nextDouble();
            
            // Validar datos
            if (baseMayor <= 0 || baseMenor <= 0 || altura <= 0) {
                System.out.println("Error: Las bases y la altura deben ser valores positivos.");
                return;
            }
            
            if (baseMayor <= baseMenor) {
                System.out.println("Advertencia: La base mayor debe ser mayor que la base menor. Los valores se han intercambiado.");
                double temp = baseMayor;
                baseMayor = baseMenor;
                baseMenor = temp;
            }
            
            // Calcular área
            double area = calcularAreaTrapecio(baseMayor, baseMenor, altura);
            
            // Mostrar resultado
            System.out.println("\nResultado:");
            System.out.println("Base mayor: " + df.format(baseMayor));
            System.out.println("Base menor: " + df.format(baseMenor));
            System.out.println("Altura: " + df.format(altura));
            System.out.println("Área del trapecio: " + df.format(area) + " unidades cuadradas");
            
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Por favor ingrese valores numéricos.");
            scanner.nextLine(); // Limpiar buffer
        }
    }
    
    /**
     * Función para calcular el área de un trapecio
     * @param baseMayor La longitud de la base mayor
     * @param baseMenor La longitud de la base menor
     * @param altura La altura del trapecio
     * @return El área del trapecio
     */
    private static double calcularAreaTrapecio(double baseMayor, double baseMenor, double altura) {
        return ((baseMayor + baseMenor) * altura) / 2;
    }
    
    /**
     * Calcula y muestra el área de un cilindro (superficie total)
     * Área = 2πr² + 2πrh (donde r es el radio y h es la altura)
     */
    private static void calcularAreaCilindro() {
        System.out.println("\n--- CÁLCULO DEL ÁREA DEL CILINDRO (SUPERFICIE TOTAL) ---");
        System.out.println("El área del cilindro se calcula como 2πr² + 2πrh (donde r es el radio y h es la altura)");
        
        try {
            System.out.print("Ingrese el radio de la base del cilindro: ");
            double radio = scanner.nextDouble();
            
            System.out.print("Ingrese la altura del cilindro: ");
            double altura = scanner.nextDouble();
            
            // Validar datos
            if (radio <= 0 || altura <= 0) {
                System.out.println("Error: El radio y la altura deben ser valores positivos.");
                return;
            }
            
            // Calcular área
            double area = calcularAreaCilindro(radio, altura);
            double areaBase = PI * radio * radio;
            double areaLateral = 2 * PI * radio * altura;
            
            // Mostrar resultado
            System.out.println("\nResultado:");
            System.out.println("Radio: " + df.format(radio));
            System.out.println("Altura: " + df.format(altura));
            System.out.println("Área de las bases: " + df.format(2 * areaBase) + " unidades cuadradas");
            System.out.println("Área lateral: " + df.format(areaLateral) + " unidades cuadradas");
            System.out.println("Área total del cilindro: " + df.format(area) + " unidades cuadradas");
            
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Por favor ingrese valores numéricos.");
            scanner.nextLine(); // Limpiar buffer
        }
    }
    
    /**
     * Función para calcular el área de un cilindro (superficie total)
     * @param radio El radio de la base del cilindro
     * @param altura La altura del cilindro
     * @return El área total del cilindro
     */
    private static double calcularAreaCilindro(double radio, double altura) {
        return 2 * PI * radio * (radio + altura);
    }
}

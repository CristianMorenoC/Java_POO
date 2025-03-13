import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Programa para convertir entre diferentes unidades de medida
 * - Longitud: millas <-> kilómetros
 * - Peso: libras <-> kilogramos
 * - Temperatura: Fahrenheit <-> Celsius
 */
public class UnidadesMedida {
    // Scanner para entrada de datos
    private static final Scanner scanner = new Scanner(System.in);
    // Formato para redondear a 2 decimales
    private static final DecimalFormat df = new DecimalFormat("#.##");
    
    public static void main(String[] args) {
        boolean continuar = true;
        
        System.out.println("=== CONVERSOR DE UNIDADES DE MEDIDA ===");
        
        while (continuar) {
            // Mostrar menú de opciones
            System.out.println("\nSeleccione el tipo de conversión:");
            System.out.println("1. Longitud (Millas <-> Kilómetros)");
            System.out.println("2. Peso (Libras <-> Kilogramos)");
            System.out.println("3. Temperatura (Fahrenheit <-> Celsius)");
            System.out.println("4. Salir");
            
            try {
                System.out.print("Ingrese su opción (1-4): ");
                int opcion = scanner.nextInt();
                
                if (opcion == 4) {
                    continuar = false;
                    System.out.println("¡Gracias por usar el conversor de unidades!");
                    break;
                }
                
                if (opcion < 1 || opcion > 4) {
                    System.out.println("Opción inválida. Por favor seleccione una opción entre 1 y 4.");
                    continue;
                }
                
                // Submenu para el tipo específico de conversión
                switch (opcion) {
                    case 1:
                        menuLongitud();
                        break;
                    case 2:
                        menuPeso();
                        break;
                    case 3:
                        menuTemperatura();
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. Por favor ingrese un número.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
        
        scanner.close();
    }
    
    /**
     * Menú para conversiones de longitud
     */
    private static void menuLongitud() {
        System.out.println("\n--- CONVERSIÓN DE LONGITUD ---");
        System.out.println("1. Millas a Kilómetros");
        System.out.println("2. Kilómetros a Millas");
        
        try {
            System.out.print("Seleccione la conversión (1-2): ");
            int opcion = scanner.nextInt();
            
            if (opcion < 1 || opcion > 2) {
                System.out.println("Opción inválida. Volviendo al menú principal.");
                return;
            }
            
            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();
            
            switch (opcion) {
                case 1:
                    double kilometros = millasAKilometros(valor);
                    System.out.println(df.format(valor) + " millas = " + df.format(kilometros) + " kilómetros");
                    break;
                case 2:
                    double millas = kilometrosAMillas(valor);
                    System.out.println(df.format(valor) + " kilómetros = " + df.format(millas) + " millas");
                    break;
            }
            
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Volviendo al menú principal.");
            scanner.nextLine(); // Limpiar buffer
        }
    }
    
    /**
     * Menú para conversiones de peso
     */
    private static void menuPeso() {
        System.out.println("\n--- CONVERSIÓN DE PESO ---");
        System.out.println("1. Libras a Kilogramos");
        System.out.println("2. Kilogramos a Libras");
        
        try {
            System.out.print("Seleccione la conversión (1-2): ");
            int opcion = scanner.nextInt();
            
            if (opcion < 1 || opcion > 2) {
                System.out.println("Opción inválida. Volviendo al menú principal.");
                return;
            }
            
            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();
            
            switch (opcion) {
                case 1:
                    double kilogramos = librasAKilogramos(valor);
                    System.out.println(df.format(valor) + " libras = " + df.format(kilogramos) + " kilogramos");
                    break;
                case 2:
                    double libras = kilogramosALibras(valor);
                    System.out.println(df.format(valor) + " kilogramos = " + df.format(libras) + " libras");
                    break;
            }
            
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Volviendo al menú principal.");
            scanner.nextLine(); // Limpiar buffer
        }
    }
    
    /**
     * Menú para conversiones de temperatura
     */
    private static void menuTemperatura() {
        System.out.println("\n--- CONVERSIÓN DE TEMPERATURA ---");
        System.out.println("1. Fahrenheit a Celsius");
        System.out.println("2. Celsius a Fahrenheit");
        
        try {
            System.out.print("Seleccione la conversión (1-2): ");
            int opcion = scanner.nextInt();
            
            if (opcion < 1 || opcion > 2) {
                System.out.println("Opción inválida. Volviendo al menú principal.");
                return;
            }
            
            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();
            
            switch (opcion) {
                case 1:
                    double celsius = fahrenheitACelsius(valor);
                    System.out.println(df.format(valor) + " °F = " + df.format(celsius) + " °C");
                    break;
                case 2:
                    double fahrenheit = celsiusAFahrenheit(valor);
                    System.out.println(df.format(valor) + " °C = " + df.format(fahrenheit) + " °F");
                    break;
            }
            
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Volviendo al menú principal.");
            scanner.nextLine(); // Limpiar buffer
        }
    }
    
    // ===== MÉTODOS DE CONVERSIÓN DE LONGITUD =====
    
    /**
     * Convierte millas a kilómetros
     * @param millas Valor en millas
     * @return Valor equivalente en kilómetros
     */
    private static double millasAKilometros(double millas) {
        return millas * 1.60934;
    }
    
    /**
     * Convierte kilómetros a millas
     * @param kilometros Valor en kilómetros
     * @return Valor equivalente en millas
     */
    private static double kilometrosAMillas(double kilometros) {
        return kilometros / 1.60934;
    }
    
    // ===== MÉTODOS DE CONVERSIÓN DE PESO =====
    
    /**
     * Convierte libras a kilogramos
     * @param libras Valor en libras
     * @return Valor equivalente en kilogramos
     */
    private static double librasAKilogramos(double libras) {
        return libras * 0.453592;
    }
    
    /**
     * Convierte kilogramos a libras
     * @param kilogramos Valor en kilogramos
     * @return Valor equivalente en libras
     */
    private static double kilogramosALibras(double kilogramos) {
        return kilogramos / 0.453592;
    }
    
    // ===== MÉTODOS DE CONVERSIÓN DE TEMPERATURA =====
    
    /**
     * Convierte grados Fahrenheit a Celsius
     * @param fahrenheit Temperatura en grados Fahrenheit
     * @return Temperatura equivalente en grados Celsius
     */
    private static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    /**
     * Convierte grados Celsius a Fahrenheit
     * @param celsius Temperatura en grados Celsius
     * @return Temperatura equivalente en grados Fahrenheit
     */
    private static double celsiusAFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}

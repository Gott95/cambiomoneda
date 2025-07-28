import java.util.Scanner;

public class MenuConversor {
    private final Scanner scanner;

    public MenuConversor() {
        this.scanner = new Scanner(System.in);
    }

    private void mostrarBienvenida() {
        System.out.println("\n====================================");
        System.out.println("  Bienvenido/a al Conversor de Monedas");
        System.out.println("====================================");
    }

    private void mostrarOpciones() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Dólar a Peso Cubano");
        System.out.println("2. Peso Cubano a Dólar");
        System.out.println("3. Dólar a Real Brasileño");
        System.out.println("4. Real Brasileño a Dólar");
        System.out.println("5. Dólar a Peso Colombiano");
        System.out.println("6. Peso Colombiano a Dólar");
        System.out.println("7. Salir");
        System.out.print("Ingrese su opción: ");
    }

    private int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double leerCantidad() {
        System.out.print("Ingrese el valor que desea convertir: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private void realizarConversion(String monedaOrigen, String monedaDestino) {
        double cantidad = leerCantidad();
        ConversorMoneda conversor = new ConversorMoneda();
        try {
            double resultado = conversor.convertir(monedaOrigen, monedaDestino, cantidad);
            System.out.printf("El valor de %.2f %s corresponde al valor final de %.2f %s\n",
                    cantidad, monedaOrigen, resultado, monedaDestino);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la conversión: " + e.getMessage());
        }
    }

    public void mostrar() {
        boolean continuar = true;
        while (continuar) {
            mostrarBienvenida();
            mostrarOpciones();
            int opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    realizarConversion("USD", "CUP");
                    break;
                case 2:
                    realizarConversion("CUP", "USD");
                    break;
                case 3:
                    realizarConversion("USD", "BRL");
                    break;
                case 4:
                    realizarConversion("BRL", "USD");
                    break;
                case 5:
                    realizarConversion("USD", "COP");
                    break;
                case 6:
                    realizarConversion("COP", "USD");
                    break;
                case 7:
                    System.out.println("¡Gracias por usar el conversor de monedas!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}

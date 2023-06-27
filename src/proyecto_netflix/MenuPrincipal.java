package proyecto_netflix;

import InterfazCliente.InterfazUsuario;
import InterfazCliente.Usuario;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Bienvenido a Netflix, elige una opcin:");
            System.out.println("1. Contratar plan");
            System.out.println("2. Iniciar sesion");
            System.out.println("0. Cerrar");
            System.out.println("_______________________________________________");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    menuA(scanner);
                    break;
                case 2:
                    menuB(scanner);
                    break;
                case 0:
                    System.out.println("Cerrando...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige nuevamente.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    public static void menuA(Scanner scanner) {
        int opcion;

        do {
            System.out.println("1. Hola");
            System.out.println("2. Hola2");
            System.out.println("0. Volver a la página principal");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    System.out.println("¡Hola!");
                    break;
                case 2:
                    System.out.println("¡Hola2!");
                    break;
                case 0:
                    System.out.println("Volviendo a la página principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuB(Scanner scanner) {
        int opcion;
        int opcion2;
        String correo;
        String pass;
        System.out.println("________________________________________");
        System.out.println("Correo Electrónico: ");
        Scanner resp = new Scanner(System.in);
        correo = resp.nextLine();

        System.out.println("Contrasenia: ");
        pass = resp.nextLine();

        InterfazUsuario interfaz = new InterfazUsuario();

        Usuario us = interfaz.iniciarSesion(correo, pass);
        if (us != null) {
            System.out.println("Bienvenido, " + us.getName());
        } else {
            System.out.println("Correo o contrasenia no valido");
            System.exit(0);
        }

        System.out.println("Seleccione un perfil o configuracion");
        System.out.println("1. Perfil A");
        System.out.println("2. Perfil B");
        System.out.println("3. Configuracion");
        opcion2 = scanner.nextInt();
        scanner.nextLine();

        if (opcion2 == 3) {
            menuC(interfaz);

        }

        do {
            System.out.println("________________________________________");
            System.out.println("1. Ver");
            System.out.println("2. Ver película 2");
            System.out.println("3. Buscar película");
            System.out.println("0. Volver a la página principal");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    System.out.println("Viendo película 1");
                    break;
                case 2:
                    System.out.println("Viendo película 2");
                    break;
                case 3:
                    System.out.println("Buscando película");
                    break;
                case 0:
                    System.out.println("Volviendo a la página principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuC(InterfazUsuario interfazUsuario) {
        int opcion;
        
        Scanner resp = new Scanner(System.in);
        do {  
        System.out.println("________________________________________");
        System.out.println("Menu de configuracion, seleccione la operacion a realizar");
        System.out.println("1. Cambiar contraseña");
        System.out.println("2. Cambiar plan o metodo de pago");
        System.out.println("3. Configuracion perfil");
        System.out.println("0. Regresar a pantalla principal");
        opcion = resp.nextInt();
        resp.nextLine();
        
            switch (opcion) {
                case 1:
                    System.out.println("Menu cambiar contrasenia");
                    System.out.println("Escriba la nueva contrasenia");
                    String newPassword=resp.nextLine();
                    interfazUsuario.getGestor().modificar(interfazUsuario.getUsuario().getId(), newPassword);

                    break;
                case 2:
                    System.out.println("Configuracion de suscripcion");
                    break;
                case 3:
                    System.out.println("Configuracion del perfil");
                    break;
                case 0:
                    System.out.println("Volviendo a la página principal...");
                    menuB(resp);
                    
                default:
                    System.out.println("Opción inválida. Por favor, elige nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }
}

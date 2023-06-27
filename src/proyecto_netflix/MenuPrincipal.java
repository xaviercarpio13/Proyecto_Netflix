package proyecto_netflix;

import InterfazCliente.InterfazUsuario;
import InterfazCliente.Perfil;
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
                    menuContratarPlan(scanner);
                    break;
                case 2:
                    menuIniciarSesion(scanner);
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

    public static void menuContratarPlan(Scanner scanner) {
        int opcion;

        do {
            System.out.println("Escoge el plan de tu preferencia: ");
            System.out.println();
            System.out.println("1. Plan Individual a $4,99 mensuales");
            System.out.println("2. Plan Familiar a $9,99 mensuales");
            System.out.println("0. Volver a la página principal");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    System.out.println("1. Haz elegido el Plan Individual a $4,99 mensuales");
                    obtenerDatos(scanner);
                    
                    break;
                case 2:
                    System.out.println("2. Haz elegido el Plan Familiar a $9,99 mensuales");
                    obtenerDatos(scanner);
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

     public static void obtenerDatos(Scanner scanner) {
         String aux;
        int opcion;
      //usuario 
     String idUsuario;
     String nombre; 
     String email;
     String password; 
     String fechaNacimiento;
     
     //suscripcion
     String idSuscripcion;
     String plan;
     float precio;
     String fechaContratacion;
     
        System.out.println("Ingresa tus datos de pago: ");
        System.out.println("________________________________________");
        System.out.println("Ingresa tu numero de tarjeta: ");
        aux = scanner.nextLine();
        System.out.println("Ingresa tu codigo CVV: ");
        aux = scanner.nextLine();
        System.out.println("Verificando...");
        System.out.println("¡Tus datos de pago se han guardado exitosamente!");
        System.out.println("________________________________________");
        System.out.println("Da enter para empezar a crear tu cuenta");
        System.out.println("/n/n");
         
       // Usuario usuario = null;
        System.out.println("Ingresa tus datos para crear cuenta:");
        System.out.println("________________________________________");
        System.out.println("Ingresa tu numero de cedula:");
        idUsuario = scanner.nextLine();
       // usuario.setId(idUsuario);
        
       System.out.println("Ingresa tu nombre:");
       nombre = scanner.nextLine();
       // usuario.setId(idUsuario);
       
        System.out.println("Ingresa tu fecha nacimiento: ");
        fechaNacimiento = scanner.nextLine();
       // usuario.setFechaNacimiento(fechaNacimiento);
        
        System.out.println("Ingresa tu correo electronico:");
        email = scanner.nextLine();
        //usuario.setEmail(email);
        
        System.out.println("Ingresa tu contrasenia:");
        password = scanner.nextLine();
        //usuario.setContrasenia(password);
        
        Usuario usuario = new Usuario(idUsuario,nombre, email, password, fechaNacimiento);
        usuario.crearUsuario(idUsuario,nombre, email, password, fechaNacimiento);
        
        InterfazUsuario interfaz = new InterfazUsuario();

        Usuario us = interfaz.iniciarSesion(email,password);
        if (us != null) {
            menuPerfil(interfaz);
            System.out.println("Bienvenido, " + us.getName());
        } else {
            System.out.println("Correo o contrasenia no valido");
            System.exit(0);
        }
     }
     
    public static void menuIniciarSesion(Scanner scanner) {
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
            menuPerfil(interfaz);
            System.out.println("Bienvenido, " + us.getName());
        } else {
            System.out.println("Correo o contrasenia no valido");
            System.exit(0);
        }
    }

    public static void menuPerfil(InterfazUsuario interfaz) {
        Scanner resp = new Scanner(System.in);
        int opcion2;
        System.out.println("________________________________________");
        System.out.println("Seleccione un perfil o configuracion");
        System.out.println("1. Perfil A");
        System.out.println("2. Perfil B");
        System.out.println("3. Configuracion");
        opcion2 = resp.nextInt();
        resp.nextLine();

        if (opcion2 == 3) {
            menuConfiguracion(interfaz);
        }

        do {
            System.out.println("________________________________________");
            System.out.println("1. Ver");
            System.out.println("2. Ver película 2");
            System.out.println("3. Buscar película");
            System.out.println("0. Volver a la página principal");

            opcion2 = resp.nextInt();
            resp.nextLine(); // Consumir el salto de línea después del número

            switch (opcion2) {
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
        } while (opcion2 != 0);
    }

    public static void menuConfiguracion(InterfazUsuario interfazUsuario) {
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
            System.out.println("________________________________________");

            switch (opcion) {
                case 1:
                    System.out.println("Menu cambiar contrasenia");
                    System.out.println("Escriba la nueva contrasenia");
                    String newPassword = resp.nextLine();
                    interfazUsuario.getGestor().modificarPassword(
                            "Usuarios", "password", interfazUsuario.getUsuario().getId(), newPassword);
                    menuPerfil(interfazUsuario);

                case 2:
                    String plan;
                    System.out.println("Configuracion de suscripcion");
                    System.out.println("Digite el nuevo plan a contratar");
                    System.out.println("1: Basico");
                    System.out.println("2: Familiar");
                    System.out.println("3: Premium");
                    plan = resp.nextLine();
                    interfazUsuario.getGestor().modificarPassword(
                            "Suscripcion", "plan", interfazUsuario.getUsuario().getId(), plan);
                    menuPerfil(interfazUsuario);

                    break;
                case 3:
                    System.out.println("Configuracion del perfil");
                    System.out.println("Digite el dato a actualizar");
                    System.out.println("1: Nombre del perfil");
                    System.out.println("2: Restriccion");
                    plan = resp.nextLine();
                    switch (plan) {
                        case "1":
                            System.out.println("Escriba el nuevo nombre del perfil");
                            plan = resp.nextLine();
                            interfazUsuario.getGestor().modificarPassword(
                                    "Perfil", "nombre", interfazUsuario.getUsuario().getId(), plan);
                            menuPerfil(interfazUsuario);
                            break;
                        case "2":
                            System.out.println("Escriba la nueva restriccion");
                            plan = resp.nextLine();
                            interfazUsuario.getGestor().modificarPassword(
                                    "Perfil", "restriccion", interfazUsuario.getUsuario().getId(), plan);
                            menuPerfil(interfazUsuario);
                            break;
                        default:
                            System.out.println("Opción inválida. Por favor, elige nuevamente.");
                            break;
                    }

                    break;
                case 0:
                    System.out.println("Volviendo a la página principal...");
                    menuIniciarSesion(resp);

                default:
                    System.out.println("Opción inválida. Por favor, elige nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }
}

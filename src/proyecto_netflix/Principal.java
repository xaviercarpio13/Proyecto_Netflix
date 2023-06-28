package proyecto_netflix;

//@authors: Xavier Carpio, Juan Carrillo, Carlos Morales, Kelly Sangoluisa

import Cliente.InterfazUsuario;
import Cliente.Perfil;
import Cliente.Suscripcion;
import Cliente.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menuPrincipal(scanner);
        scanner.close();
    }
    
    public static void menuPrincipal(Scanner scanner){
        int opcion;
        do {
            System.out.println("Bienvenido a Netflix, elige una opcion: ");
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, elige nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuContratarPlan(Scanner scanner) {
        int opcion;

        do {
            System.out.println("Escoge el plan de tu preferencia: ");
            System.out.println();
            System.out.println("1. Plan Individual a $4,99 mensuales");
            System.out.println("2. Plan Familiar a $9,99 mensuales");
            System.out.println("0. Volver a la pagina principal");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    System.out.println("1. Haz elegido el Plan Individual a $4,99 mensuales");
                    crearSuscripcion(scanner, "1",4.99F);
                    
                    break;
                case 2:
                    System.out.println("2. Haz elegido el Plan Familiar a $9,99 mensuales");
                    crearSuscripcion(scanner, "2",9.99F);
                    break;
                case 0:
                    System.out.println("Volviendo a la página principal...");
                    menuPrincipal(scanner);
                    
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige nuevamente.");
                    break;
            }
        } while (opcion != 0);       
    }
    

    public static void crearSuscripcion(Scanner scanner,String plan, float precio){
        String aux;
        //suscripcion
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        String idSuscripcion = String.valueOf(numeroAleatorio);
        LocalDate fechaActual = LocalDate.now();
        String fechaContratacion = fechaActual.toString();
        
      //usuario 
        String idUsuario;
        String nombre; 
        String email;
        String password; 
        String fechaNacimiento;
        
        //Ingresar datos de metodo de pago
        System.out.println("Ingresa tus datos de pago: ");
        System.out.println("________________________________________");
        System.out.println("Ingresa tu numero de tarjeta: ");
        aux = scanner.nextLine();
        System.out.println("Ingresa tu codigo CVV: ");
        aux = scanner.nextLine();
        System.out.println("Verificando...");
        System.out.println("¡Tus datos de pago se han guardado exitosamente!");
        System.out.println("________________________________________");
        System.out.println();
        System.out.println();
        System.out.println();
        //Ingresar datos crear cuenta
        System.out.println("Ingresa tus datos para crear cuenta:");
        System.out.println("________________________________________");
        System.out.println("Ingresa tu numero de cedula:");
        idUsuario = scanner.nextLine();
        
        System.out.println("Ingresa tu nombre:");
        nombre = scanner.nextLine();
       
        System.out.println("Ingresa tu fecha nacimiento: ");
        fechaNacimiento = scanner.nextLine();
        
        System.out.println("Ingresa tu correo electronico:");
        email = scanner.nextLine();
        
        System.out.println("Ingresa tu contrasenia:");
        password = scanner.nextLine();
        
        //Crear usuario 
        Usuario usuario = new Usuario(idUsuario,nombre, email, password, fechaNacimiento);
        usuario.crearUsuario(idUsuario,nombre, email, password, fechaNacimiento);
        
        //Crear suscripcion
        Suscripcion suscripcion = new Suscripcion(idSuscripcion, plan, precio, fechaContratacion, idUsuario);
        suscripcion.crearSuscripcion(idSuscripcion, plan, precio, fechaContratacion, idUsuario);
        
        crearPerfil(scanner,idUsuario);
        
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
    
    public static void crearPerfil(Scanner scanner,String idUsuario) {
        //suscripcion
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        String idPerfil = String.valueOf(numeroAleatorio);
        
      //perfil
        String nombre;
        int restriccion;
       // String idUsuario;
        
        System.out.println("-----Para iniciar crea un perfil------");
        System.out.println("________________________________________");
        System.out.println("Ingresa nombre: ");
        nombre = scanner.nextLine();
        System.out.println("El perfil sera: ");
        System.out.println("1. Adultos ");
        System.out.println("2. Kids ");
        restriccion = scanner.nextInt();
        
        idUsuario = scanner.nextLine();
        System.out.println("Verificando...");
        System.out.println("!Tu perfil fue creado!");
        System.out.println("________________________________________");
         
        Perfil perfil = new Perfil(idPerfil, nombre, restriccion, idUsuario);
        perfil.crearPerfil(idPerfil, nombre, restriccion, idUsuario);
        //Creo usuario en netbeans 
    }
     
    public static void menuIniciarSesion(Scanner scanner) {
        String correo;
        String pass;
        System.out.println("________________________________________");
        System.out.println("Correo Electronico: ");
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
        int opcion;
        System.out.println("________________________________________");
        System.out.println("Seleccione un perfil o configuracion");
        System.out.println("0. Configuracion");
        System.out.println("1. Crear Perfil");
        int contador;
        if(interfaz.getUsuario().obtenerPerfiles()!=null){
           for(contador=0;contador<interfaz.getUsuario().obtenerPerfiles().size();contador++){
            System.out.println(contador+2+". "+interfaz.getUsuario().getNombrePerfil(contador));
        } 
        }
        
        opcion  = resp.nextInt();
        resp.nextLine();
        String idUsuario = interfaz.getUsuario().getId();
        String email = interfaz.getUsuario().getEmail();
        String password = interfaz.getUsuario().getEmail();
        switch(opcion){
            case 0:
                    menuConfiguracion(interfaz);
                break;
            case 1:
                    crearPerfil(resp , idUsuario);
                break;
            case 2: 
                menuPeliculas();
                break;
            case 3: 
                menuPeliculas();
                break;
            case 4: 
                menuPeliculas();
                break;
            case 5:
                menuPeliculas();
                break;  
            case 6:
                menuPeliculas();
                break;
            default:
                    
                break;
        }
    }

   public static void menuPeliculas(){
        InterfazUsuario interfaz = new InterfazUsuario();

        System.out.println("________________________________________");
        ArrayList<String> listaPeliculas = interfaz.verListaPeliculas();

        System.out.println("0. Salir de la Aplicacion");
        System.out.println("1. Buscar Pelicula");
        for (int i = 0; i < listaPeliculas.size(); i++) {
            System.out.println(i+2 + ". " + listaPeliculas.get(i));
        }

        Scanner resp = new Scanner(System.in);

        int opcion = resp.nextInt();
        resp.nextLine();
        switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Ingresa el nombre de la película");
                    Scanner resp2 = new Scanner(System.in);
                    String nombrePeliculaScn = resp2.nextLine();
                    interfaz.verPelicula(nombrePeliculaScn);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige nuevamente.");
                    String nombrePelicula = listaPeliculas.get(opcion - 2);
                    interfaz.verPelicula(nombrePelicula);
                    break;
        }
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
                    interfazUsuario.getGestor().actualizar(
                            "Usuarios", "password", interfazUsuario.getUsuario().getId(), newPassword);
                    menuPerfil(interfazUsuario);
                    break;
                case 2:
                    String plan;
                    System.out.println("Configuracion de suscripcion");
                    System.out.println("Digite el nuevo plan a contratar");
                    System.out.println("1: Individual");
                    System.out.println("2: Familiar");
                    plan = resp.nextLine();
                    interfazUsuario.getGestor().actualizar(
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
                            interfazUsuario.getGestor().actualizar(
                                    "Perfil", "nombre", interfazUsuario.getUsuario().getId(), plan);
                            menuPerfil(interfazUsuario);
                            break;
                        case "2":
                            System.out.println("Escriba la nueva restriccion");
                            plan = resp.nextLine();
                            interfazUsuario.getGestor().actualizar(
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
import java.util.Date;

public class Usuario {
    private String id;
    private String name;
    private Date fechaNacimiento;
    private  String contrasenia;

    public Usuario(String id, String name, Date fechaNacimiento, String contrasenia) {
        this.id = id;
        this.name = name;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenia = contrasenia;
    }
}

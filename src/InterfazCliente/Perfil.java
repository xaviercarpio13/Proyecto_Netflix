package InterfazCliente;
public class Perfil {
    private String nombre;
    private Integer restriccion;
    private String idUsuario;
    private String Id;

    public Perfil() {
    }

    public Perfil(String id,String nombre, Integer restriccion,String idUsuario){
        Id = id;
        this.nombre = nombre;
        this.restriccion = restriccion;
        this.idUsuario = idUsuario;
    }
}

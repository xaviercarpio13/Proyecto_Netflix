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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(Integer restriccion) {
        this.restriccion = restriccion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    
}

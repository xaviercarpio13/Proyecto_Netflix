package InterfazCliente;
public class Perfil {
    private String nombre;
    private Integer restriccion;
    private String foto;
    private String tipo;
    private String idUsuario;
    private String Id;

    public Perfil() {
    }

    public Perfil(String nombre, Integer restriccion, String foto, String tipo, String idUsuario, String id) {
        this.nombre = nombre;
        this.restriccion = restriccion;
        this.foto = foto;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
        Id = id;
    }
}

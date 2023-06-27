import java.util.ArrayList;

public class GestorPersistencia<T> {
    private ArrayList<T> lista;
    private String nombreArchivo;

    public GestorPersistencia(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        lista = new ArrayList<>();
    }

    public void insertar(T objeto) {
        lista.add(objeto);
    }

    public void eliminar(T objeto) {
        lista.remove(objeto);
    }

    public void modificar(T objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T buscar(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<T> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void guardar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cargar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

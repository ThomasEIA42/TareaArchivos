package archivos;

import java.io.Serializable;

public class Proveedor implements Serializable {
    private int id;
    private String nombre;
    private String telofono;

    public Proveedor(int id, String nombre, String telofono) {
        this.id = id;
        this.nombre = nombre;
        this.telofono = telofono;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "nombre: "+nombre+"\n"+"id:"+id+"\n"+"telefono:"+telofono;
    }
}

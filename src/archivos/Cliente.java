package archivos;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int id;
    private String nombre;
    private String email;

    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "nombre: "+nombre+ "\n"+
        "id:"+ id +"\n" + "email:"+ email;
    }
}



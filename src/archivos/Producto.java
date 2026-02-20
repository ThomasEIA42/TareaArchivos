package archivos;

import excepciones.CapacidadMaximaException;
import excepciones.StockInsuficienteException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Producto implements Serializable {
    private int codigo;
    private String nombre;
    private double precio;
    private int stock;
    private int idProveedor;

    public Producto(int codigo, String nombre, double precio, int stock, int idProveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.idProveedor = idProveedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void aumentarStock(int cantidad) {
        if (cantidad > 0){
            throw new CapacidadMaximaException("No se puede aumentar el stock");
        }
            stock += cantidad;
    }
    public void vender(int cantidad) throws StockInsuficienteException {
        if (cantidad <= 0){
            throw new CapacidadMaximaException("la cantidad no puede ser negativa");
        }
        if (cantidad > stock){
            throw new StockInsuficienteException("No hay stock suficiente");
        }
            stock -= cantidad;
    }




    @Override
    public String toString() {
        return "codigo: "+codigo+"\n"+"nombre: "+nombre+"\n"+"precio: "+precio+"\n"+"stock: "+stock+"\n"+"idProveedor: "+idProveedor;}
    }



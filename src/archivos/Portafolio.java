package archivos;

import java.io.Serializable;
import excepciones.CapacidadMaximaException;
import excepciones.CodigoDuplicadoException;
import excepciones.ProveedorNoExisteException;

public class Portafolio implements Serializable {

    private Proveedor[] proveedores;
    private Cliente[] clientes;
    private int nProductos;
    private Producto[] productos;
    private int nProveedores;
    private int nClientes;

    public Portafolio(int capacidadProveedores, int capacidadClientes) {

        proveedores = new Proveedor[capacidadProveedores];
        clientes = new Cliente[capacidadClientes];

        nProveedores = 0;
        nClientes = 0;
    }

    public void agregarProveedor(Proveedor proveedor)
            throws CapacidadMaximaException, CodigoDuplicadoException {
        if (nProveedores >= proveedores.length) {
            throw new CapacidadMaximaException("No hay más espacio para proveedores");
        }

            for(int i = 0; i < nProveedores; i++){
                if(proveedores[i].getId() == proveedor.getId()){
                    throw new CodigoDuplicadoException("El codigo ya existe");
                }
            }

        proveedores[nProveedores] = proveedor;
        nProveedores++;
    }
    public void agregarCliente(Cliente cliente)
        throws CapacidadMaximaException, CodigoDuplicadoException{
            if (nClientes >= clientes.length) {
                throw new CapacidadMaximaException("No har mas espacio para clientes");
        }
            for(int i = 0; i < nClientes; i++){
                if(clientes[i].getId() == cliente.getId()){
                    throw new CodigoDuplicadoException("El codigo ya existe");
                }
            }
            clientes[nClientes] = cliente;
            nClientes++;
    }

    public void agregarProducto(Producto producto)
        throws CapacidadMaximaException, CodigoDuplicadoException{
        if(nProductos >= productos.length){
            throw new CapacidadMaximaException("No hay espacio para productos");
        }
        for(int i = 0; i < nProductos; i++){
            if(productos[i].getCodigo() == producto.getCodigo()){
                throw new CodigoDuplicadoException("El codigo ya existe");
            }
        }

        productos[nProductos] = producto;
        nProductos++;
    }
    public Proveedor bucarProveedor(int id) throws ProveedorNoExisteException {
        for(int i = 0; i < nProveedores; i++){
            if(proveedores[i].getId() == id){
                return proveedores[i];
            }
        }
        throw new ProveedorNoExisteException("El proveedor no existe"+id);
    }
    public Cliente bucarCliente(int id) throws ProveedorNoExisteException {
        for(int i = 0; i < nClientes; i++){
            if(clientes[i].getId() == id){
                return clientes[i];
            }
        }
        throw new ProveedorNoExisteException("El cliente no existe"+id);
    }
    public Producto bucarProducto(int codigo) throws ProveedorNoExisteException {
        for(int i = 0; i < nProductos; i++){
            if(productos[i].getCodigo() == codigo){
                return productos[i];
            }
        }
        throw new ProveedorNoExisteException("El producto no existe"+codigo);
    }
}
package archivos;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;
import excepciones.CapacidadMaximaException;
import excepciones.CodigoDuplicadoException;
import excepciones.ProveedorNoExisteException;
import excepciones.StockInsuficienteException;

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
        productos = new Producto[capacidadProveedores];
        nProductos = 0;
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

    public void listarProveedores(){
      if(nProveedores == 0){
          System.out.println("No hay proveedores");
      }else{
          for(int i = 0; i < nProveedores; i++){
              System.out.println(proveedores[i]);
          }
      }
    }
    public void listarClientes(){
        if(nClientes == 0){
            System.out.println("No hay clientes");
        }else{
            for(int i = 0; i < nClientes; i++){
                System.out.println(clientes[i]);
            }
        }
    }

    public void listarProductos(){
      if(nProductos == 0){
          System.out.println("No hay productos registrados");
      return;
      }
      for(int i = 0; i < nProductos; i++){

          Producto p = productos[i];
            Proveedor proveedor = null;
            for(int j = 0; j < nProveedores; j++){
                if(proveedores[j].getId() == p.getIdProveedor()){
                    proveedor = proveedores[j];
                    break;
                }
                System.out.println(
                        p + " | Proveedor: " +
                                (proveedor != null ? proveedor.getNombre() : "No encontrado")
                );
            }

      }
    }

    public void aumentarStockProducto(int codigo, int cantidad)
    throws ProveedorNoExisteException{
        Producto producto = bucarProducto(codigo);
        producto.aumentarStock(cantidad);
    }
    public void venderProducto(int codigo, int cantidad) throws ProveedorNoExisteException, StockInsuficienteException {
        Producto producto = bucarProducto(codigo);
        producto.vender(cantidad);
    }

    public void guardar() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new java.io.FileOutputStream("productos.dat"));
        oos.writeObject(this);
        oos.close();

    }

    public static Portafolio cargar()
            throws Exception, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("portafolio.dat")
        );

        Portafolio portafolio = (Portafolio) in.readObject();
        in.close();

        return portafolio;
    }
}
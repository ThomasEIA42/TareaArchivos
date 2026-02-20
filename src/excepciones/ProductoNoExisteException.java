package excepciones;

public class ProductoNoExisteException extends RuntimeException {
    public ProductoNoExisteException(String message) {
        super(message);
    }
}

package mx.uam.azc.modelo;

/**
 *
 * @author cubo
 */
public class EcommerceException extends Exception{

    public EcommerceException(String message) {
        super(message);
    }

    public EcommerceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EcommerceException(Throwable cause) {
        super(cause);
    }
}

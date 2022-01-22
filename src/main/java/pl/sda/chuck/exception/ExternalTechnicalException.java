package pl.sda.chuck.exception;

/**
 * Unknown technical exception
 */
public class ExternalTechnicalException extends RuntimeException {
    public ExternalTechnicalException(String message) {
        super(message);
    }
}

package io.github.huebrazil.whois.exceptions;

/**
 * The Class WebInterfaceErrorException.
 */
public class WebInterfaceErrorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new web interface error exception.
     *
     * @param cause the cause
     */
    public WebInterfaceErrorException(Throwable cause) {
        super(cause);
    }
}

package uk.bl.wa.whois.exceptions;

public class WebInterfaceErrorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WebInterfaceErrorException(Throwable cause) {
        super(cause);
    }
}

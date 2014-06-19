package uk.bl.wa.whois.exceptions;

import org.jruby.embed.EvalFailedException;

public class ServerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServerNotFoundException(EvalFailedException e) {
        super(e);
    }
}

package io.github.huebrazil.whois.exceptions;

import org.jruby.embed.EvalFailedException;

/**
 * The Class ServerNotFoundException.
 */
// TODO: Auto-generated Javadoc
public class ServerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new server not found exception.
     *
     * @param server the server
     */
    public ServerNotFoundException(String server) {
        super("Server not found: " + server);
    }
    
    /**
     * Instantiates a new server not found exception.
     *
     * @param e the e
     */
    public ServerNotFoundException(EvalFailedException e) {
        super(e);
    }
}

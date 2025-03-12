package com.github.huebrazil.whois.exceptions;

import org.jruby.embed.EvalFailedException;

public class ServerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServerNotFoundException(String server) {
        super("Server not found: " + server);
    }
    
    public ServerNotFoundException(EvalFailedException e) {
        super(e);
    }
}

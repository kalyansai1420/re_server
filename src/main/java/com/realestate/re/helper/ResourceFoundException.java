package com.realestate.re.helper;

public class ResourceFoundException extends RuntimeException{


    private static final long serialVersionUID = 1L;
    public long id;

    public ResourceFoundException(String message) {
        super(message);
    }

    public ResourceFoundException(String message, long uId) {
        super(message);
        this.id = uId;

    }
    
}

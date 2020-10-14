package com.referenceit.user;

public class PermissionDeniedException extends RuntimeException {

    public PermissionDeniedException() {

    }

    public PermissionDeniedException(String message) {
        super(message);
    }

}

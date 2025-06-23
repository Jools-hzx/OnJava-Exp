package com.jools.designpattern.factory;

public class BadShapeCreation extends RuntimeException {

    public BadShapeCreation(String message) {
        super(message);
    }

    public BadShapeCreation(Exception e) {
        super(e);
    }
}

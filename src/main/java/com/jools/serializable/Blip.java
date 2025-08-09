package com.jools.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author Jools He
 * @date 2025/6/24 16:39
 * @description: TODO
 */
public class Blip implements Externalizable {

    public Blip() {
        System.out.println("Blip constructor!!!");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip.readExternal");
    }
}

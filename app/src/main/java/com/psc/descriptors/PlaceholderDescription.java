package com.psc.descriptors;

import com.psc.Description;

import java.io.File;

/**
 * Created by Nicolas on 06/11/2016.
 */

public class PlaceholderDescription implements Description {
    public PlaceholderDescription() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PlaceholderDescription)
            return super.equals(obj); //TODO
        else
            return false;
    }

    @Override
    public String getDescriptorName() {
        return "Placeholder Descriptor";
    }

    @Override
    public String toString() {
        return super.toString(); //TODO
    }

    @Override
    public Description instantiateFromFile(File f) {
        return null;//TODO
    }

    @Override
    public Description saveToFile(File f) {
        return null;//TODO
    }
}

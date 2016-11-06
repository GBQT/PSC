package com.psc;

import java.io.File;

/**
 * Created by Nicolas on 06/11/2016.
 */

public interface Description {
    public String getDescriptorName();
    public String toString();
    public Description instantiateFromFile(File f); // Returns a DIFFERENT instance built from the data contained in the file. (Yes it should be static, but you can't have that in an interface)
    public Description saveToFile(File f); // Saves the description to the filesystem for later use.

}

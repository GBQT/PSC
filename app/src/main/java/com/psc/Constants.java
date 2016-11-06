package com.psc;

/**
 * Created by Nicolas on 06/11/2016.
 */

public class Constants {
    public static boolean DEBUG=true; // Debug mode, used to check whether to log and doublecheck everything.
    public static Descriptor descriptorUsed=null;
    public static Matcher matcherUsed=null;



    public static void init(){
        descriptorUsed=null; // Initialize the used descriptor here.
        matcherUsed=null; // Initialize the used matcher here.

    }
}

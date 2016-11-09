package com.psc;

/**
 * Created by Nicolas on 06/11/2016.
 */

public interface Matcher {
    public float distance(Description reference,Description target);
    public float getDistanceReferenceFactor();  //i.e does a distance of 10 means a close match or not?
    public int bestMatch(Description[] database,Description target, float minAccuracy); //Returns the index of the most likely match. Returns -1 if the minimum accuracy is not met.
    public int destTime(Description target,Description reference);
}

package com.psc.descriptors;

        import com.psc.Description;
        import com.psc.Descriptor;

/**
 * Created by Nicolas on 06/11/2016.
 */

public class PlaceholderDescriptor implements Descriptor {
    @Override
    public String getName() {
        return "Placeholder Descriptor";
    }

    @Override
    public Description describe(float[] sound, int bitRate) {
        return null;
    }

}

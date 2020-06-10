package Backend.Items.NullObjects;

import Backend.Items.FlashLight;

public class NullFlashlight extends FlashLight {

    public NullFlashlight() {
        super(0);
    }

    public static String className(){
        return "Null Flashlight";
    }

}

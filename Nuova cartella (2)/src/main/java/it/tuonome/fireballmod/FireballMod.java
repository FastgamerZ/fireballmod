
package it.tuonome.fireballmod;

import net.fabricmc.api.ModInitializer;

public class FireballMod implements ModInitializer {
    public static final String MOD_ID = "fireballmod";

    @Override
    public void onInitialize() {
        FireballAttack.register();
    }
}

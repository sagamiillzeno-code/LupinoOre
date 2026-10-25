
package com.lupinoore;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
    modid = LupinoOre.MODID,
    name = LupinoOre.NAME,
    version = LupinoOre.VERSION,
    acceptedMinecraftVersions = "[1.12.2]"
)
public class LupinoOre {

    public static final String MODID = "lupinoore";
    public static final String NAME = "LupinoOre";
    public static final String VERSION = "1.0.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(
            new WorldGenLupinoOre(),
            0
        );

        System.out.println(
            "[LupinoOre] Ore generation registered!"
        );
    }
}

package com.redtek.rootsys;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RootSystem.MODID)
public class RootSystem {

    public static final String MODID = "rootsys";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public RootSystem() {
        LOGGER.debug("Hello World!");
    }
}

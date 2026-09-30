package me.dexrn.zonifiedbeta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class ZonifiedBeta implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("ZonifiedBeta");
	public static final String VERSION = "1.0.0";

	@Override
	public void onInitialize() {
		LOGGER.info("Loading the Zone™...");
	}
}

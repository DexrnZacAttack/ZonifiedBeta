package me.dexrn.zonifiedbeta;

import me.dexrn.zonifiedbeta.ZonifiedBeta;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/** Marker file to prevent loading a vanilla world */
public class ZonifiedBetaMarkerFile {
	/** The default marker filename */
	private static final String FILENAME = ".zonifiedbeta";

	/** Writes an informational string to the marker file stream */
	public static void write(BufferedWriter writer) throws IOException {
		// Source - https://stackoverflow.com/a/22091291
		// Posted by Dipali Vasani
		// Retrieved 2026-09-28, License - CC BY-SA 3.0
		final Date currentTime = new Date();
		final SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		//END CC BY-SA 3.0 LICENSED CODE

		writer.write("ZonifiedBeta v" + ZonifiedBeta.VERSION + " / https://github.com/DexrnZacAttack/ZonifiedBeta");
		writer.newLine();
		writer.write("Last loaded on " + sdf.format(currentTime));
		writer.newLine();
		writer.newLine();
		writer.write("Loading this world without ZonifiedBeta installed will cause the game to generate new Alpha Save Format chunks instead.");
		writer.newLine();
		writer.write("This means the level will be using the Alpha Save Format, with the Zone files left behind in another folder.");
		writer.newLine();
        writer.write("There is also a very high chance that your player will spawn in a wall in the new chunks, or fall from a high place. :P");
        writer.newLine();
        writer.newLine();
        writer.write("While no zone corruption is expected, you still bare the risk of anything that happens, especially your player dying on login. At-least back up your world first!!!");
	}

	/** Gets the marker file inside the parent directory */
	public static File getFile(File parent) {
		return new File(parent, FILENAME);
	}

	/** Gets a writer for the marker file in the parent directory */
	public static BufferedWriter getWriter(File parent) throws FileNotFoundException {
		return getFileWriter(getFile(parent));
	}

	/** Gets a writer for the marker file itself */
	public static BufferedWriter getFileWriter(File markerFile) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream(markerFile);
		OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
		return new BufferedWriter(osw);
	}

	/** Returns true if the marker file exists and is a file in the parent directory */
	public static boolean exists(File parent) {
		File f = getFile(parent);

		return f.exists() && f.isFile();
	}
}

package com.viniciusmo.androidtextspeech.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;

public class FileTool {

	public static File fileToInputStream(File file, InputStream inputStream)
			throws IOException {
		final OutputStream output = new FileOutputStream(file);
		try {
			final byte[] buffer = new byte[1024];
			int read;
			while ((read = inputStream.read(buffer)) != -1)
				output.write(buffer, 0, read);
			output.flush();
		} finally {
			output.close();
		}
		return file;
	}

	public static File createTempFile(Context context) throws IOException {
		File outputDir = context.getCacheDir();
		File outputFile = File.createTempFile("prefix", ".mp3", outputDir);
		return outputFile;
	}
}

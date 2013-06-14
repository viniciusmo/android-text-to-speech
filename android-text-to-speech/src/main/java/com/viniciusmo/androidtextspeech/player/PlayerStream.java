package com.viniciusmo.androidtextspeech.player;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.viniciusmo.androidtextspeech.file.FileTool;

public class PlayerStream {

	private Context context;

	public PlayerStream(Context context) {
		this.context = context;
	}

	public void play(InputStream inputStream) {
		MediaPlayer mp = new MediaPlayer();
		playInputStreamWithMediaPlayer(inputStream, mp);
	}

	public void play(InputStream inputStream,
			OnCompletionListener onCompletionListener) {
		MediaPlayer mp = new MediaPlayer();
		mp.setOnCompletionListener(onCompletionListener);
		playInputStreamWithMediaPlayer(inputStream, mp);
	}

	private void playInputStreamWithMediaPlayer(InputStream inputStream,
			MediaPlayer mp) {
		File file = translateInputStreamToFileForPlaySpeech(inputStream);
		try {
			mp.setDataSource(new FileInputStream(file).getFD());
			mp.prepare();
			mp.start();
		} catch (IOException e) {
			throw new PlayerStreamException();
		}
	}

	private File translateInputStreamToFileForPlaySpeech(InputStream inputStream) {
		File file = null;
		try {
			file = FileTool.createTempFile(context);
		} catch (IOException e) {
			throw new PlayerStreamException();
		}
		return file;
	}

}

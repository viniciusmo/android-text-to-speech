package com.viniciusmo.androidtextspeech.translate;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;

import com.viniciusmo.androidtextspeech.Language;
import com.viniciusmo.androidtextspeech.web.Encoder;
import com.viniciusmo.androidtextspeech.web.URLGoogleAPI;

public class TranslatorSpeech implements Translatable {
	private String text;
	@SuppressWarnings("unused")
	private Language from;

	public TranslatorSpeech(String text, Language from) {
		this.text = text;
	}

	public String getUrl() {
		String format = URLGoogleAPI.TRANSLATE_AUDIO.getUrl();
		String textEncoded = Encoder.encodeWhiteSpaceText(text);
		String url = String.format(format, textEncoded, "pt-BR");
		return url;
	}

	public void speack() {
		try {
			MediaPlayer mediaPlayer = new MediaPlayer();
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mediaPlayer.setDataSource(getUrl());
			mediaPlayer.prepare();
			mediaPlayer.start();
		} catch (IOException e) {
			throw new TranslateException();
		}

	}
}

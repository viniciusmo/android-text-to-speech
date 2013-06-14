package com.viniciusmo.androidtextspeech;

import java.io.InputStream;

import android.content.Context;

import com.viniciusmo.androidtextspeech.player.PlayerStream;
import com.viniciusmo.androidtextspeech.translate.TranslatorSpeech;

public class Speaker {

	public static void speack(String text, Language from, Context context) {
		TranslatorSpeech translatorSpeech = new TranslatorSpeech(text, from);
		PlayerStream playerStream = new PlayerStream(context);
		InputStream inputStream = translatorSpeech.translate();
		playerStream.play(inputStream);
	}

	public static InputStream getInputStream(String text, Language from) {
		return null;
	}
}

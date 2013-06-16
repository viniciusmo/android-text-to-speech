package com.viniciusmo.androidtextspeech;

import android.content.Context;

import com.viniciusmo.androidtextspeech.translate.OnCompleteLoad;
import com.viniciusmo.androidtextspeech.translate.TranslatorSpeech;

public class Speaker {

	public static void speack(final String text, final Language from,
			final Context context) {
		TranslatorSpeech translatorSpeech = new TranslatorSpeech(text, from);
		translatorSpeech.speack();
	}

	public static void speack(final String text, final Language from,
			final Context context, final OnCompleteLoad onCompleteLoad) {
		new Thread() {
			public void run() {
				TranslatorSpeech translatorSpeech = new TranslatorSpeech(text,
						from);
				translatorSpeech.speack();
				onCompleteLoad.onCompleteLoaded();
			}
		}.start();
	}
}

package com.viniciusmo.androidtextspeech.translate;

import java.io.InputStream;

import com.viniciusmo.androidtextspeech.Language;
import com.viniciusmo.androidtextspeech.web.Encoder;
import com.viniciusmo.androidtextspeech.web.URLGoogleAPI;
import com.viniciusmo.androidtextspeech.web.WebClient;

public class TranslatorSpeech implements Translatable {
	private String text;
	private Language from;

	public TranslatorSpeech(String text, Language from) {
		this.text = text;
	}

	public String getUrl() {
		String format = URLGoogleAPI.TRANSLATE_DETECT.getUrl();
		String textEncoded = Encoder.encodeWhiteSpaceText(text);
		String url = String.format(format, textEncoded, from.getPrefix());
		return url;
	}

	public InputStream translate() {
		InputStream speech = WebClient.getInputStream(getUrl());
		return speech;
	}
}

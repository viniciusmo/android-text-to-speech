package com.viniciusmo.androidtextspeech.parser;

import com.viniciusmo.androidtextspeech.utils.Encoder;
import com.viniciusmo.androidtextspeech.utils.URLGoogleAPI;

public class ParserTextDetect implements Parseable {
	private String text;

	public ParserTextDetect(String text) {
		this.text = text;
	}

	private void doParse(String content) {
		System.out.println(content);
	}

	public String getUrl() {
		doParse(null);
		String format = URLGoogleAPI.TRANSLATE_DETECT.getUrl();
		String url = String.format(format, Encoder.encodeWhiteSpaceText(text));
		System.out.println(url);
		return url;
	}
}

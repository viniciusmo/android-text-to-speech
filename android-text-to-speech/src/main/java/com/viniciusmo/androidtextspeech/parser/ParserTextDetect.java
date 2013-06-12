package com.viniciusmo.androidtextspeech.parser;

import com.viniciusmo.androidtextspeech.utils.EncodeUtils;
import com.viniciusmo.androidtextspeech.utils.URLGoogleAPI;

public class ParserTextDetect implements Parseable {
	private String text;

	public ParserTextDetect(String text) {
		this.text = text;
	}

	public void doParse(String content) {
		System.out.println(content);
	}

	public String getUrl() {
		String format = URLGoogleAPI.TRANSLATE_DETECT.getUrl();
		String url = String.format(format,
				EncodeUtils.encodeWhiteSpaceText(text));
		System.out.println(url);
		return url;
	}
}

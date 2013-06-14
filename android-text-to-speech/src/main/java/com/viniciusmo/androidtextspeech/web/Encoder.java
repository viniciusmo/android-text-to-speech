package com.viniciusmo.androidtextspeech.web;

public class Encoder {

	public static String encodeWhiteSpaceText(String text) {
		return text.replaceAll(" ", "%20");
	}
}

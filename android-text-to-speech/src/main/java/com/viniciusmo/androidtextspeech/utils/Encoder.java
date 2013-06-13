package com.viniciusmo.androidtextspeech.utils;

public class Encoder {

	public static String encodeWhiteSpaceText(String text) {
		return text.replaceAll(" ", "%20");
	}
}

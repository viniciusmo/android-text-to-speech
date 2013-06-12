package com.viniciusmo.androidtextspeech.utils;

public class EncodeUtils {

	public static String encodeWhiteSpaceText(String text) {
		return text.replaceAll(" ", "%20");
	}
}

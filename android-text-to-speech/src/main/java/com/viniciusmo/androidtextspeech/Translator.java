package com.viniciusmo.androidtextspeech;

import com.viniciusmo.androidtextspeech.parser.TextTranslate;

public class Translator {

	public static String translate(Language from, Language to,
			String textForTranslate) {
		TextTranslate parseable = new TextTranslate(from, to,
				textForTranslate);
		return parseable.getTextTranslated();
	}

	public static Language detect(String text) {
		return Language.AFRIKAANS;
	}

}

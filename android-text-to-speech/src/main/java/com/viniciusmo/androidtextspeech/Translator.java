package com.viniciusmo.androidtextspeech;

import com.viniciusmo.androidtextspeech.parser.ParserTextTranslate;

public class Translator {

	public static String translate(Language from, Language to,
			String textForTranslate) {
		ParserTextTranslate parseable = new ParserTextTranslate(from, to,
				textForTranslate);
		return parseable.getTextTranslated();
	}

	public static Language detect(String text) {
		return Language.AFRIKAANS;
	}

}

package com.viniciusmo.androidtextspeech;

import com.viniciusmo.androidtextspeech.translate.TranslatorText;

public class Translator {

	public static String translate(Language from, Language to,
			String textForTranslate) {
		TranslatorText parseable = new TranslatorText(from, to,
				textForTranslate);
		return parseable.translateText();
	}

}

package com.viniciusmo.androidtextspeech;

import com.viniciusmo.androidtextspeech.parser.ParserTextDetect;
import com.viniciusmo.androidtextspeech.parser.ParserTextTranslate;
import com.viniciusmo.androidtextspeech.utils.WebUtils;

public class Translator {

	public static String translate(Language from, Language to,
			String textForTranslate) {
		ParserTextTranslate parseable = new ParserTextTranslate(from, to,
				textForTranslate);
		WebUtils.doContent(parseable);
		return parseable.getTextTranslated();
	}

	public static Language detect(String text) {
		ParserTextDetect parseable = new ParserTextDetect(text);
		WebUtils.doContent(parseable);
		return Language.AFRIKAANS;
	}

}

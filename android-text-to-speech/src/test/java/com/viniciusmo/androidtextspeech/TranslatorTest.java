package com.viniciusmo.androidtextspeech;

import junit.framework.TestCase;

public class TranslatorTest extends TestCase {

	public void testTranslateCadeiraForChairUsingPTBRtoEN() {
		String expected = "chair";
		String actual = Translator.translate(Language.PORTUGUESE_BR,
				Language.ENGLISH, "cadeira");
		assertEquals(expected, actual);
	}
}

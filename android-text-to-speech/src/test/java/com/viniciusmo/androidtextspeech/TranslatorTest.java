package com.viniciusmo.androidtextspeech;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TranslatorTest {

	@Test
	public void testTranslateCadeiraForChairUsingPTBRtoEN() {
		String expected = "chair";
		String actual = Translator.translate(Language.PORTUGUESE_BR,
				Language.ENGLISH, "cadeira");
		assertEquals(expected, actual);
	}

	@Test
	public void testTranslateCadeiraUsingPTBRtoChineseSimplified() {
		String expected = "椅子";
		String actual = Translator.translate(Language.PORTUGUESE_BR,
				Language.CHINESE_SIMPLIFIED, "cadeira");
		assertEquals(expected, actual);
	}

	@Test
	public void testTranslateChairForCadeiraUsingENtoPTBR() {
		String expected = "chair";
		String actual = Translator.translate(Language.PORTUGUESE_BR,
				Language.ENGLISH, "cadeira");
		assertEquals(expected, actual);
	}

	@Test
	public void testTranslateChairForCadeiraUsingPTBRtoEN() {
		String expected = "cadeira";
		String actual = Translator.translate(Language.ENGLISH,
				Language.PORTUGUESE_BR, "chair");
		assertEquals(expected, actual);
	}

	@Test
	public void testTranslateFailTextUsingENtoPTBR() {
		String expected = "asdadasdasdasdasdasd";
		String actual = Translator.translate(Language.ENGLISH,
				Language.PORTUGUESE_BR, "asdadasdasdasdasdasd");
		assertEquals(expected, actual);
	}

	@Test
	public void testTranslateShortPhraseUsingPTBRtoEN() {
		String expected = "I like to read newspapers";
		String actual = Translator.translate(Language.PORTUGUESE_BR,
				Language.ENGLISH, "gosto de ler jornais");
		assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTranslateEmptyString() {
		Translator.translate(Language.ENGLISH, Language.PORTUGUESE_BR, "");
	}

}

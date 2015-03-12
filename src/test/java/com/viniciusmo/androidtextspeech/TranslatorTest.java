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
	public void testTranslateTwoSentencesENToPTBR() {
		String expected = "cadeira cadeira cadeira cadeira cadeira cadeira. cadeira cadeira cadeira cadeira cadeira cadeira cadeira cadeira cadeira. cadeira cadeira cadeira";
		String textToTranslate = "chair chair chair chair chair chair. chair chair chair chair chair chair chair chair chair. chair chair chair";
				
		String actual = Translator.translate(Language.ENGLISH,
				Language.PORTUGUESE_BR, textToTranslate);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testTranslateWithSpecialCharacters() {
		String expected = "√ You can choose the music .";
		String textToTranslate = "√ Você pode escolher a música.";
				
		String actual = Translator.translate(Language.PORTUGUESE_BR,
				Language.ENGLISH, textToTranslate);
		assertEquals(expected, actual);
	}

	public void testTranslateFiveSentencesENToPTBR() {
		String expected = "Um computador é um dispositivo de uso geral que pode ser programada para realizar "
				+ "um conjunto finito de operações aritméticas ou lógicos. "
				+ "Uma vez que uma sequência de operações pode ser prontamente alterado,"
				+ " o computador pode resolver mais de um tipo de problema.Convencionalmente, um computador consiste em, pelo menos, um elemento de"
				+ " processamento, tipicamente, uma unidade central de processamento (CPU) e algum tipo de memória.O elemento de processamento"
				+ " realiza operações aritméticas e lógicas, e uma unidade de seqüenciamento e controle que pode mudar a ordem das"
				+ " operações com base nas informações armazenadas. Dispositivos periféricos permitem que a informação a ser recuperada a partir "
				+ "de uma fonte externa, eo resultado das operações de salva e recuperada.";
		String textToTranslate = "A computer is a general purpose device that can be programmed to "
				+ "carry out a finite set of arithmetic or logical operations. "
				+ "Since a sequence of operations can be readily changed, "
				+ "the computer can solve more than one kind of problem.Conventionally, a computer consists of at least one processing element, "
				+ "typically a central processing unit (CPU) and some form of memory.The processing element carries out arithmetic and logic operations,"
				+ " and a sequencing and control unit that can change the order of operations"
				+ " based on stored information. Peripheral devices allow information to be retrieved from an external source, and the result of operations saved and retrieved.";
		String actual = Translator.translate(Language.ENGLISH,
				Language.PORTUGUESE_BR, textToTranslate);
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
		String expected = "like reading newspapers";
		String actual = Translator.translate(Language.PORTUGUESE_BR,
				Language.ENGLISH, "gosto de ler jornais");
		assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTranslateEmptyString() {
		Translator.translate(Language.ENGLISH, Language.PORTUGUESE_BR, "");
	}

}

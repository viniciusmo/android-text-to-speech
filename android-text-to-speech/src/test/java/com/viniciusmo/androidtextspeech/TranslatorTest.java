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
		String expected = "Um computador é um dispositivo de uso geral que pode ser programada para realizar "
				+ "um conjunto finito de operações aritméticas ou lógicos. "
				+ "Uma vez que uma sequência de operações pode ser prontamente alterado,"
				+ " o computador pode resolver mais de um tipo de problema.";
		String textToTranslate = "A computer is a general purpose device that can be programmed to "
				+ "carry out a finite set of arithmetic or logical operations. "
				+ "Since a sequence of operations can be readily changed, "
				+ "the computer can solve more than one kind of problem.";
		String actual = Translator.translate(Language.ENGLISH,
				Language.PORTUGUESE_BR, textToTranslate);
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
	public void testTranslateBigSentenceENToPTBR() {
		String expected = "Um computador é um dispositivo de uso geral que pode ser programada para realizar um conjunto finito de operações aritméticas ou lógicos. Uma vez que uma sequência de operações pode ser prontamente alterado, o computador pode resolver mais de um tipo de problema.\n\nConvencionalmente, um computador consiste em, pelo menos, um elemento de processamento, tipicamente, uma unidade central de processamento (CPU) e algum tipo de memória. O elemento de processamento realiza operações aritméticas e lógicas, e uma unidade de seqüenciamento e controle que pode mudar a ordem das operações com base nas informações armazenadas. Dispositivos periféricos permitem que a informação a ser recuperada a partir de uma fonte externa, eo resultado das operações de salva e recuperada.\n\nO Computador AtanasoffBerry pelo búlgaro inventor americano John Vincent Atanasoff foi o primeiro computador automático e digital eletrônico, inventado na década de 1930 na Universidade Estadual de Iowa. Desafios para a sua reivindicação foi resolvida em 1973, quando a Honeywell v Sperry Rand ação quando Atanasoff tornou-se o inventor legal do computador de acordo com a lei dos Estados Unidos. [1] [2] [3] [4] O Z3 pelo alemão inventor Konrad Zuse de 1941 foi a primeira máquina de computação totalmente automático trabalho programável,. Assim, Zuse é frequentemente considerado como o inventor do computador. [5] [6] [7] [8]\n\nOs primeiros computadores eletrônicos digitais foram desenvolvidos entre 1940 e 1945 no Reino Unido e Estados Unidos. Originalmente, eles eram do tamanho de uma sala grande, consome tanta energia como várias centenas de modernos computadores pessoais (PCs). [9] Nesta época computadores analógicos mecânicos foram usados ​​para aplicações militares.\n\nOs computadores modernos baseados em circuitos integrados são milhões a bilhões de vezes mais capaz do que as primeiras máquinas, e ocupam uma fração do espaço. [10] computadores simples são pequenos o suficiente para caber em dispositivos móveis e computadores móveis pode ser alimentado por baterias pequenas . Os computadores pessoais em suas diversas formas são ícones da Era da Informação e são o que a maioria das pessoas pensa em como \"computadores.\" No entanto, os computadores embarcados encontrados em muitos dispositivos de MP3 players para aviões de caça e de brinquedos para robôs industriais são os mais numerosos.";
		String textToTranslate = "A computer is a general purpose device that can be programmed to carry out a finite set of arithmetic or logical operations. Since a sequence of operations can be readily changed, the computer can solve more than one kind of problem.\n\nConventionally, a computer consists of at least one processing element, typically a central processing unit (CPU) and some form of memory. The processing element carries out arithmetic and logic operations, and a sequencing and control unit that can change the order of operations based on stored information. Peripheral devices allow information to be retrieved from an external source, and the result of operations saved and retrieved.\n\nThe AtanasoffBerry Computer by the Bulgarian American inventor John Vincent Atanasoff was the first electronic automatic and digital computer, invented in the 1930s at Iowa State University. Challenges to his claim were resolved in 1973 when the Honeywell v. Sperry Rand lawsuit when Atanasoff became the legal inventor of the computer according to the Law of the United States.[1][2][3][4] The Z3 by German inventor Konrad Zuse from 1941 was the first working programmable, fully automatic computing machine. Thus, Zuse is often regarded as the inventor of the computer.[5][6][7][8]\n\nThe first electronic digital computers were developed between 1940 and 1945 in the United Kingdom and United States. Originally they were the size of a large room, consuming as much power as several hundred modern personal computers (PCs).[9] In this era mechanical analog computers were used for military applications.\n\nModern computers based on integrated circuits are millions to billions of times more capable than the early machines, and occupy a fraction of the space.[10] Simple computers are small enough to fit into mobile devices, and mobile computers can be powered by small batteries. Personal computers in their various forms are icons of the Information Age and are what most people think of as \"computers.\"However, the embedded computers found in many devices from MP3 players to fighter aircraft and from toys to industrial robots are the most numerous.";
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

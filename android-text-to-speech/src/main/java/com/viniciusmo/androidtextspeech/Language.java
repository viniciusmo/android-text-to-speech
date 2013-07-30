package com.viniciusmo.androidtextspeech;

public enum Language {

	AFRIKAANS("af"), ALBANIAN("sq"), ARABIC("ar"), ARMENIAN("hy"), AZERBAIJANI(
			"az"), BASQUE("eu"), BELARUSIAN("be"), BENGALI("bn"), BULGARIAN(
			"bg"), CATALAN("ca"), CHINESE("zh-CN"), CROATIAN("hr"), CZECH("cs"), DANISH(
			"da"), DUTCH("nl"), ENGLISH("en"), ESTONIAN("et"), FILIPINO("tl"), FINNISH(
			"fi"), FRENCH("fr"), GALICIAN("gl"), GEORGIAN("ka"), GERMAN("de"), GREEK(
			"el"), GUJARATI("gu"), HAITIAN_CREOLE("ht"), HEBREW("iw"), HINDI(
			"hi"), HUNGARIAN("hu"), ICELANDIC("is"), INDONESIAN("id"), IRISH(
			"ga"), ITALIAN("it"), JAPANESE("ja"), KANNADA("kn"), KOREAN("ko"), LATIN(
			"la"), LATVIAN("lv"), LITHUANIAN("lt"), MACEDONIAN("mk"), MALAY(
			"ms"), MALTESE("mt"), NORWEGIAN("no"), PERSIAN("fa"), POLISH("pl"), PORTUGUESE(
			"pt"), PORTUGUESE_BR("pt-BR"), ROMANIAN("ro"), RUSSIAN("ru"), SERBIAN(
			"sr"), SLOVAK("sk"), SLOVENIAN("sl"), SPANISH("es"), SWAHILI("sw"), SWEDISH(
			"sv"), TAMIL("ta"), TELUGU("te"), THAI("th"), TURKISH("tr"), UKRAINIAN(
			"uk"), URDU("ur"), VIETNAMESE("vi"), WELSH("cy"), YIDDISH("yi"), CHINESE_SIMPLIFIED(
			"zh-CN"), CHINESE_TRADITIONAL("zh-TW");
	private String prefix;

	private Language(String prefix) {
		this.prefix = prefix;
	}

	public String getPrefix() {
		return prefix;
	}
	
	public static Language fromString(String prefix){
		for(Language l : EnumSet.allOf(Language.class)){
			if(l.getPrefix().equalsIgnoreCase(prefix)){
				return l;
			}
		}
		return null;
	}

}

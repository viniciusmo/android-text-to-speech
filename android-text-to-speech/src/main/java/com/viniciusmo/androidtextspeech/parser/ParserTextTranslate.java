package com.viniciusmo.androidtextspeech.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.viniciusmo.androidtextspeech.Language;
import com.viniciusmo.androidtextspeech.utils.URLGoogleAPI;

public class ParserTextTranslate implements Parseable {

	private Language from;
	private Language to;
	private String textForTranslate;
	private String textTranslated;

	public ParserTextTranslate(Language from, Language to,
			String textForTranslate) {
		this.from = from;
		this.to = to;
		this.textForTranslate = verifyTextIsEmpty(textForTranslate);
	}

	private String verifyTextIsEmpty(String text) {
		if (text.isEmpty()) {
			throw new IllegalArgumentException("TextForTranslate is empty");
		}
		return text;
	}

	public void doParse(String content) {
		try {
			JSONObject jObject = new JSONObject(content);
			JSONArray sentences = (JSONArray) jObject.get("sentences");
			textTranslated = (String) sentences.getJSONObject(0).get("trans");
		} catch (JSONException e) {
			throw new ParserException();
		}
	}

	private String encodeTextTranslateParam() {
		return textForTranslate.replace(" ", "%20");
	}

	public String getUrl() {
		String format = URLGoogleAPI.TRANSLATE_TEXT.getUrl();
		String url = String.format(format, from.getPrefix(), from.getPrefix(),
				to.getPrefix(), encodeTextTranslateParam());
		return url;
	}

	public String getTextTranslated() {
		return textTranslated;
	}

}

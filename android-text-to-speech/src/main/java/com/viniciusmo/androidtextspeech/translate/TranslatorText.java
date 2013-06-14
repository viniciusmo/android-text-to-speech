package com.viniciusmo.androidtextspeech.translate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.viniciusmo.androidtextspeech.Language;
import com.viniciusmo.androidtextspeech.web.Encoder;
import com.viniciusmo.androidtextspeech.web.URLGoogleAPI;
import com.viniciusmo.androidtextspeech.web.WebClient;

public class TranslatorText implements Translatable {

	private Language from;
	private Language to;
	private String textForTranslate;
	private String textTranslated;

	public TranslatorText(Language from, Language to, String textForTranslate) {
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

	private void doParse(String content) {
		try {
			JSONObject jObject = new JSONObject(content);
			JSONArray sentences = (JSONArray) jObject.get("sentences");
			textTranslated = (String) sentences.getJSONObject(0).get("trans");
		} catch (JSONException e) {
			throw new TranslateException();
		}
	}

	public String getUrl() {
		String format = URLGoogleAPI.TRANSLATE_TEXT.getUrl();
		String url = String.format(format, from.getPrefix(), from.getPrefix(),
				to.getPrefix(), Encoder.encodeWhiteSpaceText(textForTranslate));
		return url;
	}

	public String translateText() {
		String content = WebClient.getContent(getUrl());
		doParse(content);
		return textTranslated;
	}

}

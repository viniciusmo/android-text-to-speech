package com.viniciusmo.androidtextspeech.translate;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

import com.viniciusmo.androidtextspeech.Language;
import com.viniciusmo.androidtextspeech.web.URLGoogleAPI;
import com.viniciusmo.androidtextspeech.web.WebClient;

public class TranslatorText implements Translatable {

	private Language from;
	private Language to;
	private String textForTranslate;
	private StringBuilder textTranslated;

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
			int index = 0;
			getTextTranslated(content, index);
		} catch (JSONException e) {
			throw new TranslateException();
		}
	}

	private void getTextTranslated(String content, int index)
			throws JSONException {
		JSONArray jsonArray = new JSONArray(content);
		JSONArray sentences = jsonArray.getJSONArray(0);
		for (int i = 0; i < sentences.length(); i++) {
			JSONArray sentence = sentences.getJSONArray(i);
			textTranslated.append(sentence.get(0).toString());
		}
	}

	public String getUrl() {
		String url = null;
		url = formatURL();
		return url;
	}

	private String formatURL() {
		String url;
		String format = URLGoogleAPI.TRANSLATE_TEXT.getUrl();
		url = String.format(format, from.getPrefix(), from.getPrefix(),
				to.getPrefix());
		return url;
	}

	public String translateText() {
		textTranslated = new StringBuilder();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("q", textForTranslate));
		String content = WebClient.doPost(getUrl(), nameValuePairs);
		doParse(content);
		return textTranslated.toString();
	}
}

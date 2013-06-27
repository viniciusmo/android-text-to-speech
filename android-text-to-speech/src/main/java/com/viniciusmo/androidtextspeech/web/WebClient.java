package com.viniciusmo.androidtextspeech.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class WebClient {

	public static String doGet(String urlSite) {
		StringBuilder result = new StringBuilder();
		URL url;
		URLConnection urlConn;
		try {
			url = new URL(urlSite);
			urlConn = url.openConnection();
			urlConn.addRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			Reader reader = new InputStreamReader(urlConn.getInputStream(),
					"utf-8");
			BufferedReader br = new BufferedReader(reader);
			int byteRead;
			while ((byteRead = br.read()) != -1)
				result.append((char) byteRead);
		} catch (IOException e) {
			throw new WebClientException();
		}
		return result.toString();
	}

	public static String doPost(String urlSite, List<NameValuePair> parameters) {
		String result = new String();
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(urlSite);
		try {
			httppost.setEntity(new UrlEncodedFormEntity(parameters));
			HttpResponse response = httpclient.execute(httppost);
			result = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			throw new WebClientException();
		}
		return result;
	}
}

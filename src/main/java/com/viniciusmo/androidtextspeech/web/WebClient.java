package com.viniciusmo.androidtextspeech.web;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.NameValuePair;

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
		String urlParameters;
		try {
			urlParameters = "q="
					+ URLEncoder.encode(parameters.get(0).getValue(), "UTF-8");
			return executePost(urlSite, urlParameters);
		} catch (Exception e) {
			throw new WebClientException();
		}
	}

	public static String executePost(String targetURL, String urlParameters) {
		URL url;
		HttpURLConnection connection = null;
		try {
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.addRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			connection.setRequestProperty("Content-Length",
					"" + Integer.toString(urlParameters.getBytes().length));

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Send request
			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}

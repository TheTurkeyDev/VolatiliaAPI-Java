package com.theprogrammingturkey.volatiliajava.resources;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.theprogrammingturkey.volatiliajava.resources.ConsoleLogger.Level;

public class HTTPUtil
{
	public static String makeRequest(String link, RequestType type, Map<String, String> extras) throws Exception
	{
		HttpURLConnection con = (HttpURLConnection) new URL(link).openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setReadTimeout(5000);
		con.setRequestProperty("Connection", "keep-alive");
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:16.0) Gecko/20100101 Firefox/16.0");
		((HttpURLConnection) con).setRequestMethod(type.name());
		con.setConnectTimeout(5000);

		StringBuilder builder = new StringBuilder();

		for(String property : extras.keySet())
		{
			builder.append(property);
			builder.append("=");
			builder.append(extras.get(property));
			builder.append("&");
		}

		if(builder.length() > 0)
			builder.deleteCharAt(builder.length() - 1);

		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(builder.toString());
		wr.flush();
		wr.close();

		BufferedInputStream in = new BufferedInputStream(con.getInputStream());
		int responseCode = con.getResponseCode();

		if(responseCode != HttpURLConnection.HTTP_OK && responseCode != HttpURLConnection.HTTP_MOVED_PERM)
			ConsoleLogger.log(Level.WARNING, "Update request returned response code: " + responseCode + " " + con.getResponseMessage());
		else if(responseCode == HttpURLConnection.HTTP_MOVED_PERM)
			throw new Exception();

		StringBuilder buffer = new StringBuilder();
		int chars_read;
		while((chars_read = in.read()) != -1)
			buffer.append((char) chars_read);

		return buffer.toString();
	}

	public enum RequestType
	{
		GET, POST, PUT, DELETE, UPDATE;
	}
}

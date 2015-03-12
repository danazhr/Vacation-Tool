package com.pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenWebPage {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		//String url = "http://www.google.com/search?q=car";
		String url = "https://www.google.ro/search?q=whey";

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.20 (KHTML, like Gecko) Chrome/11.0.672.2 Safari/534.20");
		HttpResponse response = client.execute(request);

		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
			//System.out.println(line);
		}
		
		System.out.println(result.toString());
		
		String strResult = result.toString();
		
		int index1 = strResult.indexOf("<body");
		int index2 = strResult.indexOf("</body>");
		String strNew = strResult.substring(index1,index2);
		System.out.println(strNew);
		
		int start_index_of_link = strNew.indexOf("<h3 class=\"r\"><a href=\"");
		strNew = strNew.substring(start_index_of_link);
		int end_index_of_link = strNew.indexOf("\" onmousedown");
		String strLink = strNew.substring(23,end_index_of_link);
		System.out.println(strLink);
		
		WebDriver driver = new FirefoxDriver();
		driver.get(strLink);
	
	}
	
}

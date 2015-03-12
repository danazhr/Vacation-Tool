package com.pages;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import net.thucydides.core.annotations.findby.By;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenWebPage {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		
		//String url = "http://www.google.com/search?q=car";
		String url = "https://www.google.ro/search?q=car&gws_rd=cr,ssl&ei=8IkBVdL0OvON7AbJsYCYBg#q=car";

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.20 (KHTML, like Gecko) Chrome/11.0.672.2 Safari/534.20");
		HttpResponse response = client.execute(request);

		System.out.println("Response Code : "
				+ response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
			System.out.println(line);
		}
		OpenWebPage.OpenFirsLink(args);	
	
}
	
	public static void OpenFirsLink (String[] args) {

	    WebDriver driver = new FirefoxDriver();
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));
	    element.sendKeys("car!\n"); // send also a "\n"
	    element.submit();

	    // wait until the google page shows the result
	    WebElement myDynamicElement = (new WebDriverWait(driver, 10))
	             .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
	    String path = "ol[id='rso'] h3[class='r'] a";
	    driver.findElements(By.cssSelector(path)).get(0);
	    	    
	    
	    // this are all the links you like to visit
	    //for (WebElement webElement : path)
	   // 	{
	       // System.out.println(webElement.getAttribute("href"));
	    //	}
	}
}

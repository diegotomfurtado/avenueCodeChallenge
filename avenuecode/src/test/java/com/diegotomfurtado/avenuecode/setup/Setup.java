package com.diegotomfurtado.avenuecode.setup;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {

	public static WebDriver setUpBrowser() {

		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		browser.get("https://qa-test.avenuecode.com/");
		return browser;
	}
}

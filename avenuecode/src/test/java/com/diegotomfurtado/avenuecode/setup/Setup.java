package com.diegotomfurtado.avenuecode.setup;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {

	public static WebDriver setUpBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Drivers\\DrivesAutomations\\chromedriver.exe");

		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		browser.get("https://qa-test.avenuecode.com/");
		return browser;
	}
}

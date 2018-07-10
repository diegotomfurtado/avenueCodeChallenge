package com.diegotomfurtado.avenuecode.pages;

import org.openqa.selenium.WebDriver;

public class BasePages {
	protected WebDriver browser;
	
	public BasePages(WebDriver browser){
		this.browser = browser;
	}
}

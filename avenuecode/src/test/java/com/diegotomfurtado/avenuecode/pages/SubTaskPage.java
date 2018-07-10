package com.diegotomfurtado.avenuecode.pages;

import static org.openqa.selenium.By.id;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.By.xpath;

public class SubTaskPage extends BasePages {

	private final By taskIdFieldLocator = id("edit_task");
	private final By buttonCloseLocator = xpath("//button[contains(@ng-click,'close')]");
	private final By descriptionFiledLocator = id("new_sub_task");
	private final By addButtonLocator = id("add-subtask");
	private final By checkingStringFromDescriptionFieldLocator = xpath(".//a[contains(@onaftersave,'updateSubTask(sub_task)')]");

	public SubTaskPage(WebDriver browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	public SubTaskPage enterValueOnTaskIdField(String name) {

		browser.findElement(taskIdFieldLocator).clear();
		browser.findElement(taskIdFieldLocator).sendKeys(name);
		return this;
	}

	public String getTaskNameId() {
		return browser.findElement(taskIdFieldLocator).getText();
	}

	public MyTaskPage buttonCloseSubTask() {

		browser.findElement(buttonCloseLocator).click();
		return new MyTaskPage(browser);
	}

	public SubTaskPage enterValueOnSubTaskIdDescriptionField(String name) {
		browser.findElement(descriptionFiledLocator).clear();
		browser.findElement(descriptionFiledLocator).sendKeys(name);
		return this;
	}

	public SubTaskPage clickOnAddSubtaskButton() {
		browser.findElement(addButtonLocator).click();
		return this;
	}

	public String checkingStringFromDescriptionField() {

		return browser.findElement(checkingStringFromDescriptionFieldLocator)
				.getText();
	}

}

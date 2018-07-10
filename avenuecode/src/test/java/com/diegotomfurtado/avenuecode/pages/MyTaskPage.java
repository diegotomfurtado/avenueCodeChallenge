package com.diegotomfurtado.avenuecode.pages;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyTaskPage extends BasePages {

	private final By tableTasksLocator = xpath(".//table[contains(@class, 'table')]");
	private final By getMessageOnTop = xpath(".//div[@class='container']/h1");
	private final By newTaskButtonLocator = xpath(".//span[@class='input-group-addon glyphicon glyphicon-plus']");
	private final By checkingEmptyTaskLocator = xpath(".//a[@class='ng-scope ng-binding editable editable-click editable-empty']");
	private final By checkingNewTaskCreatedLocator = xpath(".//a[@class='ng-scope ng-binding editable editable-click']");
	private final By checkingLableManageSubtaskLocator = xpath("//following-sibling::td//button[@ng-click='editModal(task)']");
	private final By openSubTaksPouupLocator = xpath(".//button[contains(@class,'btn btn-xs btn-primary ng-binding')]");
	private final By tableOfSubtasksCreatedLocator = xpath("//div[contains(@class,'modal-content')]//tbody/tr");
	private final By taskIdNameFromMyTaskPageLocator = xpath("//a[contains(@class,'ng-scope ng-binding editable editable-click')]");
	
	public MyTaskPage(WebDriver browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	public boolean findTableTaskOnPage() {
		return browser.findElement(tableTasksLocator).isDisplayed();
	}

	public String getConfirmationMessageOnTheTop() {
		return browser.findElement(getMessageOnTop).getText();
	}

	public void clickNewTaskBykeyOfKeyboard() {
		browser.findElement(id("new_task")).sendKeys(Keys.ENTER);
	}

	public String returnAlertMessageNewTaskEmptyField() {

		return browser.switchTo().alert().getText();
	}

	public MyTaskPage typeNewTaskField(String nameOfTask) {
		browser.findElement(id("new_task")).sendKeys(nameOfTask);
		return this;
	}

	public MyTaskPage clickNewTaskButton() {
		browser.findElement(newTaskButtonLocator).click();
		return this;
	}

	public String checkingEmptyTaskAfterAddingEmptyString() {
		return browser.findElement(checkingEmptyTaskLocator).getText();
	}

	public String checkingNewTaskCreated() {
		return browser.findElement(checkingNewTaskCreatedLocator).getText();
	}

	public String checkingLableManageSubtask(){
		return browser.findElement(checkingLableManageSubtaskLocator).getText();
	}

	public SubTaskPage openSubTaksPouup(){
		
		browser.findElement(openSubTaksPouupLocator).click();
		return new SubTaskPage(browser);
	}
	
	public int checkingANumberOfSubtasksCreated(){
		
		List<WebElement> located_elements = browser.findElements(tableOfSubtasksCreatedLocator);
		
		int count=0;
		for(WebElement located_element : located_elements){
			count++;
		}
		return count;
	}
	
	public String taskIdNameFromMyTaskPage(){
		
		return browser.findElement(taskIdNameFromMyTaskPageLocator).getText();
	}
	
}

package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlogPage {
    //variables
    WebDriver driver;
    WebDriverWait wait;

    //locators
    private By fullNameBox = By.id("fullname");
    private By emailBox = By.id("email");
    private By subscribeButton = By.id("_form_5_submit");
    private By thanksMessage = By.xpath("//*[contains(@id,'_form_')]/div[2]");
    private By fullNameErrorMessage = By.xpath("//*[contains(@id,'_form_')]/div[1]/div[2]/div/div/div[2]");
    private By emailErrorMessage = By.xpath("//*[contains(@id,'_form_')]/div[1]/div[3]/div/div/div[2]");

    //constructor
    public BlogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions
    public String readFullNameBoxPlaceHolder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameBox));
        String placeholderText = driver.findElement(fullNameBox).getAttribute("placeholder");
        System.out.println("Placeholder: " + placeholderText);
        return placeholderText;
    }
    public String readEmailPlaceHolder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBox));
        String placeholderText = driver.findElement(emailBox).getAttribute("placeholder");
        System.out.println("Placeholder: " + placeholderText);
        return placeholderText;
    }
    public String readThanksMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(thanksMessage));
        return driver.findElement(thanksMessage).getText();
    }
    public void insertFullName(String fullName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameBox));
        driver.findElement(fullNameBox).sendKeys(fullName);
    }

    public void insertEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBox));
        driver.findElement(emailBox).sendKeys(email);
    }
    public void clickOnSubscribe(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(subscribeButton));
        driver.findElement(subscribeButton).click();
    }

    public String readFullNameBoxText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameBox));
        return driver.findElement(fullNameBox).getAttribute("value");
    }
    public String readEmailBoxText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBox));
        return driver.findElement(emailBox).getAttribute("value");

    }
    public String readFullNameErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameErrorMessage));
        return driver.findElement(fullNameErrorMessage).getText();
    }
    public String readEmailErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailErrorMessage));
        return driver.findElement(emailErrorMessage).getText();
    }
}

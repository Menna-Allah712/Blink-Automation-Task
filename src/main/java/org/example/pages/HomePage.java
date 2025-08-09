package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    //variables
    WebDriver driver;
    WebDriverWait wait;

    //locators
    private By blogLink = By.linkText("BLOG");

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //actios
    public BlogPage clickBlogLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(blogLink));
        driver.findElement(blogLink).click();
        return new BlogPage(driver);
    }
}

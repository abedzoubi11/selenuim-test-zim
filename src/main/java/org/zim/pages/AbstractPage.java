package org.zim.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.FluentWait;
import org.zim.context.ThreadWebDriver;

import java.time.Duration;

public class AbstractPage {
    /**
     * The driver.
     */
    protected WebDriver driver = ThreadWebDriver.getDriver();

    /**
     * The waiter.
     */
    protected FluentWait<WebDriver> waiter = new FluentWait<>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
            .withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
}

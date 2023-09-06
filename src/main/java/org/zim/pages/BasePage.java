package org.zim.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

/**
 * The Class BasePage every Page should extend this class.
 *
 * @AbedZoabi
 */
public class BasePage extends AbstractPage{

	public BasePage() {
		super();
		PageFactory.initElements(driver, this);
	}

}

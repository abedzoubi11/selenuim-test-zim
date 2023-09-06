package org.zim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class TablePage extends AbstractPage{

	@FindBy(xpath = "//table[@id='customers']")
	private WebElement customersTable;

	@FindBy(xpath= "//body/div[@id='belowtopnav']/div[1]/div[1]/h1[1]")
	private WebElement pageTitle;

	//    @FindBy(tagName = "input")
//    private WebElement locationString;
	public void waitForWebElement(WebElement webElement, int timeOutInSeconds) {
		new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(webElement));
	}

	public void waitForWebElement(By byLocator, int timeOutInSeconds) {
		new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	public TablePage() {
		PageFactory.initElements(driver, this);
		waitForWebElement(pageTitle, 20);
	}



	// Function to get table cell text by XPath expression
	public String getTableCellTextByXpath(int searchColumn,String searchText,int returnColumnText)  {


		String xpathExpression = "//table/tbody/tr/td[" + (searchColumn) + "][contains(., '" + searchText + "')]";
		try {


			// Use the XPath expression to find matching cells
			List<WebElement> matchingCells = customersTable.findElements(By.xpath(xpathExpression));

			// Check if any matching cell was found
			if (!matchingCells.isEmpty()) {
				// Get the parent row (ancestor::tr) of the first matching cell and extract its row index
				WebElement matchingCell = matchingCells.get(0);
				WebElement parentRow = matchingCell.findElement(By.xpath("./ancestor::tr"));
				List<WebElement> rows = customersTable.findElements(By.xpath(".//tr"));
				int rowNumber = rows.indexOf(parentRow);
				String returnedValueXpath = "//table/tbody/tr[" + (rowNumber + 1) + "]/td[" + (returnColumnText) + "]";
				WebElement cell = customersTable.findElement(By.xpath(returnedValueXpath));
				String returnedValue = cell.getText();
				return returnedValue;

			} else {
				return null;
			}
		} catch (NoSuchElementException e){
			System.err.println("The element" + e.getMessage() + " Is not exist");

		} catch (Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}


	public boolean verifyTableCellText(int searchColumn, String searchText, int returnColumnText, String expectedText) {
		String actualValue = getTableCellTextByXpath(searchColumn,searchText, returnColumnText);
		if(actualValue.compareTo(expectedText) == 0)
			return true;
		return false;
	}


	public String getTableCellText(int searchColumn, String searchText, int returnColumnText)  {
		String returnedValue = getTableCellTextByXpath(searchColumn,searchText, returnColumnText);
		return returnedValue;
	}
}

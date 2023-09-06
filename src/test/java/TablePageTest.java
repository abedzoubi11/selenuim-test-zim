import org.testng.annotations.DataProvider;
import org.zim.infra.TestProperties;
import org.zim.pages.TablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The Class TablePageTest.
 *
 * @author AbedZoabi
 */
@Test(testName = "Test Company Island Trading", description = "Send company name Island Trading with search column 1 and returned column 3 to get the Country")
public class TablePageTest extends BaseTest {

	/**
	 * Positive test getting country for "Island Trading" company
	 */
	@Test(dataProvider = "additionData")
	public void getCountryByCompanyTest(int searchColumn, String searchText,int returnColumnText) {
		driver.get(TestProperties.getProperty("url"));
		TablePage tablePage = new TablePage();
		String returnedValue = tablePage.getTableCellText(searchColumn,searchText, returnColumnText);
		Assert.assertTrue(tablePage.verifyTableCellText(returnColumnText,returnedValue,searchColumn,"Island Trading"));
	}

	@DataProvider(name = "additionData")
	public Object[][] additionData() {
		return new Object[][] {
				{ 1, "Island Trading", 3 },// Will pass
				{ 2, "UK", 5  }// Will fail
		};
	}
}

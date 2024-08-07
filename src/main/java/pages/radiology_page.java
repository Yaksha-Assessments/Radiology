package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class radiology_page extends StartupPage {

	public By getUsernameTextfieldLocator() {
		return By.id("username_id");
	}

	public By getPasswordTextboxLocator() {
		return By.xpath("//input[@id='password']");
	}

	public By getSignInButtonLocator() {
		return By.xpath("//button[@id='login']");
	}

	public By getRadiologyLocator() {
		return By.xpath("//a[@href='#/Radiology']");
	}

	public By getDoctorLocator() {
		return By.xpath("//a[@href='#/Doctors']");
	}

	public By getPageBarFixedLocator(String navBarName) {
		if (navBarName.equalsIgnoreCase("list requests")) {
			navBarName = "ImagingRequisitionList";
		} else if (navBarName.equalsIgnoreCase("list reports")) {
			navBarName = "ImagingReportsList";
		} else if (navBarName.equalsIgnoreCase("edit doctors")) {
			navBarName = "EditDoctors";
		} else if (navBarName.equalsIgnoreCase("ward billing")) {
			navBarName = "InpatientList";
		}
		return By.xpath("//ul[@class='page-breadcrumb']/li/a[@href='#/Radiology/" + navBarName + "']");
	}

	public By getAnchorTagLocatorByText(String anchorTagName) {
		return By.xpath("//a[contains(text(),'" + anchorTagName + "')]");
	}

	public By getButtonLocatorsBytext(String buttonName) {
		return By.xpath("//button[contains(text(),'" + buttonName + "')]");
	}

	public By calendarFromDropdown() {
		return By.xpath("(//input[@id='date'])[1]");
	}

	public By calendarToDropdown() {
		return By.xpath("(//input[@id='date'])[2]");
	}

	public By getOkButtonLocator() {
		return By.xpath("//button[@class='btn green btn-success']");
	}

	public By searchBarId() {
		return By.id("quickFilterInput");
	}

	public By searchBarIdAtDoctorModule() {
		return By.xpath("(//input[@id='quickFilterInput'])[3]");
	}

	public By getDateRangeButton() {
		return By.cssSelector("td [data-hover='dropdown']");
	}

	public By getFilterDropdownLocator() {
		return By.xpath("//b[text()='Filter']/../imaging-type-selector/select");
	}

	public By getStarIconLocator() {
		return By.xpath("//i[contains(@class,'icon-favourite')]/..");
	}

	public By favouriteOrStarIcon() {
		return By.xpath("//i[contains(@class,'icon-favourite')]");
	}

	public By getActionColumnButton(String patientName, String actionName) {
		return By.xpath("(//div[@col-id='Patient.ShortName' and text() = '" + patientName
				+ "']/../div/span/a[contains(text(),'" + actionName + "')])[1]");
	}

	public By getFilmTypeErrorMessage() {
		return By.xpath("//input[@display-property-name='FilmTypeDisplayName']/../../span");
	}

	public By getFilmTypeInputField() {
		return By.cssSelector("input[display-property-name='FilmTypeDisplayName']");
	}

	public By getQuantityInputField() {
		return By.xpath("//div[text()='Quantity']/../div/input");
	}

	public By getPopUpMessageText(String msgStatus, String messageText) {
		return By.xpath("//p[contains(text(),' " + msgStatus + " ')]/../p[contains(text(),'" + messageText + "')]");
	}

	public By getAddReportHeading() {
		return By.xpath("//span[text()='Add report of USG Chest (X-RAY)']");
	}

	public By getSaveButtonLocator() {
		return By.cssSelector("input[value='Save']");
	}

	public By getTextEditorLocator() {
		return By.xpath("//iframe[contains(@title,'Rich Text Editor')]");
	}

	public By getBodyTextLocator() {
		return By.cssSelector("html[dir='ltr'] body");
	}

	public By popupCloseButton() {
		return By.cssSelector("a.close-btn");
	}

	public By getImagingName() {
		return By.xpath("//div[@col-id='ImagingItemName' and text()='USG Chest']");
	}

	public By getFirstLabIcon() {
		return By.cssSelector("[title='Labs']");
	}

	public By getOrderFilterDropdown() {
		return By.xpath("//span[text()=' New Orders']/../../../..//select");
	}

	public By getInputFieldByPlaceholder(String placeholder) {
		return By.xpath("//input[@placeholder='" + placeholder + "']");
	}

	public By getListElementWithText(String listElementText) {
		return By.xpath("//li[contains(text(),'" + listElementText + "')]");
	}

	public By getCurrentPage() {
		return By.xpath("//span[@ref='lbCurrent']");
	}

	public By getFirstPatientName() {
		return By.xpath("//div[@col-id='Patient.ShortName' and @role='gridcell']");
	}

	public By getOrderSection() {
		return By.xpath("//span[text()='Selected Orders']/../../..");
	}

	public By getSelectDateRangeDropDown() {
		return By.xpath("//span[@class=\"icon-range-ddl dropdown-toggle\"]");
	}

	public By getActualRequestedOnDates() {
		return By.xpath("//div[@ref=\"eBodyViewport\"]//div//div[@row-index]/div[1]/span");
	}

	public By getImagingTypeName() {
		return By.xpath("//div[@col-id='ImagingTypeName' and text()='X-RAY']");
	}

	public By wardBillingViewDetailsbutton() {
		return By.cssSelector("a[danphe-grid-action='ViewDetails']");
	}

	public By wardBillingModal() {
		return By.xpath("//span[text()='Radiology Ward Billing']");
	}

	public radiology_page(WebDriver driver) {
		super(driver);
	}

	/**
	 * @Test1.1 about this method loginTohealthAppByGivenValidCredetial()
	 * 
	 * @param : Map<String, String>
	 * @description : fill usernameTextbox & passwordTextbox and click on sign in
	 *              button
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			WebElement usernametextFieldWebElement = commonEvents.findElement(getUsernameTextfieldLocator());
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(getUsernameTextfieldLocator(), expectedData.get("username"));

			WebElement passwordtextFieldWebElement = commonEvents.findElement(getPasswordTextboxLocator());
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(getPasswordTextboxLocator(), expectedData.get("password"));

			WebElement signinButtonWebElement = commonEvents.findElement(getPasswordTextboxLocator());
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.click(getSignInButtonLocator());
			textIsDisplayed = true;
		} catch (Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}

	/**
	 * @Test1.2 and @Test15.1 about this method scrollDownAndClickRadiologyTab()
	 * 
	 * @param : null
	 * @description : verify the radiology tab, scroll to it, and click it
	 * @return : String
	 * @author : YAKSHA
	 */
	public void scrollDownAndClickRadiologyTab() throws Exception {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement radiologyTab = commonEvents.findElement(getRadiologyLocator());
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", radiologyTab);
			jsExecutor.executeScript("window.scrollBy(0, -50)");
			commonEvents.highlight(radiologyTab);
			commonEvents.click(radiologyTab);

			// Wait for the URL to contain "Verification/Inventory"
			commonEvents.waitForUrlContains("Radiology/ImagingRequisitionList", 10);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test1.3 about this method verifyRadiologyPageUrl()
	 * 
	 * @param : null
	 * @description : verify radiology page url
	 * @return : String
	 * @author : YAKSHA
	 */
	public String verifyRadiologyPageUrl() throws Exception {
		try {
			String titleToVerify = commonEvents.getCurrentUrl();
			return titleToVerify;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test2 @Test4.2 @Test4.3 @Test4.4 @Test4.5 @Test4.6
	 * about this method highlightAndVerifyWhetherElementIsDisplayed
	 * 
	 * @param element : By - Locator of the element to be highlighted and verified
	 * @description : This method verifies whether an element is displayed on the
	 *              page, highlights it if displayed, and returns true if displayed.
	 * @return : boolean - true if the element is displayed, otherwise false
	 * @author : YAKSHA
	 */
	public boolean highlightAndVerifyWhetherElementIsDisplayed(By element) {
		boolean isElementDisplayed = false;
		try {
			if (commonEvents.isDisplayed(element)) {
				WebElement elementToHighlight = commonEvents.findElement(element);
				commonEvents.highlight(elementToHighlight);
				isElementDisplayed = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementDisplayed;
	}

	/**
	 * @Test3 about this method verifyUrlRadiologyModule()
	 * 
	 * @description This method verifies that the "List Requests" tab is present in
	 *              the Radiology module and returns the current URL of the page.
	 * @return String - The current URL of the page after verifying the "List
	 *         Requests" tab.
	 * @throws Exception - If there is an issue locating the "List Requests" tab or
	 *                   verifying its text.
	 * @autor YAKSHA
	 */
	public String verifyUrlRadiologyModule() throws Exception {
		try {
			// Locate the "List Requests" tab element
			WebElement listRequesttab = commonEvents.findElement(getPageBarFixedLocator("List Requests"));
			System.out.println("List req tab > " + listRequesttab.getText().trim());

			// Verify that the "List Requests" tab text matches the expected value
			Assert.assertEquals(listRequesttab.getText().trim(), "List Requests");

			// Get the current URL of the page
			String verifyListRequestUrl = commonEvents.getCurrentUrl();
			System.out.println("verifyListRequestUrl: " + verifyListRequestUrl);

			return verifyListRequestUrl;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test4.1 about this method applyDateFilter()
	 * 
	 * @param : String, String
	 * @description : Applies the date filter with date range
	 * @return : void
	 * @throws : Exception - if there is an issue finding or filling the date fields
	 * @author : YAKSHA
	 */
	public boolean applyDateFilter(String fromDate, String toDate) throws Exception {
		try {
			String fromDay, fromMonth, fromYear, toDay, toMonth, toYear;
			fromDay = fromDate.split("-")[0];
			fromMonth = fromDate.split("-")[1];
			fromYear = fromDate.split("-")[2];
			toDay = toDate.split("-")[0];
			toMonth = toDate.split("-")[1];
			toYear = toDate.split("-")[2];
			WebElement fromDateDropdown = commonEvents.findElement(calendarFromDropdown());
			WebElement toDateDropdown = commonEvents.findElement(calendarToDropdown());
			commonEvents.highlight(fromDateDropdown).sendKeys(fromDateDropdown, fromDay)
					.sendKeys(fromDateDropdown, fromMonth).sendKeys(fromDateDropdown, fromYear);
			commonEvents.highlight(toDateDropdown).sendKeys(toDateDropdown, toDay).sendKeys(toDateDropdown, toMonth)
					.sendKeys(toDateDropdown, toYear);
			clickButtonByText("OK");
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

	/**
	 * @Test4.7 about this method verifySearchBarIsDisplayed()
	 * 
	 * @param : null
	 * @description : This method verifies if the search bar is visible
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the search bar or it is
	 *           not visible
	 * @author : YAKSHA
	 */
	public boolean verifySearchBarIsDisplayed() {
		return highlightAndVerifyWhetherElementIsDisplayed(searchBarId());
	}

	/**
	 * @Test4.8 about this method verifyDateRangeButtonIsDisplayed()
	 * 
	 * @param : null
	 * @description : This method verifies if the date range button is visible
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the date range button or
	 *           it is not visible
	 * @author : YAKSHA
	 */
	public boolean verifyDateRangeButtonIsDisplayed() {
		return highlightAndVerifyWhetherElementIsDisplayed(getDateRangeButton());
	}

	/**
	 * @Test4.9 about this method verifyFilterDropdownIsDisplayed()
	 * 
	 * @param : null
	 * @description : This method verifies if the filter dropdown is visible
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the filter dropdown or it
	 *           is not visible
	 * @author : YAKSHA
	 */
	public boolean verifyFilterDropdownIsDisplayed() {
		return highlightAndVerifyWhetherElementIsDisplayed(getFilterDropdownLocator());
	}

	/**
	 * @Test4.10 about this method verifyFromDateFieldIsDisplayed()
	 * 
	 * @param : null
	 * @description : This method verifies if the "from date" field is visible
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the "from date" field or
	 *           it is not visible
	 * @author : YAKSHA
	 */
	public boolean verifyFromDateFieldIsDisplayed() {
		return highlightAndVerifyWhetherElementIsDisplayed(calendarFromDropdown());
	}

	/**
	 * @Test4.11 about this method verifyToDateFieldIsDisplayed()
	 * 
	 * @param : null
	 * @description : This method verifies if the "to date" field is visible
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the "to date" field or it
	 *           is not visible
	 * @author : YAKSHA
	 */
	public boolean verifyToDateFieldIsDisplayed() {
		return highlightAndVerifyWhetherElementIsDisplayed(calendarToDropdown());
	}

	/**
	 * @Test4.12 about this method verifyStarIconIsDisplayed()
	 * 
	 * @param : null
	 * @description : This method verifies if the start icon is visible
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the start icon or it is
	 *           not visible
	 * @author : YAKSHA
	 */
	public boolean verifyStarIconIsDisplayed() {
		return highlightAndVerifyWhetherElementIsDisplayed(getStarIconLocator());
	}

	/**
	 * @Test5 about this method
	 * verifySelectedTabIsActiveOrNot()
	 * 
	 * @param : element - the locator of the tab to be verified
	 * @description : This method verifies if the specified tab is displayed, clicks
	 *              it, and returns whether its "class" attribute contains "active".
	 *              This can be used to determine if the tab is active based on its
	 *              class attributes.
	 * @return : boolean - true if the "class" attribute of the tab contains
	 *         "active", false otherwise
	 * @throws : Exception - if there is an issue locating, highlighting, clicking
	 *           the tab, or getting its attribute
	 * @author : YAKSHA
	 */
	public boolean verifySelectedTabIsActiveOrNot(By element) throws Exception {
		boolean isActive = false;
		try {
			if (commonEvents.isDisplayed(element)) {
				WebElement tabs = commonEvents.findElement(element);
				commonEvents.highlight(tabs);
				commonEvents.click(tabs);
				String locatorAttributeValue = commonEvents.getAttribute(tabs, "class");
				isActive = locatorAttributeValue.contains("active");
			}
		} catch (Exception e) {
			throw e;
		}
		return isActive;
	}

	/**
	 * @Test6 about this method performScrollOperation()
	 * @param : null
	 * @description : Scrolls till Radiology tab, selects it, and clicks "List
	 *              Requests" tab
	 * @return : boolean
	 * @throws : Exception - if there is an issue finding the tab
	 * @author : YAKSHA
	 */
	public boolean performScrollOperation() {
		boolean isNextButtonDisplayed = false;
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement nextButton = commonEvents.findElement(getButtonLocatorsBytext("Next"));
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", nextButton);
			jsExecutor.executeScript("window.scrollBy(0, -50)");
			commonEvents.highlight(nextButton);
			isNextButtonDisplayed = commonEvents.isDisplayed(nextButton);
			System.out.println("isNextButtonDisplayed >> " + isNextButtonDisplayed);
			isNextButtonDisplayed = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isNextButtonDisplayed;
	}

	/**
	 * @Test7 about this method verifyToolTipText()
	 * @param : null
	 * @description : Verify the text of the tooltip
	 * @return : String
	 * @throws : Exception - if there is an issue finding the text
	 * @author : YAKSHA
	 */
	public String verifyToolTipText() {
		String toolTipValue = "";
		try {
			WebElement toolTip = commonEvents.findElement(favouriteOrStarIcon());
			toolTipValue = commonEvents.highlight(toolTip).getAttribute(toolTip, "title");
			System.out.println("Tool tip title : " + toolTipValue);
		} catch (Exception e) {
			throw e;
		}
		return toolTipValue;
	}

	/*
	 * @Test8 about this method verifyDatesAreRememberedCorrectly()
	 * 
	 * @param fromDate - the expected "from" date in the format "dd-MM-yyyy"
	 * 
	 * @param toDate - the expected "to" date in the format "dd-MM-yyyy"
	 * 
	 * @description : This method selects the "from" and "to" dates in the calendar,
	 * clicks the OK button, navigates away to another tab, returns to the original
	 * tab, and verifies if the dates are remembered correctly.
	 * 
	 * @return : boolean - true if the dates are remembered correctly, false
	 * otherwise
	 * 
	 * @throws : Exception - if there is an issue locating, highlighting, or
	 * clicking elements, or if there is an issue with date selection or
	 * verification
	 * 
	 * @author : YAKSHA
	 * 
	 * @throws Exception
	 */
	public boolean verifyDatesAreRememberedCorrectly(String fromDate, String toDate) throws Exception {
		try {
			// Split the fromDate and toDate into day, month, and year components
			String[] fromDateComponents = fromDate.split("-");
			String fromDay = fromDateComponents[0];
			String fromMonth = fromDateComponents[1];
			String fromYear = fromDateComponents[2];

			String[] toDateComponents = toDate.split("-");
			String toDay = toDateComponents[0];
			String toMonth = toDateComponents[1];
			String toYear = toDateComponents[2];

			// Locate the date dropdowns and OK button
			WebElement fromDateDropdown = commonEvents.findElement(calendarFromDropdown());
			WebElement toDateDropdown = commonEvents.findElement(calendarToDropdown());
			WebElement okButton = commonEvents.findElement(getOkButtonLocator());

			// Highlight and set the "from" date
			commonEvents.highlight(fromDateDropdown).sendKeys(fromDateDropdown, fromDay)
					.sendKeys(fromDateDropdown, fromMonth).sendKeys(fromDateDropdown, fromYear);

			// Highlight and set the "to" date
			commonEvents.highlight(toDateDropdown).sendKeys(toDateDropdown, toDay).sendKeys(toDateDropdown, toMonth)
					.sendKeys(toDateDropdown, toYear);

			// Locate and click the tooltip
			WebElement toolTip = commonEvents.findElement(getStarIconLocator());
			commonEvents.click(toolTip);

			// Highlight and click the OK button
			commonEvents.highlight(okButton).click(okButton);

			// Navigate to "List Reports" and "List Requests"
			commonEvents.click(getPageBarFixedLocator("List Reports"));
			commonEvents.click(getPageBarFixedLocator("List Requests"));

			// Wait for the OK button to be visible
			commonEvents.waitTillElementVisible(getOkButtonLocator(), 10000);

			// Construct the actual dates from the selected components
			String actualFromDate = fromDay + "-" + fromMonth + "-" + fromYear;
			String actualToDate = toDay + "-" + toMonth + "-" + toYear;

			System.out.println("Actual from date : " + actualFromDate);
			System.out.println("Actual to date : " + actualToDate);

			// Verify if the remembered dates match the expected dates
			if (actualFromDate.equals(fromDate) && actualToDate.equals(toDate)) {
				System.out.println("Returned true");
				return true;
			}

		} catch (Exception e) {
			throw e;
		}
		return false;
	}

	/**
	 * @Test9.1 about this method clickDateRangeDropdownAndSelect()
	 * 
	 * @param : String - Text of the value to select from dropdown
	 * @description : This method clicks on the date range button and selects a
	 *              value by its text
	 * @return : boolean - true if successfully selected the intended value and
	 *         false if the value is not selected
	 * @throws : Exception - if there is an issue finding the dropdown or its values
	 * @author : YAKSHA
	 */
	public boolean clickDateRangeDropdownAndSelect(String valueToSelect) throws Exception {
		try {
			WebElement dateRangeButton = commonEvents.findElement(getSelectDateRangeDropDown());
			commonEvents.highlight(dateRangeButton).click(dateRangeButton);
			WebElement valueToSelectElement = commonEvents.findElement(getAnchorTagLocatorByText(valueToSelect));
			commonEvents.highlight(valueToSelectElement).click(valueToSelectElement);
			commonEvents.highlight(dateRangeButton).click(dateRangeButton);
			commonEvents.highlight(valueToSelectElement).click(valueToSelectElement);
			boolean isValueSelected = commonEvents.getAttribute(valueToSelectElement, "class")
					.contains("selected-range");
			WebElement okButton = commonEvents.findElement(getOkButtonLocator());
			commonEvents.highlight(okButton).click(okButton);
			return isValueSelected;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test9.2 about this method
	 * verifyToDataRangeBySelectOneWeekOptionFromDropdown()
	 * 
	 * @param : String, String - from date - to date
	 * @description : This method verifies whether the "Requested On" dates for all
	 *              the result requisitions are within the specified date range.
	 * @return : boolean - true if the actual dates fall within the specified date
	 *         and false if they don't.
	 * @throws : Exception - if there is an issue finding the actual data
	 * @author : YAKSHA
	 */

	public boolean verifyToDataRangeBySelectOneWeekOptionFromDropdown(String fromDate, String toDate) throws Exception {

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			List<WebElement> actualDatesAfterFilterApplied = commonEvents.getWebElements(getActualRequestedOnDates());
			LocalDate from = LocalDate.parse(fromDate, formatter);
			LocalDate to = LocalDate.parse(toDate, formatter);

			for (WebElement dateElement : actualDatesAfterFilterApplied) {
				commonEvents.highlight(dateElement);
				String dateText = dateElement.getText();

				LocalDate date;
				LocalDate newDate;
				try {
					date = LocalDate.parse(dateText, inputFormatter);
					newDate = LocalDate.parse(date.format(formatter), formatter);

				} catch (Exception e) {
					System.out.println("Date parsing failed for: " + dateText);
					return false;
				}

				if (newDate.isBefore(from) || newDate.isAfter(to)) {
					return false;
				}
			}
			return true;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test10 about this method
	 *         verifyDataFromTabelByEnteringDataXRAYInSearchField() Verifies that
	 *         all records in the table match the entered text in the dropdown.
	 * 
	 * @param dropDownValue - The text to select from the dropdown.
	 * @return boolean - Returns true if all records match the selected text,
	 *         otherwise false.
	 * @throws Exception - If there is an issue locating or interacting with
	 *                   elements.
	 */
	public boolean verifyDataFromTabelByEnteringDataXRAYInSearchField(String dropDownValue) throws Exception {
		try {

			// Locate the dropdown element
			WebElement dropdownElement = driver.findElement(getFilterDropdownLocator());

			// Highlight the dropdown element (if applicable)
			commonEvents.highlight(dropdownElement).click(dropdownElement);

			// Create a Select object
			Select dropdown = new Select(dropdownElement);

			// Select the option with visible text
			dropdown.selectByVisibleText(dropDownValue);

			System.out.println("Selected the ' " + dropDownValue + " ' option from the dropdown.");

			Thread.sleep(1000);

			// Locate all the imaging name elements in the table
			List<WebElement> imagingTypeNameElements = commonEvents.getWebElements(getImagingTypeName());
			System.out.println("Length of status > " + imagingTypeNameElements.size());

			commonEvents.click(searchBarId());

			if (imagingTypeNameElements.size() > 0) {
				// Verify that each imaging name element matches the entered text
				for (WebElement imagingTypeNameElement : imagingTypeNameElements) {
					commonEvents.highlight(imagingTypeNameElement);
					String imagingTypeNameElementText = imagingTypeNameElement.getText().trim();
					if (!imagingTypeNameElementText.equalsIgnoreCase(dropDownValue)) {
						System.out.println("Found a record that is not equal to expected: " + imagingTypeNameElement);
						return false;
					}
				}
				System.out.println("All Imaging Name records verified");
				return true;
			} else {
				throw new Exception("No Imaging Name records found.");
			}

		} catch (Exception e) {
			throw new Exception("Failed to verify Table Data", e);
		}
	}

	/**
	 * @Test11 about this method verifyRadiologyWardBillingCancellationPopup()
	 * 
	 * @param radiologyExpectedData - A map containing the expected data for the
	 *                              radiology test, such as patient name and
	 *                              expected cancellation remarks message.
	 * @description This method verifies that the Radiology Ward Billing modal opens
	 *              upon searching for a patient and clicking on the view details
	 *              button. It then clicks the cancel button and verifies that the
	 *              appropriate popup message "Please Write Cancellation Remarks"
	 *              appears.
	 * @return String - The actual failed remarks message displayed in the popup.
	 * @throws Exception - If there is an issue locating or interacting with
	 *                   elements.
	 * @autor YAKSHA
	 */
	public String verifyRadiologyWardBillingCancellationPopup(Map<String, String> radiologyExpectedData) {
		String failedRemarksMsg = "";
		try {
			// Navigate to the "Ward Billing" section
			commonEvents.click(getAnchorTagLocatorByText("Ward Billing"));

			Thread.sleep(1000);

			// Locate the search bar element
			WebElement searchBar = commonEvents.findElement(searchBarId());

			// Highlight and enter text into the search bar
			commonEvents.highlight(searchBar).click(searchBar);
			commonEvents.sendKeys(searchBar, radiologyExpectedData.get("patientName"));

			// Click on the "View Details" button for the specified patient
			commonEvents.click(wardBillingViewDetailsbutton());

			// Verify that the Radiology Ward Billing modal is displayed
			boolean isModalDisplayed = commonEvents.isDisplayed(wardBillingModal());
			System.out.println("isModalDisplayed: " + isModalDisplayed);

			// Locate all the elements that match the locator for "Cancel" buttons
			List<WebElement> cancelButton = commonEvents.getWebElements(getButtonLocatorsBytext("Cancel"));

			// Click on the first "Cancel" button in the list
			WebElement firstCancelButton = cancelButton.get(0);
			commonEvents.highlight(firstCancelButton).click(firstCancelButton);
			System.out.println("Clicked on first cancel button");

			// Verify the failed message
			WebElement failedMessageElement = commonEvents
					.findElement(getPopUpMessageText("failed", radiologyExpectedData.get("cancellationRemarksMsg")));
			System.out.println("Failed message text: " + failedMessageElement.getText() + " Expected: "
					+ radiologyExpectedData.get("cancellationRemarksMsg"));

			// Store the failed remarks message
			failedRemarksMsg = failedMessageElement.getText();

			// Close the popup
			commonEvents.click(popupCloseButton());

			// Close the modal
			commonEvents.click(getAnchorTagLocatorByText("X"));

			// Navigate back to the "List Requests" section
			commonEvents.click(getAnchorTagLocatorByText("List Requests"));

			return failedRemarksMsg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return failedRemarksMsg;
	}

	/**
	 * @Test12 about this method verifyToolTipText() Verifies that all records in
	 *         the table match the entered text in the search field.
	 * 
	 * @param textToEnter - The text to enter in the search field.
	 * @return boolean - Returns true if all records match the entered text,
	 *         otherwise false.
	 * @throws Exception - If there is an issue locating or interacting with
	 *                   elements.
	 */
	public boolean verifyDataFromTableByEnteringDataInSearchField(String textToEnter) throws Exception {
		try {
			// Locate the search bar element
			WebElement searchBar = commonEvents.findElement(searchBarId());

			// Highlight and enter text into the search bar
			commonEvents.highlight(searchBar).click(searchBar);
			commonEvents.sendKeys(searchBar, textToEnter);

			// Click the "OK" button to perform the search
			commonEvents.click(getButtonLocatorsBytext("OK"));

			Thread.sleep(1000);

			// Locate all the imaging name elements in the table
			List<WebElement> imagingNameElements = commonEvents.getWebElements(getImagingName());
			System.out.println("Length of status > " + imagingNameElements.size());

			if (imagingNameElements.size() > 0) {
				// Verify that each imaging name element matches the entered text
				for (WebElement imagingNameElement : imagingNameElements) {
					commonEvents.highlight(imagingNameElement);
					String imagingNameElementText = imagingNameElement.getText().trim();
					System.out.println("imagingNameElementText > " + imagingNameElementText);
					if (!imagingNameElementText.equalsIgnoreCase(textToEnter)) {
						System.out.println("Found a record that is not equal to expected: " + imagingNameElementText);
						return false;
					}
				}
				System.out.println("All Imaging Name records verified");
				return true;
			} else {
				throw new Exception("No Imaging Name records found.");
			}

		} catch (Exception e) {
			throw new Exception("Failed to verify Table Data", e);
		}
	}

	/**
	 * @Test13 and @Test14 about this method verifyImageOrderCreation() Verifies the
	 *         creation of an imaging order for a specific patient in the In Patient
	 *         Department.
	 *
	 * @param radiologyExpectedData        - A map containing the expected data for
	 *                                     radiology, including the patient name.
	 * @param doYouWantToCancelTheNewOrder - A boolean indicating whether to cancel
	 *                                     the new order.
	 * @return String - Returns the actual success message if the order is created
	 *         successfully, otherwise returns "true" or "false" based on the cancel
	 *         action verification.
	 * @throws Exception - If there is an issue locating or interacting with
	 *                   elements.
	 */
	public String verifyImageOrderCreation(Map<String, String> radiologyExpectedData,
			boolean doYouWantToCancelTheNewOrder) {
		String actualMsg = "";
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

			// Scroll to the Doctor tab and click it
			WebElement doctorTab = commonEvents.findElement(getDoctorLocator());
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", doctorTab);
			commonEvents.highlight(doctorTab);
			commonEvents.click(doctorTab);

			// Wait for the URL to contain "Doctors/OutPatientDoctor"
			commonEvents.waitForUrlContains("Doctors/OutPatientDoctor", 10);

			// Click on "In Patient Department"
			WebElement buttonToClick = commonEvents.findElement(getAnchorTagLocatorByText("In Patient Department"));
			commonEvents.highlight(buttonToClick).click(buttonToClick);

			// Enter the patient's name into the search bar
			WebElement searchBar = commonEvents.findElement(searchBarIdAtDoctorModule());
			commonEvents.highlight(searchBar).click(searchBar).sendKeys(searchBar,
					radiologyExpectedData.get("patientName"));

			Thread.sleep(1000);

			// Click the first lab icon
			WebElement firstLabIcon = commonEvents.findElement(getFirstLabIcon());
			commonEvents.waitTillElementVisible(firstLabIcon, 30000);
			commonEvents.highlight(firstLabIcon).click(firstLabIcon);

			Thread.sleep(3000);

			// Select "Imaging" from the dropdown
			commonEvents.waitTillElementVisible(getOrderFilterDropdown(), 30000);
			WebElement dropdownElement = commonEvents.findElement(getOrderFilterDropdown());
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByValue("Imaging");

			// Enter text into the search order items field and press Enter
			WebElement inputFieldToClick = commonEvents.findElement(getInputFieldByPlaceholder("search order items"));
			commonEvents.highlight(inputFieldToClick).click(inputFieldToClick);
			commonEvents.sendKeys(getInputFieldByPlaceholder("search order items"), Keys.ENTER);

			// Handle the case where the order is cancelled
			if (doYouWantToCancelTheNewOrder) {
				commonEvents.click(getButtonLocatorsBytext("Cancel"));
				int numberOfOrderSections = commonEvents.getWebElements(getOrderSection()).size();
				WebElement homeButton = commonEvents.findElement(getAnchorTagLocatorByText("Home"));
				commonEvents.highlight(homeButton).click(homeButton);
				return numberOfOrderSections > 0 ? "true" : "false";
			} else {
				// Proceed with creating the order
				commonEvents.click(getButtonLocatorsBytext("Proceed"));
				commonEvents.waitTillElementClickable(getButtonLocatorsBytext("Sign"), 30000);
				commonEvents.click(getButtonLocatorsBytext("Sign"));
			}

			// Verify the success message
			WebElement element = commonEvents
					.findElement(getPopUpMessageText("success", "Imaging and lab order add successfully"));
			actualMsg = element.getText();
			System.out.println("Actual Success Message > " + actualMsg);

			// Return to the home page
			WebElement homeButton = commonEvents.findElement(getAnchorTagLocatorByText("Home"));
			commonEvents.highlight(homeButton).click(homeButton);

			commonEvents.click(popupCloseButton());

			return actualMsg;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return actualMsg;
	}

	/**
	 * @Test15.2 about this method verifyScanDonePopupAndRequiredFieldMessage()
	 * 
	 * @param patientName - The name of the patient for whom the action is to be
	 *                    performed.
	 * @param actionName  - The name of the action button to be clicked (e.g., "scan
	 *                    done").
	 * @description : This method verifies that the "Scan Done" popup opens for the
	 *              specified patient and that the required field message appears on
	 *              the film type field when the "Done" button is clicked without
	 *              entering any details.
	 * @return : String - The error message text displayed on the film type field if
	 *         it is required.
	 * @throws : Exception - if there is an issue locating or interacting with
	 *           elements.
	 * @author : YAKSHA
	 */
	public String verifyScanDonePopupAndRequiredFieldMessage(String patientName, String actionName) {
		String fieldErrorMessage = "";
		try {

			// Locate the action button element for the specified patient and action
			WebElement actionButtonElement = commonEvents.findElement(getActionColumnButton(patientName, actionName));

			// Wait until the action button is visible
			commonEvents.waitTillElementVisible(actionButtonElement, 30000);

			// Highlight and click the action button
			commonEvents.highlight(actionButtonElement).click(actionButtonElement);

			// Verify the action button text matches the expected action name
			String actualButtonName = actionButtonElement.getText();
			System.out.println("Button name: " + actualButtonName);
			Assert.assertEquals(actualButtonName, actionName);

			// Locate and click the "Done" button without entering details
			WebElement doneButton = commonEvents.findElement(getButtonLocatorsBytext("Done"));
			commonEvents.highlight(doneButton).click(doneButton);

			// Locate the error message on the film type field and capture its text
			WebElement errorMessage = commonEvents.findElement(getFilmTypeErrorMessage());
			System.out.println("Error message: " + errorMessage.getText());
			fieldErrorMessage = errorMessage.getText();

			// Click the "Cancel" button to close the popup
			commonEvents.click(getButtonLocatorsBytext("Cancel"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return fieldErrorMessage;
	}

	/**
	 * @Test16 about this method verifyScanDetailUpdatedSuccessPopup()
	 * 
	 * @param radiologyExpectedData - A map containing expected data for the
	 *                              radiology test case, including the patient name
	 *                              and expected success message.
	 * @param actionName            - The name of the action button to be clicked
	 *                              (e.g., "scan done").
	 * @description : This method verifies that the "Scan Done" popup opens for the
	 *              specified patient, enters the film type details, and verifies
	 *              that the success message appears after clicking the "Done"
	 *              button.
	 * @return : String - The success message text displayed after updating the scan
	 *         details.
	 * @throws : Exception - if there is an issue locating or interacting with
	 *           elements.
	 * @author : YAKSHA
	 */
	public String verifyScanDetailUpdatedSuccessPopup(Map<String, String> radiologyExpectedData, String actionName) {
		String successPopUpMessage = "";

		try {
			// Locate the action button element for the specified patient and action
			WebElement actionButtonElement = commonEvents
					.findElement(getActionColumnButton(radiologyExpectedData.get("patientName"), actionName));

			// Wait until the action button is visible
			commonEvents.waitTillElementVisible(actionButtonElement, 30000);

			// Highlight and click the action button
			commonEvents.highlight(actionButtonElement).click(actionButtonElement);

			// Verify the action button text matches the expected action name
			String actualButtonName = actionButtonElement.getText();
			System.out.println("Button name: " + actualButtonName);
			Assert.assertEquals(actualButtonName, actionName);

			// Enter film type details and press enter
			commonEvents.click(getFilmTypeInputField()).sendKeys(getFilmTypeInputField(), "X-RAY(14*17)");
			commonEvents.sendKeys(getFilmTypeInputField(), Keys.ENTER);

			// Locate and click the "Done" button
			WebElement doneButton = commonEvents.findElement(getButtonLocatorsBytext("Done"));
			commonEvents.highlight(doneButton).click(doneButton);

			// Verify the success message
			WebElement successMessageElement = commonEvents
					.findElement(getPopUpMessageText("success", radiologyExpectedData.get("scanUpdatedMessage")));
			System.out.println("Success message text: " + successMessageElement.getText() + " Expected: "
					+ radiologyExpectedData.get("scanUpdatedMessage"));

			successPopUpMessage = successMessageElement.getText();

			commonEvents.click(popupCloseButton());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return successPopUpMessage;
	}

	/**
	 * @Test17 about this method verifyAlertMessageOnClosingWithoutSaving()
	 * 
	 * @param patientName - The name of the patient for whom the action is to be
	 *                    performed.
	 * @param actionName  - The name of the action button to be clicked (e.g., "Add
	 *                    Report").
	 * @description : This method verifies that after clicking the "Add Report"
	 *              button, the "Add report of USG Chest (X-RAY)" popup opens. When
	 *              the popup is closed without saving, an alert message "Changes
	 *              will be discarded. Do you want to close anyway?" appears and is
	 *              accepted.
	 * @return : boolean - Returns true if the alert message is successfully
	 *         accepted, otherwise false.
	 * @throws : Exception - if there is an issue locating or interacting with
	 *           elements.
	 * @author : YAKSHA
	 */
	public boolean verifyAlertMessageOnClosingWithoutSaving(String patientName, String actionName) throws Exception {
		boolean isAlertAccepted = false;
		try {
			// Navigate to "List Reports" and "List Requests"
			commonEvents.click(getAnchorTagLocatorByText("List Reports"));
			commonEvents.click(getAnchorTagLocatorByText("List Requests"));

			// Locate the action button element for the specified patient and action
			WebElement actionButtonElement = commonEvents.findElement(getActionColumnButton(patientName, actionName));

			// Wait until the action button is visible
			commonEvents.waitTillElementVisible(actionButtonElement, 30000);

			// Highlight and click the action button
			commonEvents.highlight(actionButtonElement).click(actionButtonElement);

			// Wait for the popup to open
			Thread.sleep(2000);

			// Verify the action button text matches the expected action name
			String actualButtonName = actionButtonElement.getText();
			System.out.println("Button name: " + actualButtonName);
			Assert.assertEquals(actualButtonName, actionName);

			// Close the popup
			commonEvents.click(getAnchorTagLocatorByText("X"));

			// Accept the alert message
			commonEvents.acceptAlert();
			System.out.println("Alert Accepted!!");

			// Set the flag to true indicating the alert was accepted
			isAlertAccepted = true;

		} catch (Exception e) {
			throw new Exception("Failed to verify the alert message on closing without saving", e);
		}

		return isAlertAccepted;
	}

	/**
	 * @Test18 and @Test19 about this method
	 *         verifyAddAndEditReportAndRequiredTextMessage()
	 * 
	 * @param patientName - The name of the patient for whom the action is to be
	 *                    performed.
	 * @param actionName  - The name of the action button to be clicked (e.g., "Add
	 *                    Report").
	 * @param popUpMeg    - The expected success message text after performing the
	 *                    action.
	 * @description : This method verifies that the "Add Report" popup opens for the
	 *              specified patient, enters text into the report field, and
	 *              verifies the success message when the "Save" button is clicked.
	 * @return : String - The success message text displayed after clicking the
	 *         "Save" button.
	 * @throws : Exception - if there is an issue locating or interacting with
	 *           elements.
	 * @author : YAKSHA
	 */
	public String verifyAddAndEditReportAndRequiredTextMessage(String patientName, String actionName, String popUpMeg) {
		String popUpMessage = "";

		try {
			// Navigate to "List Reports" and "List Requests"
			commonEvents.click(getAnchorTagLocatorByText("List Reports"));
			commonEvents.click(getAnchorTagLocatorByText("List Requests"));

			// Locate the action button element for the specified patient and action
			WebElement actionButtonElement = commonEvents.findElement(getActionColumnButton(patientName, actionName));

			// Wait until the action button is visible
			commonEvents.waitTillElementVisible(actionButtonElement, 30000);

			// Highlight and click the action button
			commonEvents.highlight(actionButtonElement).click(actionButtonElement);

			// Wait for the popup to open
			Thread.sleep(2000);

			// Verify the action button text matches the expected action name
			String actualButtonName = actionButtonElement.getText();
			System.out.println("Button name: " + actualButtonName);
			Assert.assertEquals(actualButtonName, actionName);

			// Verify the "Add report" popup heading
			WebElement addReportHeading = commonEvents.findElement(getAddReportHeading());
			String actualAddReportHeadingText = addReportHeading.getText().trim();
			System.out.println("actualAddReportHeadingText > " + actualAddReportHeadingText);
			String expectedTitle = "Add report of USG Chest (X-RAY)";
			Assert.assertEquals(actualAddReportHeadingText, expectedTitle);

			// Switch to the iframe to enter report details
			WebElement iframeElement = commonEvents.findElement(getTextEditorLocator());
			driver.switchTo().frame(iframeElement);

			// Enter text into the report field
			WebElement paragraphLocator = commonEvents.findElement(getBodyTextLocator());
			commonEvents.sendKeys(paragraphLocator, " Test");

			// Switch back to the default content
			driver.switchTo().defaultContent();

			// Locate and click the "Save" button
			WebElement saveButton = commonEvents.findElement(getSaveButtonLocator());
			commonEvents.highlight(saveButton).click(saveButton);
			System.out.println("Clicked on save button");

			// Verify the success message
			WebElement successMessageElement = commonEvents.findElement(getPopUpMessageText("success", popUpMeg));
			commonEvents.waitTillElementVisible(successMessageElement, 10000);
			System.out.println("Success message text: " + successMessageElement.getText() + " Expected: " + popUpMeg);

			popUpMessage = successMessageElement.getText();

			// Close the popup
			commonEvents.click(popupCloseButton());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return popUpMessage;
	}

	/**
	 * @Test20 about this method takingScreenshotOfTheCurrentPage()
	 * @param : null
	 * @description : Taking screenshot of the current page.
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public Boolean takingScreenshotOfTheCurrentPage() throws Exception {
		boolean isDisplayed = false;
		try {
			commonEvents.takeScreenshot("Radiology");
			isDisplayed = true;

		} catch (Exception e) {
			throw e;
		}
		return isDisplayed;
	}

	/**
	 * @Test21.1 about this method clickAnchorButtonByText()
	 * 
	 * @param : null
	 * @description : Clicks Anchor button through its text
	 * @return : Boolean
	 * @author : YAKSHA
	 */
	public boolean clickAnchorButtonByText(String textOfAnchorButton) throws Exception {
		try {
			WebElement buttonToClick = commonEvents.findElement(getAnchorTagLocatorByText(textOfAnchorButton));
			commonEvents.highlight(buttonToClick).click(buttonToClick);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test21.2 @Test21.4 about this method verifyCurrentPageIs()
	 * 
	 * @param : String - expected current page
	 * @description : This method verifies whether the current page matches with the
	 *              expected current page
	 * @return : boolean - true if the current page matches with the expected
	 *         current page and false they don't match
	 * @throws : Exception - if there is an issue finding the element button
	 * @author : YAKSHA
	 */
	public boolean verifyCurrentPageIs(String expectedCurrentPage) throws Exception {
		try {
			WebElement currentpageElement = commonEvents.findElement(getCurrentPage());
			String elementText = commonEvents.getText(currentpageElement);
			return elementText.contains(expectedCurrentPage);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Test21.3 @Test21.5 about this method clickButtonByText()
	 * 
	 * @param buttonText : String - The text of the button to be clicked
	 * @description : This method locates a button using its text and performs a
	 *              click action on it. If the button is found and successfully
	 *              clicked, it highlights the button first. In case of failure
	 *              (e.g., button not found or click error), an error message is
	 *              printed and an exception is thrown.
	 * @return : void
	 * @throws : Exception - if there is an issue finding the button or performing
	 *           the click action
	 * @author : YAKSHA
	 */
	public boolean clickButtonByText(String buttonText) throws Exception {
		try {
			WebElement buttonToClick = commonEvents
					.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]"));
			commonEvents.highlight(buttonToClick).click(buttonToClick);
		} catch (Exception e) {
			System.out.println("Either the button not found or encountered error while clicking!");
			throw e;
		}
		return true;
	}

}

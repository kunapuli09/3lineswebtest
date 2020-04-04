package test.java.com.starpath.smart;

import com.starpath.smart.base.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

@RunWith(BlockJUnit4ClassRunner.class)
public class ApplicationFormTest extends BaseTest {

    private WebDriver driver;

    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement companyName;
    private WebElement phone;
    private WebElement elevatorPitch;
    private WebElement website;
    private WebElement referrer;
    private WebElement capitalRaised;
    private WebElement revenueStatus;
    private WebElement industries;
    private WebElement fundingNeeds;


    private WebElement submitAppButton;


    private static final By APP_HEADING_PATH = By.xpath("//*[@id=\"contact\"]/div/div[1]/div/h2");
    private static final By FIRST_NAME_TEXT_FIELD_PATH = By.xpath("//*[@id=\"FirstName\"]");
    private static final By LAST_NAME_TEXT_FIELD_PATH = By.xpath("//*[@id=\"LastName\"]");
    private static final By EMAIL_TEXT_FIELD_PATH = By.xpath("//*[@id=\"Email\"]");
    private static final By COMPANY_NAME_TEXT_FIELD_PATH = By.xpath("//*[@id=\"CompanyName\"]");
    private static final By WEBSITE_TEXT_FIELD_PATH = By.xpath("//*[@id=\"Website\"]");
    private static final By PHONE_TEXT_FIELD_PATH = By.xpath("//*[@id=\"Phone\"]");
    private static final By ELEVATOR_PITCH_TEXT_FIELD_PATH = By.xpath("//*[@id=\"ElevatorPitch\"]");
    private static final By REFERRER_TEXT_FIELD_PATH = By.xpath("//*[@id=\"Referrer\"]");
    private static final By CAPITAL_RAISED_TEXT_FIELD_PATH = By.xpath("//*[@id=\"CapitalRaised\"]");
    private static final By REVENUE_STATUS_HEADING_PATH = By.xpath(" //*[@id=\"Revenue\"]/div[1]/h6");
    private static final By PRE_REVENUE_CHECKBOX_FIELD_PATH = By.xpath("//*[@id=\"inlineRadio4\"]");
    private static final By REVENUE_POSITIVE_CHECKBOX_FIELD_PATH = By.xpath("//*[@id=\"inlineRadio5\"]");
    private static final By PROFITABLE_CHECKBOX_FIELD_PATH = By.xpath("//*[@id=\"inlineRadio6\"]");
    private static final By COMMENTS_TEXT_FIELD_PATH = By.xpath("//*[@id=\"Comments\"]");
    private static final By INDUSTRY_HEADING_PATH = By.xpath("//*[@id=\"Industries\"]/div[1]/h6");

    private static final By artificialIntelligenceID = By.xpath("//*[@id=\"check1\"]");
    private static final By saasID = By.xpath("//*[@id=\"check2\"]");
    private static final By healthcareID = By.xpath("//*[@id=\"check3\"]");
    private static final By cyberSecurityID = By.xpath("//*[@id=\"check4\"]");
    private static final By internetOfThingsID = By.xpath("//*[@id=\"check5\"]");
    private static final By enterpriseSoftwareID = By.xpath("//*[@id=\"check6\"]");
    private static final By mobilityID = By.xpath("//*[@id=\"check7\"]");
    private static final By finTechID = By.xpath("//*[@id=\"check8\"]");
    private static final By agricultureID = By.xpath("//*[@id=\"check9\"]");
    private static final By supplyChainID = By.xpath("//*[@id=\"check10\"]");
    private static final By otherID = By.xpath("//*[@id=\"check11\"]");

    private static final By LOCATIONS_HEADING_PATH = By.xpath("//*[@id=\"Program\"]/h6");
    private static final By LOCATIONS_OPTION_US = By.xpath("//*[@id=\"Program\"]/option[1]");
    private static final By LOCATIONS_OPTION_INDIA = By.xpath("//*[@id=\"Program\"]/option[2]");


    private static final By SUBMIT_APPLICATION_BUTTON_PATH = By.xpath("//*[@id=\"sendApplicationButton\"]");

    private static final By RESULT_MESSAGE_PATH = By.xpath("//*[@id=\"successApplication\"]/div/strong");
    private static final String failureMessage = "Sorry Duplicate Entry. An application with Website, CompanyName or Email Already Exists, please fill in all required fields";
    private static final String successMessage = "Thank You for applying. Pls send the deck to dsc@3lines.vc We will get back to you soon.";
    @Before
    public void createAndStartService() {
        System.setProperty("webdriver.chrome.driver", "C:\\Software\\chromedriver_win32\\chromedriver.exe");
        //Krishna's: System.setProperty("webdriver.chrome.driver", "/Users/krishnakunapuli/projects/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:9999/appl");

        WebElement appHeading = driver.findElement(APP_HEADING_PATH);
        Assert.assertEquals("APPLICATION FOR FUNDING", appHeading.getText());

        WebElement locationsHeading = driver.findElement(LOCATIONS_HEADING_PATH);
        Assert.assertEquals("Please select your location", locationsHeading.getText());

        WebElement locationUS = driver.findElement(LOCATIONS_OPTION_US);
        Assert.assertNotNull(locationUS);

        WebElement locationIndia = driver.findElement(LOCATIONS_OPTION_INDIA);
        Assert.assertNotNull(locationIndia);

        firstName = driver.findElement(FIRST_NAME_TEXT_FIELD_PATH);
        Assert.assertNotNull(firstName);

        lastName = driver.findElement(LAST_NAME_TEXT_FIELD_PATH);
        Assert.assertNotNull(lastName);

        email = driver.findElement(EMAIL_TEXT_FIELD_PATH);
        Assert.assertNotNull(email);

        phone = driver.findElement(PHONE_TEXT_FIELD_PATH);
        Assert.assertNotNull(phone);

        companyName = driver.findElement(COMPANY_NAME_TEXT_FIELD_PATH);
        Assert.assertNotNull(companyName);

        elevatorPitch = driver.findElement(ELEVATOR_PITCH_TEXT_FIELD_PATH);
        Assert.assertNotNull(elevatorPitch);

        website = driver.findElement(WEBSITE_TEXT_FIELD_PATH);
        Assert.assertNotNull(website);

        referrer = driver.findElement(REFERRER_TEXT_FIELD_PATH);
        Assert.assertNotNull(referrer);

        WebElement revenueStatusHeading = driver.findElement(REVENUE_STATUS_HEADING_PATH);
        Assert.assertEquals("Revenue Status:", revenueStatusHeading.getText());

        WebElement preRevenue = driver.findElement(PRE_REVENUE_CHECKBOX_FIELD_PATH);
        Assert.assertNotNull(preRevenue);

        WebElement revenuePositive = driver.findElement(REVENUE_POSITIVE_CHECKBOX_FIELD_PATH);
        Assert.assertNotNull(revenuePositive);

        WebElement profitable = driver.findElement(PROFITABLE_CHECKBOX_FIELD_PATH);
        Assert.assertNotNull(profitable);

        WebElement industryHeading = driver.findElement(INDUSTRY_HEADING_PATH);
        Assert.assertEquals("Please check the industries most closely related to your company:", industryHeading.getText());

        WebElement artificialIntelligenceCheckbox = driver.findElement(artificialIntelligenceID);
        Assert.assertNotNull(artificialIntelligenceCheckbox);

        WebElement saasCheckbox = driver.findElement(saasID);
        Assert.assertNotNull(saasCheckbox);

        WebElement healthcareCheckbox = driver.findElement(healthcareID);
        Assert.assertNotNull(healthcareCheckbox);

        WebElement cyberSecurityCheckbox = driver.findElement(cyberSecurityID);
        Assert.assertNotNull(cyberSecurityCheckbox);

        WebElement internetOfThingsCheckbox = driver.findElement(internetOfThingsID);
        Assert.assertNotNull(internetOfThingsCheckbox);

        WebElement enterpriseSoftwareCheckbox = driver.findElement(enterpriseSoftwareID);
        Assert.assertNotNull(enterpriseSoftwareCheckbox);

        WebElement mobilityCheckbox = driver.findElement(mobilityID);
        Assert.assertNotNull(mobilityCheckbox);

        WebElement finTechCheckbox = driver.findElement(finTechID);
        Assert.assertNotNull(finTechCheckbox);

        WebElement agricultureCheckbox = driver.findElement(agricultureID);
        Assert.assertNotNull(agricultureCheckbox);

        WebElement supplyChainCheckbox = driver.findElement(supplyChainID);
        Assert.assertNotNull(supplyChainCheckbox);

        WebElement otherCheckbox = driver.findElement(otherID);
        Assert.assertNotNull(otherCheckbox);

        capitalRaised = driver.findElement(CAPITAL_RAISED_TEXT_FIELD_PATH);
        Assert.assertNotNull(capitalRaised);

        fundingNeeds = driver.findElement(COMMENTS_TEXT_FIELD_PATH);
        Assert.assertNotNull(fundingNeeds);

//        WebElement failuresMessage = driver.findElement(RESULT_MESSAGE_PATH);
//        Assert.assertNotNull(successMessage);

        submitAppButton = driver.findElement(SUBMIT_APPLICATION_BUTTON_PATH);
        Assert.assertNotNull(submitAppButton);
    }

    @After
    public void createAndStopService() {
        driver.close();
    }

    @Test
    public void testApplicationForm() throws InterruptedException {
        firstName.sendKeys("Test");
        lastName.sendKeys("One");
        email.sendKeys("test" + Math.round(Math.random() * 10000) + "@test.com");
        phone.sendKeys("1111111111");
        companyName.sendKeys("TestOne"+ Math.round(Math.random() * 10000));
        elevatorPitch.sendKeys("It's a great company" + Math.round(Math.random() * 10000));
        website.sendKeys("https://test" + Math.round(Math.random() * 10000) + ".com");
        referrer.sendKeys("Referrer" + Math.round(Math.random() * 10000) + ".com");
        capitalRaised.sendKeys(Long.toString(Math.round(Math.random() * 10000)));
        //WebElement revenuePositive = driver.findElement(REVENUE_POSITIVE_CHECKBOX_FIELD_PATH);
        //WebElement profitable = driver.findElement(PROFITABLE_CHECKBOX_FIELD_PATH);
        WebElement preRevenue = driver.findElement(PRE_REVENUE_CHECKBOX_FIELD_PATH);
        if (preRevenue.isSelected() == false) {
            preRevenue.click();
        }
        WebElement artificialIntelligenceCheckbox = driver.findElement(artificialIntelligenceID);
        if (artificialIntelligenceCheckbox.isSelected() == false) {
            artificialIntelligenceCheckbox.click();
        }
        WebElement saasCheckbox = driver.findElement(saasID);
        WebElement healthcareCheckbox = driver.findElement(healthcareID);
        WebElement cyberSecurityCheckbox = driver.findElement(cyberSecurityID);
        WebElement internetOfThingsCheckbox = driver.findElement(internetOfThingsID);
        WebElement enterpriseSoftwareCheckbox = driver.findElement(enterpriseSoftwareID);
        WebElement mobilityCheckbox = driver.findElement(mobilityID);
        WebElement finTechCheckbox = driver.findElement(finTechID);
        WebElement agricultureCheckbox = driver.findElement(agricultureID);
        WebElement supplyChainCheckbox = driver.findElement(supplyChainID);
        WebElement otherCheckbox = driver.findElement(otherID);
        fundingNeeds.sendKeys("Gimme the money.");
        submitAppButton.click();

        WebElement resultMessage = driver.findElement(RESULT_MESSAGE_PATH);
        Assert.assertNotNull(resultMessage);
        Assert.assertEquals(successMessage, resultMessage.getText());
        //System.out.println(resultMessage.getText());

        sleep(1000);
    }
    @Test
    public void testDataEntryValidation() throws InterruptedException {

    }
    @Test
    public void testFailedMessages() throws InterruptedException {

    }
    @Test
    public void testEmptyFieldsError() throws InterruptedException {
        //Comment a line, run, and check. Process repeated for all input lines.
        //Should return false for empty lines.
        firstName.sendKeys("Test");
        lastName.sendKeys("One");
        email.sendKeys("test" + Math.round(Math.random() * 10000) + "@test.com");
        companyName.sendKeys("TestOne"+Math.round(Math.random() * 10000));
        website.sendKeys("https://test" + Math.round(Math.random() * 10000) + ".com");
        phone.sendKeys("1111111111");

//        artificialIntelligenceCheckbox.getAttribute("checked");
//        if(artificialIntelligenceCheckbox.equals("false"))
//            artificialIntelligenceCheckbox.click();


        capitalRaised.sendKeys("70000.00");
        System.out.println(capitalRaised.getAttribute("value"));
        fundingNeeds.sendKeys("Gimme the money.");
        submitAppButton.click();

        WebElement successMessage = driver.findElement(RESULT_MESSAGE_PATH);
        Assert.assertNotNull(successMessage);


        sleep(1000);
    }
}

package com.starpath.smart;

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

@RunWith(BlockJUnit4ClassRunner.class)
public class ScreeningNotes extends BaseTest {
    private WebDriver driver;

    //SIGN-UP --> LOGIN
    private static final By LoginHeadingPath = By.xpath("//*[@id=\"login\"]/div/div[1]/div/h2");
    private static final By LoginEmailFieldPath = By.xpath("//*[@id=\"Email\"]");
    private static final By LoginPasswordFieldPath = By.xpath("//*[@id=\"Password\"]");
    private static final By LoginButtonPath = By.xpath("//*[@id=\"loginButton\"]");

    //DASHBOARD --> DEALS --> ONE APPLICATION --> ADD SCREENING NOTES
    private static final By CustomerNeedHeadPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[1]/form/div[1]/label");
    private static final By CompellingNeedPath = By.xpath("//*[@id=\"Need\"]/option[1]");
    private static final By NiceToHaveNeedPath = By.xpath("//*[@id=\"Need\"]/option[2]");
    private static final By NotConvincedNeedPath = By.xpath("//*[@id=\"Need\"]/option[3]");
    private static final By ScreeningStatusHeadPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[1]/form/div[2]/label");
    private static final By RecommendStatusPath = By.xpath("//*[@id=\"Status\"]/option[1]");
    private static final By TrackStatusPath = By.xpath("//*[@id=\"Status\"]/option[2]");
    private static final By ArchiveStatusPath = By.xpath("//*[@id=\"Status\"]/option[3]");
    private static final By FastTrackStatusPath = By.xpath("//*[@id=\"Status\"]/option[4]");
    private static final By ScreeningDateHeadPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[1]/form/label[1]");
    private static final By ScreeningDateFieldPath = By.xpath("//*[@id=\"ScreeningDate\"]");
    //Add path for screening date picker
    private static final By ExitRiskScoreHeadingPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[1]/form/label[2]");
    private static final By ExitRiskScoreDescriptionPath = By.xpath("//*[@id=\"exitHelp\"]");
    private static final By ExitRiskScoreSliderPath = By.xpath("//*[@id=\"ExitRisk\"]");
    private static final By TeamRiskScoreHeadingPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[2]/label[1]");
    private static final By TeamRiskScoreDescriptionPath = By.xpath("//*[@id=\"teamHelp\"]");
    private static final By TeamRiskScoreSliderPath = By.xpath("//*[@id=\"TeamRisk\"]");
    private static final By BarrierEntryRiskScoreHeadingPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[2]/label[2]");
    private static final By BarrierEntryRiskScoreDescriptionPath = By.xpath("//*[@id=\"barrierHelp\"]");
    private static final By BarrierEntryScoreSliderPath = By.xpath("//*[@id=\"BarrierToEntry\"]");
    private static final By TechnologyRiskScoreHeadingPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[2]/label[3]");
    private static final By TechnologyRiskScoreDescriptionPath = By.xpath("//*[@id=\"techHelp\"]");
    private static final By TechnologyScoreSliderPath = By.xpath("//*[@id=\"TechRisk\"]");
    private static final By CompetitionRiskScoreHeadingPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[3]/label[1]");
    private static final By CompetitionRiskScoreDescriptionPath = By.xpath("//*[@id=\"competitionHelp\"]");
    private static final By CompetitionScoreSliderPath = By.xpath("//*[@id=\"CompetitionRisk\"]");
    private static final By PoliticalRiskScoreHeadingPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[3]/label[2]");
    private static final By PoliticalRiskScoreDescriptionPath = By.xpath("//*[@id=\"politicalHelp\"]");
    private static final By PoliticalScoreSliderPath = By.xpath("//*[@id=\"PoliticalRisk\"]");
    private static final By SupplierRiskScoreHeadingPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[3]/label[3]");
    private static final By SupplierRiskScoreDescriptionPath = By.xpath("//*[@id=\"supplierHelp\"]");
    private static final By SupplierScoreSliderPath = By.xpath("//*[@id=\"SupplierRisk\"]");
    private static final By ExecutionRiskScoreHeadingPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[4]/label[1]");
    private static final By ExecutionRiskScoreDescriptionPath = By.xpath("//*[@id=\"executionHelp\"]");
    private static final By ExecutionScoreSliderPath = By.xpath("//*[@id=\"ExecutionRisk\"]");
    private static final By MarketRiskScoreHeadingPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[4]/label[2]");
    private static final By MarketRiskScoreDescriptionPath = By.xpath("//*[@id=\"marketHelp\"]");
    private static final By MarketScoreSliderPath = By.xpath("//*[@id=\"MarketRisk\"]");
    private static final By ScalingRiskScoreHeadingPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[4]/label[3]");
    private static final By ScalingRiskScoreDescriptionPath = By.xpath("//*[@id=\"scalingHelp\"]");
    private static final By ScalingScoreSliderPath = By.xpath("//*[@id=\"ScalingRisk\"]");
    private static final By ScreeningCommentsPath = By.xpath("//*[@id=\"Comments\"]");
    private static final By UpdateScreeningNotesButtonPath = By.xpath("//*[@id=\"news\"]/div/div[2]/div[5]/div/button");

    //LOGOUT
    private static final By LogoutButtonPath = By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[2]/a");


    private WebElement startup, team, website, logo, description, industry, investmentDate, headquarters, capTable;
    private WebElement boardRep, boardMembers, exitValueAtClosing, fundOwnership, investorGroup, managementOwnership;
    private WebElement investmentCommitment, investedCapital, realizedProceeds, reportedValue, investmentMultiple;
    private WebElement grossIRR, statusPending, statusComplete, statusArchive, investmentBackground, investmentThesis;
    private WebElement valuationMethodology, riskAssessment;


    @Before
    public void createAndStartService() {
        System.setProperty("webdriver.chrome.driver", "C:\\Software\\chromedriver_win32\\chromedriver.exe");
        //Krishna's: System.setProperty("webdriver.chrome.driver", "/Users/krishnakunapuli/projects/chromedriver");
        driver = new ChromeDriver();
        //9999 for Niharika and 8888 for Krishna
        driver.get("http://localhost:9999/appl"); //Change URL

        //SIGN-UP
            //Figure out how to sign-up and wack out a user for daily testing
            //Assign two new users DSC permissions
            //One user will be used to add screeening notes and update them
            //The other user will test if notes can be edited by other users

        //LOGIN
        WebElement loginHeading = driver.findElement(LoginHeadingPath);
        Assert.assertNotNull(loginHeading);
        Assert.assertEquals("LOGIN", loginHeading.getText());

        WebElement loginButton = driver.findElement(LoginButtonPath);
        Assert.assertNotNull(loginButton);

        WebElement email = driver.findElement(LoginEmailFieldPath);
        Assert.assertNotNull(email);

        WebElement password = driver.findElement(LoginPasswordFieldPath);
        Assert.assertNotNull(password);

        email.sendKeys("fundone@3lines.vc");
        password.sendKeys("Support@2019");
        loginButton.click();

        //SCREENING NOTES
            //Figure out how to create fake application
            //Go to Add Screening Notes page
            //Set up webelements to test the form

        //LOGOUT
        WebElement logoutButton = driver.findElement(LogoutButtonPath);
        Assert.assertNotNull(logoutButton);
    }

    @After
    public void createAndStopService() {
        //LOGOUT
        //Delete users
        //Delete test application & related data
        //Close Driver
        driver.close();
    }


    /**
     * @GENERAL TESTING
     * Make sure notes are not added with blank values
     * Screening Comments: Try to overload with too many characters or unique characters.
     * SQL Injections
     * Look for cybersecurity vulnerabilities
     * Screening Date: Enter date in wrong format, enter date w/ only a few of the variables, enter other characters
     * After testAddNewScreeningNotesPass runs successfully once, go back and update values to make sure it updates correctly
     * Log-in w/ different user to make sure the pre-existing screening notes cannot be edited
     * Test basic like navbar, footers, etc.
     */

    @Test
    public void testAddNewScreeningNotesPass() {
        //Fill in the form and make sure it works like it is supposed to
        //i.e. exit risk score only adds exit risk score
    }

    @Test
    public void testUpdateNewScreeningNotesPass() {
        //Fill in the form and make sure it works like it is supposed to
        //i.e. exit risk score only adds exit risk score
    }

    @Test
    public void testAddScreeningNotesBlank() {
        //Empty Form Test
        //Click "Update" Button
    }

    @Test
    public void testAddNewInvestmentScreeningComments() {
        /*Conduct tests for the following 3 scenarios:
            1. Unique Characters (such as random chinese characters)
            2. Numbers
            3. Large Number of Characters at Once
        */

        //Click "Update" Button
    }

    @Test
    public void testNavbar(){
        //Test navbar functionality
    }

    @Test
    public void testBackTo(){
        //Test Back-To Buttons, buttons that lead to other pages from current page, etc.
    }

    @Test
    public void testFooter(){
    //Test that footer exists and leads to the social medias linked
    }
}

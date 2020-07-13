package stepdefinitions;

import org.testng.Assert;

import com.pages.HomePage;

import com.pages.LoginPage;
import com.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CRMLoginStepDef extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	@Given("^User is already on login page$")
	public void user_is_already_on_login_page() throws Throwable {
		TestBase.initialization();
	}
	
	@When("^Title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() throws Throwable {
		loginPage = new LoginPage();
		String loginTitle = loginPage.validateLoginPageTitle();
		System.out.println("Login Page title : " + loginTitle);
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", loginTitle);
	}
	
	@Then("^User enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
		
	@Then("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		homePage = new HomePage();
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals("CRMPRO", title);
		
	}
	
	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
		Thread.sleep(2000);
		driver.quit();
	}
	

}

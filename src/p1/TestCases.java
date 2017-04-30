package p1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import commonUtils.ReadPropFileData;

public class TestCases {

	ReadPropFileData file = new ReadPropFileData();
	
	@BeforeSuite
	public void setup(){
	System.setProperty("webdriver.chrome.driver","D:\\Selenium tut\\chromedriver_2.29.exe");
};
	
	//@Test
	public void wrongCredentials(){
		LoginPage lp = new LoginPage(file.getProperty("userName"), "shodjdojfdoj");	
		lp.navigateToLoginPage();
		lp.setUserName();
		lp.setPassword();
		lp.clickLoginBtn();
		assertEquals(lp.getErrorMsg(),"You have entered a wrong email address or password");
		
	};
	
	@Test
	public void correctCredentials(){
		LoginPage lp = new LoginPage(file.getProperty("userName"), file.getProperty("password"));	
		lp.navigateToLoginPage();
		lp.login();
		assertEquals(lp.verifyNiceLogoAfterlogin(), true);
	};
	
}

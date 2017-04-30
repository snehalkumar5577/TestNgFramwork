package p1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import commonUtils.ReadPropFileData;

public class LoginPage {
	
	private String userName;
	private String password;
	
	ReadPropFileData file = new ReadPropFileData();

	
	public LoginPage(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	
	
	WebDriver driver = new ChromeDriver();
	
	
	public void setUserName(){
		WebElement userNameField =  driver.findElement(By.id("emailField"));
		userNameField.sendKeys(userName);
	};
	
	public void setPassword(){
		WebElement passwordField =  driver.findElement(By.id("passField"));
		passwordField.sendKeys(password);
	};
	
	public void clickLoginBtn(){
		WebElement loginBtn =  driver.findElement(By.id("loginBtn"));
		loginBtn.click();
	};
	
	public String getErrorMsg(){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement errorMsg =  driver.findElement(By.xpath(".//*[contains(text(),'You have entered')]"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println(errorMsg.getText());
		return errorMsg.getText();
	};
	
	public void navigateToLoginPage(){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(file.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	};
	
	public void login(){
		this.setUserName();
		this.setPassword();
		this.clickLoginBtn();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	};
	
	public boolean verifyNiceLogoAfterlogin (){
		return driver.findElement(By.className("nice-app")).isDisplayed();
	};	
}

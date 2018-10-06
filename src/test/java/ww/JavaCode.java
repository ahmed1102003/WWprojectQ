package ww;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;

//import org.apache.commons.codec.binary.StringUtils;

//import org.apache.commons.exec.util.StringUtils;

//import org.apache.commons.exec.util.StringUtils;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Point;
//import org.openqa.selenium.Rectangle;
//import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.server.handler.interactions.MouseMoveToLocation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JavaCode {
 
	
	private static final int waittime = 1000;
	static final int LOAD = 120;
	static WebDriver driver = null;
	private List<WebElement> findElements;
	private long avaragetime;
	private String pathfile;
	private String number2;
	static final Logger log = Logger.getLogger("file3");
	static final Logger logerror = Logger.getLogger("file4");
	public void afterScenario() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Given("^User at Home page$")
	// @SuppressWarnings("deprecation")
	public void user_at_login_page() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/ahmadyounis/Downloads/chromedriver 2");
		driver = new ChromeDriver();
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("resources/log4j.properties"));
		logerror.error("for testing the error file log ");
		log.info("for testing the info file log ");
		driver.get("https://www.weightwatchers.com/us/");
		Thread.sleep(waittime);
		Thread.sleep(waittime);
		Thread.sleep(waittime);
		Thread.sleep(waittime);
		log.info("Opened WW Home page succuffly");
	}



	// This will add value to the field with ID only
	@When("^I Enter (.*) in the (.*)$")
	public void I_enter_username_in_the(String username, String filed) throws InterruptedException {
		Thread.sleep(waittime);
		WebElement findElement = driver.findElement(By.id(filed));
		findElement.clear();
		Thread.sleep(waittime);
		findElement.sendKeys(username);
		Thread.sleep(waittime);
		Thread.sleep(waittime);
	}

	@When("^I enter (.*) in the (.*) by xpath$")
	public void I_enter_username_in_by_xpath(String username, String filed) throws InterruptedException {
		Thread.sleep(waittime);
		WebElement findElement = driver.findElement(By.xpath(filed));
		findElement.clear();
		findElement.sendKeys(username);
	}

	@When("^I enter (.*) in the (.*) by name$")
	public void I_enter_username_in_by_name(String data, String filed) throws InterruptedException {
		Thread.sleep(waittime);
		WebElement findElement = driver.findElement(By.name(filed));
		findElement.clear();
		findElement.sendKeys(data);
	}

	@When("^I Click on (.*) button$")
	public void I_Click_on_ID_button(String ID) throws InterruptedException {
		Thread.sleep(waittime);
		By id = By.id(ID);
		 Thread.sleep(1000);
		driver.findElement(id).click();
	}

	@When("^I click on (.*) buttons$")
	public void I_Click_on_ID_buttons(String ID) throws InterruptedException {
		Thread.sleep(waittime);
		By id = By.id(ID);
		 Thread.sleep(1000);
		driver.findElement(id).click();
	}

	
	
	
	@When("^I Click on (.*) button by xpath$")
	public void I_click_on_xpath_button(String xpath) throws InterruptedException {
		Thread.sleep(waittime);
		By id = By.xpath(xpath);
		driver.findElement(id).click();
	}

	@When("^wait (.*) seconds$")
	public void wait_for_seconds(int seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
	}

	@When("^I click on (.*) button by name$")
	public void I_click_on_Login_button_by_name(String Name) throws InterruptedException {
		Thread.sleep(waittime);
		By id = By.name(Name);
		driver.findElement(By.name(Name)).click();
	}
	
	@Then("^'(.*)' message will display at '(.*)'$")
	public void Check_Messages(String message, String xpath) throws InterruptedException {
		// Thread.sleep(1000);
		By xpath2 = By.xpath(xpath);
		// WebDriverWait wait = new WebDriverWait(driver, LOAD);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath_to_search_textbox")));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(xpath2));
		// Thread.sleep(1000);
		WebElement findElement = driver.findElement(xpath2);
		String text = findElement.getText();
		assertEquals(message, text);
	}
	
	
	@Then("^get the messages '(.*)'$")
	public void get_the_messages(String xpath) {
		// WebDriverWait wait = new WebDriverWait(driver,LOAD);
		By by = By.xpath(xpath);
		this.findElements = driver.findElements(by);
		// driver.switchTo().frame(0);
		System.out.println("Options for drop down list" + this.findElements.size());
		for (WebElement i : this.findElements) {
			String dropdownlistoption = i.getText();
			System.out.println("/" + dropdownlistoption + "|");
		}
	}
	@Then("^the following messages will be displayed$")
	public void the_following_messages_will_be_displayed(String... messages) {
		for (WebElement i : this.findElements) {
			String dropdownlistoption = i.getText();
			System.out.println("|" + dropdownlistoption + "|");
		}
		for (String i : messages) {
			System.out.println("|" + i + "|"); 
		}
		List<String> list = new ArrayList<String>(Arrays.asList(messages));
		for (WebElement webElement : this.findElements) {
			String actual = webElement.getText().trim();
			if (!StringUtils.isEmpty(actual)) {
				assertTrue(list.size() > 0);
				String excpet = list.remove(0);
				assertEquals(excpet, actual);
			}

		}
		assertEquals(0, list.size());
	}



	@When("^Confrim the message with Welcome$")
	public void Confrim_the_message_with_Welcome() throws Throwable {
		get_the_messages("/html/body/h1");
		the_following_messages_will_be_displayed("Welcome");
	}

	// Running Test case to confirm the message when user click on Received  button for POP3
			@When("^Confrim the address in the search result is the same when user click on it")
			public void Confrim_the_message_with_OK_OFF_OFF() throws Throwable {
				get_the_messages("//*[@id=\"ml-1180510\"]/result-location/div/div[1]/a/location-address/div/div");
				the_following_messages_will_be_displayed("//*[@id=\"ml-1180510\"]/result-location/div/div[1]/a/location-address/div/div");
			}
		
	
	@When("^Confrim the message For Test button with Connection Error$")
	public void Confrim_the_message_For_Test_button_with_Connection_Error() throws Throwable {
		get_the_messages("//*[@id=\"tdlaligncenter\"]");
		the_following_messages_will_be_displayed("Connection Error");
	}
	
	// Use it for debug to print all the ID to console so that we can make sure that we are in the right page to click on ID 
	@When("^Print Out all IDs$")
	public void Print_out_all_IDs() throws InterruptedException {
		List<WebElement> el = driver.findElements(By.cssSelector("*"));
		for (WebElement i : el) {
			String tagName = i.getTagName();
			String idvalue = i.getAttribute("id");
			String namevalue = i.getAttribute("name");
			if (!StringUtils.isBlank(idvalue) || !StringUtils.isBlank(namevalue)) {
				System.out.print("+++" + tagName + ": ");
				System.out.print("id=" + idvalue);
				System.out.print(" name=" + namevalue);
				System.out.println();
			}

		}
	}

	
	
	/*
	 public void password_for_login_page_from_txt_file() throws Throwable {
			FileInputStream fstream = new FileInputStream("C://Test/userInfo.txt");	
			
			// to save more than one password in the same text file 
			PropertiesFile p = new PropertiesFile("");
			Properties properties = p.getProperties();
			properties.get("emailpass");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			    this.loginpass = br.readLine();
			    br.close();
			    fstream.close();
	    }
	 		
	    
	public void doesFileExist(String path) throws IOException {
		try {
			FileInputStream pathfile = new FileInputStream(path);													
			BufferedReader pass = new BufferedReader(new InputStreamReader(pathfile));
			
			    this.pathfile = pass.readLine();
			    System.out.println(pathfile);
			    pass.close();
			    pathfile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			
		}
		
		
		
		
	}
	
	*/
	
	
	
}
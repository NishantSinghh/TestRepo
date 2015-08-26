package TestJen;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Jenki {
	
	public WebDriver driver1;
	public AndroidDriver driver;

	public void setup() throws MalformedURLException{
		
		
		System.out.println("Inside setp before start");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		//cap.setCapability("platformVersion", "4.4.2");
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("BrowserName", "Android");
		cap.setCapability("appPackage", "com.experitest.ExperiBank");
		cap.setCapability("appActivity", "com.experitest.ExperiBank.LoginActivity");
		/*
		cap.setCapability("testdroid_username","nishant.a.singh@capgemini.com");
		cap.setCapability("testdroid_password","Capgemini@123");
		cap.setCapability("testdroid_project","ERItest");
		cap.setCapability("testdroid_description","Eri bank application test");
		cap.setCapability("testdroid_testrun","Test Run: 2");
		cap.setCapability("testdroid_device",DeviceID);
		cap.setCapability("testdroid_app","95753ea9-4ff7-478f-98d5-a0ba1510f813/EriBank.apk");
		cap.setCapability("testdroid_target","Android");
		System.out.println("Inside setp before init");
		
		driver = new AndroidDriver(new URL("http://appium.testdroid.com/wd/hub"), cap);
		//return driver;
		*/
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		//driver.rotate(ScreenOrientation.LANDSCAPE);
		//String StrOrientation = driver.getOrientation().toString();
		//System.out.println(StrOrientation);
	}

	public void startappium() throws InterruptedException, IOException {
		
		String os_name = null;
		os_name = System.getProperty("os.name");
		System.out.println(os_name);
		CommandLine command = null;
		
		
			// Starting Appium on Windows-----------------------------------------------------------
						System.out.print("Attempting to start appium server..");
						command = new CommandLine("cmd");
						command.addArgument("/c");
						command.addArgument("D:\\Automation_Tools\\Appium\\node.exe");
						command.addArgument("D:\\Automation_Tools\\Appium\\node_modules\\appium\\bin\\appium.js");
						command.addArgument("--address");
						command.addArgument("127.0.0.1");
						command.addArgument("--port");
						command.addArgument("4723");
						command.addArgument("--bootstrap-port");
						command.addArgument("2251");
						command.addArgument("--command-timeout");
						command.addArgument("180");
						command.addArgument("--no-reset");
						command.addArgument("--log");
						command.addArgument("D:\\log\\appiumLogs.txt");  
						
						
			/*			System.out.print("Attempting to start appium server ..");
						String[] command1 = {"cmd.exe", "/C", "Start", strStartServerPath};
						Runtime.getRuntime().exec(command1);		*/
			//-----------------------------------------------------------------------
						DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
						DefaultExecutor executor = new DefaultExecutor();
						executor.setExitValue(1);
						try {
							executor.execute(command, resultHandler);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Thread.sleep(10000);
						System.out.print("Appium Started..");		
		
	}
	public void testCalc(){
		   //locate the Text on the calculator by using By.name()
			System.out.println("Before Testcalc Appium");
		   WebDriverWait wt = new WebDriverWait(driver,25);
		   wt.until(ExpectedConditions.elementToBeClickable(By.id("com.experitest.ExperiBank:id/usernameTextField")));
		   driver.findElementById("com.experitest.ExperiBank:id/usernameTextField").sendKeys("company");
		   driver.findElementById("com.experitest.ExperiBank:id/passwordTextField").sendKeys("company");
		   driver.findElementById("com.experitest.ExperiBank:id/loginButton");
		   System.out.println("After Start Appium");
		}
	public void afterTest() {

		driver.quit();

	}
	
	public static void main(String[] args) throws InterruptedException, IOException{
		Jenki jn = new Jenki();
		jn.startappium();
		jn.setup();
		jn.testCalc();
		jn.afterTest();
	}

}

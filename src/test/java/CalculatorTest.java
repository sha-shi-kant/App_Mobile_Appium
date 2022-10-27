import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;



class CalculatorTest {
	
	static AppiumDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			openCalculator();
		}catch(Exception exp) {
			//System.out.println(exp.getCause());
			//System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	public static void openCalculator() throws Exception {
		//mettre en file d'attente les capacités souhaités à distance de selenium ou une erreur vous pouvez simplement la survoler
		 DesiredCapabilities cap = new DesiredCapabilities();

		 //settings -> a propos de l'appareil -> numéro du modéle
		 cap.setCapability("deviceName","SM-G532F");
		 //cmd -> adb devices
	     cap.setCapability("udid","4200e4070783b4af");
	     cap.setCapability("platformName","Android");
	     //settings -> à propos de l'appareil -> infos logiciel -> version Android
	     cap.setCapability("platformVersion","6.0.1");
	     
	     //si vous travaillez avec une application native 
	     cap.setCapability("appPackage","com.sec.android.app.popupcalculator");
	     cap.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
	   
	        
	     //on va passer l'url de notre serveur appium
	     //URL url = new URL("http://localhost:4723/wd/hub");

	     // je dois envoyes les capability au serveur appium
	     //driver = new AppiumDriver(url,cap);
	     AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    
	     System.out.println("Application Started");
	     
	     WebElement two = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02"));
	     WebElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add"));
	     WebElement three = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_03"));
	     WebElement equals = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal"));
	     WebElement result = driver.findElement(By.className("android.widget.EditText"));
	   
	     two.click();
	     plus.click();
	     three.click();
	     equals.click();
	     
	     String res = result.getText();
	     System.out.println("\n Result is: "+res);
	     
	     System.out.println("Completed....");
	     
	}

}

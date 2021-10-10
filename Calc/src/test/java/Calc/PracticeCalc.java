package Calc;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PracticeCalc {
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException
	{
	//IP 127.0.0.1
	//4723
		
		//URL
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        
      //Desired Capability
      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability("platformName", "Android");
      cap.setCapability("platformVersion", "10");
      cap.setCapability("appPackage", "com.google.android.calculator");
      cap.setCapability("appActivity", "com.android.calculator2.Calculator");
      
//      {
//            "platformName": "Android",
//            "platformVersion": "11",
//            "appPackage": "com.google.android.calculator",
//            "appActivity": "com.android.calculator2.Calculator"
//          }
      
      
      
       //AndroidDriver
      
      // new AndroidDriver<WebElement>(null, null)
      AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, cap);
      
      SessionId sesId = driver.getSessionId(); // to get the session id
      System.out.println(sesId);
      
      //Mobile Element
  
      driver.findElement(By.xpath("//android.widget.Button[@text=9]")).click();
      driver.findElement(By.xpath("//android.widget.Button[@text='+']")).click();
      driver.findElement(By.xpath("//android.widget.Button[@text=5]")).click();
      driver.findElement(By.xpath("//android.widget.Button[@text='=']")).click();
     
     String result= driver.findElement(By.xpath("//android.widget.TextView")).getAttribute("text");
     System.out.println(result);
      
      System.out.println("Wait for sleep.."); 
	        for(int i=0; i<30; i++) //this we are using for debugging
	        {
	        	Thread.sleep(5000);
	        	
	        }
	        
	       System.out.println("Execution over");
	       
	   
 
}
}
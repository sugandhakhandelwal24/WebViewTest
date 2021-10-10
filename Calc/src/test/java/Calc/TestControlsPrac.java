package Calc;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class TestControlsPrac {

	static AndroidDriver<MobileElement> driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Create Driver Instance");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        //        Desired Capability
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "10");
        cap.setCapability("appPackage", "com.touchboarder.android.api.demos");
        cap.setCapability("appActivity", "com.example.android.apis.ApiDemos");   
//        cap.setCapability("appActivity","com.example.android.apis.views.Controls1");
        //        AndroidDriver
     driver = new AndroidDriver<MobileElement>(url, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SessionId sessionId = driver.getSessionId();
        System.out.println(sessionId);
        Thread.sleep(1000);
        String locValue = "//android.widget.Button[@text='Continue']";
        checkAndClick(locValue);
        Thread.sleep(1000);
        //android.widget.Button[@text='Continue']
        locValue = "//android.widget.Button[@text='OK']";
        checkAndClick(locValue);
        Thread.sleep(1000);
        locValue = "//android.widget.TextView[@text='OK']";
        checkAndClick(locValue);
        Thread.sleep(1000);
        locValue = "//android.widget.TextView[@text='API Demos']";
        checkAndClick(locValue);
        Thread.sleep(1000);
        locValue = "//android.widget.TextView[@text='Views']";
        checkAndClick(locValue);
//        clickViewold("Controls");
//        clickView("01. Light Theme");
//        driver.hideKeyboard();
        
    }

//    @Test
    public void testSeekBar() throws InterruptedException{
    	clickView("Seek Bar");
    	MobileElement seekbar = driver.findElement(By.id("com.touchboarder.android.api.demos:id/seek"));
    	int startX = seekbar.getLocation().getX();
    	int startY = seekbar.getLocation().getY();
    	
    	int width = seekbar.getSize().getWidth();
    	int endX = (int)(0.5*width + startX);
        int endY = startY;
    	//int endY = (int)(0.7*width + startY);
     //   int endX = startX;
    	 TouchAction action = new TouchAction(driver);
    	 action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
    	
    	 for (int i=0; i<40; i++)
    	 {
    		 Thread.sleep(4000);
    	 }
    }
    
    private static void clickViewold(String elemClick) {
        MobileElement parent = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']"));
        List<MobileElement> lstViews = parent.findElements(By.xpath("//android.widget.TextView"));
        for (MobileElement view : lstViews) {
            System.out.println(view.getAttribute("text"));
            if (view.getAttribute("text").equals(elemClick)) {
                view.click();
                break;
            }
        }
    }

private static void checkAndClick(String locValue) {
        List<MobileElement> lstElems = driver.findElements(By.xpath(locValue));
        if (lstElems.size()>0) {
            lstElems.get(0).click();
        }
    }

//    @Test
    public void testFirstName() {
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/edit")).sendKeys("Sugandha");
        String expValue = driver.findElement(By.id("com.touchboarder.android.api.demos:id/edit")).getAttribute("text");
        System.out.println(expValue);
        driver.hideKeyboard();
    }

   // @Test
    public void testCB2() {
        MobileElement cb2 = driver.findElement(By.id("com.touchboarder.android.api.demos:id/check2"));
        cb2.click();
        if (!cb2.getAttribute("checked").equals("false")) {
            cb2.click();
        }
        
    }

//    @Test
    public void testRadioGroup() {
        MobileElement rg = driver.findElement(By.xpath("//android.widget.RadioGroup"));
        List<MobileElement> rbts = rg.findElements(By.xpath("//android.widget.RadioButton"));
        for (MobileElement rb : rbts) {
            System.out.println(rb.getAttribute("checked"));
        }
        
   }
    
//    @Test
    public void testToogleButton() {
        
        MobileElement tb1 = driver.findElement(By.id("com.touchboarder.android.api.demos:id/toggle1"));
        System.out.println(tb1.getAttribute("checked"));
        tb1.click();
        System.out.println(tb1.getAttribute("checked"));
        
        
    }

//    @Test
    public void testSpinner() {
        MobileElement spinner = driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner1"));
        MobileElement selectedTV = spinner.findElement(By.id("android:id/text1"));
//Getting the default selected value
        System.out.println(selectedTV.getAttribute("text"));
        spinner.click();
        
        List<MobileElement> lstTVs = driver.findElements(By.xpath("//android.widget.CheckedTextView"));
        for (MobileElement tv : lstTVs) {
            System.out.println(tv.getAttribute("text")+" "+tv.getAttribute("checked"));
            if (tv.getAttribute("text").equals("Saturn")) {
                tv.click();
                
            }
            
        }
        
        selectedTV = spinner.findElement(By.id("android:id/text1"));
        System.out.println(selectedTV.getAttribute("text"));
        
        
    }
    
    
   // @Test
    public void DragDrop()
    {
    	clickView("Drag and Drop");
    	MobileElement drag = driver.findElement(By.id("com.touchboarder.android.api.demos:id/"));
        MobileElement drop = driver.findElement(By.id("com.touchboarder.android.api.demos:id/drag_dot_3"));
    	int startX = drag.getLocation().getX();
    	int startY = drag.getLocation().getY();
    	
    	//endX = drop
    }
    
    
    @Test
    public void WebView()
    {
    	clickView("WebView");
    	MobileElement WebView = driver.findElement(By.id("//android.widget.TextView[@text='WebView']"));
    	WebView.click();
    	WebElement iframeElement = driver.findElement(By.xpath("//android.webkit.WebView"));
    	driver.context("Hello World! - 1");
    	driver.switchTo().frame(iframeElement);
    	iframeElement.click();
    }

public boolean isSelected(String id) {
        MobileElement me = driver.findElement(By.id(id));
        boolean status = false;
        if (me.getAttribute("checked").equals("true")) {
            status = true;
        }
        return status;
    }
    
    public boolean isSelected(MobileElement me) {
        
        boolean status = false;
        if (me.getAttribute("checked").equals("true")) {
            status = true;
        }
        return status;
    }

    private void clickView(String view) {
        boolean flagView = false;
        while (!flagView) {
            MobileElement parent = driver
                    .findElementByXPath("//android.widget.FrameLayout[@resource-id='android:id/content']");
            List<MobileElement> lstViews = parent.findElements(By.xpath("//android.widget.TextView"));
            for (MobileElement cview : lstViews) {
                System.out.println(cview.getAttribute("text"));
                if (cview.getAttribute("text").equals(view)) {
                    cview.click();
                    flagView = true;
                    break;
                }
            }
            
            if (!flagView) {
                scrollUp();
            }
        }
    }
    
  
    
    
//@Test
public void testScroll() {
    scrollUp();
   
}

public void scrollUp()  {
    int height = driver.manage().window().getSize().getHeight();
    int width = driver.manage().window().getSize().getWidth();
    
    int startX = (int) (0.5 * width);
    int endX = (int) (0.5 * width);
    
    int startY = (int) (0.90 * height);
    int endY = (int) (0.10 * height);
    
    
    TouchAction action = new TouchAction(driver);
    
    action
    .longPress(PointOption.point(startX, startY))
    .moveTo(PointOption.point(endX, endY))
    .release()
    .perform();
    
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
}
}




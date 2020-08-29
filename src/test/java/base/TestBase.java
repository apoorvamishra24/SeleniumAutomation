package base;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import webfactory.WebDriverFactory;

public class TestBase {
    protected WebDriver driver; //this should never be static, if made static parallel execution of classes not possible
    protected final static String base_url = "https://amazon.in";
    protected final static int implicit_wait_timeout_in_sec = 20;
    protected final static String defaultPageTitleText = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    
    private String getBrowserName(){
        String browserDefault = "chrome"; 
        String browserSentFromCmd = System.getProperty("browser");
      
        if (browserSentFromCmd==null){
            return browserDefault;
        }else{
            return browserSentFromCmd;
        }
    }

    @Before
    public void set_up(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
        
        String browser = getBrowserName();
        try{
            driver = WebDriverFactory.getWebDriverForBrowser(browser);
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail("Browser Initialization failed. Check the Stack Trace. " + e.getMessage());
        }
    }

    @After
    public void clean_up(){
        driver.quit();
    }

}

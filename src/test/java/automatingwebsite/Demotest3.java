package automatingwebsite;
import org.junit.Test;

import  base.TestBase;
import pageobjects.CmnPageObjects;


public class Demotest3  extends TestBase{



	    @Test
	    public void t_02_search_for_product() {

	       
	        driver.get(base_url);
	        CmnPageObjects cmnPageObjects = new CmnPageObjects(driver);
	        cmnPageObjects.validatePageTitleMatch(defaultPageTitleText);

	     
	        cmnPageObjects.SetSearchTextBox("Laptop");
	        cmnPageObjects.ClickOnSearchButton();
	        cmnPageObjects.validatePageTitleMatch("Amazon.in : Laptop");
	        
	    }
	}




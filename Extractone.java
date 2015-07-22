package selenium;





import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Extractone  {
    public static void main(String[] args) throws InterruptedException {
       
        //WebDriver driver = new HtmlUnitDriver();
        WebDriver driver = new FirefoxDriver();
        

        
        driver.get("http://www.otcmarkets.com/stock/PZOO/news");
        
        boolean next=true;
      
        //while(next){
        
        WebElement table = driver.findElement(By.id("outsideNewsTable"));
       
       List<WebElement> tbodies= table.findElements( By.tagName("tbody"));

       
        for(WebElement ele:tbodies){
        	
        	try{
        		ele.findElement(By.tagName("a"));
        	}
        	catch(Exception e){
        		continue;
        	}
        	
        		
        	WebElement atag=ele.findElement(By.tagName("a"));
        
        	//System.out.println(atag.getText());
        	atag.click();
        	
        	 Thread.sleep(3000);
        	// System.out.println(driver.getPageSource());
        	WebElement newscontainer = driver.findElement(By.className("newsContainer"));
        	System.out.println(newscontainer.getText());
        	WebElement newsback = driver.findElement(By.className("newsBack"));
        	WebElement back =newsback.findElement(By.tagName("a"));
        	back.click();
        	Thread.sleep(3000);
        	break;
       }
        
        
        //List<WebElement> pagination=driver.findElements(By.className("pageList"));
        //for
        
        //} 
        
/*        List<WebElement> tabletr= table.findElements(By.xpath(".//tbody/tr"));
        
for(WebElement ele:tabletr){
	for (WebElement elein:ele.findElements(By.xpath(".//td"))){
		if (elein.getAttribute("class")==null||elein.getAttribute("class")==""){
			elein.
		}
	}
	}*/

        driver.quit();
    }
}
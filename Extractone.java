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
        

        
        driver.get("http://www.otcmarkets.com/stock/GOOG/news");
        
        Thread.sleep(3000);
        
        boolean next=true;
      
        while(next){
            next=false;
        

            WebElement table = driver.findElement(By.id("outsideNewsTable"));
            
            List<WebElement> tbodies= table.findElements( By.tagName("tbody"));
           
            
        for(int i=0;i<tbodies.size();i++){
            
            try{
                tbodies.get(i).findElement(By.tagName("a"));
            }
            catch(Exception e){
                continue;
            }
            
            List<WebElement> trs= tbodies.get(i).findElements( By.tagName("tr"));
            
            
            for(int j=0;j<trs.size();j++){
                
                
                WebElement atag=trs.get(j).findElement(By.tagName("a"));
                if(atag.getAttribute("href").equals("javascript:void(null);")){
            
                
                atag.click();
                
                 Thread.sleep(3000);
                
                // System.out.println(driver.getPageSource());
                WebElement newscontainer = driver.findElement(By.className("newsContainer"));
                System.out.println(newscontainer.getText());
                WebElement newsback = driver.findElement(By.className("newsBack"));
                WebElement back =newsback.findElement(By.tagName("a"));
                back.click();
                 Thread.sleep(3000);    
                 
                 //refreshing the holders as the page was messed with
                 
                  table = driver.findElement(By.id("outsideNewsTable"));
                 
                  tbodies= table.findElements( By.tagName("tbody"));
                  
                  trs= tbodies.get(i).findElements( By.tagName("tr"));
                  
                  //refresh ends
                }
                else{
                    System.out.println(atag.getAttribute("href"));
                }
                
            }
                
            
            
       }
        
        //check for the next button, if found then click set the flag to true
        
        WebElement pagination=driver.findElement(By.id("outsideNewsTable")).findElement(By.className("pageList"));
        List<WebElement> paginationli=pagination.findElements(By.tagName("li"));
      
        
        for(WebElement ele:paginationli){
            
            
            try{
            ele.findElement(By.tagName("a")).getText();
            }
            catch(Exception e){
                continue;
            }
            
            if(ele.findElement(By.tagName("a")).getText().equals("next >")){
                //System.out.println("HI");
                WebElement nextpage= ele.findElement(By.tagName("a"));
                nextpage.click();
                next=true;
                Thread.sleep(3000);
                
            }
            
        }
        
              } 
        


        driver.quit();
    }
}
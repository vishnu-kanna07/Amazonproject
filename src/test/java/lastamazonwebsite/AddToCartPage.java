package lastamazonwebsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.BaseAmazonClass;

public class AddToCartPage extends BaseAmazonClass {
	

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[1]/h2/a")WebElement firstproduct;
		// @FindBy(id="add-to-cart-button") WebElement Addcart;
		 
	public 	 AddToCartPage()
	
	 {
		PageFactory.initElements(driver,this);
   
       }

	
	public void Addoneitemtothecart() throws InterruptedException
	{
		
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
Thread.sleep(2000);
	String text = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div/div[2]/div[1]/h2/a")).getText();
	if(text!= null)
			{
		 driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div/div[2]/div[1]/h2/a")).click();
		 Thread.sleep(5000);
	//int a =driver.findElements(By.id("add-to-cart-button")).size();
	//if(a==1)
	//{
	 
		 //driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[1]/h2/a")).click();
			int quantity =driver.findElements(By.className("quantity")).size();
			
			do {
			Select dropdown = new Select(driver.findElement(By.id("quantity")));
			dropdown.selectByIndex(quantity);
			
				quantity++;
				
				if(quantity==3)
					break;

				System.out.println("item quantity is increased:" + quantity);	
			}
			while(quantity>=1);
		
			{
	
			System.out.println(" items added to the cart module");
			driver.findElement(By.id("add-to-cart-button")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
			Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id=\"quantity\"]")));
			dropdown2.selectByIndex(2);
			System.out.println("succussfully the same item added  multiple times");	
			
			
			}}}

		
	
public void Addmultipleitemtothecart() throws InterruptedException

{
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,800)");
Thread.sleep(2000);
String text = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[1]/h2/a")).getText();
if(text!= null)
		{
	 driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[1]/h2/a")).click();
	 Thread.sleep(5000);

		int quantity =driver.findElements(By.className("quantity")).size();
		System.out.println(" items added to the cart module");
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		
	
		
		
		}}
	

	
}	

     
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



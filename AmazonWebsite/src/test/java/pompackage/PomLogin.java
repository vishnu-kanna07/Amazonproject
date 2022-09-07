package pompackage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basepackage.BaseAmazonClass;
import homepackage.Homepage;
import orderpackage.Orderpage;
public class PomLogin extends BaseAmazonClass{

	   Actions action=new Actions(driver);

	@FindBy(css="#nav-link-accountList")
	WebElement Account;
	@FindBy(xpath="//a[contains(text(),'Start here.')]")
	WebElement Starthere;
	@FindBy(css="#ap_customer_name")
	WebElement Username;
	//@FindBy(id="ap_customer_name")WebElement Username;
	@FindBy(id="ap_email")WebElement Mobilenumber;
	@FindBy(id="ap_password") WebElement Password;
	@FindBy(id="ap_password_check")WebElement passwordagain;
	@FindBy(id="continue")WebElement Continue;
	@FindBy(css = "#authportal-main-section > div:nth-child(2) > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a")WebElement signIn;
	@FindBy(id="ap_email")WebElement email;
	@FindBy(id="continue")WebElement Continue1;
	@FindBy(id="ap_password")WebElement password;
	@FindBy(id="signInSubmit")WebElement Continue2;
	@FindBy(css ="#nav-logo-sprites")WebElement logo;

	public PomLogin() {

		PageFactory.initElements(driver,this);
	}
	
	public  String verify()
	{
		return driver.getTitle();
	}
	
	public Homepage login(String un,String mb,String pa,String pada) throws InterruptedException


	{
	   action.moveToElement(Account).build().perform();
	   Thread.sleep(2000);
	   action.moveToElement(Starthere).click().build().perform();
	   Thread.sleep(2000);
		Username.sendKeys(un);
		Mobilenumber.sendKeys(mb);
		Password.sendKeys(pa);
		passwordagain.sendKeys(pada);
	    Continue.click();
	    signIn.click();
	    email.sendKeys(mb);
	    Continue1.click();
	    password.sendKeys(pa);
	    Continue2.click();
	    Thread.sleep(2000);
	 
		return new  Homepage();	
	}

public boolean ValidateIMG()
	
	{
		return logo.isDisplayed();
	}

	}


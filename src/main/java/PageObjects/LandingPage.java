package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/health-quiz']")
	WebElement healthQuizBtn;
	
	public void goTo() {
		driver.get("https://staging-nuxt3.bywinona.com/");
	}
	
	public String getTheTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public HealthQuiz takeQuiz() {
		healthQuizBtn.click();
		return new HealthQuiz(driver);
	}
}

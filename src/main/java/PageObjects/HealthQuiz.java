package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Utils;

public class HealthQuiz extends Utils {
	
	WebDriver driver;

	public HealthQuiz(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private By startQuizButton = By.xpath("//button[text()='Start Quiz']");
	
	private By ageField = By.xpath("//input[@placeholder='Age']");
	
	private By nextButton = By.xpath("//button[text()='Next']");
	
	private By choice = By.className("health-quiz-options__item");
	
	private By emailField = By.xpath("//input[@type='email']");
	
	private By submitButton = By.xpath("//button[@type='submit']");
	
	public By confirmMsg = By.xpath("//div[@class='texts-content']/h1");
	
	public void startQuiz() {
		visibilityOf(startQuizButton);
		driver.findElement(startQuizButton).click();
	}
	
	public void enterAge(int age) throws InterruptedException {
		String ageString = String.valueOf(age);
		visibilityOf(ageField);
		driver.findElement(ageField).sendKeys(ageString);
		Thread.sleep(2000);
		clickNextButton(nextButton);
	}
	
	public void select3Symptoms(String email) {
		headerChecker("Do you have any of the following symptoms? ");
		pickAndClick(choice, 3);
		clickNextButton(nextButton);
		
		try {
			headerChecker("How long have you been experiencing these symptoms?");
			pickAndClick(choice, 1);
			visibilityOf(emailField);
			driver.findElement(emailField).sendKeys(email);
			driver.findElement(submitButton).click();
		} catch (TimeoutException e) {
			System.out.println("Skipping 'How long...' question because user selected 'None'.");
		}
	}
	
	public void mensCycleChange() {
		headerChecker("Have you noticed changes in your menstrual cycle?");
		pickAndClick(choice, 1);
	}
	
	public void selectConditions(int count) {
		headerChecker("Do you have concerns about any of the following conditions?");
		pickAndClick(choice, count);
		clickNextButton(nextButton);
	}
	
	public void hrt() {
		headerChecker("Are you familiar with bioidentical hormone replacement therapy (HRT) for women?");

		pickAndClick(choice, 1);

		try {
			headerChecker("Have you taken bioidentical hormone replacement therapy (HRT) in the past?");
			pickAndClick(choice, 1);
		} catch (TimeoutException e) {
			System.out.println("Skipping 'Have you taken...' question because user clicked 'No'.");
		}
	}
	
	public String confirmationPage() throws InterruptedException {
		visibilityOf(confirmMsg);
		Thread.sleep(2000);
		String lastPageMsg = driver.findElement(confirmMsg).getText();
		return lastPageMsg;
	}


}

package AbstractComponents;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public Utils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
	}

	public void pickAndClick(By locator, int count) {
		List<WebElement> elements = driver.findElements(locator);

		if (count > elements.size()) {
			throw new IllegalArgumentException("Count cannot be larger than list size.");
		}

		List<Integer> indices = new ArrayList<>();
		for (int i = 0; i < elements.size(); i++) {
			indices.add(i);
		}

		Collections.shuffle(indices);

		for (int i = 0; i < count; i++) {
			WebElement element = elements.get(indices.get(i));

			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

			element.click();
		}
	}

	public void clickNextButton(By nextButton) {
		wait.until(d -> d.findElement(nextButton).isEnabled());
		WebElement next = driver.findElement(nextButton);
		wait.until(ExpectedConditions.elementToBeClickable(next));
		next.click();
	}

	public void headerChecker(String title) {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[text()='" + title + "'] | //h2[text()='" + title + "']")));
	}

	public void visibilityOf(By ele) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}

}

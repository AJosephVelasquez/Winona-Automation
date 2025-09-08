package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HealthQuiz;
import TestComponents.BaseTest;

public class MainTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void winonaQuizHappyPath(HashMap<String, Object> input) throws InterruptedException {
		
		String title = landingPage.getTheTitle();
		Assert.assertEquals(title, "Winona | Menopause Care & Hormone Replacement Therapy", "Website title mismatch");
		
		HealthQuiz healthQuiz = landingPage.takeQuiz();
		healthQuiz.startQuiz();
		healthQuiz.enterAge((Integer) input.get("age"));
		healthQuiz.select3Symptoms((String) input.get("email"));
		healthQuiz.mensCycleChange();
		healthQuiz.selectConditions((Integer) input.get("noOfConditions"));
		healthQuiz.hrt();
		
		String lastPageMsg = healthQuiz.confirmationPage();
		Assert.assertTrue(lastPageMsg.contains("good candidate for Winona"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
	    List<HashMap<String, Object>> data = getData(
	            System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\validData.json");

	    Object[][] maps = new Object[data.size()][1];
	    for (int i = 0; i < data.size(); i++) {
	        maps[i][0] = data.get(i);
	    }
	    return maps;
	}

}

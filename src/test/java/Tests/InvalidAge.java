package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HealthQuiz;
import TestComponents.BaseTest;

public class InvalidAge extends BaseTest {

	@Test(dataProvider = "getData")
	public void underOrOverAge(HashMap<String, Integer> input) throws InterruptedException {
		
		String title = landingPage.getTheTitle();
		Assert.assertEquals(title, "Winona | Menopause Care & Hormone Replacement Therapy");
		
		HealthQuiz healthQuiz = landingPage.takeQuiz();
		healthQuiz.startQuiz();
		healthQuiz.enterAge(input.get("age"));
		String lastPageMsg = healthQuiz.confirmationPage();
		Assert.assertTrue(lastPageMsg.contains("unable to provide you treatment"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, Object>> data = getData(
				System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\invalidAge.json");

		int limit = data.size();
		
		Object[][] maps = new Object[limit][1];
		
		for(int i = 0; i < limit; i ++) {
			maps[i][0] = data.get(i);
		}
		
		return maps;
	}
}

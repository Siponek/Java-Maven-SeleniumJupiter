package test;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SeleniumJupiter.class)
public class TestClassA {

	@Test
	public void testA(ChromeDriver driver) throws InterruptedException {
		// Example Test method()
    	// You have to insert here the test logics
	}
	
	@Test
	public void testB(ChromeDriver driver) throws InterruptedException {
		// Example Test method()
    	// You have to insert here the test logics
	}
	
	@Test
	public void testC(ChromeDriver driver) throws InterruptedException {
		// Example Test method()
    	// You have to insert here the test logics
	}
}


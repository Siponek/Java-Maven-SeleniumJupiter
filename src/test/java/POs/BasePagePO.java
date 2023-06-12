package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

// page_url = http://localhost:8080/
public class BasePagePO {
    protected WebDriver driver;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public BasePagePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By element) {
        return driver.findElement(element);
    }

    public void click(By element) {
        find(element).click();
    }

    public void type(By element, String text) {
        find(element).sendKeys(text);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @FindBy(css = "span.help-inline")
    public List<WebElement> spanErrorMessage;
    public boolean isErrorDisplayed(String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<String> elementTexts = wait.until(ExpectedConditions.visibilityOfAllElements(spanErrorMessage))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        for (String text : elementTexts) {
            if (text.contains(errorMessage)) {
                System.out.println(ANSI_BLUE + "Error message: " + text + ANSI_RESET);
                return true;
            }
        }
        return false;
    }
}

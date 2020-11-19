package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Browser {
    CHROME, FIREFOX;

    Browser() { }

    public WebDriver getWebDriver() {
        WebDriver driver;

        switch (this) {
            case CHROME:
            {
                System.setProperty("webdriver.chrome.driver", System.getenv("SELENIUM_CHROME_DRIVER"));
                driver = new ChromeDriver();
                break;
            }
            case FIREFOX:
            {
                System.setProperty("webdriver.firefox.driver", System.getenv("SELENIUM_FIREFOX_DRIVER"));
                driver = new FirefoxDriver();
                break;
            }
            default:
            {
                driver = null;
            }
        }

        return driver;
    }


}

package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    public static WebDriver createDriver() {
        WebDriver driver = null;
        String browserType = getBrowserType();


        switch (browserType) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");
                System.setProperty("webdriver.chrome.whitelistedIps", "");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--no-first-run");
                chromeOptions.addArguments("--disable-default-apps");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);


                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.merge(dc);

                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver.exe");
                System.setProperty("webdriver.chrome.whitelistedIps", "");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                driver = new FirefoxDriver(firefoxOptions);
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void cleanUpDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }

    private static String getBrowserType() {
        String browsertype;
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            properties.load(fileInputStream);
            browsertype = properties.getProperty("browser", "chrome").toLowerCase().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return browsertype;
    }
}

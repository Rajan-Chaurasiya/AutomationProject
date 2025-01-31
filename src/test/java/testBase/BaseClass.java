package testBase;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j
import org.testng.annotations.Parameters;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups = {"Sanity","Regression","Master"})
    @Parameters({"os","browser"})
    public void setup(String os, String browser) throws IOException {

        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        // remote
        // os
        if (p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            if (os.equalsIgnoreCase("window")){
                desiredCapabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("linux")) {
                desiredCapabilities.setPlatform(Platform.LINUX);

            } else if (os.equalsIgnoreCase("mac")) {
                desiredCapabilities.setPlatform(Platform.MAC);
            }else {
                System.out.println("No Matching OS");
                return;
            }

            // browser
            switch (browser.toLowerCase()){
                case "chrome" : desiredCapabilities.setBrowserName("chrome");break;
                case  "edge" : desiredCapabilities.setBrowserName("MicrosoftEdge");break;
                case "firefox" : desiredCapabilities.setBrowserName("FireFox");break;
                default:
                    System.out.println("No Matching Browser");
                    return;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),desiredCapabilities);
        }

        // local
        if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("Invalid browser");
                    return;
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(p.getProperty("URL1"));
        driver.manage().window().maximize();

    }

    @AfterClass(groups = {"Sanity","Regression","Master"})
    public void teardown(){
        driver.quit();
    }

    public String randomString()
    {
        String generatedstring= RandomStringUtils.randomAlphabetic(5);
        return generatedstring;
    }

    public String randomNumber()
    {
        String generatednumber=RandomStringUtils.randomNumeric(10);
        return generatednumber;
    }

    public String randomAlphaNumberic()
    {
        String generatedstring=RandomStringUtils.randomAlphabetic(3);
        String generatednumber=RandomStringUtils.randomNumeric(3);
        return (generatedstring+"@"+generatednumber);
    }

    public String captureScreen(String tname) throws IOException, InterruptedException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }



}

//Otići na http://www.strela.co.rs/,
// kliknuti na dugme Prodavnica u headeru,

// izabrati opciju Lukovi - Bows iz leve navigacije,
// potom kliknuti na luk koji se zove Samick Sage,
// i onda proveriti da ime tog luka na njegovoj stranici zaista sadrži reč Samick.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.navigate().to("http://www.strela.co.rs/");

        WebElement prodavnica = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a/span/strong"));
        prodavnica.click();

        WebElement lukovi = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
        lukovi.click();

        WebElement samick = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
        samick.click();

        String expectedName = "Samick";
        String actualName = driver.getTitle();

        if(actualName.contains(expectedName)){
            System.out.println("Ime luka sadrži reč Samick.");
        }else{
            System.out.println("Ime luka ne sadrži reč Samick.");
        }

        driver.close();

    }
}

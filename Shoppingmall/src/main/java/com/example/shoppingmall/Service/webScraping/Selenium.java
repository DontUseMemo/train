package com.example.shoppingmall.Service.webScraping;

import com.example.shoppingmall.entity.dataSample.ScrapingEntity;
import com.example.shoppingmall.repository.dataSample.ScrapingRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.List;

//selenium : 동적인 데이터 수집 가능 (직접 브라우저를 통제해서 사람처럼 브라우저 작동을 데이터 수집) : chromdriver
//jsoup : httpRequest 사용해서 정적이 데이터 (HTML, CSS..)를 수집
@Service
public class Selenium {

    //selenium 드라이버 다운
    private WebDriver driver;

    private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private static final String WEB_DRIVER_PATH = "D:/chromedriver.exe";
    //메서드 매개변수로 받아서 스크래핑 동작을 위한 변수 선언
    private String base_url;

    public void scraping() {
        //System.io : 개발한 자바 프로그램(런타임)에서 외부 프로그램을 작동하기 위한 객체
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        base_url = "https://www.fragrantica.com/notes/";
        driver.get(base_url);

        try {
            Thread.sleep(10000);
            //스크래핑할 페이지의 전체 데이터 출력
            System.out.println(driver.getPageSource());

            List<WebElement> elements = driver.findElements(By.tagName("h2"));
            int checkNum = 0;
            for(WebElement e : elements) {
                System.out.println(e.getText());
//                System.out.println((e.getCssValue("width")));
//                //Entity 인스턴스를 만듦
//                ScrapingEntity scrapingEntity = new ScrapingEntity();
                //Entity에 스크래핑을 통해 얻은 데이터를 넣기
                checkNum++;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //공식문서에서는 close()가 아니라 quit() 권장
            driver.quit();
        }
    }
}

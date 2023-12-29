package nftdata.dataprocessing.datacollector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TwitterDataCollector extends DataCollector{
    public static void twitterDataCollector() {
        System.setProperty("webdriver.edge.driver", "browserDrivers/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized ", "--disable-extensions");
        WebDriver driver = new EdgeDriver(options);
        try{
            driver.get("https://twitter.com/explore");
            Thread.sleep(5000);

            //Login
            WebElement usernameInput = driver.findElement(By.xpath("//input[@autocomplete=\"username\"]"));
            usernameInput.sendKeys("acccftest1@gmail.com");
            usernameInput.sendKeys(Keys.RETURN);
            Thread.sleep(5000);

            WebElement userCheckInput = driver.findElement(By.xpath("//input[@autocomplete=\"on\"]"));
            if (userCheckInput != null) {
                userCheckInput.sendKeys("@cf61885");
                userCheckInput.sendKeys(Keys.RETURN);
                Thread.sleep(5000);
            }

            WebElement passwordInput = driver.findElement(By.xpath("//input[@autocomplete=\"current-password\"]"));
            passwordInput.sendKeys("@cf61885");
            passwordInput.sendKeys(Keys.RETURN);
            Thread.sleep(8000);

            //Search
            WebElement searchBox = driver.findElement(By.xpath("//input[@enterkeyhint=\"search\"]"));
            searchBox.sendKeys(SEARCH_HASHTAG);
            searchBox.sendKeys(Keys.RETURN);
            Thread.sleep(8000);


            //Data Collect
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < SCROLL_TURNS; i++) {
                List<WebElement> postElements = driver.findElements(By.xpath("//article[@data-testid=\"tweet\"]"));

                for (WebElement postElement : postElements) {
                    String author = postElement.findElement(By.xpath(".//span[@class=\"css-1qaijid r-bcqeeo r-qvutc0 r-poiln3\"]")).getText();
                    String inputDate = postElement.findElement(By.xpath(".//time")).getAttribute("datetime").substring(0, 10);
                    LocalDate dateFormat = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
                    String date = dateFormat.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    String replies = postElement.findElement(By.xpath(".//div[@data-testid=\"reply\"]")).getText();
                    String reposts = postElement.findElement(By.xpath(".//div[@data-testid=\"retweet\"]")).getText();
                    String likes = postElement.findElement(By.xpath(".//div[@data-testid=\"like\"]")).getText();
                    String views = postElement.findElement(By.xpath("(.//div[@class=\"css-175oi2r r-xoduu5 r-1udh08x\"])[4]")).getText();
                    String hashtags = extractHashtags(postElement);

                    JSONObject tweetObject = new JSONObject();
                    tweetObject.put("author", author);
                    tweetObject.put("date", date);
                    tweetObject.put("replies", replies);
                    tweetObject.put("reposts", reposts);
                    tweetObject.put("likes", likes);
                    tweetObject.put("views", views);
                    tweetObject.put("hashtags", hashtags);

                    jsonArray.add(tweetObject);
                }

                scrollDown(driver);
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String formattedJson = gson.toJson(JsonParser.parseString(jsonArray.toString()));

            try (FileWriter fileWriter = new FileWriter("src/nftdata/datacollection/twitter.json")) {
                fileWriter.write(formattedJson);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

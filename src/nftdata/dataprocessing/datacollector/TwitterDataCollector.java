package nftdata.dataprocessing.datacollector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwitterDataCollector {
    private static final String SEARCH_HASHTAG = "#NFT";
    private static final int MAX_ELEMENTS = 2;

    private static String extractHashtags(WebElement postElement) {
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(postElement.getText());
        StringBuilder hashtagsStringBuilder = new StringBuilder();
        while (matcher.find()) {
            String hashtag = matcher.group();
            hashtagsStringBuilder.append(hashtag).append(" ");
        }
        return hashtagsStringBuilder.toString().trim();
    }

    private static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "browserDrivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        try{
            driver.get("https://twitter.com/explore");
            Thread.sleep(3000);

            //Login
            WebElement usernameInput = driver.findElement(By.xpath("//input[@autocomplete=\"username\"]"));
            usernameInput.sendKeys("acccftest1@gmail.com");
            usernameInput.sendKeys(Keys.RETURN);
            Thread.sleep(3000);

            WebElement usercheckInput = driver.findElement(By.xpath("//input[@autocomplete=\"on\"]"));
            usercheckInput.sendKeys("@cf61885");
            usercheckInput.sendKeys(Keys.RETURN);
            Thread.sleep(3000);

            WebElement passwordInput = driver.findElement(By.xpath("//input[@autocomplete=\"current-password\"]"));
            passwordInput.sendKeys("@cf61885");
            passwordInput.sendKeys(Keys.RETURN);
            Thread.sleep(8000);

            //Search
            WebElement searchBox = driver.findElement(By.xpath("//input[@enterkeyhint=\"search\"]"));
            searchBox.sendKeys(SEARCH_HASHTAG);
            searchBox.sendKeys(Keys.RETURN);
            Thread.sleep(4000);


            //Data Collect
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < 2; i++) {
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

                    System.out.println("Author: " + author);
                    System.out.println("Date: " + date);
                    System.out.println("Replies: " + replies);
                    System.out.println("Reposts: " + reposts);
                    System.out.println("Likes: " + likes);
                    System.out.println("Views: " + views);
                    System.out.println("Hashtags: " + hashtags);
                    System.out.println("-------------------------");

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

            try (FileWriter fileWriter = new FileWriter("src/twitter.json")) {
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

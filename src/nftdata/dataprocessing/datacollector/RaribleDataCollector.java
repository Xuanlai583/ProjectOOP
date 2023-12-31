package nftdata.dataprocessing.datacollector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RaribleDataCollector extends DataCollector{
    public static void raribleDataCollector(){
        WebDriver driver = openBrowser();
        try{
            driver.get("https://rarible.com/explore/all/collections?period=H1");
            Thread.sleep(8000);

            //Data Collect
            boolean[] visited = new boolean[101];
            JSONArray jsonArray = new JSONArray();
            outer: while(true){
                List<WebElement> raribleElements = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div"));

                for(WebElement raribleElement : raribleElements) {
                    String rank = raribleElement.findElement(By.xpath(".//a/div/div/div[1]/span")).getText();
                    int rankInt = Integer.parseInt(rank);
                    if (rankInt > MAX_ELEMENTS) break outer;
                    if(!visited[rankInt]) {
                        visited[rankInt] = true;
                        String collection = raribleElement.findElement(By.xpath(".//a/div/div/div[2]/a/div/div[2]/span")).getText();
                        String floorPrice = raribleElement.findElement(By.xpath(".//a/div/div/div[3]/span")).getText();
                        String floorChange;
                        try {
                            floorChange = raribleElement.findElement(By.xpath(".//a/div/div/div[4]/span/span")).getText();
                        }catch (org.openqa.selenium.NoSuchElementException e){
                            floorChange = "—";
                        }
                        String volume = raribleElement.findElement(By.xpath(".//a/div/div/div[5]/span")).getText();
                        String volumeChange = raribleElement.findElement(By.xpath(".//a/div/div/div[6]/span")).getText();
                        String items = raribleElement.findElement(By.xpath(".//a/div/div/div[7]/span")).getText();
                        String owners = raribleElement.findElement(By.xpath(".//a/div/div/div[8]/span")).getText();

                        //JSON Object
                        JSONObject raribleObject = new JSONObject();
                        raribleObject.put("rank", rank);
                        raribleObject.put("collection", collection);
                        raribleObject.put("floor price", floorPrice);
                        raribleObject.put("floor change", floorChange);
                        raribleObject.put("volume", volume);
                        raribleObject.put("volume change", volumeChange);
                        raribleObject.put("items", items);
                        raribleObject.put("owners", owners);

                        jsonArray.add(raribleObject);

                    }
                }
                pixelScrollDown(driver, 1800);
            }

            //Export JSON
            exportJSON(jsonArray, "rarible.json");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}

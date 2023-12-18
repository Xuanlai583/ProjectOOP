package nft.user;

import nft.data.NFTToken;
import nft.data.posts.Blog;
import nft.data.posts.Tweet;

import java.util.ArrayList;

public class User {

    public static void main(String[] args) {
        NFTToken NFT1 = new NFTToken("NFTso1","snow", "12.12.2010",12.3, "Movie", true);
        NFTToken NFT2 = new NFTToken("NFTso2","snowngu", "12.01.2013",15.6, "Actor", true);

        ArrayList<String> tags = new ArrayList<>();
        ArrayList<String> keywords = new ArrayList<>();
        tags.add("2021");
        keywords.add("2022");
        Blog blog1 = new Blog("quan","son", NFT1, tags, keywords , "12.03.2020",12,20,30);

        ArrayList<String> hastag = new ArrayList<>();
        hastag.add("new");
        hastag.add("great");
        Tweet tweet1 =new Tweet("quanNFT", "duc", NFT2, hastag,"20.10.2018", 30, 12, 33);


        System.out.println(blog1.toString());
    }
}

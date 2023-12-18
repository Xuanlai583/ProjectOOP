package nft.data.posts;

import nft.data.NFTToken;

import java.util.ArrayList;

public class Blog extends Post {
    private ArrayList<String> Keywords = new ArrayList<>();

//    getter
    public ArrayList<String> getKeywords() {
        return Keywords;
    }

    //    Constructor
    public Blog(String title, String author, NFTToken NFTtoken, ArrayList<String> hastags, ArrayList<String> keywords, String writingDate, int reactNumbers, int shareNumbers, int commentNumbers) {
        super(title, author, NFTtoken, hastags, writingDate, reactNumbers, shareNumbers, commentNumbers);
        this.Keywords=keywords;
    }

//    Method

    @Override
    public String toString() {
        return "Blog{" + '\n' +
                "Title: " + this.getTitle() + '\n' +
                "Author: " + this.getAuthor() + '\n' +
                this.getNFTtoken() + '\n' +
                "WritingDate: " + this.getWritingDate() + '\n' +
                "ReactNumbers: " + this.getReactNumbers() + '\n' +
                "ShareNumbers: " + this.getShareNumbers() + '\n' +
                "CommentNumbers: " + this.getCommentNumbers() + '\n' +
                "Tags: " + this.getHastags() + '\n' +
                "Keywords: " + Keywords + '\n' +
                '}';
    }
}

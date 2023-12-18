package nft.data.posts;

import nft.data.NFTToken;

import java.util.ArrayList;

public class Tweet extends Post {

    public Tweet(String title, String author, NFTToken NFTtoken, ArrayList<String> hastag, String writingDate, int reactNumbers, int shareNumbers, int commentNumbers) {
        super(title, author, NFTtoken, hastag, writingDate, reactNumbers, shareNumbers, commentNumbers);
    }

    @Override
    public String toString() {
        return "Tweet{" + '\n' +
                "Title: " + this.getTitle() + '\n' +
                "Author: " + this.getAuthor() + '\n' +
                this.getNFTtoken() + '\n' +
                "WritingDate: " + this.getWritingDate() + '\n' +
                "ReactNumbers: " + this.getReactNumbers() + '\n' +
                "ShareNumbers: " + this.getShareNumbers() + '\n' +
                "CommentNumbers: " + this.getCommentNumbers() + '\n' +
                "Hastag: " + this.getHastags() + '\n' +
                '}';
    }
}

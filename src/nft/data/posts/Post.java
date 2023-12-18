package nft.data.posts;

import nft.data.NFTToken;

import java.util.ArrayList;

public class Post {
    private String Title;
    private String Author;
    private ArrayList<String> Hastags = new ArrayList<>();
    private NFTToken NFTtoken;
    private String WritingDate;
    private int ReactNumbers;
    private int ShareNumbers;
    private int CommentNumbers;

//  getter

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public ArrayList<String> getHastags() {
        return Hastags;
    }

    public NFTToken getNFTtoken() {
        return NFTtoken;
    }

    public String getWritingDate() {
        return WritingDate;
    }

    public int getReactNumbers() {
        return ReactNumbers;
    }

    public int getShareNumbers() {
        return ShareNumbers;
    }

    public int getCommentNumbers() {
        return CommentNumbers;
    }

//  constructor

    public Post(String title, String author, NFTToken NFTtoken, ArrayList<String> hastags, String writingDate, int reactNumbers, int shareNumbers, int commentNumbers) {
        Title = title;
        Author = author;
        this.NFTtoken = NFTtoken;
        Hastags = hastags;
        WritingDate = writingDate;
        ReactNumbers = reactNumbers;
        ShareNumbers = shareNumbers;
        CommentNumbers = commentNumbers;
    }

//    method

    @Override
    public String toString() {
        return "Post{" +
                "Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", NFTtoken=" + NFTtoken +
                ", WritingDate='" + WritingDate + '\'' +
                ", ReactNumbers=" + ReactNumbers +
                ", ShareNumbers=" + ShareNumbers +
                ", CommentNumbers=" + CommentNumbers +
                '}';
    }
}

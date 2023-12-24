package dataNFT.DataStorage.posts;

public class Post {
    private String author;
    private String date;
    private String hashtag;

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getHashtag() {
        return hashtag;
    }
    public Post(String author, String date, String hashtag) {
        this.author = author;
        this.date = date;
        this.hashtag = hashtag;
    }

    @Override
    public String toString() {
        return "Post{" + '\n'+
                "Author: " + this.getAuthor() + '\n' +
                "Date: " + this.getDate() + '\n' +
                "Hashtag: " + this.getHashtag() + '\n' +
                '}';
    }
}

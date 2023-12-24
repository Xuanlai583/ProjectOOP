package nftdata.datastorage.posts;

public class Cointelegraph extends Blog{
    private String view;

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Cointelegraph(String author, String date, String hashtag, String title, String view) {
        super(author, date, hashtag, title);
        this.view = view;
    }

    @Override
    public String toString() {
        return "Cointelegraph{" + '\n' +
                "Title: " + this.getTitle() + '\n' +
                "Author: " + this.getAuthor() + '\n' +
                "Date: " + this.getDate() +'\n' +
                "View: " + this.getView() + '\n' +
                "Hashtag: " + this.getHashtag() + '\n' +
                '}';
    }
}

package nft.data;
public class NFTToken {
    private static String NFTName;
    private static String Publisher;
    private static String ReleaseDate;
    private static double Price;
    private static String Category;
    private static boolean Trend;

//    getter

    public String getNFTName() {
        return NFTName;
    }

    public String getPublisher() {
        return Publisher;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public double getPrice() {
        return Price;
    }

    public String getCategory() {
        return Category;
    }

    public boolean isTrend() {
        return Trend;
    }

//    setter

    public void setNFTName(String NFTName) {
        this.NFTName = NFTName;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setTrend(boolean trend) {
        Trend = trend;
    }

//  constructor

    public NFTToken(String NFTName, String publisher, String releaseDate, double price, String category, boolean trend) {
        this.NFTName = NFTName;
        Publisher = publisher;
        ReleaseDate = releaseDate;
        Price = price;
        Category = category;
        Trend = trend;
    }

//    method
    @Override
    public String toString() {
        return "NFTToken{ " +
                "NFTName: " + NFTName +
                ", Publisher: " + Publisher +
                ", ReleaseDate: " + ReleaseDate +
                ", Price: " + Price +
                ", Category: " + Category +
                ", Trend: " + Trend +
                '}';
    }
}

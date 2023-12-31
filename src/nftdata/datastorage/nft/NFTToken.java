package nftdata.datastorage.nft;

public class NFTToken {
    private String collection;
    private String rank;
    private String price;

    public String getCollection() {
        return collection;
    }

    public String getRank() {
        return rank;
    }

    public String getPrice() {
        return price;
    }


    public NFTToken(String collection, String rank, String price) {
        this.collection = collection;
        this.rank = rank;
        this.price = price;
    }

//    @Override
//    public String toString() {
//        return "NFTToken{" + '\n'+
//                "Rank: " + this.getRank() + '\n' +
//                "Collection: " + this.getCollection() + '\n' +
//                "Price: " + this.getPrice() + '\n' +
//                '}';
//    }
}

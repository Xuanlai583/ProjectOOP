package nftdata.datastorage.nft;

public class OpenseaNFT extends  NFTToken{
    private String volume;
    private String change;
    private String sale;

    public String getVolume() {
        return volume;
    }

    public String getChange() {
        return change;
    }

    public String getSale() {
        return sale;
    }

    public OpenseaNFT(String collection, String rank, String price, String volume, String change, String sale) {
        super(collection, rank, price);
        this.volume = volume;
        this.change = change;
        this.sale = sale;
    }

//    @Override
//    public String toString() {
//        return "OpenseaNFT{" +'\n' +
//                "Rank: " + this.getRank() + '\n' +
//                "Collection: " + this.getCollection() + '\n' +
//                "Volume: " + this.getVolume() + '\n' +
//                "Change: " + this.getChange() + '\n' +
//                "Price: " + this.getPrice() + '\n' +
//                "Sale: " + this.getSale() + '\n' +
//                '}';
//    }
}

package nftdata.datastorage.nft;

import java.util.Comparator;

public class NFTTokenComparator{
    public static class RankSalesOwnersItemsComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
        }
    }
}

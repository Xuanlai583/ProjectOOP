package nft.data.database;

import nft.data.NFTToken;
import nft.data.posts.Post;

import static nft.data.database.Database.NFTDatabase;
import static nft.data.database.Database.PostDatabase;

public class SearchEngine {

//    SearchNFT
    public void SearchNFTByName(String name){
        for(NFTToken NFTtoken : NFTDatabase){
            if(NFTtoken.getNFTName().equals(name)){
                System.out.println(NFTtoken.toString());
            }
            else return;
        }
    }

    public void SearchNFTByPublisher(String publisher){
        for (NFTToken NFTtoken : NFTDatabase){
            if (NFTtoken.getPublisher().equals(publisher)){
                System.out.println(NFTtoken.toString());
            }
            else return;
        }
    }

    public void SearchNFTByCategory(String category){
        for (NFTToken NFTtoken : NFTDatabase){
            if (NFTtoken.getCategory().equals(category)){
                System.out.println(NFTtoken.toString());
            }
            else return;
        }
    }

//      Search posts
    public void SearchPostsByTitle(String postTitle){
        for (Post post : PostDatabase){
            if (post.getTitle().equals(postTitle)){
                System.out.println(post.toString());
            }
            else return;
        }
    }

    public void SearchPostByNFTName(String NFTname){
        for (Post post : PostDatabase){
            if (post.getNFTtoken().getNFTName().equals(NFTname)){
                System.out.println(post.toString());
            }
            else return;
        }
    }

    public void SearchPostByHastag(String hastag){
        for (Post post : PostDatabase){
            if (post.getHastags().contains(hastag)){
                System.out.println(post.toString());
            }
            else return;
        }
    }

    public void SearchPostByAuthor(String author){
        for (Post post: PostDatabase){
            if (post.getAuthor().equals(author)){
                System.out.println(post.toString());
            }
            else return;
        }
    }
    
}

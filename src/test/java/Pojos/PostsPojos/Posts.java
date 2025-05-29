package Pojos.PostsPojos;

import java.util.List;

public class Posts {
    /*
     {
            "id": 1,
            "title": "His mother had always taught him",
            "body": "His mother had always taught him not to ever think of himself as better than others. He'd tried to live by this motto. He never looked down on those who were less fortunate or who had less money than him. But the stupidity of the group of people he was talking to made him change his mind.",
            "tags": [
                "history",
                "american",
                "crime"
            ],
            "reactions": {
                "likes": 192,
                "dislikes": 25
            },
            "views": 305,
            "userId": 121
        }
        "total": 251,
    "skip": 0,
    "limit": 30
     */
    private List<Post> posts;
    private int total;
    private int skip;
    private int limit;

    public Posts(){
        //empty constructor;
    }

    public Posts(List<Post> posts, int total, int skip , int limit){
        this.posts = posts;
        this.total = total;
        this.skip = skip;
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

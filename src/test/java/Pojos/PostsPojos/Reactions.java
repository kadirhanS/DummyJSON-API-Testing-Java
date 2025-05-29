package Pojos.PostsPojos;

public class Reactions {
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
     */
    private int likes;
    private int dislikes;

    public Reactions(){
        //empty constructor
    }

    public Reactions(int likes, int dislikes){
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
}

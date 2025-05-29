package Pojos.PostsPojos;

import java.util.List;

public class Post {
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
    private int id;
    private String title;
    private String body;
    private List<String> tags;
    private Reactions reactions;
    private int views;
    private int userId;

    public Post(){
        //empty constructor
    }

    public Post (int id, String title, String body, List<String> tags, Reactions reactions, int views, int userId){
        this.id = id;
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.reactions = reactions;
        this.views = views;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Reactions getReactions() {
        return reactions;
    }

    public void setReactions(Reactions reactions) {
        this.reactions = reactions;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

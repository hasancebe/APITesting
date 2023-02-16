package Day_03.pojo;

public class JsonPlaceHolderPojo {
  /*
    "userId": 1,
            "id": 2,
            "title": "Team104",
            "completed": false
            */
   private int userId;
   private int id;
   private String title;
   private  boolean completed;

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    public JsonPlaceHolderPojo(){
}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    JsonPlaceHolderPojo(int id, int userId, String title, boolean completed){
       this.id=id;
       this.userId=userId;
       this.title=title;
       this.completed=completed;
}
}

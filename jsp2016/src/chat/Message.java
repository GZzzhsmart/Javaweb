package chat;

import java.util.Date;
public class Message {
	private int id;             //留言id  
    private String message;     //留言信息  
    private String author;      //留言作者  
    private Date postTime;      //留言时间  
      
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public String getMessage() {  
        return message;  
    }  
    public void setMessage(String message) {  
        this.message = message;  
    }  
    public String getAuthor() {  
        return author;  
    }  
    public void setAuthor(String author) {  
        this.author = author;  
    }  
    public Date getPostTime() {  
        return postTime;  
    }  
    public void setPostTime(Date postTime) {  
        this.postTime = postTime;  
    }  
}

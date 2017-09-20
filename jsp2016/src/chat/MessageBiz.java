package chat;
import java.util.*;  
public class MessageBiz {  
    //保存一条信息
    public void saveMessage(Message message){  
        MessageDao messageDao=new MessageDao();  
        messageDao.save(message);  
    }  
    //根据页码来查询数据
    public List<Message> listByPage(int pageSize,int pageNum){  
        MessageDao messageDao=new MessageDao();  
        return messageDao.listByPage(pageSize,pageNum);  
    }  
      
   //返回查询到的记录的总条数
    public int getAllUserCount(){  
        MessageDao messageDao=new MessageDao();  
        return messageDao.getAllUserCount();  
    }  
}

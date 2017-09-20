package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
	
	 private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	    private String url="jdbc:sqlserver://localhost:1433;DataBaseName=t7";  
	    private String name="sa";  
	    private String password="123456";  
	    //保存一条记录
	    public int save(Message message){  
	        int line=0;             //保存记录的行数  
	        Connection con=null;  
	        PreparedStatement pstat=null;  
	        try{  
	            con=getConn();  
	            pstat=con.prepareStatement("insert into TBL_MESSAGE(message,author,postTime) values(?,?,getdate())");  
	            pstat.setString(1,message.getMessage());  
	            pstat.setString(2,message.getAuthor());  
	            line=pstat.executeUpdate();  
	              
	        }catch(SQLException e){  
	            e.printStackTrace();  
	        }finally{  
	            closeAll(null,pstat,con);  
	        }  
	        return line;  
	    }  
	      
	    /** 
	     * 分页显示信息 
	     * @param pageSize 每页显示的信息数量 
	     * @param pageNum  定位到那一页 
	     * @return 
	     */  
	    public List<Message> listByPage(int pageSize,int pageNum){  
	        Connection con=null;  
	        PreparedStatement pstat=null;  
	        ResultSet res=null;  
	        List<Message> list=new ArrayList<Message>();  
	        try{  
	            con=getConn();  
	            pstat=con.prepareStatement("select top "+pageSize+" * from TBL_MESSAGE where id not in (select top "+pageSize*(pageNum-1)+" id from TBL_MESSAGE order by postTime) order by postTime");  
	            res=pstat.executeQuery();  
	            while(res.next()){  
	                Message message=new Message();  
	                message.setId(res.getInt(1));  
	                message.setMessage(res.getString(2));  
	                message.setAuthor(res.getString(3));  
	                message.setPostTime(res.getDate(4));  
	                list.add(message);  
	            }  
	        }catch(SQLException e){  
	            e.printStackTrace();  
	        }finally{  
	            closeAll(res,pstat,con);  
	        }  
	        return list;  
	    }  
	      
	    /** 
	     * 获得记录的总条数 
	     * @return  返回查询到的所有记录的总条数 
	     */  
	    public int getAllUserCount(){  
	        Connection con=null;  
	        PreparedStatement pstat=null;  
	        ResultSet res=null;  
	        int ret = 0;  
	        try{  
	            con=getConn();  
	            pstat=con.prepareStatement("select count(*) from TBL_MESSAGE");  
	            res=pstat.executeQuery();  
	            if(res.next()){  
	                ret=res.getInt(1);  
	            }  
	        }catch(SQLException e){  
	            e.printStackTrace();  
	        }finally{  
	            closeAll(res,pstat,con);  
	        }  
	        return ret;  
	    }  
	   
	    /** 
	     * 连接数据库 
	     */  
	    public Connection getConn(){  
	        Connection con=null;  
	        try{  
	            Class.forName(driver);  
	            con=DriverManager.getConnection(url,name,password);  
	        }catch(ClassNotFoundException e){  
	            e.printStackTrace();  
	        }catch(SQLException e){  
	            e.printStackTrace();  
	        }  
	        return con;  
	    }  
	      
	      
	      
	    /** 
	     * 关闭数据库连接，而且三者是有顺序的，先关闭ResultSet连接，接着关闭Statement连接，最后关闭Connection连接 
	     * 并且还要抛出异常。数据库连接使用完毕以后需要关闭连接的，否则，连接数据库的“通道”就会继续增加，而数据库的连接 
	     * 能力也是有限的，大约是200个，因此需要在使用完数据库后将连接关闭掉。 
	     * @param res 
	     * @param stat 
	     * @param conn 
	     */  
	    public void closeAll(ResultSet res,PreparedStatement pstat,Connection con){  
	        try{  
	            if(res!=null){  
	                res.close();  
	                res=null;  
	            }  
	            if(pstat!=null){  
	                pstat.close();  
	                pstat=null;  
	            }  
	            if(con!=null){  
	                con.close();  
	            }  
	        }catch(SQLException e){  
	            e.printStackTrace();  
	        }  
	      
	    }  
	      
}

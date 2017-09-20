package T8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import T8.DBConn;

import T8.TushuVo;

public class BookImaple implements BookJiekou{
	//添加书籍
	public void TushuAdd(TushuVo bookid) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="insert into book values('"+bookid.getBookzuozhe()+"','"+bookid.getBiaoti()
			+"','"+bookid.getChuban()+"','"+bookid.getShijian()+"',"+bookid.getJiage()+")";
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//删除书籍
	public void TushuDel(int bookid) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="delete book where bookid="+bookid;
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
    //修改书籍
	public void TushuUpdate(TushuVo bookid) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn .createStatement();
			String sql="update book set bookzuozhe='"+bookid.getBookzuozhe()+"',biaoti='"+bookid.getBiaoti()
			+"',chuban='"+bookid.getChuban()+"',shijian='"+bookid.getShijian()+"',jiage="+bookid.getJiage()+"  where bookid="+bookid.getBookid();
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//查询所有的书籍
	public List<TushuVo> tushuList() {
		Connection conn=DBConn.openDB();
		List<TushuVo> list=new ArrayList<TushuVo>();
		try {
			Statement stm=conn.createStatement();
			String sql="select * from book;";
			ResultSet cc=stm.executeQuery(sql);
			while(cc.next()){
				TushuVo ff=new TushuVo();
				ff.setBookid(cc.getInt("bookid"));
				ff.setBookzuozhe(cc.getString("bookzuozhe"));
				ff.setBiaoti(cc.getString("biaoti"));
				ff.setChuban(cc.getString("chuban"));
				ff.setShijian(cc.getString("shijian"));
				ff.setJiage(cc.getFloat("jiage"));
				list.add(ff);
			}
			cc.close();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//查找书籍
	public TushuVo findBook(String bookId) {
		Connection conn=DBConn.openDB();
		TushuVo bok=new TushuVo();
		try {
			Statement stm=conn.createStatement();
			String sql="select * from book where bookid="+bookId;
			ResultSet dc=stm.executeQuery(sql);
			if(dc.next()){
				bok.setBookid(dc.getInt(1));
				bok.setBookzuozhe(dc.getString(2));
				bok.setBiaoti(dc.getString(3));
				bok.setChuban(dc.getString(4));
				bok.setShijian(dc.getString(5));
				bok.setJiage(dc.getFloat(6));
			}
			dc.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bok;
	}
	//分页
	public int getBookCount() {
		String sql = "select count(*) cnt from book";
		Connection conn = DBConn.openDB();
		int cnt =0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	//查询所有书籍的资料
	public List<TushuVo> tushuList(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<TushuVo> list = new ArrayList<TushuVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from book where bookid not in(select top "+startPos+" bookid from book)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TushuVo book = new TushuVo();
				book.setBookid(rs.getInt("bookid"));
				book.setBookzuozhe(rs.getString("bookzuozhe").trim());
				book.setBiaoti(rs.getString("biaoti").trim());
				book.setChuban(rs.getString("chuban").trim());
				book.setShijian(rs.getString("shijian").trim());
				book.setJiage(rs.getInt("jiage"));
				list.add(book);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

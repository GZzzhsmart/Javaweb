package T8;

import java.util.List;

import T8.TushuVo;
public interface BookJiekou {
	
	public abstract void TushuAdd(TushuVo bookid );
	public abstract void TushuDel(int bookid);
	public abstract void TushuUpdate(TushuVo bookid);
	public abstract List<TushuVo> tushuList();
	
	TushuVo  findBook(String bookId);
	
	//·ÖÒ³
	public abstract int getBookCount();
	public abstract List<TushuVo> tushuList(int pageSize,int startPos);
	
}

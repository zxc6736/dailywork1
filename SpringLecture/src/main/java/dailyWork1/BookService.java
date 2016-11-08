package dailyWork1;

import java.util.ArrayList;

public class BookService {

	private BookDAO dao;
	private String keyword;
	
	
	public BookService(){
		
	}
	
	public BookService(BookDAO dao){
		this.dao = dao;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public BookDAO getDao() {
		return dao;
	}

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}

	public ArrayList<BookEntity> getListByKeyword() {
			
		//DAO 생성
		//DAO method 호출 => 결과 받아서 return
		
		return dao.selectAll(keyword);
		
	}

	public ArrayList<BookEntity> getCommentList(String bisbn) {
		return dao.selectComment(bisbn);
	}

}

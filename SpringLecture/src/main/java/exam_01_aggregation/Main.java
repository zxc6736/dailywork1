package exam_01_aggregation;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		//입력받고
		Scanner s = new Scanner(System.in);
		System.out.println("검색할 키워드: ");
		String keyword = s.nextLine();
		
		System.out.println("입력된 값은 :  "+keyword);
		
		//로직처리하고
		//로직처리를 위한 service객체를 생성
		//나중에 db처리를 위해서 dao객체를 생성
		BookDAO dao = new BookDAO();
		
		Bookservice service = new Bookservice(dao);
		
		//서비스를 이용해서 Business Logic을 수행
		ArrayList<BookEntity> list = service.getListByKeyword(keyword);
		
		//출력처리
		for(BookEntity entity:list){
			System.out.println(entity.getBtitle()+":"+entity.getBauthor());
			
			
		}
		s.close();
	}

}

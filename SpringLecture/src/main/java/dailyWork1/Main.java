package dailyWork1;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//입력받은 keyword를 이용해서 책의 제목과 저자를 출력하는데 만약 comment가 존재하면 같이 출력할 꺼예요
		
		System.out.println("keyword를 입력하세요 ==>");
		//Scanner s = new Scanner(System.in);
		//String keyword = s.nextLine();//nextLine 공백포함해서 한줄을 표준입력으로 부터 받아요
		
		//config 파일에 대한 경로를 문자열로 저장
		String config = "classpath:applicationCtx.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		BookService service = ctx.getBean("bookService", BookService.class);
	
		ArrayList<BookEntity> list = service.getListByKeyword();
		
		for(BookEntity entity:list){
			System.out.println(entity.getBtitle()+":"+entity.getBauthor());
			
			ArrayList<BookEntity> list2 = service.getCommentList(entity.getBisbn());
			for(int i=0; i<list2.size();i++){
				System.out.println("==> " + list2.get(i).getCtext());
			}

		}
		ctx.close();
		//s.close();
	}

}

package day20_DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBClass {
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	private String id = "eun";
	private String pwd = "asd";
	
	
	public DBClass() {
		// 1. 자바에서 오라클에 관련된 기능을 사용할 수 있게 라이브러리 기능을 등록하는것
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection(null);//객체
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void getList() {
		// 2. 데베연결
		try {
	Connection con = DriverManager.getConnection(url,id,pwd);
	System.out.println("연결이 잘 이뤄졌습니다");
		// 3. 데베 연결된 객체 이용해서 명령어를 수행할 수 잇는 객체를 얻어온다
		// 4. 명령어를 수행할 수 있는 객체를 이용해서 명령어 수행
		// 5. 수행 결과를 저장한다
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}

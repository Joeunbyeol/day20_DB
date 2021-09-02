package day20_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBClass {
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	private String id = "eun";
	private String pwd = "asd";

	public DBClass() {
		// 1. 자바에서 오라클에 관련된 기능을 사용할 수 있게 라이브러리 기능을 등록하는것
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<StudentDTO> getList() {
		ArrayList<StudentDTO> arr = new ArrayList<StudentDTO>();

		// 2. 데베연결
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결이 잘 이뤄졌습니다\n");

			// 3. 데베 연결된 객체 이용해서 명령어를 수행할 수 잇는 객체를 얻어온다
			String sql = "select * from newst";
			PreparedStatement ps = con.prepareStatement(sql);

			// 4. 명령어를 수행할 수 있는 객체를 이용해서 명령어 수행
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				/*
				 * System.out.println("id = "+rs.getString("id"));
				 * System.out.println("name = "+rs.getString("name"));
				 * System.out.println("age = "+rs.getInt("age"));
				 * System.out.println("------------------------------");
				 */
				StudentDTO dto = new StudentDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				arr.add(dto);
			}
			// 5. 수행 결과를 저장한다

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	public StudentDTO searchST(String id) {
		//select * from newst where id = '222';
		String sql = "select * from newst where id = '" +id+ "'";
		StudentDTO dto =null;
		
		try {//1.디비연결
			Connection con = DriverManager.getConnection(url,this.id,pwd);
			System.out.println("연결확인");
			//2.명령어(전송)객체생성
			PreparedStatement ps =con.prepareStatement(sql);
			//3.전송 후 결과값 저장
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) { //데이터가 있으면 저장하라
				dto = new StudentDTO();
				dto.setId(rs.getString("id"));
				dto.setId(rs.getString("name"));
				dto.setId(rs.getString("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
}

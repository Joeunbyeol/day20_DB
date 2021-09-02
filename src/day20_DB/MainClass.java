package day20_DB;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num, age;
		String id, name;
		ArrayList<StudentDTO> arr = null;
		DBClass db = new DBClass();

		while (true) {
			System.out.println("1.모든 데이터 보기 2.검색 3.저장 4.삭제 5.수정");
			num = input.nextInt();
			switch (num) {
			case 1:
				arr = db.getList();
				// 데이터베이스의 모든 데이터를 가져와서 보여준다
				for (int i = 0; i < arr.size(); i++) {
					System.out.println("id = " + arr.get(i).getId());
					System.out.println("name = " + arr.get(i).getName());
					System.out.println("age = " + arr.get(i).getAge());
					System.out.println("-------------");
				}
				break;
			case 2:

				// 검색 데이터를 데베에서 가져오기ㅇ
				System.out.print("검색id입력 : ");
				id = input.next();
			
				StudentDTO dto = db.searchST(id);
				if(dto != null) {
				System.out.println("id = " + dto.getId());
				System.out.println("name = " + dto.getName());
				System.out.println("age = " + dto.getAge());
				}else {
					System.out.println("해당 아이디는 존재하지 않습니다");
				}
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}

	}
}

package cheerup;

import java.util.Scanner;

import cheerup.Member;
import cheerup.MemberDAO;

public class Main {

	public static void main(String[] args) {
		System.out.println("1.가입 2.조회 ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if(choice == 1) {
			System.out.println("이름");
			String name = sc.next();
			System.out.println("나이");
			int age = sc.nextInt();
			System.out.println("전화번호");
			String tel = sc.next();
			System.out.println("고객번호");
			String memnum = sc.next();
			Member mem = new Member(name,age,tel,memnum);
			MemberDAO dao = new MemberDAO();
			dao.insert(mem);
			
		}else if(choice == 2) {
			System.out.println("고객번호");
			String memnum = sc.next();
			MemberDAO dao = new MemberDAO();
			Member n = dao.selectOne(memnum);
			System.out.println("이름/나이/전화번호/고객번호");
			System.out.println(n.getName()+"/"+n.getAge()+"/"+n.getTel()+"/"+n.getMemnum());
			
			
		}
				

	}

}

package cheerup;

import java.util.Scanner;

import cheerup.Member;
import cheerup.MemberDAO;

public class Main {

	public static void main(String[] args) {
		System.out.println("1.���� 2.��ȸ ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if(choice == 1) {
			System.out.println("�̸�");
			String name = sc.next();
			System.out.println("����");
			int age = sc.nextInt();
			System.out.println("��ȭ��ȣ");
			String tel = sc.next();
			System.out.println("����ȣ");
			String memnum = sc.next();
			Member mem = new Member(name,age,tel,memnum);
			MemberDAO dao = new MemberDAO();
			dao.insert(mem);
			
		}else if(choice == 2) {
			System.out.println("����ȣ");
			String memnum = sc.next();
			MemberDAO dao = new MemberDAO();
			Member n = dao.selectOne(memnum);
			System.out.println("�̸�/����/��ȭ��ȣ/����ȣ");
			System.out.println(n.getName()+"/"+n.getAge()+"/"+n.getTel()+"/"+n.getMemnum());
			
			
		}
				

	}

}

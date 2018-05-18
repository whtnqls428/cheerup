package cheerup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	public void insert(Member mem) {
		// JDBC ����ϱ�
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password="1234";
		Connection con = null;		
		PreparedStatement psmt = null;
		
		try {  //���� �� ������ �� �� �ִ� ����
			// 1. ����̹� �ε� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽��� �����Ͽ� Connection ��ü ���
			con = DriverManager.getConnection(url, user, password);
			// 3. SQL ���� �غ��ϱ�
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,mem.getName());
			psmt.setInt(2, mem.getAge()); 
			psmt.setString(3,mem.getTel());
			psmt.setString(4, mem.getMemnum());
			//4. �����ϱ�
			int num = psmt.executeUpdate();
			System.out.println(num);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Ŭ������ ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL ������ ������ �߻�");
			e.printStackTrace();
		}finally {
			//5. ���� ����
			try {
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public Member selectOne(String memnum) {
		// JDBC ����ϱ�
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String password="1234";
		Connection con = null;		
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Member m = null;
		try {  //���� �� ������ �� �� �ִ� ����
			// 1. ����̹� �ε� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽��� �����Ͽ� Connection ��ü ���
			con = DriverManager.getConnection(url, user, password);
			// 3. SQL ���� �غ��ϱ�
			String sql = "SELECT * FROM MEMBER  WHERE MEMNUM = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, memnum);
		
			//4. �����ϱ�
			rs = psmt.executeQuery();
						
			//5. ResultSet ��ü���� ������ ������
			rs.next();
				String name = rs.getString(1);
				int age = rs.getInt(2);
				String tel = rs.getString(3);
				String memnum2 = rs.getString(4);
				 m = new Member(name, age, tel, memnum2);
				
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Ŭ������ ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL ������ ������ �߻�");
			e.printStackTrace();
		}finally {
			//5. ���� ����
			try {
				if(rs != null) rs.close();
				psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return m;
	}

}

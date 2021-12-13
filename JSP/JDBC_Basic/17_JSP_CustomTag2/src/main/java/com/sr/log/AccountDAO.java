package com.sr.log;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.digester.CallParamRule;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sr.log.Account;
import com.sr.log.DBManager;

public class AccountDAO {

	public static void loginCheck(HttpServletRequest request) {

		// hs
		HttpSession hs = request.getSession();
		Account a = (Account) hs.getAttribute("accountInfo");

		if (a == null) {
			// �α��� ����
			request.setAttribute("loginPage", "login.jsp");
		} else {
			// �α��� ����
			request.setAttribute("loginPage", "loginOK.jsp");
		}

	}

	public static void login(HttpServletRequest request) {

		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");

		// 2. DB�� �� ( ���� ������ �ȵ� ) - �������� ó��
		// crud - r(select)

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from account_1 where a_id = ?";

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// ���̵� ������ pw�˻�
				String dbPW = rs.getString("a_pw");

				if (userPw.equals(dbPW)) {

					// ���� �������ϱ� ���ļ�
					Account a = new Account();
					a.setName(rs.getString("a_name"));
					a.setId(rs.getString("a_id"));
					a.setPw(rs.getString("a_pw"));
					a.setGender(rs.getString("a_gender"));
					a.setAddr(rs.getString("a_addr"));
					a.setInterest(rs.getString("a_interest"));
					a.setIntroduce(rs.getString("a_introduce"));
					a.setImg(rs.getString("a_img"));

					HttpSession hs = request.getSession();
					hs.setAttribute("accountInfo", a);
					hs.setMaxInactiveInterval(10);

					// request.setAttribute("a", a);

					request.setAttribute("r", "�α��� ����!");
				} else {
					request.setAttribute("r", "��й�ȣ ����!");
				}
			} else {
				request.setAttribute("r", "�������� �ʴ� ȸ�� �Դϴ�.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void logOut(HttpServletRequest request) {

		// �α׾ƿ� �ϴ� ��
		// ������ ������.
		// ���ʿ� ����������� ������, ������ �ð��� ����Ǿ��� ��
		HttpSession hs = request.getSession();
		hs.setAttribute("accountInfo", null);

	}

	public static void reg(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into account_1 values (?,?,?,?,?,?,?,?)";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String path = request.getSession().getServletContext().getRealPath("file");
			System.out.println(path);
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1021 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			String name = mr.getParameter("name");
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String gender = mr.getParameter("gender");
			String addr = mr.getParameter("addr");
			String[] interest = mr.getParameterValues("interest"); // �迭
			String introduce = mr.getParameter("textArea");
			String img = mr.getFilesystemName("img");
			String interest2 = "";

			if (interest != null) {
				for (String s : interest) {
					interest2 += s + "!";
				}
			} else {
				interest2 = "���ɻ� ����";
			}
			if (introduce.length() == 0) {
				introduce = "...";
			}

			System.out.println(name);
			System.out.println(id);
			System.out.println(pw);
			System.out.println(gender);
			System.out.println(addr);
			System.out.println(interest); // �迭
			System.out.println(interest2);
			System.out.println(introduce);
			System.out.println(img);

			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, gender);
			pstmt.setString(5, addr);
			pstmt.setString(6, interest2);
			pstmt.setString(7, introduce);
			pstmt.setString(8, img);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("��� ����!");
			} else {
				System.out.println("��� ����...");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB ���� ����...");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void updateAccount(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "update account_1 set a_name=?,a_pw=?,a_addr=?,a_interest=?,a_introduce=?,a_img=? where a_id=?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String path = request.getSession().getServletContext().getRealPath("file");
			System.out.println(path);
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1021 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			String name = mr.getParameter("name");
			String pw = mr.getParameter("pw");
			String pw2 = mr.getParameter("pw2");
			String addr = mr.getParameter("addr"); // ���, �����̶��� �ٸ��� ����:���ο ������ �۾�x
			String interest = mr.getParameter("interest"); // exer!food!
			String[] interest2 = mr.getParameterValues("interest2"); // ���ɻ� �ٽ� ������
			String introduce = mr.getParameter("textArea");
			String oldFile = mr.getParameter("img"); // **.jpg
			String newFile = mr.getFilesystemName("img2"); // ������ ���� �߰���(���� �Ϸ���)
			
			String interest3 = "";

			if (interest2 != null) {
				for (String s : interest2) {
					interest3 += s + "!";
				}
			} else {
				interest3 = "���ɻ� ����";
			}
			if (introduce.length() == 0) {
				introduce = "...";
			}

			System.out.println(name);
			System.out.println(pw);
			System.out.println(pw2);
			System.out.println(addr);
			System.out.println(interest); // �迭
			System.out.println(interest3);
			System.out.println(introduce);
			System.out.println(oldFile);
			System.out.println(newFile);

			pstmt.setString(1, name);
			String pw3 = "";
			if (pw2.length() == 0) {
				pw3 = pw;
			}else {
				pw3 = pw2;
			}
			pstmt.setString(2, pw3);			
			pstmt.setString(3, addr);
			if (interest2 == null) {
				pstmt.setString(4, interest);	// excer!food!
			}else {
				pstmt.setString(4, interest3);	// 4�� ��				
			}
			pstmt.setString(5, introduce);
			if (newFile == null) {
				pstmt.setString(6, oldFile);				
			}else {
				pstmt.setString(6, newFile);		
				String delFile = path + "/" + oldFile;
				File f = new File(delFile);
				f.delete();
			}
			pstmt.setString(7, mr.getParameter("id"));

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "���� ����!");
			} else {
				request.setAttribute("r", "���� ����...");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r","DB ���� ����...");
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	
	public static int makeInterest(HttpServletRequest req) {
		
		Account a = (Account) req.getSession().getAttribute("accountInfo");
		
		// ���ɻ� ������
				if(a != null) {
					String inter = a.getInterest();
					String[] inter2 = inter.split("!");
					req.setAttribute("inter", inter2);
					return 1;
				}
				return 0;
	}
}

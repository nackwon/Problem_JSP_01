package kr.co.jimmy.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.jimmy.VO.InfoVO;
import kr.co.jimmy.connection.ConnectionManager;

public class InfoDAO {

	// �о������ �� �ɰ���
	public InfoVO getInstance(String line) {
		InfoVO vo = new InfoVO();

		vo.setCnumber(Integer.parseInt(line.substring(0, 6)));// 6�ڸ�
		vo.setEmail(line.substring(6, 10).trim());// 4�ڸ�
		vo.setKorean(Integer.parseInt(line.substring(10, 13).trim()));// 3�ڸ�
		vo.setEnglish(Integer.parseInt(line.substring(13, 16).trim()));// 3�ڸ�
		vo.setMath(Integer.parseInt(line.substring(16, 19).trim()));// 3�ڸ�
		vo.setScience(Integer.parseInt(line.substring(19, 22).trim()));// 3�ڸ�
		vo.setHistory(Integer.parseInt(line.substring(22, 25).trim()));// 3�ڸ�
		vo.setScore(Integer.parseInt(line.substring(25, 28).trim()));// 3�ڸ�
		vo.setTcode(line.substring(28, 29));// 1�ڸ�
		vo.setAchievement(line.substring(29, 30));// 1�ڸ�
		vo.setRegioncode(line.substring(30, 31));// 1�ڸ�

		return vo;
	}

	// ���� ���� ����
	public void insertInfo(String path) {

		ConnectionManager mgr = new ConnectionManager(); // ���� Ŭ����
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String line = ""; // ���� ���� �� �б�
		ArrayList<InfoVO> list = new ArrayList<InfoVO>(); // ���� ���� ���� list

		if (con == null) {
			System.out.println("�������");
		}
		try {
			// ���� �б�
			BufferedReader br = new BufferedReader(new FileReader(new File(path)));

			while ((line = br.readLine()) != null) {
				list.add(this.getInstance(line));
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (con == null)
			System.out.println("���� ����");

		// DB �����ϱ� SQL��
		String sql = "INSERT INTO project VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		try {

			pstmt = con.prepareStatement(sql);

			for (InfoVO vo : list) {
				pstmt.setInt(1, vo.getCnumber());
				pstmt.setString(2, vo.getEmail());
				pstmt.setInt(3, vo.getKorean());
				pstmt.setInt(4, vo.getEnglish());
				pstmt.setInt(5, vo.getMath());
				pstmt.setInt(6, vo.getScience());
				pstmt.setInt(7, vo.getHistory());
				pstmt.setInt(8, vo.getScore());
				pstmt.setString(9, vo.getTcode());
				pstmt.setString(10, vo.getAchievement());
				pstmt.setString(11, vo.getRegioncode());
				rs = pstmt.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mgr.connectClose(con, pstmt, rs);// ����
		}
	}
}

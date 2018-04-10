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

	// 읽어들이은 값 쪼개기
	public InfoVO getInstance(String line) {
		InfoVO vo = new InfoVO();

		vo.setCnumber(Integer.parseInt(line.substring(0, 6)));// 6자리
		vo.setEmail(line.substring(6, 10).trim());// 4자리
		vo.setKorean(Integer.parseInt(line.substring(10, 13).trim()));// 3자리
		vo.setEnglish(Integer.parseInt(line.substring(13, 16).trim()));// 3자리
		vo.setMath(Integer.parseInt(line.substring(16, 19).trim()));// 3자리
		vo.setScience(Integer.parseInt(line.substring(19, 22).trim()));// 3자리
		vo.setHistory(Integer.parseInt(line.substring(22, 25).trim()));// 3자리
		vo.setScore(Integer.parseInt(line.substring(25, 28).trim()));// 3자리
		vo.setTcode(line.substring(28, 29));// 1자리
		vo.setAchievement(line.substring(29, 30));// 1자리
		vo.setRegioncode(line.substring(30, 31));// 1자리

		return vo;
	}

	// 파일 정보 삽입
	public void insertInfo(String path) {

		ConnectionManager mgr = new ConnectionManager(); // 연결 클래스
		Connection con = mgr.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String line = ""; // 정보 한줄 씩 읽기
		ArrayList<InfoVO> list = new ArrayList<InfoVO>(); // 읽은 정보 담을 list

		if (con == null) {
			System.out.println("연결실패");
		}
		try {
			// 파일 읽기
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
			System.out.println("연결 실패");

		// DB 저장하기 SQL문
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
			mgr.connectClose(con, pstmt, rs);// 종료
		}
	}
}

package com.diworksdev.webproj3.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.webproj3.dto.HelloStrutsDTO;
import com.diworksdev.webproj3.util.DBConnector;

public class HelloStrutsDAO {
	public HelloStrutsDTO select() {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		HelloStrutsDTO dto=new HelloStrutsDTO();

	String sql="select * from users";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();

		if (rs.next()) {
			dto.setResult("MySQL と接続できます。");
		}else{
			dto.setResult("MySQL と接続できません。");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}

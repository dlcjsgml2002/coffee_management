package coffee_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coffee_management.dto.Sale;
import coffee_management.jdbc.ConnectionProvider;
import coffee_management.jdbc.LogUtil;

public class SaleDaoImpl implements SaleDao {

	@Override
	public List<Sale> selectSaleByAll() {
		List<Sale> list = new ArrayList<>();
		String sql = "select no, code, price, saleCnt, marginRate from sale";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			LogUtil.prnLog(pstmt);
			while (rs.next()) {
				list.add(getSale(rs));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	private Sale getSale(ResultSet rs) throws SQLException {
		int no = rs.getInt("no");
		String code = rs.getString("code");
		int price = rs.getInt("price");
		int saleCnt = rs.getInt("saleCnt");
		int marginRate = rs.getInt("marginRate");
		return new Sale(no, code, price, saleCnt, marginRate);
	}

	@Override
	public int insertSale(Sale sale) throws SQLException {
		return 0;
	}

	@Override
	public int deleteSale(Sale sale) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSale(Sale sale) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sale selectSaleByNo(Sale sale) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

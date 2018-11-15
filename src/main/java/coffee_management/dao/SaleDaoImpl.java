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
		LogUtil.prnLog("insertSale()");
		String sql = "insert into sale values(?, ?, ?, ?, ?)";
		int rowAffected = 0;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, sale.getNo());
			pstmt.setString(2, sale.getCode());
			pstmt.setInt(3, sale.getPrice());
			pstmt.setInt(4, sale.getSaleCnt());
			pstmt.setInt(5, sale.getMarginRate());
			LogUtil.prnLog(pstmt);
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public int deleteSale(Sale sale) throws SQLException {
		LogUtil.prnLog("deleteSale()");
		String sql = "delete from sale where no=?";
		int rowAffected = 0;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, sale.getNo());
			LogUtil.prnLog(pstmt);
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public int updateSale(Sale sale) throws SQLException {
		LogUtil.prnLog("updateSale()");
		String sql = "update sale set code=?, price=?, salecnt=?, marginRate=? where no=?";
		int rowAffected = 0;
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(5, sale.getNo());
			pstmt.setString(1, sale.getCode());
			pstmt.setInt(2, sale.getPrice());
			pstmt.setInt(3, sale.getSaleCnt());
			pstmt.setInt(4, sale.getMarginRate());
			LogUtil.prnLog(pstmt);
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public Sale selectSaleByNo(Sale sale) throws SQLException {
		LogUtil.prnLog("selectSaleByNo()");
		Sale sales = null;
		String sql = "SELECT no, code, price, saleCnt, marginRate from sale where no=?";

		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, sale.getNo());
			LogUtil.prnLog(pstmt);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					sales = getSale(rs);
				}
			}
		}
		return sales;
	}

}

package coffee_management.dao;

import java.sql.SQLException;
import java.util.List;

import coffee_management.dto.Sale;

public interface SaleDao {
	List<Sale> selectSaleByAll();

	int insertSale(Sale sale) throws SQLException;

	int deleteSale(Sale sale) throws SQLException;

	int updateSale(Sale sale) throws SQLException;

	Sale selectSaleByNo(Sale sale) throws SQLException;
}

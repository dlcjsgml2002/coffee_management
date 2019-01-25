package coffee_management.service;

import java.sql.SQLException;
import java.util.List;

import coffee_management.dao.SaleMapper;
import coffee_management.dao.SaleMapperImpl;
import coffee_management.dto.Sale;

public class OutputService {
	private SaleMapper saleDao;

	public OutputService() {
		// TODO Auto-generated constructor stub
		saleDao = new SaleMapperImpl();
	}
	
	public List<Sale> outputOrder(boolean isSale) throws SQLException{
		return saleDao.selectSaleRank(isSale);
	}
	
}

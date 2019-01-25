package coffee_management.service;

import java.sql.SQLException;

import coffee_management.dao.ProductMapper;
import coffee_management.dao.ProductMapperImpl;
import coffee_management.dao.SaleMapper;
import coffee_management.dao.SaleMapperImpl;
import coffee_management.dto.Product;
import coffee_management.dto.Sale;

public class CoffeeManagementService {
	private ProductMapper productDao;
	private SaleMapper saleDao;
	
	public CoffeeManagementService() {
		// TODO Auto-generated constructor stub
		productDao = new ProductMapperImpl();
		saleDao = new SaleMapperImpl();
	}
	
	public int registerSale(Sale sale) throws SQLException{
		return saleDao.insertSale(sale);
	}
	
	public Product searchProduct(Product product) throws SQLException{
		return productDao.selectProductByCode(product);
	}
	
}

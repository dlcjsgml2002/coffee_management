package coffee_management.service;

import java.sql.SQLException;

import coffee_management.dao.ProductDao;
import coffee_management.dao.ProductDaoImpl;
import coffee_management.dao.SaleDao;
import coffee_management.dao.SaleDaoImpl;
import coffee_management.dto.Product;
import coffee_management.dto.Sale;

public class SaleInputService {
	private ProductDao productDao;
	private SaleDao saleDao;
	public SaleInputService() {
		productDao = new ProductDaoImpl();
		saleDao = new SaleDaoImpl();
	}
	
	public Product searchProduct(Product product) throws SQLException {
		return productDao.selectProductByCode(product);
	}
	
	public int registerSale(Sale sale) throws SQLException {
		return saleDao.insertSale(sale);
	}
}

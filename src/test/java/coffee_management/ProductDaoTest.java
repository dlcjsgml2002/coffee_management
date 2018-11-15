package coffee_management;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import coffee_management.dao.ProductDao;
import coffee_management.dao.ProductDaoImpl;
import coffee_management.dto.Product;
import coffee_management.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {
	static ProductDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("START ProductDaoTest");
		dao = new ProductDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("END ProductDaoTest");
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	//select
	@Test
	public void test01selectProductByAll() throws SQLException {
		LogUtil.prnLog("selectProductByAll()");
		List<Product> list = dao.selectProductByAll();
		LogUtil.prnLog(list.toString());
		Assert.assertNotNull(list);
	}

	//제품코드
	@Test
	public void test02selectProductByCode() throws SQLException {
		LogUtil.prnLog("selectProductByCode()");
		Product sPdt = new Product("A001");
		Product searchPdt = dao.selectProductByCode(sPdt);
		LogUtil.prnLog(searchPdt.toString());
		Assert.assertNotNull(searchPdt);
	}
}

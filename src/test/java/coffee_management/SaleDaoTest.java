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

import coffee_management.dao.SaleDao;
import coffee_management.dao.SaleDaoImpl;
import coffee_management.dto.Sale;
import coffee_management.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleDaoTest {
	static SaleDao sao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start SaleDaoTest");
		sao = new SaleDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End SaleDaoTest");
		sao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectByAll() {
		List<Sale> lists = sao.selectSaleByAll();
		LogUtil.prnLog(lists.toString());
		Assert.assertNotNull(lists);
	}

	@Test
	public void test02InsertSale() {
		try {
			Sale newSale = new Sale(5, "A003", 3000, 250, 18);
			int rowAffected = sao.insertSale(newSale);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				LogUtil.prnLog("해당 품목 존재");
			} else {
				LogUtil.prnLog(e);
			}
		}
	}
	
/*	@Test
	public void test04DeleteSale() {
		try {
			Sale delSale = new Sale();
			delSale.setNo(5);
			int rowAffected = sao.deleteSale(delSale);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		} catch (SQLException e) {
			if (e.getErrorCode() == 1451) {
				LogUtil.prnLog("해당 품목이 존재");
			} else {
				LogUtil.prnLog(e);
			}
		}
	}*/
	
	@Test
	public void test03updateSale() {
		try {
			Sale updateSale = new Sale(5, "B003", 1200, 360, 8);
			int rowAffected = sao.updateSale(updateSale);
			LogUtil.prnLog(String.format("rowAffected %d", rowAffected));
			Assert.assertEquals(1, rowAffected);
		} catch (SQLException e) {
			LogUtil.prnLog(e);
		}
	}
	
	@Test
	public void test05SelectSaleByNo() {
		try {
			Sale selsale = new Sale();
			selsale.setNo(1);
			Sale sale = sao.selectSaleByNo(selsale);
			LogUtil.prnLog(String.format("%s - %s", sale.getClass().getSimpleName(), sale));
			Assert.assertNotNull(sale);
		} catch (SQLException e) {
			LogUtil.prnLog(e);
		}
	}

}

package coffee_management.dto;

public class SaleDetail {
	private int supplytax;
	private int addtax;
	private int saleprice;
	private int marginprice;

	public SaleDetail() {
		
	}

	public SaleDetail(int supplytax, int addtax, int saleprice, int marginprice) {
		this.supplytax = supplytax;
		this.addtax = addtax;
		this.saleprice = saleprice;
		this.marginprice = marginprice;
	}

	public int getSupplytax() {
		return supplytax;
	}

	public void setSupplytax(int supplytax) {
		this.supplytax = supplytax;
	}

	public int getAddtax() {
		return addtax;
	}

	public void setAddtax(int addtax) {
		this.addtax = addtax;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public int getMarginprice() {
		return marginprice;
	}

	public void setMarginprice(int marginprice) {
		this.marginprice = marginprice;
	}

	@Override
	public String toString() {
		return String.format("SaleDetail [supplytax=%s, addtax=%s, saleprice=%s, marginprice=%s]", supplytax, addtax,
				saleprice, marginprice);
	}
}

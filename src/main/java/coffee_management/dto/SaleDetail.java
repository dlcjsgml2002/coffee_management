package coffee_management.dto;

public class SaleDetail {
	private int supplyprice;
	private int addtax;
	private int saleprice;
	private int marginprice;
	private int rank;

	public SaleDetail() {

	}

	public SaleDetail(int supplyprice, int addtax, int saleprice, int marginprice, int rank) {
		this.supplyprice = supplyprice;
		this.addtax = addtax;
		this.saleprice = saleprice;
		this.marginprice = marginprice;
		this.rank = rank;
	}

	public SaleDetail(int supplyprice, int addtax, int saleprice, int marginprice) {
		this.supplyprice = supplyprice;
		this.addtax = addtax;
		this.saleprice = saleprice;
		this.marginprice = marginprice;
	}

	public int getSupplyprice() {
		return supplyprice;
	}

	public void setSupplyprice(int supplyprice) {
		this.supplyprice = supplyprice;
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return String.format("SaleDetail [supplyprice=%s, addtax=%s, saleprice=%s, marginprice=%s, rank=%s]", supplyprice,
				addtax, saleprice, marginprice, rank);
	}
}

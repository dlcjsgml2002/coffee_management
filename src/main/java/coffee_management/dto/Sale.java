package coffee_management.dto;

public class Sale {
	private int no;
	private String code;
	private int price;
	private int saleCnt;
	private int marginRate;

	public Sale() {
		
	}

	public Sale(int no) {
		this.no = no;
	}

	public Sale(int no, String code, int price, int saleCnt, int marginRate) {
		this.no = no;
		this.code = code;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleCnt() {
		return saleCnt;
	}

	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}

	public int getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (no != other.no)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s", no, code, price, saleCnt, marginRate);
	}
}

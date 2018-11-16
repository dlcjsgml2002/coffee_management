package coffee_management.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import coffee_management.dto.Sale;
import coffee_management.dto.Product;

public class RankListPanel extends JPanel {
	private JTable table;
	private List<Sale> lists;

	public RankListPanel() {

		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(getDatas(), getColumnNames()));
		scrollPane.setViewportView(table);
	}

	private void setLists(List<Sale> lists) {
		this.lists = lists;
	}

	private Object[][] getDatas() {
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getSaleRow(lists.get(i));
		}
		return datas;
	}

	private Object[] getSaleRow(Sale sale) {
		return new Object[] { sale.getNo(), sale.getCode().getCode(),
				sale.getCode().getName(),
				String.format("%,d", sale.getPrice()),
				String.format("%,d", sale.getSaleCnt()),
				String.format("%,d", sale.getDetail().getSupplytax()),
				String.format("%,d", sale.getDetail().getAddtax()),
				String.format("%,d", sale.getDetail().getSaleprice()), sale.getMarginRate() + "%",
				String.format("%,d", sale.getDetail().getMarginprice()) };
	}

	private String[] getColumnNames() {
		return new String[] { "순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액" };
	}

}

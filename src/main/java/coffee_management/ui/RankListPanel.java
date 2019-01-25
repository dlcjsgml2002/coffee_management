package coffee_management.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import coffee_management.dto.Sale;

public class RankListPanel extends JPanel {
	private JTable table;
	private List<Sale> list;

	public void setList(List<Sale> list) {
		this.list = list;
	}

	public RankListPanel() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
	}

	private void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableCellAlignment(SwingConstants.RIGHT, 3, 4, 5, 6, 7, 8, 9);
		tableSetWidth(100, 100, 200, 150, 100, 200, 200, 200, 100, 150);
	}

	private void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel tcm = table.getColumnModel();

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	private void tableSetWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	public void loadDatas() {
		table.setModel(new DefaultTableModel(getDatas(), getColumnNames()));
		setAlignWidth();
	}

	private Object[][] getDatas() {
		Object[][] datas = new Object[list.size() + 1][];

		for (int i = 0; i < list.size(); i++) {
			datas[i] = getSaleRow(list.get(i));
		}
		datas[list.size()] = getTotal();
		return datas;
	}

	private Object[] getTotal() {
		int totalSupplyTax = 0;
		int totalAddTax = 0;
		int totalSalePrice = 0;
		int totalMarginPrice = 0;

		for (Sale s : list) {
			totalSupplyTax += s.getDetail().getSupplyTax();
			totalAddTax += s.getDetail().getAddTax();
			totalSalePrice += s.getDetail().getSalePrice();
			totalMarginPrice += s.getDetail().getMarginPrice();
		}
		return new Object[] { "합계", "", "", "", "", String.format("%,d", totalSupplyTax),
				String.format("%,d", totalAddTax), String.format("%,d", totalSalePrice), "",
				String.format("%,d", totalMarginPrice) };
	}

	private Object[] getSaleRow(Sale sale) {
		return new Object[] { sale.getDetail().getRank(), sale.getProduct().getCode(), sale.getProduct().getName(),
				String.format("%,d", sale.getPrice()), sale.getSaleCnt(),
				String.format("%,d", sale.getDetail().getSupplyTax()),
				String.format("%,d", sale.getDetail().getAddTax()),
				String.format("%,d", sale.getDetail().getSalePrice()), sale.getMarginRate(),
				String.format("%,d", sale.getDetail().getMarginPrice()) };
	}

	private String[] getColumnNames() {
		return new String[] { "순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액" };
	}
}

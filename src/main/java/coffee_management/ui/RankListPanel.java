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
import coffee_management.jdbc.LogUtil;

public class RankListPanel extends JPanel {
	private JTable table;
	private List<Sale> lists;

	public void setLists(List<Sale> lists) {
		this.lists = lists;
	}

	public RankListPanel() {

		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
	}

	private void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableCellAlignment(SwingConstants.RIGHT, 3, 4, 5, 6, 7, 8, 9);
		tableSetWidth(100, 150, 200, 150, 150, 200, 150, 200, 100, 150);

	}

	// 정렬
	private void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	// 폭
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
		Object[][] datas = new Object[lists.size() + 1][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = getSaleRow(lists.get(i));
		}
		datas[lists.size()] = getTotal();
		return datas;
	}

	private Object[] getSaleRow(Sale sale) {
		return new Object[] { sale.getNo(), sale.getCode().getCode(), sale.getCode().getName(),
				String.format("%,d", sale.getPrice()), String.format("%,d", sale.getSaleCnt()),
				String.format("%,d", sale.getDetail().getSupplyprice()),
				String.format("%,d", sale.getDetail().getAddtax()),
				String.format("%,d", sale.getDetail().getSaleprice()), sale.getMarginRate() + "%",
				String.format("%,d", sale.getDetail().getMarginprice()) };
	}

	private String[] getColumnNames() {
		return new String[] { "순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액" };
	}

	public Object[] getTotal() {
		LogUtil.prnLog("getTotal()");
		int totalsupplyPrice = 0;
		int totalAddtax = 0;
		int totalSalePrice = 0;
		int totalMarginPrice = 0;
		for (Sale s : lists) {
			totalsupplyPrice += s.getDetail().getSupplyprice();
			totalAddtax += s.getDetail().getAddtax();
			totalSalePrice += s.getDetail().getSaleprice();
		}
		LogUtil.prnLog(totalsupplyPrice + "");
		return new Object[] { "합계", "", "", "", "", String.format("%,d", totalsupplyPrice),
				String.format("%,d", totalAddtax), String.format("%,d", totalSalePrice), "",
				String.format("%,d", totalMarginPrice) };
	}

}

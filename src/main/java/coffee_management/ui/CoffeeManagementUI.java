package coffee_management.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import coffee_management.dto.Product;
import coffee_management.dto.Sale;
import coffee_management.service.SaleInputService;

public class CoffeeManagementUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfName;
	private JTextField tfPrice;
	private JTextField tfSaleCnt;
	private JTextField tfMarginRate;
	private JButton btnInput;
	private JButton btnPrint1;
	private JButton btnPrint2;

	private SaleInputService service;

	public CoffeeManagementUI() {
		service = new SaleInputService();
		initComponents();
	}

	private void initComponents() {
		setTitle("프랜차이즈 커피전문점 상품별 판매실적 계산 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 4, 10, 10));

		JLabel lblCode = new JLabel("제품코드 : ");
		panel_1.add(lblCode);

		tfCode = new JTextField();
		panel_1.add(tfCode);
		tfCode.setColumns(10);

		JLabel lblName = new JLabel("제품명 : ");
		panel_1.add(lblName);

		tfName = new JTextField();
		panel_1.add(tfName);
		tfName.setColumns(10);

		JLabel lblPrice = new JLabel("제품단가 : ");
		panel_1.add(lblPrice);

		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		panel_1.add(tfPrice);

		JLabel lbl = new JLabel("");
		panel_1.add(lbl);

		JLabel lbl_1 = new JLabel("");
		panel_1.add(lbl_1);

		JLabel lblSaleCnt = new JLabel("판매수량 : ");
		panel_1.add(lblSaleCnt);

		tfSaleCnt = new JTextField();
		panel_1.add(tfSaleCnt);
		tfSaleCnt.setColumns(10);

		JLabel lbl_2 = new JLabel("");
		panel_1.add(lbl_2);

		JLabel lbl_3 = new JLabel("");
		panel_1.add(lbl_3);

		JLabel lblMarginRate = new JLabel("마진율 : ");
		panel_1.add(lblMarginRate);

		tfMarginRate = new JTextField();
		panel_1.add(tfMarginRate);
		tfMarginRate.setColumns(10);

		JLabel lbl_4 = new JLabel("");
		panel_1.add(lbl_4);

		JLabel lbl_5 = new JLabel("");
		panel_1.add(lbl_5);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		btnInput = new JButton("입력");
		btnInput.addActionListener(this);
		panel.add(btnInput);

		btnPrint1 = new JButton("출력1");
		btnPrint1.addActionListener(this);
		panel.add(btnPrint1);

		btnPrint2 = new JButton("출력2");
		btnPrint2.addActionListener(this);
		panel.add(btnPrint2);

		tfCode.getDocument().addDocumentListener(new MyDocumentListener() {

			@Override
			public void msg() {
				if (tfCode.getText().length() == 4) {
					Product pdt = new Product(tfCode.getText().trim());
					try {
						Product searchPdt = service.searchProduct(pdt);
						System.out.println(searchPdt);
						tfName.setText(searchPdt.getName());
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (NullPointerException e) {
						tfName.setText("해당 제품이 없음");
					}
				}

			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrint2) {
			do_btnPrint2_actionPerformed(e);
		}
		if (e.getSource() == btnPrint1) {
			do_btnPrint1_actionPerformed(e);
		}
		if (e.getSource() == btnInput) {
			do_btnInput_actionPerformed(e);
		}
	}

	protected void do_btnInput_actionPerformed(ActionEvent e) {
		Sale sale = getSale();
		int res;
		try {
			res = service.registerSale(sale);
			if (res == 1) {
				JOptionPane.showMessageDialog(null, "추가했습니다.");
			}
			clearTf();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "유효하지 않은 명령입니다.");
			e1.printStackTrace();
		}
	}

	private void clearTf() {
		tfCode.setText("");
		tfPrice.setText("");
		tfName.setText("");
		tfSaleCnt.setText("");
		tfMarginRate.setText("");

	}

	private Sale getSale() {
		String code = tfCode.getText().trim();
		int price = Integer.parseInt(tfPrice.getText().trim());
		int saleCnt = Integer.parseInt(tfSaleCnt.getText().trim());
		int marginRate = Integer.parseInt(tfMarginRate.getText().trim());

		return new Sale(0, new Product(code), price, saleCnt, marginRate);
	}

	protected void do_btnPrint1_actionPerformed(ActionEvent e) {
	}

	protected void do_btnPrint2_actionPerformed(ActionEvent e) {
	}
}

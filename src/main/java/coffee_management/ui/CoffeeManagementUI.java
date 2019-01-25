package coffee_management.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import coffee_management.dto.Product;
import coffee_management.dto.Sale;
import coffee_management.service.CoffeeManagementService;
import coffee_management.service.OutputService;

import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoffeeManagementUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfName;
	private JTextField tfPrice;
	private JTextField tfSaleCnt;
	private JTextField tfMarginRate;
	private CoffeeManagementService saleService;
	private OutputService productService;
	private JButton btnInput;
	private JButton btnSalePrice;
	private JButton btnMarginPrice;

	public CoffeeManagementUI() {
		saleService = new CoffeeManagementService();
		productService = new OutputService();
		initComponents();
	}

	private void initComponents() {
		setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		setTitle("이천희 판매실적 계산 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);

		JPanel pContent = new JPanel();
		contentPane.add(pContent, BorderLayout.CENTER);
		pContent.setLayout(new GridLayout(0, 4, 10, 10));

		JLabel lblCode = new JLabel("제품코드");
		lblCode.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		pContent.add(lblCode);

		tfCode = new JTextField();
		tfCode.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pContent.add(tfCode);
		tfCode.setColumns(10);

		JLabel lblName = new JLabel("제품명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pContent.add(lblName);

		tfName = new JTextField();
		tfName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tfName.setEnabled(false);
		pContent.add(tfName);
		tfName.setColumns(10);

		JLabel lblPrice = new JLabel("제품단가");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pContent.add(lblPrice);

		tfPrice = new JTextField();
		tfPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pContent.add(tfPrice);
		tfPrice.setColumns(10);

		JLabel lblBlank0 = new JLabel("");
		pContent.add(lblBlank0);

		JLabel lblBlank1 = new JLabel("");
		pContent.add(lblBlank1);

		JLabel lblSaleCnt = new JLabel("판매수량");
		lblSaleCnt.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaleCnt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pContent.add(lblSaleCnt);

		tfSaleCnt = new JTextField();
		tfSaleCnt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pContent.add(tfSaleCnt);
		tfSaleCnt.setColumns(10);

		JLabel lblBlank2 = new JLabel("");
		pContent.add(lblBlank2);

		JLabel lblBlank3 = new JLabel("");
		pContent.add(lblBlank3);

		JLabel lblMarginRate = new JLabel("마진율");
		lblMarginRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarginRate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pContent.add(lblMarginRate);

		tfMarginRate = new JTextField();
		tfMarginRate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pContent.add(tfMarginRate);
		tfMarginRate.setColumns(10);

		JPanel pButton = new JPanel();
		contentPane.add(pButton, BorderLayout.SOUTH);

		btnInput = new JButton("입력");
		btnInput.addActionListener(this);
		btnInput.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pButton.add(btnInput);

		btnSalePrice = new JButton("출력1");
		btnSalePrice.addActionListener(this);
		btnSalePrice.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pButton.add(btnSalePrice);

		btnMarginPrice = new JButton("출력2");
		btnMarginPrice.addActionListener(this);
		btnMarginPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pButton.add(btnMarginPrice);

		tfCode.getDocument().addDocumentListener(new MyDocumentListener() {

			@Override
			public void msg() {
				if (tfCode.getText().length() == 4) {
					Product product = new Product(tfCode.getText().trim());

					try {
						Product searchProduct = saleService.searchProduct(product);
						System.out.println("검색한 제품명 : " + searchProduct);
						tfName.setText(searchProduct.getName());

					} catch (SQLException e) {
						e.printStackTrace();

					} catch (NullPointerException e) {
						tfName.setText("해당 제품 없음");
					}
				}
			}
		});
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnMarginPrice) {
			do_btnMarginPrice_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalePrice) {
			do_btnSalePrice_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnInput) {
			do_btnInput_actionPerformed(arg0);
		}
	}

	protected void do_btnInput_actionPerformed(ActionEvent arg0) {
		Sale sale = getSale();
		int res;

		try {
			res = saleService.registerSale(sale);

			if (res == 1) {
				JOptionPane.showMessageDialog(null, "제품을 추가했습니다.");
			}
			clearTf();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private Sale getSale() {
		String code = tfCode.getText().trim();
		int price = Integer.parseInt(tfPrice.getText().trim());
		int saleCnt = Integer.parseInt(tfSaleCnt.getText().trim());
		int marginRate = Integer.parseInt(tfMarginRate.getText().trim());

		return new Sale(0, new Product(code), price, saleCnt, marginRate);
	}

	private void clearTf() {
		tfCode.setText("");
		tfPrice.setText("");
		tfName.setText("");
		tfSaleCnt.setText("");
		tfMarginRate.setText("");
	}

	protected void do_btnSalePrice_actionPerformed(ActionEvent arg0) {
		OutputUI ui = new OutputUI(true);
		ui.setVisible(true);
	}

	protected void do_btnMarginPrice_actionPerformed(ActionEvent arg0) {
		OutputUI ui = new OutputUI(false);
		ui.setVisible(true);
	}
}

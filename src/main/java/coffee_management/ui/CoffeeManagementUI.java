package coffee_management.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class CoffeeManagementUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfName;
	private JTextField tfPrice;
	private JTextField tfSaleCnt;
	private JTextField tfMarginRate;

	public CoffeeManagementUI() {
		setTitle("프랜차이즈 커피전문점 상품별 판매실적 계산 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblCode = new JLabel("제품코드 : ");
		contentPane.add(lblCode);
		
		tfCode = new JTextField();
		contentPane.add(tfCode);
		tfCode.setColumns(10);
		
		JLabel lblName = new JLabel("제품명 : ");
		contentPane.add(lblName);
		
		tfName = new JTextField();
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblPrice = new JLabel("제품단가 : ");
		contentPane.add(lblPrice);
		
		tfPrice = new JTextField();
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lbl = new JLabel("");
		contentPane.add(lbl);
		
		JLabel lbl_1 = new JLabel("");
		contentPane.add(lbl_1);
		
		JLabel lblSaleCnt = new JLabel("판매수량 : ");
		contentPane.add(lblSaleCnt);
		
		tfSaleCnt = new JTextField();
		contentPane.add(tfSaleCnt);
		tfSaleCnt.setColumns(10);
		
		JLabel lbl_2 = new JLabel("");
		contentPane.add(lbl_2);
		
		JLabel lbl_3 = new JLabel("");
		contentPane.add(lbl_3);
		
		JLabel lblMarginRate = new JLabel("마진율 : ");
		contentPane.add(lblMarginRate);
		
		tfMarginRate = new JTextField();
		contentPane.add(tfMarginRate);
		tfMarginRate.setColumns(10);
		
		JLabel lbl_4 = new JLabel("");
		contentPane.add(lbl_4);
		
		JLabel lbl_5 = new JLabel("");
		contentPane.add(lbl_5);
		
		JButton btnInput = new JButton("[입력]");
		contentPane.add(btnInput);
		
		JButton btnOutput1 = new JButton("[출력1]");
		contentPane.add(btnOutput1);
		
		JButton btnOutput2 = new JButton("[출력2]");
		contentPane.add(btnOutput2);
	}

}

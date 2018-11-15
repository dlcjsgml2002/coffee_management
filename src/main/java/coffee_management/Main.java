package coffee_management;

import java.awt.EventQueue;

import coffee_management.ui.CoffeeManagementUI;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeManagementUI frame = new CoffeeManagementUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

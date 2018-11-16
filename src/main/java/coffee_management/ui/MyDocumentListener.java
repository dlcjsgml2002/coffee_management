package coffee_management.ui;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public interface MyDocumentListener extends DocumentListener {

	@Override
	default void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		msg();
	}

	@Override
	default void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		msg();
	}

	@Override
	default void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		msg();
	}
	
	public abstract void msg();
	
}

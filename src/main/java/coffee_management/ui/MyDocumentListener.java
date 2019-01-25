package coffee_management.ui;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public interface MyDocumentListener extends DocumentListener {

	@Override
	default void changedUpdate(DocumentEvent arg0) {
		msg();
	}

	@Override
	default void insertUpdate(DocumentEvent arg0) {
		msg();
	}

	@Override
	default void removeUpdate(DocumentEvent arg0) {
		msg();
	}

	public abstract void msg();
}

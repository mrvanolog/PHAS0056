package module9;

import java.awt.event.*;
import javax.swing.*;

/** Panel illustrating text and button input. */
public class TextInputPanel extends JPanel implements ActionListener {
	// These components are accessed from more than
	// one method so they must be member variables.
	private JLabel label;
	private JTextField text;
	private JButton button;
	/** Create panel containing the required components. */
	public TextInputPanel() {
		// Simple layout with vertical arrangement of components.
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		label = new JLabel("Please enter some text.");
		text = new JTextField(20);
		button = new JButton("Reverse");
		add(label); // add components to this frame
		add(text);
		add(button);
		// Call actionPerformed method of this object
		// if text is entered in field.
		text.addActionListener(this);
		button.addActionListener(this); // Likewise if button clicked.
	}
	/**
	 * This method is called by Swing whenever
	 * an action is detected in the JTextField
	 * or JButton. It is required by the
	 * ActionListener interface.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==text) { // action is from JTextField
			label.setText(text.getText()); // copy text from input to label
		}
		else if (e.getSource()==button) { // action is from JButton
			label.setText(reverse(label.getText()));
		}
	}
	/** Private utility method to reverse a string. */
	private static String reverse(String input) {
		StringBuilder s = new StringBuilder();
		for (int i=input.length()-1; i>=0; --i) {
			s.append(input.charAt(i));
		}
		return s.toString();
	}
}

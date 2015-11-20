package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Controller.RadioButtonListener;
import Model.Data;
import Model.Questions;

public class QuestionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea userName;
	private JTextArea keywords;

	/**
	 * Create the frame.
	 * 
	 * @param commentView
	 */
	public QuestionPanel(Data data) {

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(Questions.QUESTIONS.length + 2, 1, 0, 0));

		
		JPanel panel5 = new JPanel(new GridLayout(1, 2));
		add(panel5);
		JTextArea textArea3 = new JTextArea("Please fill the following questions knowing that 1 means \"I totally disagree\" and 5 means \"I totally agree\".");
		textArea3.setLineWrap(true);
		textArea3.setEditable(false);
		textArea3.setBackground(new Color(240, 240, 240));
		panel5.add(textArea3);

		JPanel panel = new JPanel(new GridLayout(1, 2));
		add(panel);
		JTextArea textArea = new JTextArea("Enter your mail:");
		textArea.setEditable(false);
		textArea.setBackground(new Color(240, 240, 240));
		panel.add(textArea);
		userName = new JTextArea();
		userName.setToolTipText("Mail");
		panel.add(userName);

		Border border = BorderFactory.createLineBorder(Color.BLACK);
		userName.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		int i = 0;
		while (i < Questions.QUESTIONS.length) {
			JPanel panel2 = new JPanel(new GridLayout(1, 2));
			add(panel2);
			if (i == 0) {
				JTextArea textArea2 = new JTextArea(Questions.QUESTIONS[i]);
				textArea2.setBackground(new Color(240, 240, 240));
				textArea2.setEditable(false);
				panel2.add(textArea2);
				JPanel panel3 = new JPanel(new GridLayout(1, 5));
				panel2.add(panel3);
				ButtonGroup group = new ButtonGroup();
				for (int j = 1; j < 4; j++) {
					JRadioButton radioButton = new JRadioButton(Integer.toString(j));
					radioButton.addActionListener(new RadioButtonListener(i, radioButton, data));
					radioButton.setBackground(new Color(240, 240, 240));
					group.add(radioButton);
					panel3.add(radioButton);
					radioButton.setSelected(true);
					data.setAnswer(Questions.QUESTIONS[i], radioButton.getText());
				}
			} else if (i == 3) {
				JTextArea textArea2 = new JTextArea(Questions.QUESTIONS[i]);
				textArea2.setBackground(new Color(240, 240, 240));
				textArea2.setEditable(false);
				panel2.add(textArea2);

				keywords = new JTextArea();
				keywords.setToolTipText("Keywords");
				Border border2 = BorderFactory.createLineBorder(Color.BLACK);
				keywords.setBorder(
						BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
				panel2.add(keywords);
			} else {

				JTextArea textArea2 = new JTextArea(Questions.QUESTIONS[i]);
				textArea2.setBackground(new Color(240, 240, 240));
				textArea2.setEditable(false);
				panel2.add(textArea2);
				JPanel panel3 = new JPanel(new GridLayout(1, 5));
				panel2.add(panel3);
				ButtonGroup group = new ButtonGroup();
				for (int j = 1; j < 6; j++) {
					JRadioButton radioButton = new JRadioButton(Integer.toString(j));
					radioButton.addActionListener(new RadioButtonListener(i, radioButton, data));
					radioButton.setBackground(new Color(240, 240, 240));
					group.add(radioButton);
					panel3.add(radioButton);
					radioButton.setSelected(true);
					data.setAnswer(Questions.QUESTIONS[i], radioButton.getText());
				}

			}
			i++;
		}

	}

	public String getUserName() {
		return userName.getText();
	}

	public String getKeywords() {
		return keywords.getText();
	}
}

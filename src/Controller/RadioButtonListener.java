package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import Model.Data;
import Model.Questions;

public class RadioButtonListener implements ActionListener {

	private int questionIndex;
	private JRadioButton radioButton;
	private Data data;
	
	public RadioButtonListener(int questionIndex, JRadioButton radioButton, Data data) {
		this.questionIndex = questionIndex;
		this.radioButton = radioButton;
		this.data = data;
	}
	
	public void actionPerformed(ActionEvent e) {
		data.setAnswer(Questions.QUESTIONS[questionIndex], radioButton.getText());
	}

}

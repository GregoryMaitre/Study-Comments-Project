package View;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controller.CSVListener;
import Controller.NextListener;
import Model.Data;

public class StudyView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QuestionPanel questionPanel;
	private JPanel contentPane;
	private NextListener nextListener;
	private CSVListener csvListener;

	/**
	 * Create the frame.
	 */
	public StudyView() {
		
		Data data = new Data();
		questionPanel = new QuestionPanel(data);
		nextListener = new NextListener(data, this);
		csvListener = new CSVListener();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel(new GridLayout(1, 1));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNext = new JMenuItem("Next");
		mntmNext.addActionListener(nextListener);
		mnNewMenu.add(mntmNext);
		
		JMenuItem mntmExportCsv = new JMenuItem("Export CSV");
		mntmExportCsv.addActionListener(csvListener);
		mnNewMenu.add(mntmExportCsv);
		
		contentPane.add(questionPanel);
		
		setVisible(true);
	}

	public void next() {
		if (questionPanel != null) {
			contentPane.remove(questionPanel);
		}
		Data data = new Data();
		nextListener.setData(data);
		questionPanel = new QuestionPanel(data);
		contentPane.add(questionPanel);
		questionPanel.updateUI();
	}
	
	public QuestionPanel getPanel() {
		return questionPanel;
	}
}

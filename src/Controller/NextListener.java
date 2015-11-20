package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Common.Constants;
import Model.Data;
import View.StudyView;

public class NextListener implements ActionListener {
	
	private Data data;
	private StudyView view;
	
	public NextListener(Data data, StudyView view) {
		this.data = data;
		this.view = view;
	}
	
	public void setData(Data data) {
		this.data = data;
	}

	public void actionPerformed(ActionEvent e) {
		
		data.setUser(view.getPanel().getUserName());
		data.setKeywords(view.getPanel().getKeywords());
		
		System.out.println(data);
		
		if ((data.user == null) || (data.user.length() == 0)) {
			return;
		}
		
		String json = JSONManager.getInstance().toJson(data);
		
		BufferedWriter output = null;
		try {
			String path = Constants.PATH + File.separator + data.user + ".json";
			output = new BufferedWriter(new FileWriter(path));
			output.write(json);
			
		} catch (IOException er) {
			System.err.println("Unable to save the comment!");
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException err) {
					err.printStackTrace();
				}
			}
		}
		
		view.next();
	}
}

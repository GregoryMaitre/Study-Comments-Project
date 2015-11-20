package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;

import Common.Constants;
import Model.Data;

public class CSVListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		HashMap<String, ArrayList<Data>> datas = load();
		List<String[]> dataCSVFormat = format(datas);
		save(dataCSVFormat);
	}

	private HashMap<String, ArrayList<Data>> load() {
		HashMap<String, ArrayList<Data>> datas = new HashMap<String, ArrayList<Data>>();
		File resultsFolder = new File(Constants.PATH);
		
		File[] children = resultsFolder.listFiles();
		
		for (File child : children) {
			Data data = loadData(child);
			ArrayList<Data> list = datas.get(data.user);
			if (list == null) {
				datas.put(data.user, new ArrayList<Data>());
				list = datas.get(data.user);
			}
			list.add(data);
		}
		return datas;
	}
	
	private Data loadData(File file) {
		StringBuilder json = new StringBuilder();
		Scanner fileStream = null;
		try {
			fileStream = new Scanner(new FileInputStream(file));
			while (fileStream.hasNext()) {
				json.append(fileStream.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			fileStream.close();
		}
		
		Data data = JSONManager.getInstance().toData(json.toString());
		data.userToInt();
		return data;
	}
	
	private List<String[]> format(HashMap<String, ArrayList<Data>> datas) {
		ArrayList<String> keys = new ArrayList<String>(datas.keySet());
		Collections.sort(keys);
		
		ArrayList<String[]> format = new ArrayList<String[]>();
		format.add(Data.getHeaders());
		
		for (String key : keys) {
			for (Data data : datas.get(key)) {
				format.add(data.getFormat());
			}
		}
		
		return format;
	}

	private void save(List<String[]> dataCSVFormat) {
		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new FileWriter(Constants.CSV_PATH), ';');

			
			writer.writeAll(dataCSVFormat);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		}
	}
}

package Controller;

import java.io.File;
import java.io.IOException;

import Common.Constants;
import View.StudyView;

public class MainApplication {
	public static void main(String[] args) throws IOException {
		File file = new File(Constants.PATH);
		if (file.exists() || file.mkdirs()) {
			new StudyView();
		}
	}
}

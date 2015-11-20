package Model;

import java.util.HashMap;

public class Data {
	public String user;
	public String keyWords;
	public HashMap<String, String> data;
	
	public Data() {
		data = new HashMap<String,String>();
	}

	public void setAnswer(String string, String text) {
		data.put(string, text);
	}

	public void setUser(String text) {
		user = text;
	}
	
	public void setKeywords(String text) {
		keyWords = text;
	}

	@Override
	public String toString() {
		return "Data [user=" + user + ", data=" + data + "]";
	}
	
	public static String[] getHeaders() {
		String[] format = {"user_id", "app_id", "Q1", "Q2", "Keywords", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8", "Q9", "Q10", "Q11"};
		return format;
	}

	public String[] getFormat() {
		String[] format = new String[Questions.QUESTIONS.length + 1];
		format[0] = user;
		for (int i = 0; i < Questions.QUESTIONS.length; i++) {
			if (i == 3) {
				format[i + 1] = keyWords;
			} else {
				format[i + 1] = data.get(Questions.QUESTIONS[i]);
			}
		}
		return format;
	}

	public void userToInt() {
		String[] split = user.split("( )|(_)");
		if (split.length != 1) {
			user = split[0];
		}
	}
}

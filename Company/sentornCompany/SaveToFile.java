package com.sentornCompany;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Properties;

public class SaveToFile<T> {

	private Properties p = System.getProperties();
	
	void saveToFile(List<T> list, String name) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(
					p.getProperty("user.home") + "/" + name));
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	List<T> readFromFile(List<T> list, String name) {
		ObjectInputStream ois = null;
		File file = new File(p.getProperty("user.home") + "/" + name);
		try {
			if (file.length() != 0) {
				ois = new ObjectInputStream(new FileInputStream(file));

				try {
					list = (List<T>) ois.readObject();

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				ois.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
}

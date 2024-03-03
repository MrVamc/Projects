package genericutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Reusable {
	public String PropertyFetch(String path,String key) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		
		Properties obj = new Properties();
		obj.load(fis);
		String data = obj.getProperty(key);
		return data;
	}

}

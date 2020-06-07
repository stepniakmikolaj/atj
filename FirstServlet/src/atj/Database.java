package atj;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Database {
	
	private static Map<String, String> database = new HashMap<String, String>();

	public Map<String, String> getDatabase() {
		return database;
	}
	
	public void addToDB(String key, String value) {
		database.put(key, value);
	}

	public String getHTTPSite(String key) {
		String result = "init value";
		for (Entry<String, String> map : database.entrySet()) {
			if (key.equals(map.getKey())) {
				result = map.getValue();
			}
		}
		return result;
	}
}

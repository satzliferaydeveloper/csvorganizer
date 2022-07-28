package test;

import java.util.Comparator;
import java.util.Map;

public class CustomFieldComparator implements Comparator<Map<String, String>>{
	
	private String fieldName;
	
	public CustomFieldComparator(String fieldName) {
		this.fieldName=fieldName;
	}
	
	
	@Override
	public int compare(Map<String, String> o1, Map<String, String> o2) {
	  return o1.get(fieldName).compareTo(o2.get(fieldName));
	}
	

}

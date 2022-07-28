package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomDataSorter {

	
	public void sortInputData() {
		
		final List<Map<String, String>> inputData = new ArrayList<Map<String, String>>();

		String line = "";
		String splitBy = ",";
		String fileName = "SampleData.csv" ;
		try (InputStream inputStream = this.getClass().getResourceAsStream(fileName)){
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
			// parsing a CSV file into BufferedReader class constructor
			String[] header = null;
			// read header
			if ((line=br.readLine()) != null) {
				header = line.split(splitBy);

			}
			
			
			if (header != null) {
				while ((line = br.readLine()) != null)
				// returns a Boolean value
				{
					String[] row = line.split(splitBy);
					// use comma as separator
					Map<String, String> record = new HashMap<>();
					for (int i = 0; i < header.length; i++) {
						record.put(header[i], row[i]);
					}
					inputData.add(record);
				}

				/*final String sortBy = header[0];*/
				// default it will be sorted by first column
					// it can read dynamically as input
				 final String sortBy="firstName";
				Collections.sort(inputData, new CustomFieldComparator(sortBy));
				
				System.out.println(inputData.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

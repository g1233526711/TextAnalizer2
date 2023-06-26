import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.FileInputStream;


public class TextAnalizer2 
{
	public static void main(String[] args) throws IOException 
	{
		File file = new File ("test.txt");
				FileInputStream fis = new FileInputStream(file);
				Scanner scanner = new Scanner(fis);
				Map<String, Integer> wordMap = new HashMap<>();
				
				while (scanner.hasNextLine()) 
				{
					String line = scanner.nextLine();
					String[] words = line.split("\\s+");
					
					for (String word : words) 
					{
						word = word.replaceAll("[^a-zA-Z]", "");
						if (wordMap.containsKey(word)) 
						{
							int count = wordMap.get(word);
							wordMap.put(word, count + 1);
						}
						
						else
						
						{
							wordMap.put(word, 1);
						}
					}
					
				}
				
				scanner.close();
				System.out.println("Word" +"\tFrequency");
				System.out.printf( "*****" + "\t*********\n");
				wordMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.forEach(entry -> System.out.println( (entry.getKey() + "\t" + entry.getValue())))
				
	}

}

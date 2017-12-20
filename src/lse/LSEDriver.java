package lse;
import java.io.*;
import java.util.*;

public class LSEDriver 
{
	static Scanner sc = new Scanner(System.in);
	
	static String getOption() 
	{
		System.out.print("getKeyWord(): ");
		String response = sc.next();
		return response;
	}
	
	public static void main(String args[])
	{
		LittleSearchEngine lse = new LittleSearchEngine();
		
		try
		{
			lse.makeIndex("docs.txt", "noisewords.txt");
		} 
		catch (FileNotFoundException e)
		{
		}		
		
//		String input;
//
		for (String hi : lse.keywordsIndex.keySet())
			System.out.println(hi+" "+lse.keywordsIndex.get(hi));
//				
//		while (!(input = getOption()).equals("q"))
//		{
//				System.out.println(lse.getKeyWord(input));
//		}
		
		Occurrence occs = new Occurrence("WowCh1.txt",12);
		Occurrence occs1 = new Occurrence("WowCh1.txt",8);
		Occurrence occs2 = new Occurrence("WowCh1.txt",7);
		Occurrence occs3 = new Occurrence("WowCh1.txt",5);
		Occurrence occs4 = new Occurrence("WowCh1.txt",3);
		Occurrence occs5 = new Occurrence("WowCh1.txt",2);
		Occurrence occs6 = new Occurrence("WowCh1.txt",6);
		ArrayList<Occurrence> x = new ArrayList<Occurrence>();
		x.add(occs);
		x.add(occs1);
		x.add(occs2);
		x.add(occs3);
		x.add(occs4);
		x.add(occs5);
		x.add(occs6);
		System.out.println(x);
		System.out.println(lse.insertLastOccurrence(x));
		System.out.println(x);
		System.out.println(lse.top5search("war", "feet"));
		System.out.println(lse.getKeyword("what,ever"));
		HashMap<String, Occurrence> y = new HashMap<String, Occurrence>();
		y.put("Alex", occs);
		y.put("Bryan", occs1);
		y.put("Kevin", occs2);
		lse.mergeKeywords(y);
		System.out.println(lse.keywordsIndex);
				
		
		try {
			System.out.println(lse.loadKeywordsFromDocument("WowCh1.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
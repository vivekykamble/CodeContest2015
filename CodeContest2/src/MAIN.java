import java.util.ArrayList;
import java.util.HashSet;


public class MAIN {

	
	 public static int maxno_city(String[] input1)
	    {
		 	int prevlenght=0,lenght=1;
		 	HashSet<String> passedList= new HashSet<>();
		 	HashSet<String> possibleList= new HashSet<>();
			for(int i=0;i<=input1.length-1;i++)
			{
				//System.out.println("For String  "+input1[i]);
				lenght=1;
				String str=input1[i];
				if(str!=null)
				{
				int hasIndex=str.indexOf("#");
				String from=str.substring(0,hasIndex);
				String to=str.substring(hasIndex+1,str.length());
				passedList.add(from);
				passedList.add(to);
				//Forward Loop
				for(int j=0;j<=input1.length-1;j++)
				{
					
					if(str!=null)
					{
					String str2=input1[j];
					int hasIndex2=str2.indexOf("#");
					String from2=str2.substring(0,hasIndex2);
					String to2=str2.substring(hasIndex2+1,str2.length());
					if(to.equalsIgnoreCase(from2) && !(passedList.contains(to2)))
						{
							//System.out.println(from+ " "+ to + "  "+from2+ " "+ to2);
							lenght++;
							passedList.add(to2);
							j=0;
							from=from2;
							to=to2;
							
						}
						else if(to.equalsIgnoreCase(to2) && !from.equalsIgnoreCase(from2) && ! passedList.contains(from2)){
							//System.out.println(from+ " "+ to + "  "+from2+ " "+ to2);
							lenght++;
							passedList.add(from2);
							j=0;
							from=to;
							to=from2;
							}
					}
				 }
				}
				if(prevlenght<passedList.size())
					prevlenght=passedList.size();
				//System.out.println("Length " +passedList.size());
				passedList.clear();
			}
			return ++prevlenght;
	    }
	 public static void main(String[] args) {
		ystem.out.println(maxno_city(new String[]{"1#2","2#3","1#11","3#11","4#11","4#5","5#6","5#7","6#7","4#12","8#12","9#12","8#10","9#10","8#9"}));
	}
}

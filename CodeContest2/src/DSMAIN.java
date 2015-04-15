import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;


public class DSMAIN {
	
	static HashMap<String,HashSet<String>>rtnmap=null;
	static HashSet<HashSet<String>> pathSet= new HashSet<HashSet<String>>();
	 public static int maxno_city(String[] input1)
	 {
		 rtnmap=mapOfRoadLinks(input1);
		// System.out.println(rtnmap);
		 Set<Entry<String, HashSet<String>>> setView=rtnmap.entrySet();
		 Iterator<Entry<String, HashSet<String>>> it=setView.iterator();
		 while(it.hasNext())
		 {
			 Entry<String, HashSet<String>> tempVariable=it.next();
			 String str=tempVariable.getKey();
			 HashSet<String> links=tempVariable.getValue();
			 LinkedHashSet<String> path=new LinkedHashSet<String>();
			 
			 
			 for(String link:links)
			 {int tempvalue=0;
				 path.add(str);
				 if(tempvalue!=1 &&path.add(link))
				 {
					 tempvalue=itrateOverEmbededLinks(link,path);
				 }
			//	 System.out.println("KEy " +str + " path  "+path + "    "+pathSet);
				 path.clear();
			 }
			 
		 }
		 int maxLength=0;
		for( Set<String> ab:pathSet)
		{	if(maxLength<ab.size())
			{
				maxLength=ab.size();
			}
		}
		
		 return maxLength;
	 }

	private static int itrateOverEmbededLinks(String link,
			LinkedHashSet<String> path) {
		// TODO Auto-generated method stub


		int tempvalue=0;
		String anchor=link;
		 HashSet<String> links= rtnmap.get(link);
		 for(String link2:links)
		 {
			 if(path.add(link2)){
				 tempvalue=itrateOverEmbededLinks(link2,path);
			 }
		 
		 //System.out.println(path);
		 pathSet.add((HashSet<String>) path.clone());
		 Iterator<String> it2= path.iterator();
		 LinkedHashSet<String> retainedLinkes= new LinkedHashSet<String>();
		 while(it2.hasNext())
		 {
			 String strcomp= it2.next();
			 if(strcomp.equalsIgnoreCase(anchor))
			 {
				 retainedLinkes.add(strcomp);
				 path.retainAll(retainedLinkes);
				 break;
			 }else
			 {
			 retainedLinkes.add(strcomp);
			 }
		 }
		 }
		 return 1;
		 
	}

	private static HashMap<String, HashSet<String>> mapOfRoadLinks(
			String[] input1) {
		LinkedHashMap<String,HashSet<String>> rtnMap=new LinkedHashMap<String, HashSet<String>>();
		for(int i=0;i<=input1.length-1;i++)
		{
			String str=input1[i];
			int hasIndex=str.indexOf("#");
			String from=str.substring(0,hasIndex);
			String to=str.substring(hasIndex+1,str.length());
						HashSet<String> set=new HashSet<String>();
			set.add(to);
			for(int j=0;j<=input1.length-1;j++)
			{
				
				if(str!=null)
				{
				String str2=input1[j];
				int hasIndex2=str2.indexOf("#");
				String from2=str2.substring(0,hasIndex2);
				String to2=str2.substring(hasIndex2+1,str2.length());
				if(from.equalsIgnoreCase(from2))
					{
					set.add(to2);	
					}
					else if(to2.equalsIgnoreCase(from)){
						set.add(from2);	
					}
				}
			}
			
			rtnMap.put(from, set);
		}
		
		for(int i=input1.length-1;i>=0;i--)
		{
			String str=input1[i];
			int hasIndex=str.indexOf("#");
			String from=str.substring(hasIndex+1,str.length());
			String to=str.substring(0,hasIndex);
						HashSet<String> set=new HashSet<String>();
			set.add(to);
			for(int j=0;j<=input1.length-1;j++)
			{
				
				if(str!=null)
				{
				String str2=input1[j];
				int hasIndex2=str2.indexOf("#");
				String from2=str2.substring(0,hasIndex2);
				String to2=str2.substring(hasIndex2+1,str2.length());
				if(from.equalsIgnoreCase(from2))
					{
					set.add(to2);	
					}
					else if(to2.equalsIgnoreCase(from)){
						set.add(from2);	
					}
				}
			}
			
			rtnMap.put(from, set);
		}
		return rtnMap;
	}

	 public static void main(String[] args) {
			System.out.println(maxno_city(new String[]{"1#2","2#3","1#11","3#11","4#11","4#5","5#6","5#7","6#7","4#12","8#12","9#12","8#10","9#10","8#9"}));

		}
}

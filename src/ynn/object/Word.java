package ynn.object;

import java.util.ArrayList;
import java.util.List;

public class Word {
	private static List<String> list=new ArrayList<String>();
	static{
		list.add("sb");
		list.add("大傻瓜");
		list.add("嘻嘻");
	}

	public static List<String> getWords(){
		return list;
	}
	/*public static void reBuild(){
		
	}*/
	public static void addwords(String newword) {
		// TODO Auto-generated method stub
		list.add(newword);
	}
}

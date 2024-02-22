package listDriver;

import list.LinkedList;
import list.List;

public class Quiz1Driver {

	public static void main (String[] args) {
		List<String> list = new LinkedList<String>();
		list.add("jay");
		list.add("ash");
		list.add("tom");
		list.add("ash");
		list.add("joy");
		list.add("wowow");

		int i = list.indexOfLast("ash");
		System.out.println(i);	// Should be 3

		deleteStrings(4, list);
	}

	private static void deleteStrings(int max, List<String> names) {
		for(int i = 0; i < names.size(); i++) {
			if(names.get(i).length() > max) {
				names.remove(i);
			}
		}
		System.out.println(names);
	}
}

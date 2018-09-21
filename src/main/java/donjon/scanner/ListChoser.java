package donjon.scanner;

import java.util.*;

public class ListChoser {


    public static final ListChoser CHOSER = new ListChoser();

	/**
	 * the choser function
	 *
	 * @param str the question
	 * @param list of items
	 * @param <T>
	 * @return the donjon.donjon.donjon.item chose
	 */
	public <T> T chose (String str, List<T> list){
		int ind = 1;
		System.out.println(str);
		for(T elem: list){
			System.out.println(ind+"."+elem.toString());
			
			ind ++;
		}
		
		ind = ScannerInt.readInt(list.size()+1);
		if (ind==0){
			return null;
		}
		return list.get(ind-1);
	}
}

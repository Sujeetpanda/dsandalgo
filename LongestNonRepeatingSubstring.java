import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestNonRepeatingSubstring {

	public static void main(String[] args) {
		System.out.println(getLongestSubString("dvdf"));
	}
	public static int getLongestSubString(String s) {
		Set<Character> set = new LinkedHashSet<Character>();
		int maxLength = 0;
		for(int i = 0; i < s.length();i++) {
			if(set.contains(s.charAt(i))) {
				if(set.size() > maxLength) {
					maxLength = set.size();
				}
				
				//set.clear();
				Character ch = s.charAt(i);
				for (Iterator<Character> it = set.iterator(); it.hasNext();) {
				    Character element = it.next();
				    while(element != ch) {
				        it.remove();
				        element = it.next();
				    }
				    break;
				}
				set.remove(s.charAt(i));
				set.add(s.charAt(i));
			}else {
				set.add(s.charAt(i));
			}
		}
		return set.size() > maxLength? set.size():maxLength;
	}

}

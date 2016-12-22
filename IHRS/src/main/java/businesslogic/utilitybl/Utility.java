package businesslogic.utilitybl;

import java.util.regex.Pattern;

public class Utility {
	public static boolean isInteger(String s) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
	    return pattern.matcher(s).matches();    
	}
}

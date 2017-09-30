package test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	private static Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5a-zA-Z\\d\\../:]");


	public static String parseString(String str) {
		StringBuilder sb = new StringBuilder();
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			sb.append(matcher.group());
		}
		return sb.toString();
	}

}

package tsc.dbutil;

public class StringUtil {
	public static boolean isEmpty(String string) {
		if(string==null||"".equals(string.trim()))
		{
			return true;
		}else {
			return false;
		}
	}
	//ÅÐ¶Ï²»Îª¿Õ
	public static boolean isNotEmpty(String string) {
		if(string!=null&&!"".equals(string.trim()))
		{
			return true;
		}else {
			return false;
		}
	}
}

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
	//�жϲ�Ϊ��
	public static boolean isNotEmpty(String string) {
		if(string!=null&&!"".equals(string.trim()))
		{
			return true;
		}else {
			return false;
		}
	}
}

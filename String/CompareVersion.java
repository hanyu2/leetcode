package String;

public class CompareVersion {
	public static int compareVersion(String version1, String version2) {
		String[] a = version1.split("\\.");
		String[] b = version2.split("\\.");
		if((a.length == 0 && b.length == 0) ||(a.length == 1 && b.length == 1)){
			if(Integer.parseInt(version1) < Integer.parseInt(version2)){
				return -1;
			}else if(Integer.parseInt(version1) > Integer.parseInt(version2)){
				return 1;
			}else{
				return 0;
			}
		}
		int sa = Integer.parseInt(a[0]);
		int sb = Integer.parseInt(b[0]);
		if (sa < sb) {
			return -1;
		} else if (sa > sb) {
			return 1;
		} else {
			int la = 0;
			int lb = 0;
			while (la == a[1].length() - 1 && lb == b[1].length() - 1) {
				if (((int) a[1].charAt(la) - '0') == ((int) b[1].charAt(lb) - '0')) {
					la++;
					lb++;
					continue;
				} else if (((int) a[1].charAt(la) - '0') > ((int) b[1].charAt(lb) - '0')) {
					return 1;
				} else {
					return -1;
				}
			}
			if (la < a[1].length() - 1) {
				return 1;
			} else if(lb < b[1].length() - 1){
				return -1;
			}else{
				return 0;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(compareVersion("01", "1"));
	}
}

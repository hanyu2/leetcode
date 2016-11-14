package String;

public class CompareVersion {
	public static int compareVersion(String version1, String version2) {
		String[] str1 = version1.split("\\.");
		String[] str2 = version2.split("\\.");
		// 获取需要比例的长度为两版本中长度的大者
		int length = Math.max(str1.length, str2.length);
		for (int i = 0; i < length; i++) {
			int num1 = i < str1.length ? Integer.parseInt(str1[i]) : 0;
			int num2 = i < str2.length ? Integer.parseInt(str2[i]) : 0;
			if (num1 > num2) {
				return 1;
			} else if (num1 < num2) {
				return -1;
			}
		}
		return 0;
	}

	public static int compareVersion2(String version1, String version2) {
		String[] verArr1 = version1.split("\\.");
		String[] verArr2 = version2.split("\\.");
		int index1 = 0;
		int index2 = 0;
		while (index1 < verArr1.length || index2 < verArr2.length) {
			int val1 = 0;
			int val2 = 0;
			if (index1 < verArr1.length) {
				val1 = Integer.parseInt(verArr1[index1++]);// Do not foget
															// increment here!!!
			}
			if (index2 < verArr2.length) {
				val2 = Integer.parseInt(verArr2[index2++]);
			}
			if (val1 < val2) {
				return -1;
			}
			if (val1 > val2) {
				return 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(compareVersion("0", "1"));
		System.out.println(compareVersion2("2", "2.5"));
	}
}

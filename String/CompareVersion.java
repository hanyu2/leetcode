package String;

public class CompareVersion {
	public static int compareVersion(String version1, String version2) {
		String[] str1=version1.split("\\.");  
	    String[] str2=version2.split("\\.");  
	    //获取需要比例的长度为两版本中长度的大者  
	    int length=Math.max(str1.length, str2.length);  
	    for (int i = 0; i < length; i++)  
	    {  
	        /* 
	         * 下面两行代码的意思将两版本的长度设置成一样 
	         * 如version1=1.1 version2=1.1.2 
	         * 执行完 int num1=i<str1.length?Integer.parseInt(str1[i]):0 后 
	         * version1=1.1.0，这样方便比较 
	         */  
	        int num1=i<str1.length?Integer.parseInt(str1[i]):0;  
	        int num2=i<str2.length?Integer.parseInt(str2[i]):0;  
	          
	        if (num1>num2)  
	        {  
	            return 1;  
	        }  
	        else if (num1<num2)  
	        {  
	            return -1;  
	        }  
	    }  
	    return 0;    
	}
	
	public static void main(String[] args) {
		System.out.println(compareVersion("01", "1"));
	}
}

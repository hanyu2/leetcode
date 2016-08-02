package String;

public class IntegerToEnglishWords {
	private static final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	private static final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };
	private static final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

	public static String numberToWords(int num) {
		if (num == 0)
			return "Zero";

		int i = 0;
		String words = "";

		while (num > 0) {
			if (num % 1000 != 0)
				words = helper(num % 1000) + THOUSANDS[i] + " " + words;
			num /= 1000;
			i++;
		}

		return words.trim();
	}

	private static String helper(int num) {
		if (num == 0)
			return "";
		else if (num < 20)
			return LESS_THAN_20[num] + " ";
		else if (num < 100)
			return TENS[num / 10] + " " + helper(num % 10);
		else
			return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
	}
	
	private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords2(int num) {
        if (num == 0) return "Zero";
        return helper(num); 
    }
    
    private String helper2(int num) {
        String result = new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num -10];
        else if (num < 100) result = belowHundred[num/10] + " " + helper2(num % 10);
        else if (num < 1000) result = helper2(num/100) + " Hundred " +  helper2(num % 100);
        else if (num < 1000000) result = helper2(num/1000) + " Thousand " +  helper2(num % 1000);
        else if (num < 1000000000) result = helper2(num/1000000) + " Million " +  helper2(num % 1000000);
        else result = helper2(num/1000000000) + " Billion " + helper2(num % 1000000000);
        return result.trim();
    }
	
	public static void main(String[] args) {
		System.out.println(numberToWords(1234567));
	}
}

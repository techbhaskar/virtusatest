import java.util.Scanner;

public class NumberToWord

{
    private static int num;
	private static final String[] multipleThousands = { "", " thousand", " million" };

	private static final String[] multipleTens = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] multipleOnes = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	public String convertLessThanOneThousand(int number) {
		try {
			String current;

			if (number % 100 < 20) {
				current = multipleOnes[number % 100];
				number /= 100;
			} else {
				current = multipleOnes[number % 10];
				number /= 10;

				current = multipleTens[number % 10] + current;
				number /= 10;
			}
			if (number == 0)
				return current;

			return multipleOnes[number] + " hundred" + current;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return "";
	}

	public String convertToWord(int number) {
		try {
			if (number == 0) {
				return "zero";
			}

			String prefix = "";

			if (number < 0) {
				number = -number;
				prefix = "negative";
			}

			String current = "";
			int place = 0;

			do {
				int n = number % 1000;
				if (n != 0) {
					String s = convertLessThanOneThousand(n);
					current = s + multipleThousands[place] + current;
				}
				place++;
				number /= 1000;
			} while (number > 0);

			return (prefix + current).trim();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return "";
	}

	public static void main(String[] args) {
		NumberToWord ntw = new NumberToWord();
		Scanner in=new Scanner(System.in);
        try
        {
          System.out.print("Please enter number to Convert into Words : ");
          num=in.nextInt();
          
        }
        catch(Exception e)
        {
         System.out.println("Enter only number from -99999999 to 999999999");
         System.exit(1);
        }
		System.out.println(">>>>>>>>>>>>> " + ntw.convertToWord(num));
	}
}
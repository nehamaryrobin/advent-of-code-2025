import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
You'll need to find the largest possible joltage each bank can produce. In the above example:

In 987654321111111, you can make the largest joltage possible, 98, by turning on the first two batteries.
In 811111111111119, you can make the largest joltage possible by turning on the batteries labeled 8 and 9, producing 89 jolts.
In 234234234234278, you can make 78 by turning on the last two batteries (marked 7 and 8).
In 818181911112111, the largest joltage you can produce is 92.
The total output joltage is the sum of the maximum joltage from each bank, so in this example, the total output joltage is 98 + 89 + 78 + 92 = 357.

There are many batteries in front of you. Find the maximum joltage possible from each bank; what is the total output joltage?
 */

public class Day3 {
    public static void main(String[] args) throws IOException {
        
        String inputFile = "input3.txt";
        BufferedReader input = new BufferedReader(new FileReader(inputFile));

        String line;
        long sum = 0;

        while ((line = input.readLine()) != null) {
            
            int n = line.length();
            int [] rightMax = new int[n];

            rightMax[n - 1] = line.charAt(n - 1) - '0';

            for (int i = n - 2; i >= 0; i--) {

                int digit = line.charAt(i) - '0';
                rightMax[i] = Math.max(digit, rightMax[i + 1]);
            }
            int maxJoltage = 0;

            for (int i = 0; i < n - 1; i++) {

                int firstDigit = line.charAt(i) - '0';
                int secondDigit = rightMax[i + 1];

                int num = firstDigit * 10 + secondDigit;
                maxJoltage = Math.max(maxJoltage, num);
            }  
            sum += maxJoltage; 
        }
        input.close();
        System.out.println(sum);
    }
}

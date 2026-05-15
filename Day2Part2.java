import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Day2Part2 {

    public static ArrayList<Integer> getFactors(int n) {

        ArrayList<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {

                factors.add(i);

                // avoid duplicate
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }

        Collections.sort(factors);

        return factors;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new FileReader("input2.txt"));

        String line;
        long sum = 0;

        while ((line = input.readLine()) != null) {

            String[] ranges = line.split(",");

            for (String range : ranges) {

                String[] nums = range.split("-");

                long start = Long.parseLong(nums[0]);
                long end = Long.parseLong(nums[1]);

                for (long i = start; i <= end; i++) {

                    String num = String.valueOf(i);

                    ArrayList<Integer> factors = getFactors(num.length());

                    boolean invalid = false;

                    for (int factor : factors) {

                        // skip full length
                        if (factor == num.length()) {
                            continue;
                        }

                        // must divide evenly
                        if (num.length() % factor != 0) {
                            continue;
                        }

                        String pattern = num.substring(0, factor);

                        boolean same = true;

                        // check every chunk
                        for (int j = factor; j < num.length(); j += factor) {

                            String part = num.substring(j, j + factor);

                            if (!part.equals(pattern)) {
                                same = false;
                                break;
                            }
                        }

                        if (same) {
                            invalid = true;
                            break;
                        }
                    }

                    if (invalid) {
                        sum += i;
                    }
                }
            }
        }

        input.close();

        System.out.println(sum);
    }
}
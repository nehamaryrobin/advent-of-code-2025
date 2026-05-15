import java.io.*;

public class Day2 {
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

                for(long i = start ; i <= end; i++) {

                    String num = String.valueOf(i);

                    if (num.length() % 2 != 0){
                        continue;
                    }

                    int mid = num.length() / 2;

                    String left = num.substring(0, mid);
                    String right = num.substring(mid);
            
                    
                    if(left.equals(right)) {
                        sum += i;
                    }
                    
                }
            }   

        }

        input.close();

        System.out.println(sum);
    }
}
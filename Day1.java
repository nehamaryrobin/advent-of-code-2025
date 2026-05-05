import java.io.*;

public class Day1 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input1.txt"));

        int pos = 50;
        int count = 0;

        String line;
        while ((line = input.readLine()) != null) {
            char direction = line.charAt(0);
            int value = Integer.parseInt(line.substring(1));

            if (direction == 'L') {
                //to prevent it from becoming negative, we add 100 before taking the modulus
                pos = (pos - value % 100 + 100) % 100;
            } else {
                pos = (pos + value % 100) % 100;
            }

            if (pos == 0) {
                count++;
            }
        }

        input.close();

        System.out.println(count);
    }
}
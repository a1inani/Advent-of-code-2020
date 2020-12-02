/* Author: Alinani */
/* 2/12/2020 */

/*
--- Part Two ---
While it appears you validated the passwords correctly, they don't seem to be what the Official Toboggan Corporate Authentication System is expecting.

The shopkeeper suddenly realizes that he just accidentally explained the password policy rules from his old job at the sled rental place down the street! The Official Toboggan Corporate Policy actually works a little differently.

Each policy actually describes two positions in the password, where 1 means the first character, 2 means the second character, and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!) Exactly one of these positions must contain the given letter. Other occurrences of the letter are irrelevant for the purposes of policy enforcement.

Given the same example list from above:

1-3 a: abcde is valid: position 1 contains a and position 3 does not.
1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
How many passwords are valid according to the new interpretation of the policies?
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Part2 {
    public static void main(String[] args) throws Exception {
        //read input from txt file
        File file = new File("/Users/Alinani/Desktop/Advent-of-code-2020/Day2/src/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int valid = 0;
        while((st = br.readLine()) != null) {
            //split each line into its constituent parts
            String[] parts = st.split(" ");
            String[] numbers = parts[0].split("-");
            int first = Integer.parseInt(numbers[0]);
            int second = Integer.parseInt(numbers[1]);
            String letter = parts[1].substring(0,1);
            String password = parts[2];
            int count = 0;
            if((password.charAt(first-1) == letter.charAt(0) && password.charAt(second-1) != letter.charAt(0)) ||
                    (password.charAt(second-1) == letter.charAt(0) && password.charAt(first-1) != letter.charAt(0))) {
                valid += 1;
            }
        }
        System.out.println(valid);
    }
}

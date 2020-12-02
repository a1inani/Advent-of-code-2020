/* Author: Alinani */
/* 2/12/2020 */

/*
--- Day 2: Password Philosophy ---
Your flight departs in a few days from the coastal airport; the easiest way down to the coast from here is via toboggan.

The shopkeeper at the North Pole Toboggan Rental Shop is having a bad day. "Something's wrong with our computers; we can't log in!" You ask if you can take a look.

Their password database seems to be a little corrupted: some of the passwords wouldn't have been allowed by the Official Toboggan Corporate Policy that was in effect when they were chosen.

To try to debug the problem, they have created a list (your puzzle input) of passwords (according to the corrupted database) and the corporate policy when that password was set.

For example, suppose you have the following list:

1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
Each line gives the password policy and then the password. The password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid. For example, 1-3 a means that the password must contain a at least 1 time and at most 3 times.

In the above example, 2 passwords are valid. The middle password, cdefg, is not; it contains no instances of b, but needs at least 1. The first and third passwords are valid: they contain one a or nine c, both within the limits of their respective policies.

How many passwords are valid according to their policies?
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Part1 {
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
            int min = Integer.parseInt(numbers[0]);
            int max = Integer.parseInt(numbers[1]);
            String letter = parts[1].substring(0,1);
            String password = parts[2];
            int count = 0;
            for(int i = 0; i<password.length(); i++) {
                if(password.charAt(i) == letter.charAt(0)) {
                    count += 1;
                }
            }
            if(count >= min && count <= max) {
                valid += 1;
            }
        }
        System.out.println(valid);
    }
}

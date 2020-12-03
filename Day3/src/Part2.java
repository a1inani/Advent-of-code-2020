/* Author: Alinani */
/* 3/12/2020 */

/*
--- Part Two ---
Time to check the rest of the slopes - you need to minimize the probability of a sudden arboreal stop, after all.

Determine the number of trees you would encounter if, for each of the following slopes, you start at the top-left corner and traverse the map all the way to the bottom:

Right 1, down 1.
Right 3, down 1. (This is the slope you already checked.)
Right 5, down 1.
Right 7, down 1.
Right 1, down 2.
In the above example, these slopes would find 2, 7, 3, 4, and 2 tree(s) respectively; multiplied together, these produce the answer 336.

What do you get if you multiply together the number of trees encountered on each of the listed slopes?
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Part2 {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/Alinani/Desktop/Advent-of-code-2020/Day3/src/input.txt");
        //cast result to long to avoid int max value limit
        System.out.println((long)right3down1(file) * right1down1(file) * right5down1(file) * right7down1(file) * right1down2(file));
    }

    public static int right3down1(File file) throws Exception {
        //read input from txt file
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int start = 0, down = 1, open = 0, tree = 0, next = 0;
        while((st = br.readLine()) != null) {
            if(next > 0) {
                if(st.charAt(start%st.length()) == '.') {
                    open += 1;
                } else {
                    tree += 1;
                }
                next = 0;
            }
            start += 3;
            next = 1;
        }
        return tree;
    }

    public static int right1down1(File file) throws Exception {
        //read input from txt file
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int start = 0, down = 1, open = 0, tree = 0, next = 0;
        while((st = br.readLine()) != null) {
            if(next > 0) {
                if(st.charAt(start%st.length()) == '.') {
                    open += 1;
                } else {
                    tree += 1;
                }
                next = 0;
            }
            start += 1;
            next = 1;
        }
        return tree;
    }

    public static int right5down1(File file) throws Exception {
        //read input from txt file
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int start = 0, down = 1, open = 0, tree = 0, next = 0;
        while((st = br.readLine()) != null) {
            if(next > 0) {
                if(st.charAt(start%st.length()) == '.') {
                    open += 1;
                } else {
                    tree += 1;
                }
                next = 0;
            }
            start += 5;
            next = 1;
        }
        return tree;
    }

    public static int right7down1(File file) throws Exception {
        //read input from txt file
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int start = 0, down = 1, open = 0, tree = 0, next = 0;
        while((st = br.readLine()) != null) {
            if(next > 0) {
                if(st.charAt(start%st.length()) == '.') {
                    open += 1;
                } else {
                    tree += 1;
                }
                next = 0;
            }
            start += 7;
            next = 1;
        }
        return tree;
    }

    public static int right1down2(File file) throws Exception {
        //read input from txt file
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int start = 0, down = 1, open = 0, tree = 0, next = 0;
        while((st = br.readLine()) != null) {
            if(next == 2) {
                next = 1;
            } else if(next == 1) {
                if(st.charAt(start%st.length()) == '.') {
                    open += 1;
                } else {
                    tree += 1;
                }
                start += 1;
                next = 2;
            } else {
                start += 1;
                next = 2;
            }
        }
        return tree;
    }
}

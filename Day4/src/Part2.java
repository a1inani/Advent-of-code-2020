/* Author: Alinani */
/* 4/12/2020 */

/*
--- Part Two ---
The line is moving more quickly now, but you overhear airport security talking about how passports with invalid data are getting through. Better add some data validation, quick!

You can continue to ignore the cid field, but each other field has strict rules about what values are valid for automatic validation:

byr (Birth Year) - four digits; at least 1920 and at most 2002.
iyr (Issue Year) - four digits; at least 2010 and at most 2020.
eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
hgt (Height) - a number followed by either cm or in:
If cm, the number must be at least 150 and at most 193.
If in, the number must be at least 59 and at most 76.
hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
pid (Passport ID) - a nine-digit number, including leading zeroes.
cid (Country ID) - ignored, missing or not.
Your job is to count the passports where all required fields are both present and valid according to the above rules. Here are some example values:

byr valid:   2002
byr invalid: 2003

hgt valid:   60in
hgt valid:   190cm
hgt invalid: 190in
hgt invalid: 190

hcl valid:   #123abc
hcl invalid: #123abz
hcl invalid: 123abc

ecl valid:   brn
ecl invalid: wat

pid valid:   000000001
pid invalid: 0123456789
Here are some invalid passports:

eyr:1972 cid:100
hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926

iyr:2019
hcl:#602927 eyr:1967 hgt:170cm
ecl:grn pid:012533040 byr:1946

hcl:dab227 iyr:2012
ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277

hgt:59cm ecl:zzz
eyr:2038 hcl:74454a iyr:2023
pid:3556412378 byr:2007
Here are some valid passports:

pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
hcl:#623a2f

eyr:2029 ecl:blu cid:129 byr:1989
iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm

hcl:#888785
hgt:164cm byr:2001 iyr:2015 cid:88
pid:545766238 ecl:hzl
eyr:2022

iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719
Count the number of valid passports - those that have all required fields and valid values. Continue to treat cid as optional. In your batch file, how many passports are valid?
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import static java.lang.Integer.parseInt;

public class Part2 {
    public static void main(String[] args) throws Exception {
        //read input from txt file
        File file = new File("/Users/Alinani/Desktop/Advent-of-code-2020/Day4/src/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String fullString = "";
        while((st = br.readLine()) != null) {
            fullString += st + "\n";
        }
        System.out.println(Arrays.stream(fullString.split("\n\n")).filter(Part2::checkValidity).filter(Part2::allFieldsCorrect).count());
    }

    public static boolean checkValidity(String passport) {
        String[] data = passport.replace("\n", " ").split(" ");
        if(data.length == 8) return true;
        if(data.length == 6) return false;
        return passport.contains("byr") && passport.contains("iyr") && passport.contains("eyr") && passport.contains("hgt")
                && passport.contains("hcl") && passport.contains("ecl") && passport.contains("pid");
    }

    public static boolean allFieldsCorrect(String passport) {
        String[] data = passport.replace("\n", " ").split(" ");
        return Arrays.stream(data).noneMatch(Part2::fieldNotCorrect);

    }

    public static boolean fieldNotCorrect(String field) {
        String[] split = field.split(":");
        switch (split[0]) {
            case "byr" : return !isValidNumber(parseInt(split[1]), 1920, 2002);
            case "iyr" : return !isValidNumber(parseInt(split[1]), 2010, 2020);
            case "eyr" : return !isValidNumber(parseInt(split[1]), 2020, 2030);
            case "hgt" : return !isValidHeight(split[1]);
            case "hcl" : return !isValidHairColor(split[1]);
            case "ecl" : return !isValidEyeColor(split[1]);
            case "pid" : return !isValidPassportId(split[1]);
            case "cid" : return false;
        }
        return true;
    }

    /**
     * pid (Passport ID) - a nine-digit number, including leading zeroes.
     */
    public static boolean isValidPassportId(String passportId) {
        if (passportId.length() != 9) {
            return false;
        }
        try {
            parseInt(passportId);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    /**
     * ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
     */
    public static boolean isValidEyeColor(String eyeColor) {
        return "amb".equals(eyeColor) || "blu".equals(eyeColor) || "brn".equals(eyeColor) || "gry".equals(eyeColor)
                || "grn".equals(eyeColor) || "hzl".equals(eyeColor) || "oth".equals(eyeColor);
    }

    /**
     * hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
     */
    public static boolean isValidHairColor(String hairColor) {
        if(hairColor.length() != 7 || hairColor.charAt(0) != '#') {
            return false;
        }
        try {
            Long.parseLong(hairColor.substring(1), 16);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * hgt (Height) - a number followed by either cm or in:
     * If cm, the number must be at least 150 and at most 193.
     * If in, the number must be at least 59 and at most 76.
     */
    public static boolean isValidHeight(String height) {
        if (height.contains("cm")) {
            return isValidNumber(parseInt(height.replace("cm", "")), 150, 193);
        }
        return isValidNumber(parseInt(height.replace("in", "")), 59, 76);
    }

    public static boolean isValidNumber(int num, int min, int max) {
        return num >= min && num <= max;
    }
}

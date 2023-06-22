import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    static int[] arabic = {1, 4, 5, 9, 10, 40, 50, 90, 100};
    static String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};

    public static String convert(int num) {
        String result = "";
        do {
            for (int i = arabic.length - 1; i >= 0; i--) {
                if (arabic[i] <= num) {
                    num -= arabic[i];
                    result += roman[i];
                    break;
                }
            }

        } while (num > 0);
        return result;
    }

    public static Map<String, Integer> romanToArabic = new HashMap<>();
    public static Map<Integer, String> arabicToRoman = new HashMap<>();

    static {
        romanToArabic.put("I", 1);
        romanToArabic.put("II", 2);
        romanToArabic.put("III", 3);
        romanToArabic.put("IV", 4);
        romanToArabic.put("V", 5);
        romanToArabic.put("VI", 6);
        romanToArabic.put("VII", 7);
        romanToArabic.put("VIII", 8);
        romanToArabic.put("IX", 9);
        romanToArabic.put("X", 10);

        arabicToRoman.put(1, "I");
        arabicToRoman.put(2, "II");
        arabicToRoman.put(3, "III");
        arabicToRoman.put(4, "IV");
        arabicToRoman.put(5, "V");
        arabicToRoman.put(6, "VI");
        arabicToRoman.put(7, "VII");
        arabicToRoman.put(8, "VIII");
        arabicToRoman.put(9, "IX");
        arabicToRoman.put(10, "X");
    }

    public static boolean isArabic(char a) {
        int num = (int) a;
        if (num >= 48 && num <= 57)
            return true;
        else return false;
    }

    public static String calc(String input) {
        boolean calcstate = false;
        String[] parts = input.split("\\s+");
        if (isArabic(parts[0].charAt(0)) && isArabic(parts[2].charAt(0))) {
            calcstate = true;
        }

        int a;
        int b;
        if (calcstate) {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
            if ((a < 1 || a > 10) || (b < 1 || b > 10)) {
                throw new IllegalArgumentException("Invalid number format");
            }
        } else {

            a = romanToArabic.get(parts[0]);
            b = romanToArabic.get(parts[2]);
            if ((a < 1 || a > 10) || (b < 1 || b > 10)) {
                throw new IllegalArgumentException("Invalid number format");
            }
        }

        int result = 0;
        switch (parts[1]) {

            case "+":
                result = a + b;
                System.out.println(a + " + " + b + " = ");
                break;

            case "-":
                result = a - b;
                System.out.println(a + " - " + b + " = ");
                break;

            case "*":
                result = a * b;
                System.out.println(a + " * " + b + " = ");
                break;

            case "/":
                result = a / b;
                System.out.println(a + " / " + b + " = ");
                break;

            default:
                System.out.println("Invalid operator!");
                break;

        }
            // case "+":
            //       result = a + b;
            //      break;
            //  case "-":
            //     result = a - b;
            //      break;
            // case "/":
            //     result = a / b;
            //     break;
            //  case "*":
            //      result = a * b;
            //      break;
            //  }

            // if(parts[1]!="+"&&parts[1]!="-"&&parts[1]!="/"&&parts[1]!="*"){
            //     throw new IllegalArgumentException("Invalid symbol format");
            //  }
            if (!calcstate) {
                if (result <= 0) throw new IllegalArgumentException("Invalid result");
                return convert(result);

            }
            return Integer.toString(result);
        }


        public static void main (String[]args){
            boolean calcstate = false;
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            //     String input="I + VII";
            String[] parts = input.split("\\s+");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid input format");
            }
            if (isArabic(parts[0].charAt(0)) != isArabic(parts[2].charAt(0))) {
                throw new IllegalArgumentException("Invalid number format");
            }
            System.out.println(calc(input));

        }

    }






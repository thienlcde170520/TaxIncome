
package common;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Library {
    
    static Scanner sc = new Scanner(System.in);
    /*
    public int inputIntLimit(int min, int max) {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                
            }
        }
    }*/
    
    public String getString(String promt) {
        String s;
        do {
            System.out.print(promt);
            s = sc.nextLine();
        } while (s.equalsIgnoreCase(""));
        return s;
    }
    public double inputIncome(String title) {
        double a = -1;
        while (a < 0) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(title + ": ");
                a = sc.nextDouble();
                if (a < 0) {
                    throw new Exception();
                }
            } catch (InputMismatchException e) {
                System.err.println("Please input digit");
                a = -1;
            } catch (Exception e) {
                System.err.println("Please input a > 0");
            }
        }
        return a;
    }
    
    public String inputStringMatch(String title, String regex) {
        String s = "";
        while (!s.matches(regex)) {
            Scanner sc = new Scanner(System.in);
            System.out.print(title + ": ");
            s = sc.nextLine();
        }
        return s;
    }
    public int inputInt(String title, int min, int max) {
        int a = -1;
        while (a < min || a > max) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(title + ": ");
                a = sc.nextInt();
                if (a < min || a > max) {
                    throw new Exception();
                }
            } catch (InputMismatchException e) {
                System.err.println("Please input digit");
                a = -1;
            } catch (Exception e) {
                System.err.println("Please input " + min + "<a<" + max);
            }
        }
        return a;
    }
    public boolean inputBoolean(String title) {
        return inputInt(title, 0, 1) == 1;
    }
}

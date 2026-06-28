package scanner;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        int i = sc.nextInt();
        System.out.println("Enter the second number");
        int j = sc.nextInt();
        System.out.println("The sum of both is :" + (i+j));
        sc.close();
    }
}

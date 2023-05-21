package dsa.com.homework1;

import java.util.Scanner;

public class SinX{
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        float x, sin = 0;
        System.out.println("Nhập giá trị x: ");
        x = scanner.nextFloat();
        int n = 0;
        while (Math.abs(Factory(x, n)) > 0.00001){
            sin += Factory(x, n);
            n++;
        }
        System.out.println("Giá trị sin(x): " + sin);
    }

    public static float Factory(float x, int n){
        int a;
        if(n % 2 == 0){
            a = 1;
        } else {
            a = -1;
        }
        float f = 1;
        for (int i = 1; i <= 2*n +1; i++){
            f = f*x/i;
        }
        return a*f;
    }
}
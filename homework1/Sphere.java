package dsa.com.homework1;

import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Math.*;

public class Sphere {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        double r, x, y, z, S ,V, d;

        System.out.println("Nhập các gtri x, y ,z, d: ");
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        z = scanner.nextDouble();
        d = scanner.nextDouble();
        r = sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2) - d);
        S = 4 * PI * pow(r, 2);
        V = PI * pow(r, 3);
        DecimalFormat df = new DecimalFormat("#,##");
        System.out.println("R = " + df.format(r));
        System.out.println("Diện tích mặt cầu: " + df.format(S));
        System.out.println("Thể tích mặt cầu: " + df.format(V));

    }
}

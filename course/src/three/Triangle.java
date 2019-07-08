package three;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {

    public static String check(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "NO";
        }

        if (a == b && b == c) {
            return "DB";
        }

        if (a == b || b == c || a == c) {
            return "DY";
        }

        if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
            return "ZJ";
        }

        return "YB";
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入第一条边长");
            int a = scanner.nextInt();
            System.out.println("请输入第二条边长");
            int b = scanner.nextInt();
            System.out.println("请输入第三条边长");
            int c = scanner.nextInt();
            System.out.println(check(a, b, c));
        } catch (InputMismatchException e) {
            System.out.println("输入的三角形边长非整数！");
        }
    }
}

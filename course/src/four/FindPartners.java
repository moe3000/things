package four;

import java.util.Scanner;

public class FindPartners {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入同学个数");
        String sum = scanner.nextLine();
        System.out.println("请输入同学学号，以空格分隔");
        String numStr = scanner.nextLine();
        String[] num = numStr.split(" ");

        if (!String.valueOf(num.length).equals(sum)) {
            System.out.println("输入的学号个数和同学个数不等");
            return;
        }

        int half = num.length / 2;
        int remainder = num.length % 2;
        for (int i = 0; i < half; i++) {
            if (i == half - 1 && remainder != 0) {
                System.out.println(num[i] + " " + num[i + 1] + " " + num[num.length - i - 1]);
            } else {
                System.out.println(num[i] + " " + num[num.length - i - 1]);
            }
        }
    }


}

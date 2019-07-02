package two;

import java.util.Random;

public class TestOperation {


    public static void main(String[] args) {
        char[] operators = new char[]{'+', '-', '*', '/'};

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            Calculation calculation = new Calculation(
                    random.nextInt(101),
                    random.nextInt(101),
                    operators[random.nextInt(4)]);
            calculation.printOperation();
        }
    }
}

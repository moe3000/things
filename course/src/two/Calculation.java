package two;

public class Calculation extends Operation {

    public Calculation(int operand1, int operand2, char operator) {
        super();
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    @Override
    public int operation() {
        if (operator == '+') {
            return operand1 + operand2;
        }

        if (operator == '-') {
            return operand1 - operand2;
        }

        if (operator == '*') {
            return operand1 * operand2;
        }

        if (operator == '/') {
            return operand1 / operand2;
        }
        throw new RuntimeException("不支持的运算符");
    }

    @Override
    public void printOperation() {
        System.out.println("" + operand1 + operator + operand2 + "=" + operation());
    }
}

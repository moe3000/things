package one;

public class WaterFee {

    class Stage {
        //档位起始
        int start;

        //档位结束
        int end;

        //价格
        double price;

        //档位全部
        int full;

        Stage(int start, int end, double price) {
            this.start = start;
            this.end = end;
            this.price = price;
            this.full = end - start;
        }
    }

    private double calculate(double one, double two, double three, double four, double five, double six) {
        Stage first = new Stage(0, 216, 2.90d);
        Stage second = new Stage(216, 300, 3.85d);
        Stage third = new Stage(300, Integer.MAX_VALUE, 6.70d);

        double sumUse = one + two + three + four + five + six;

        //不满第一档
        if (sumUse <= first.end) {
            return first.price * sumUse;
        }

        //不满第二档
        if (sumUse <= second.end) {
            return first.price * first.full + (sumUse - first.end) * second.price;
        }

        //第三档
        return first.price * first.full + second.full * second.price + (sumUse - second.end) * third.price;
    }


    public static void main(String[] args) {
        WaterFee waterFee = new WaterFee();
        double pay = waterFee.calculate(50, 45, 55, 60, 50, 50);
        System.out.println(pay);
    }
}

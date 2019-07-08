package six;

import java.io.*;
import java.util.Scanner;

public class RecordScore {


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请开始输入成绩");
        String line;
        double scoreSum = 0;
        int num = 0;
        while ((line = scanner.nextLine()) != null) {
            if (line.equals("end#")) {
                //结束
                break;
            }

            if (!line.contains(" ")) {
                System.out.println("输入的格式或成绩有误");
                continue;
            }

            //拆分数据
            String[] s = line.split(" ");

            //累计总分 和 人数
            scoreSum = scoreSum + Double.parseDouble(s[1]);
            num++;
            sb.append(line);
            sb.append("\r\n");
        }

        //计算平均分
        double score = scoreSum / num;
        sb.append("平均成绩：");
        sb.append(score);

        //写入文件
        File file = new File("score.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        byte[] bytes = sb.toString().getBytes();
        int b = bytes.length;
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes, 0, b);
        fos.close();
        System.out.println("成绩统计完成");
    }
}

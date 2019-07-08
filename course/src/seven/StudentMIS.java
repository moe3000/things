package seven;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMIS {

    private File file = new File("student.txt");

    private List<Student> students = new ArrayList<>();

    private Student readFromLine(String line) {
        String[] column = line.split(",");
        if (column.length != 4) {
            throw new MISException("数据有误，请检查文件");
        }
        return new Student(column[0], column[1], column[2], column[3]);
    }

    private void createIfFileNotExist() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    private void readFromFile() throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            Student student = readFromLine(line);
            students.add(student);
        }
        bufferedReader.close();
        fileReader.close();
    }

    private void start() {
        try {
            createIfFileNotExist();
            //读取文件数据
            System.out.println("系统启动，读取文件数据中");
            readFromFile();
            //显示菜单文字
            Scanner scanner = new Scanner(System.in);
            System.out.println("文件读取完成，请选择以下操作，输入括号内英文开始操作");
            System.out.println("增加(I)、修改(U)、删除(D)、显示(L)、保存(S)、退出(exit)");
            //读取操作
            String operation;
            while ((operation = scanner.nextLine())!=null) {
                if (operation.equals("exit")) {
                    break;
                }

                switch (operation) {
                    case "I":
                        System.out.println("开始增加");
                        System.out.println("请输入");
                    case "U":
                        System.out.println("开始修改");

                    case "D":
                        System.out.println("开始删除");

                    case "L":
                        System.out.println("开始显示");
                        for (Student student :
                                students) {
                            System.out.println(student);
                        }
                    case "S":
                        System.out.println("开始保存");

                    default:
                        System.out.println("请选择正确的操作");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("student.txt文件异常，可能被占用");
        }
    }

    public static void main(String[] args) {
        StudentMIS mis = new StudentMIS();
        mis.start();
    }
}

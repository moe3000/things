package seven;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
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
        return new Student(Integer.parseInt(column[0]), column[1], column[2], column[3]);
    }

    private void createIfFileNotExist() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    private String writeToLine(Student student) {
        return student.getNo() + "," + student.getName() + "," + student.getSex() + "," + student.getMajor();
    }

    private void writeToFile() throws IOException {
        System.out.println("开始保存");
        StringBuilder sb = new StringBuilder();
        for (Student student :
                students) {
            sb.append(writeToLine(student));
            sb.append("\r\n");
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(sb.toString());
        fileWriter.flush();
        fileWriter.close();
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

    private String getInput(Scanner scanner) {
        //TODO 获取其他类型输入校验
        String input;
        while ((input = scanner.nextLine()) != null) {
            if (input.trim().equals("")) {
                System.out.println("请输入非空数据");
                continue;
            }
            return input;
        }
        return "";
    }

    private void addStudent(Scanner scanner) {
        System.out.println("开始增加");
        Student addStudent = new Student();
        System.out.println("学号(只允许数字):");
        String no = getInput(scanner);
        addStudent.setNo(Integer.parseInt(no));
        System.out.println("姓名:");
        String name = getInput(scanner);
        addStudent.setName(name);
        System.out.println("性别:");
        String sex = getInput(scanner);
        addStudent.setSex(sex);
        System.out.println("专业:");
        String major = getInput(scanner);
        addStudent.setMajor(major);
        students.add(addStudent);
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getNo() - o2.getNo();
            }
        });
    }

    private void updateStudent(Scanner scanner) {
        System.out.println("开始修改");
        Student student = null;
        do {
            System.out.println("请先输入学号(只允许数字):");
            String noStr = getInput(scanner);
            int no = Integer.parseInt(noStr);
            for (Student s :
                    students) {
                if (s.getNo() == no) {
                    student = s;
                }
            }
            if (student == null) {
                System.out.println("没有查到该学生，请重新操作，输入back返回上一级操作，其他则继续修改");
                String operation = scanner.nextLine();
                if ("back".equals(operation)) {
                    return;
                }
            } else {
                System.out.println("请输入");
                System.out.println("姓名:");
                String name = getInput(scanner);
                student.setName(name);
                System.out.println("性别:");
                String sex = getInput(scanner);
                student.setSex(sex);
                System.out.println("专业:");
                String major = getInput(scanner);
                student.setMajor(major);
            }
        } while (student == null);
    }

    private void deleteStudent(Scanner scanner) {
        System.out.println("开始删除");
        int index = -1;
        do {
            System.out.println("请先输入学号(只允许数字):");
            String noStr = getInput(scanner);
            int no = Integer.parseInt(noStr);
            for (Student s :
                    students) {
                if (s.getNo() == no) {
                    index = s.getNo();
                }
            }
            if (index < 0) {
                System.out.println("没有查到该学生，请重新操作，输入back返回上一级操作，其他则继续修改");
                String operation = scanner.nextLine();
                if ("back".equals(operation)) {
                    return;
                }
            } else {
                students.remove(index - 1);
            }
        } while (index < 0);
    }

    private void start() {
        try {
            createIfFileNotExist();
            //读取文件数据
            System.out.println("系统启动，读取文件数据中");
            readFromFile();
            //显示菜单文字
            Scanner scanner = new Scanner(System.in);
            System.out.println("文件读取完成，请选择以下操作，输入括号内英文开始操作，回车键确认");
            System.out.println("增加(I)、修改(U)、删除(D)、显示(L)、保存(S)、退出(exit)");
            //读取操作
            String operation;
            while ((operation = scanner.nextLine()) != null) {
                if (operation.equals("exit")) {
                    //退出时保存文件
                    writeToFile();
                    System.out.println("保存完毕，bye~");
                    break;
                }

                switch (operation) {
                    case "I":
                        addStudent(scanner);
                        break;
                    case "U":
                        updateStudent(scanner);
                        break;
                    case "D":
                        deleteStudent(scanner);
                        break;
                    case "L":
                        System.out.println("开始显示");
                        for (Student student :
                                students) {
                            System.out.println(student);
                        }
                        break;
                    case "S":
                        writeToFile();
                        break;
                    default:
                        System.out.println("请选择正确的操作");
                }
                System.out.println("操作完成");
                System.out.println("请选择以下操作，输入括号内英文开始操作，回车键确认");
                System.out.println("增加(I)、修改(U)、删除(D)、显示(L)、保存(S)、退出(exit)");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("student.txt文件异常，可能被占用");
        } catch (MISException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        StudentMIS mis = new StudentMIS();
        mis.start();
    }
}

package CoreJava.DAO;

import CoreJava.Models.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {
    public List<Student> getStudents(){
        List<Student> studentList = new ArrayList<>();
        File studentFile = new File("C:\\Users\\chino\\Desktop\\students.csv");
        String email, name, pass;
        try {
            Scanner scanStuList = new Scanner(studentFile);
            while(scanStuList.hasNextLine()){
                String[] partitions = scanStuList.nextLine().split(",");
                email = partitions[0];
                name = partitions[1];
                pass = partitions[2];
                Student student = new Student(name, email, pass);
                studentList.add(student);

            }


        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        return studentList;
    }

    public Student getStudentByEmail(List<Student> studentList, String studentEmail){
        System.out.println("size of student= " + studentList.size());
        Student match = new Student();
        for(int i = 0; i<studentList.size();i++){
            if(studentList.get(i).getEmail().equals(studentEmail)){
                match = studentList.get(i);
            }
        }
        return match;
    }

    public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass){
        Student match = new Student();
        for(int i = 0; i<studentList.size();i++){
            if(studentList.get(i).getEmail().equals(studentEmail) && studentList.get(i).getPass().equals(studentPass)){
                return true;
            }
        }
        return false;
    }
}

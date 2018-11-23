package CoreJava.DAO;

import CoreJava.Models.Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseDAO {
    public List<Course> getAllCourses(){
        List<Course> courseList = new ArrayList<>();
        File courseFile = new File("C:\\Users\\chino\\Desktop\\courses.csv");
        int ID; String name, instructor;

        try {
            Scanner courseReader = new Scanner(courseFile);
            while(courseReader.hasNextLine()){
                String[] partitions =  courseReader.nextLine().split(",");
                ID = Integer.parseInt(partitions[0]);
                instructor = partitions[1];
                name = partitions[2];
                Course course = new Course(ID, name, instructor);
                courseList.add(course);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        return courseList;
    }
}

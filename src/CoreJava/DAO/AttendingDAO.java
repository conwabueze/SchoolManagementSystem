package CoreJava.DAO;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendingDAO {

    public List<Attending> getAttending(){
        List<Attending> attendingList = new ArrayList<>();
        File attendingFile = new File("C:\\Users\\chino\\Desktop\\attending.csv");
        int courseID; String studentEmail;

        try {
            Scanner attendingReader = new Scanner(attendingFile);
            while(attendingReader.hasNextLine()){
                String[] partitions =  attendingReader.nextLine().split(",");
                courseID = Integer.parseInt(partitions[0]);
                studentEmail = partitions[1];

                Attending attending = new Attending(courseID, studentEmail);
                attendingList.add(attending);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        return attendingList;
    }

    public void registerStudentToCourse(List<Attending> attending, String studentEmail, int courseID){
        boolean isThere = false;
        for(int i =0; i<attending.size();i++){
            if(attending.get(i).getCourseID()==courseID && attending.get(i).getStudentEmail().equals(studentEmail)){
                isThere=true;
            }
        }
        if(isThere==false){
                Attending newAttendee = new Attending(courseID, studentEmail);
                attending.add(newAttendee);
                saveAttending(attending);
        }
    }

    public List<Course> getStudentCourses(List<Course> courseList, List<Attending> attending, String studentEmail){
        List<Course> getCourses =  new ArrayList<>();
        for(int i = 0; i<attending.size(); i++){
            if(attending.get(i).getStudentEmail().equals(studentEmail)){
                int courseID=attending.get(i).getCourseID();
                for(int x = 0; x<courseList.size(); x++){
                    if(courseList.get(x).getID()==courseID){
                        getCourses.add(courseList.get(x));
                    }
                }
            }
        }
        return getCourses;
    }

    public void saveAttending(List<Attending> attending){
        File overWrite = new File("C:\\Users\\chino\\Desktop\\attending.csv");
        final String comma = ",";
        final String newLine = "\n";
        try{
            FileWriter writer = new FileWriter(overWrite);
            for(int i = 0; i<attending.size(); i++){
                String ID = attending.get(i).getCourseID() + "";
                String studentEmail = attending.get(i).getStudentEmail();
                writer.write(ID);
                writer.write(comma);
                writer.write(studentEmail);
                writer.write(newLine);
            }
            writer.close();

        }catch (IOException e){
            System.out.println("Somethings wrong");
        }

    }

}

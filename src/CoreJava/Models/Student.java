package CoreJava.Models;

public class Student {

    private String name;
    private String email;
    private String pass;

    public Student() {
        name = "";
        email="";
        pass="";
    }

    public Student(String name, String email, String pass) {
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getPass(){
        return pass;
    }
}

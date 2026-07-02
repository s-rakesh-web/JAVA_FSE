package JAVA;

class Student{
    private String name;
    private int Id;
    private String grade;

    public Student(String name,int Id ,String grade){
        this.name=name;
        this.Id=Id;
        this.grade=grade;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.Id;
    }
    public String getGrade(){
        return this.grade;
    }

}

class StudentView{
    public void display(String name,int Id,String grade){
        System.out.println("Name:"+name+
                "\nId:"+Id+
                "\ngrad:"+grade);
    }
}

class StudentController{
    Student student;
    StudentView view;
    public StudentController(Student student,StudentView view){
        this.student=student;
        this.view=view;
    }

    public void setName(String name){
        student.setName(name);
    }

    public void viewStudent(){
        view.display(student.getName(), student.getId(), student.getGrade());
    }
}






public class MVC_PatternExample {
    public static void main(String[] args){

        Student student=new Student("Rakesh",123,"A");
        StudentView view=new StudentView();
        StudentController sc=new StudentController(student,view);
        sc.viewStudent();

        System.out.println("\n-----Changes made -----\n");

        sc.setName("Ragu");
        sc.viewStudent();
    }
}

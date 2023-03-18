package Compulsatory;

import java.util.Scanner;

public class Project implements Comparable {
    private String name;
    private int complexity;

    private Student student;

    public Project(String name, int complexity) {
        student = null;
        this.name = name;
        this.complexity = complexity;
    }

    public int compareTo(Object o) {

        if(o==null){
            throw new NullPointerException("Null argument");
        }

        if(!(o instanceof Project)){
            throw new ClassCastException("Not a project");
        }

        return name.compareTo(((Project) o).name);
    }

    public static String parameter() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void setName() {
        this.name = parameter();
    }

    public String getName() {
        return name;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}

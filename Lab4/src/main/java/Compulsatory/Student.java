package Compulsatory;

import Compulsatory.Project;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Student implements Comparable {
    private String name;
    private List<Project> projectList;

    public Student(String name) {
        this.name = name;
        projectList = new Vector<Project>(5);
    }

    public int compareTo(Object o) {
        if (o == null) {
            throw new NullPointerException("Argument is null");
        }

        if (!(o instanceof Student)) {
            throw new ClassCastException("NOT A STUDENT");
        }

        return name.compareTo(((Student) o).name);
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

    public void addProject(Project project) {
        projectList.add(project);
    }
}

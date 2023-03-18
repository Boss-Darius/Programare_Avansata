package org.example;

import Compulsatory.Student;
import Compulsatory.Project;

import java.util.*;
import java.util.stream.*;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        Student student1 = new Student(null);
        Student student2 = new Student(null);
        Student student3 = new Student(null);

        Project p1 = new Project("QuizzGame", 2);
        Project p2 = new Project("P2P", 3);

        List<Student> studentList = new LinkedList<>();
        Set<Project> projectSet = new TreeSet<>();

        projectSet.add(p1);
        projectSet.add(p2);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        System.out.println("Initializare studenti din stream");
        Stream<Student> studentStream = studentList.stream();
        studentStream.forEach(x -> x.setName());

        Stream<Student> studentStream1 = studentList.stream();
        studentStream1.sorted().forEach(x -> System.out.println(x.getName()));

        Stream<Project> projectStream = projectSet.stream();
        System.out.println("Initializare proiecte din stream");

        projectStream.forEach(x -> x.setName());

        Stream<Project> projectStream1 = projectSet.stream();
        projectStream1.sorted().forEach(x -> System.out.println(x.getName()));

    }
}

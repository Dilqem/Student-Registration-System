/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import beans.Student;
import static myprojects.studentregistrationsystem.main.students;

/**
 *
 * @author V&V
 */
public class StudentUtil {
    public static void updateStudentWithNewObject() {
        StudentUtil.printAllRegisteredStudents();
        int a = InputUtil.requireNumber("Nechenci telebede deyishiklik etmek isteyirsiniz?");
        Student s = StudentUtil.fillStudent();
        students[a - 1] = s;
    }
    
    public static void updateStudentWithSameObject(){
        int i = InputUtil.requireNumber("Nechenci adamda deyishiklik etmek isteyirsiniz?");
        String changeParams = InputUtil.requireText("Neleri deyishmek isteyirsiniz? mes: 'name','surname'");
        if(changeParams.contains("'name'"))
        students[i].setName(InputUtil.requireText("name")); 
        else if(changeParams.contains("'surname'"))
        students[i].setSurname(InputUtil.requireText("surname")); 
        else if(changeParams.contains("'classname'"))
        students[i].setClassName(InputUtil.requireText("class name")); 
        else if(changeParams.contains("'age'"))
        students[i].setAge(InputUtil.requireNumber("age")); 
    }
    
    public static void updateStudentWithSplit() {
        int i = InputUtil.requireNumber("Nechenci adamda deyishiklik etmek isteyirsiniz?");
        String changeParams = InputUtil.requireText("Neleri deyishmek isteyirsiniz? mes: name,surname,age");
        String[] parametrs = changeParams.split(",");
        for (int j = 0; j < parametrs.length; j++) {
            if (parametrs[i].equalsIgnoreCase("name")) {
                students[i].setName(InputUtil.requireText("name"));
            } else if (parametrs[i].equalsIgnoreCase("surname")) {
                students[i].setSurname(InputUtil.requireText("surname"));
            } else if (parametrs[i].equalsIgnoreCase("class name")) {
                students[i].setClassName(InputUtil.requireText("class name"));
            } else if (parametrs[i].equalsIgnoreCase("age")) {
                students[i].setAge(InputUtil.requireNumber("age"));
            }
        }
    }

    public static Student fillStudent() {
        String name = InputUtil.requireText("enter name");
        String surname = InputUtil.requireText("enter surname");
        String className = InputUtil.requireText("enter classname");
        int age = InputUtil.requireNumber("enter age");

        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void printAllRegisteredStudents() {
        if (students == null) {
            return;
        }
        for (int i = 0; i < students.length; i++) {
            Student st = students[i];
            System.out.println(st.getFullName());
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requireNumber("How many student do you want to register?");
        students = new Student[count];
        for (int i = 0; i < count; i++) {
            System.out.println(i + 1 + ".Register");
            students[i] = StudentUtil.fillStudent();
        }
        System.out.println("Registration is successful");
        StudentUtil.printAllRegisteredStudents();
    }
    
    public static void findStudentAndPrint() {
        String text  = InputUtil.requireText("Type name,surname or classname");
        Student[] result = StudentUtil.findStudents(text);
        for (int i = 0; i < result.length; i++) {
                System.out.println(i+1+"."+result[i].getFullName());
        }
    }
    
    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            Student st = students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int found = 0;
        for (int i = 0; i < students.length; i++) {
            Student st = students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                result[found++]=st;
                
            }
        }
        return result;
    }
}

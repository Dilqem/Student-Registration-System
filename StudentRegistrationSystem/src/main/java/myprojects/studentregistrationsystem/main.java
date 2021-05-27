/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprojects.studentregistrationsystem;

import beans.Student;
import java.util.Scanner;
import Util.InputUtil;
import Util.StudentUtil;
import java.util.Arrays;

/**
 *
 * @author V&V
 */
public class main {

    public static Student[] students = null;

    public static void main(String[] args) {
        while (true) {
            int menu = InputUtil.requireNumber("What do you want to do"
                    + "\n1.Register Student"
                    + "\n2.Show all Students"
                    + "\n3.Find Student"
                    + "\n4.Update Student");
            switch (menu) {
                case 1:
                    StudentUtil.registerStudents();
                    break;
                case 2:
                    StudentUtil.printAllRegisteredStudents();
                    break;
                case 3:
                    StudentUtil.findStudentAndPrint();
                    break;
                case 4:
                    StudentUtil.updateStudentWithNewObject();
                    break;
                default:
                    break;
            }

        }
    }

}

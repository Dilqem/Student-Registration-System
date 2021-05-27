/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Scanner;

/**
 *
 * @author V&V
 */
public class InputUtil {
    public static String requireText(String title){
        System.out.println(title +":");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        return answer;
    }
    
    public static int requireNumber(String title){
        System.out.println(title +":");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        return answer;
    }
}

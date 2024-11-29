package DataStructure;

import java.util.Scanner;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        //khai bao mang? : Tap hop cac du lieu cung` kieu?
        //c1
        int[] array = {1,2,3,4,5};

        // // cach 2
        // int[] array2= new int[5];

        // // Accessing
         System.out.println(array[0]);

        // //duyet qua cac phan tu trong mang?
        // //1. For loop
        // for(int i=0;i <array.length; i++); {

        // }
        // //for each
        // for(int a:array) {
        //     System.out.println(a);
        // }

        //while
        // int i=0;
        // while(i < array.length){
        //     System.out.println(array[i]);
        //     i++;
        // }

        //bai1
        // Scanner scanner = new Scanner(System.in);

        // String[] array3 = new String[100];
        // int count = 0;
        // while (scanner.hasNext() && count < array3.length) {
        //     array3[count] = scanner.next();
        //     count++;
            
        // }

        // for (String w: array3) {
        //     System.out.println(w);
        // }

        // char a = 'A';
        // System.out.println(a > 1);

        String[] students = {
            "BH02034,9,8.5,10,10,7,9,9.5,10",
            "BH06960,9,9,10,9,7,8,10,8,10",
        };

        // for(String s : students) {
        //     getavg(s);
        // }
        

        //copy array
        int[] a = {2,4,6,8};
        int[] b = new int[4];
        b =a;
        System.out.println(a);
        

        // String student1 = students[0];
        // System.out.println(student1);
        // String[] a = student1.split(",");
        // for(String s: a) {
        //     System.out.println(s);
        // };


        // float sum = 0;
        // for(int i = 1;i < a.length;i++) {
        //     sum = sum + Float.parseFloat(a[i]);
        // }
        // float avg = sum / (a.length - 1);
        // System.out.println(avg);


    }


    public static void getavg(String student) {
        String[] a = student.split(",");
        float sum = 0;
        for(int i = 1;i < a.length;i++) {
            sum = sum + Float.parseFloat(a[i]);
        }
        float avg = sum / (a.length - 1);
        System.out.print("Sinh vien:");
        System.out.println(a[0]);
        System.out.print("Diem Trung binh:");
        System.out.println(avg);
    }

    // copy array
}

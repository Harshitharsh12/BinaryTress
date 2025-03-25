package TreeQuestions;

import java.util.Scanner;

public class Path{
    public static void main(String[] args) {
        Tree obj = new Tree();
        Scanner sc=new Scanner(System.in);
        int[] arr={10,9,11,2};
        obj.populate(arr);
        System.out.println(obj.pathSum(21));
    }
}
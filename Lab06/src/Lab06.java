import java.util.*;
import java.io.File;
import java.io.IOException;

public class Lab06 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String selection;

        do{
        System.out.println("Please select the operation you want: ");
        System.out.println("1 - To Find the length of a string");
        System.out.println("2- To Find the number of non-vowels in a string");
        System.out.println("3- To generate binary strings of length n");
        System.out.println("4- To find the number of files in given directory on your computer");
        System.out.println("9- EXIT THE PROGRAM");

        selection = scan.nextLine();

        if(selection.equals("1")){
            System.out.println(" Please enter a string to count its length");
            String str = scan.nextLine();
            System.out.println(length(str));
        }
        if(selection.equals("2")){
            System.out.println(" Please enter a string to count its non-vowel char number");
            String str = scan.nextLine();
            System.out.println(countVowels(str,str.length()));
        }
            if(selection.equals("3")){
                System.out.println(" Please enter n to see n binary");

                int n = scan.nextInt();
                int[] arr = new int[n];

                generateAllBinaryStrings(n,arr , 0 );
            }

            if(selection.equals("4")){
                System.out.println(" Please enter a path to see how many files in the path");
                String str = scan.nextLine();
                File directory = new File (str);
                System.out.println("The number of files: " + getFilesCount( directory ));

            }

         } while ( !selection.equals("9"));
    }

    //PART A
    private static int length(String str) {
        if (str.equals(""))
            return 0;
        else
            return length(str.substring(1)) + 1;
    }

    //PART B
    private static int isVowel(char ch) {
        ch = Character.toUpperCase(ch);
        if(ch =='A' || ch =='E' || ch =='I' ||
                ch =='O' || ch =='U')
            return 0;
        else return 1;
    }
    private static int countVowels(String str, int n)
    {
        if (n == 1)
            return isVowel(str.charAt(0));

        return countVowels(str, n - 1) + isVowel(str.charAt(n - 1));
    }

    //PART C
    private static void printTheArray(int[] arr, int n) {
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void generateAllBinaryStrings(int n, int[] arr, int i) {
        if (i == n)
        {
            printTheArray(arr, n);
            return;
        }

        arr[i] = 0;
        generateAllBinaryStrings(n, arr, i + 1);

        arr[i] = 1;
        generateAllBinaryStrings(n, arr, i + 1);
    }

    //PART D

    public static int getFilesCount(File file) {
        File[] files = file.listFiles();
        int count = 0;
        for (File f : files)
            if (f.isDirectory())
                count += getFilesCount(f);
            else
                count++;

        return count;
    }

}

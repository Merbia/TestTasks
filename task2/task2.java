import java.io.*;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) throws FileNotFoundException {


        File file1 = new File(args[0]);
        Scanner scan1 = new Scanner(file1);

        Integer[] numbers = new Integer[3];
        for (int i = 0; scan1.hasNext(); i++) {
            numbers[i] = scan1.nextInt();
        }

        scan1.close();

        int x_point = numbers[0];
        int y_point = numbers[1];
        int r_circle = numbers[2];



        File file2 = new File(args[1]);
        Scanner scan2 = new Scanner(file2);

        String[] points = new String[2];
        String line;
        while (scan2.hasNextLine()) {
            line = scan2.nextLine();
            points = line.split(" ");
            int x = Integer.parseInt(points[0]);
            int y = Integer.parseInt(points[1]);
            double hypotenuse = Math.sqrt(Math.pow(x - x_point, 2) + Math.pow(y - y_point, 2));

            if (hypotenuse < r_circle) {
                System.out.print(1 + " ");
            } else if (hypotenuse == r_circle) {
                System.out.print(0 + " ");
            }else {
                System.out.print(2 + " ");
            }
        }
        scan2.close();
    }
}
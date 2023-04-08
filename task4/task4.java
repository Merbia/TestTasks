import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class task4 {
    public static void main(String[] args) throws FileNotFoundException {

        String fileName = args[0];
        File file = new File(fileName);
        ArrayList<Integer> num = new ArrayList<Integer>();

        int sum = 0;
        Scanner scanner = new Scanner(file);
            for (int i = 0;scanner.hasNextInt(); i++) {
                num.add(scanner.nextInt());
                sum = sum + num.get(i);
            }
            int med = Math.round(sum / num.size());

            int count = 0;
            scanner.close();
            while (true) {
                for (int i = 0; i < num.size(); i++) {
                    if (num.get(i) < med)  {
                        num.set(i, num.get(i) + 1);
                        count++;
                    } else if (num.get(i) > med) {
                        num.set(i, num.get(i) - 1);
                        count++;
                    }
                }
                if ((Collections.min(num) == med) && (Collections.max(num) == med)){
                    break;
                }
            }
        System.out.println(count);


    }
}
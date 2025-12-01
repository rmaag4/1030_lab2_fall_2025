import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean[] chptList = new boolean[16]; // Chapters 1 to 15
    
        for (int i = 1; i <= 15; i++) {
            int chpt = scnr.nextInt();
            chptList[i] = (chpt == 1);
        }

        List<String> output = new ArrayList<>();
        int i = 1;

        while (i <= 15) {
            if (chptList[i]) {
                int start = i;
                int end = i;

                // Extend range while next chapters are selected
                while (end + 1 <= 15 && chptList[end + 1]) {
                    end++;
                }

                int length = end - start + 1;

                if (length >= 3) {
                    output.add(start + "-" + end);
                    i = end + 1; // Skip processed range
                } else {
                    for (int j = start; j <= end; j++) {
                        output.add(String.valueOf(j));
                    }
                    i = end + 1;
                }
            } else {
                i++;
            }
        }

        // Final output
        if (output.isEmpty()) {
            System.out.println("None ");
        } else {
            for (String item : output) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}

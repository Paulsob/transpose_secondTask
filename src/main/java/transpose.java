import java.io.*;

public class transpose {

    public static void main(String[] args) {
        new Parser().parse(args);
    }
    public static void trans(boolean r, boolean t, int num, String outFile) {
        int n = 0;
        BufferedReader br = null;
        BufferedReader newBr;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("input/Example.txt"));
            String line;
            String newLine;
            int count = 0;

            // определение размера двумерного массива
            while ((newLine = br.readLine()) != null) {
                String[] split = newLine.split(" ");
                int length = split.length;
                if (length > n) n = length;
                count++;
            }
            if (n < count) n = count;
            String[][] array = new String[n][n];

            // чтение из файла построчно + разделение строки по пробелу + задание массива
            int j = 0;
            newBr = new BufferedReader(new FileReader("input/Example.txt"));
            while ((line = newBr.readLine()) != null) {
                String[] split = line.split(" ");
                System.arraycopy(split, 0, array[j], 0, split.length);
                j++;
            }

            // транспонирование массива
            for (int i = 0; i < n; i++) {
                for (int k = i + 1; k < n; k++) {
                    String temp = array[i][k];
                    array[i][k] = array[k][i];
                    array[k][i] = temp;
                }
            }

            // печать строк
            String substring = "";
            for (int i = 0; i < n; ++i) {
                for (int k = 0; k < n; ++k) {
                    if (array[i][k] != null) {
                        bw = new BufferedWriter(new FileWriter("input/Example_output.txt"));
                        String word = array[i][k];
                        substring = word;
                        if (outFile != null)
                            bw.write(array[i][k]);
                        else System.out.print(word + " ");
                    }
                }
                assert bw != null;
                System.out.println();
            }

            // флаг -а num
            if (num != 0 && substring.length() <= num) {
                int countOfWhiteSpaces = num - (substring.length() - 1);
                String adding = " ".repeat(countOfWhiteSpaces);
                substring = substring + adding;
                if (outFile == null) {
                    System.out.println(substring);
                } else {
                    assert bw != null;
                    bw.write(substring);
                }
            }

            // флаг -t
            if (t) {
                int cuttingLength = substring.length() - 1 - num;
                substring = substring.substring(cuttingLength);
                if (outFile == null) {
                    System.out.println(substring);
                } else {
                    assert bw != null;
                    bw.write(substring);
                }
            }

            // флаг -r
            if (r) {
                int countOfWhiteSpaces = num - (substring.length() - 1);
                String adding = " ".repeat(countOfWhiteSpaces);
                substring = adding + substring;
                if (outFile == null) {
                    System.out.println(substring);
                } else {
                    assert bw != null;
                    bw.write(substring);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                if (br != null && bw != null) {
                    br.close();
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }

    }
}

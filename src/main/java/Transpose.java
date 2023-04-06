import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.max;

public class Transpose {

    public ArrayList<String[]> arrayList;
    public int length;

    public void main(String[] args) {
        new Parser().parse(args);
    }

    // boolean r, boolean t, int num, String outfile
    public static void trans(boolean r, boolean t, int num, String inputFile, String outfile) {
        try {
            File file = new File(inputFile);
            File out = new File(outfile);
            BufferedReader br = new BufferedReader(new FileReader(file));
            Transpose transpose = new Transpose();
            transpose.reading(br);
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            String[][] answer = transpose.transposing();
            for (int i = 0; i < transpose.length; i++) {
                for (int j = 0; j < transpose.length; j++) {
                    output.write(answer[i][j]);
                    output.write(" ");
                }
                output.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

//    public String[][] determineOfSize(int j) throws IOException {
//        int n = 0;
//        BufferedReader br;
//        br = new BufferedReader(new FileReader("input/Example.txt"));
//        int count = 0;
//        // определение размера двумерного массива
//        while ((newLine = br.readLine()) != null) {
//            String[] split = newLine.split(" ");
//            int length = split.length;
//            if (length > n) n = length;
//            count++;
//        }
//        if (n < count) n = count;
//        String[][] array = new String[n][n];
//        return array;
//    }

    public void reading(BufferedReader br) throws IOException {
        String line;
        ArrayList<String[]> arrayList = new ArrayList<>();
        // чтение из файла построчно + разделение строки по пробелу + задание массива
        int j = 0;
        int length;
        int count = 0;
        int n = 0;
        while ((line = br.readLine()) != null) {
            String[] split = line.split(" ");
            arrayList.add(split);
            length = split.length;
            if (length > n) n = length;
            count++;
            j++;
        }
        this.length = max(n, count);
        this.arrayList = arrayList;
    }

    public String[][] transposing() throws IOException {
        ArrayList<String[]> array = this.arrayList;
        int length = this.length;
        int n = 0;
        int count = 0;
        String[][] answer = new String[length][length];
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.get(i).length; j++) {
                answer[i][j] = array.get(i)[j];
            }
        }
        for (int i = 0; i < length; i++) {
            for (int k = i + 1; k < length; k++) {
                String temp = answer[i][k];
                answer[i][k] = answer[k][i];
                answer[k][i] = temp;
            }
        }
        this.printMatrix(answer);
        return answer;
    }

    public void printMatrix(String[][] answer) {
        String str = "";
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                str += answer[i][j];
                str += " ";
            }
            str += "\n";
        }
        System.out.println(str);
    }
}

//    public String printing(String outFile) throws IOException {
//        BufferedReader br = null;
//        BufferedWriter bw = null;
//        String newLine;
//        int n = 0;
//        while ((newLine = br.readLine()) != null) {
//            String[] split = newLine.split(" ");
//            int length = split.length;
//            if (length > n) n = length;
//        }
//        String substring = "";
//        for (int i = 0; i < n; ++i) {
//            for (int k = 0; k < n; ++k) {
////                if (transposing(i, k) != null) {
////                    bw = new BufferedWriter(new FileWriter("input/Example_output.txt"));
////                    String word = transposing(i, k);
////                    substring = word;
////                    if (outFile != null)
////                        bw.write(transposing(i, k));
////                    else System.out.print(word + " ");
//                }
//            }
//            assert bw != null;
//            System.out.println();
//        }
//        return substring;
//    }

//    public void flag_a(int num, String outFile) throws IOException {
//        BufferedWriter bw = null;
//        if (num != 0 && printing(outFile).length() <= num) {
//            int countOfWhiteSpaces = num - (printing(outFile).length() - 1);
//            String adding = " ".repeat(countOfWhiteSpaces);
//            String substring = printing(outFile) + adding;
//            if (outFile == null) {
//                System.out.println(substring);
//            } else {
//                assert false;
//                bw.write(substring);
//            }
//        }
//
//    }
//
//    public void flag_t(boolean t, int num, String outFile) throws IOException {
//        BufferedWriter bw = null;
//        if (t) {
//            int cuttingLength = printing(outFile).length() - 1 - num;
//            String substring = printing(outFile).substring(cuttingLength);
//            if (outFile == null) {
//                System.out.println(substring);
//            } else {
//                assert false;
//                bw.write(substring);
//            }
//        }
//    }
//
//    public void flag_r(boolean r, int num, String outFile) throws IOException {
//        BufferedWriter bw = null;
//        if (r) {
//            int countOfWhiteSpaces = num - (printing(outFile).length() - 1);
//            String adding = " ".repeat(countOfWhiteSpaces);
//            String substring = adding + printing(outFile);
//            if (outFile == null) {
//                System.out.println(substring);
//            } else {
//                assert false;
//                bw.write(substring);
//            }
//        }
//    }
//}

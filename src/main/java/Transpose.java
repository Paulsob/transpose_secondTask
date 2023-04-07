import java.io.*;
import java.util.ArrayList;

import static java.lang.Math.max;

public class Transpose {
    public ArrayList<String[]> arrayList;
    public int length;

    public void main(String[] args) {
        new Parser().parse(args);
    }

    // boolean r, boolean t, int num, String outfile.txt
    public static void trans(boolean r, boolean t, int num, String inputFile, String outfile) {
        try {
            File file = new File("input/inputFile.txt");
            File out = new File("input/outfile.txt");
            BufferedReader input = new BufferedReader(new FileReader(file));
            Transpose transpose = new Transpose();
            transpose.reading(input);
            BufferedWriter output = new BufferedWriter(new FileWriter(out));
            String[][] answer = transpose.transposing();
            for (int i = 0; i < transpose.length; i++) {
                for (int j = 0; j < transpose.length; j++) {
                    output.write(answer[i][j] + " ");
                }
                output.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void reading(BufferedReader br) throws IOException {
        String line;
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length;
        int count = 0;
        int n = 0;
        while ((line = br.readLine()) != null) {
            String[] split = line.split(" ");
            arrayList.add(split);
            length = split.length;
            if (length > n) n = length;
            count++;
        }
        this.length = max(n, count);
        this.arrayList = arrayList;
    }

    public String[][] transposing() throws IOException {
        ArrayList<String[]> array = this.arrayList;
        int length = this.length;
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
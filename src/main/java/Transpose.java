import java.io.*;
import java.util.ArrayList;

import static java.lang.Math.max;

public class Transpose {
    public ArrayList<String[]> arrayList;
    public int columns;
    public int rows;

    public void main(String[] args) {
        new Parser().parse(args);
    }

    public static void trans(boolean r, boolean t, String num, String inputFile, String outfile) {
        try {
            BufferedReader input;
            BufferedWriter output;
            if (inputFile == null) input = new BufferedReader(new InputStreamReader(System.in));
            else input = new BufferedReader(new FileReader(inputFile));
            Transpose transpose = new Transpose();
            transpose.reading(input);
            input.close();
            File out = new File(outfile);
            out.createNewFile();
            output = new BufferedWriter(new FileWriter(out));
            String[][] answer = transpose.transposing(r, num, t);
            for (int i = 0; i < answer.length; i++) {
                for (int j = 0; j < answer[i].length; j++) {
                    if (answer[i][j] != "") {
                        output.write(answer[i][j] + " ");
                    }
                }
                output.write("\n");
            }
            output.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void reading(BufferedReader br) throws IOException {
        int count = 0;
        int n = 0;
        String line;
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length;
        while ((line = br.readLine()) != null) {
            String[] split = line.split(" ");
            arrayList.add(split);
            length = split.length;
            if (length > n) n = length;
            count++;
        }
        this.rows = count;
        this.columns = n;
        this.arrayList = arrayList;
    }

    public String[][] transposing(boolean r, String num, boolean t) throws IOException {
        ArrayList<String[]> array = this.arrayList;
        String[][] answer = new String[columns][rows];
        String word;
        int number = Integer.parseInt(num);
        if (number == 0) number = 10;
        for (int i = 0; i < rows; i++) {
            System.out.println(array);
            for (int j = 0; j < columns; j++) {
                try {
                    word = array.get(i)[j];
                } catch (IndexOutOfBoundsException e) {
                    word = "";
                }
                if (number != 0) {
                    if (t) {
                        if (word.length() > number) word = word.substring(0, number);
                    } else {
                        if (r) word = " ".repeat(max(0, word.length() - number)) + word;
                        else word = word + " ".repeat(max(0, word.length() - number));
                    }
                }
                answer[j][i] = word;
            }
        }
        return answer;
    }
}

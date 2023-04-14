import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TransposeTest {

//    private boolean assertFileContent (String outfile, String example) throws IOException {
//        BufferedReader expected = new BufferedReader(new FileReader(outfile));
//        BufferedWriter actual = new BufferedWriter(new FileWriter(example));
//        for (int i = 0; i < )
//    }

    @Test
    public void parsers() throws IOException {
        String[] args = {"-a 8", "-t", "-r", "-o ofile", "file"};
        Parser par = new Parser();
        par.parse(args);
        Assumptions.assumeTrue(par.t);
        Assumptions.assumeTrue(par.r);
        Assertions.assertEquals("-a 8", par.num);
        Assertions.assertEquals("-o ofile", par.outfile);
        Assertions.assertEquals("file", par.inputFile);
    }

    @Test
    void test2() throws IOException {
        Transpose transpose = new Transpose();
        transpose.main("input/Example.txt outfile 2 -t -r".split(" "));
        BufferedReader brNew = new BufferedReader(new FileReader("outfile"));
        int c = brNew.read();
        String answer = "";
        while (c != -1) {
            answer += (char)c;
            c = brNew.read();
        }
        assertNotEquals("A B \nD E \nC \n", answer);
    }

    @Test
    void test3() throws IOException {
        Transpose transpose = new Transpose();
        transpose.main("input/Example.txt outfile 2 -t -r".split(" "));
        BufferedReader brNew = new BufferedReader(new FileReader("outfile"));
        int c = brNew.read();
        String answer = "";
        while (c != -1) {
            answer += (char)c;
            c = brNew.read();
        }
        assertNotEquals("A D \nE B \nC \n", answer);
    }
}
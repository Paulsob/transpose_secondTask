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

//    @Test
//    void transTest() throws IOException {
//       Transpose transpose = new Transpose();
//       String str = "A B C \\n D E ";
//       String[][] result = transpose.transposing(true, 3, false);
//       assertEquals("A D \\nB E \\nC \\n", result);
//       Transpose.trans(true, false, 3, "input/Example.txt", "input/outfile.txt");
//    }

    @Test
    void test1() throws IOException {
//        String[] inp = {"input/Example.txt", "-o outfile", "-a 2", "-t", "-r"};
//        Parser par = new Parser();
//        par.parse(inp);
        Transpose transpose = new Transpose();
//        transpose.trans(par.r, par.t, par.num.substring(3), par.inputFile, par.outfile);
        transpose.main("input/Example.txt outfile 2 -t -r".split(" "));
        BufferedReader brNew = new BufferedReader(new FileReader("outfile"));
        int c = brNew.read();
        String answer = "";
        while (c != -1) {
            answer += (char)c;
            c = brNew.read();
        }
        assertEquals("A D \nB E \nC \n", answer);
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
}
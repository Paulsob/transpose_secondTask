import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TransposeTest {
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
    void trans()  {
        String[] args = {"-a 8", "-t", "-r", "-o ofile", "file"};
        Parser obj = new Parser();
        obj.parse(args);

    }
}
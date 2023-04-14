// [-a num] [-t] [-r] [-o outfile.txt] [file]

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    @Argument(metaVar = "inputFile.txt")
    String inputFile;
    @Option(name = "-o", usage = "name of output file")
    String outfile;
    @Option(name = "-a", usage = "number of symbols")
    String num;
    @Option(name = "-t", usage = "for superfluous symbols")
    boolean t;
    @Option(name = "-r", usage = "alignment of text")
    boolean r;

    public static void main(String[] args) {
     //   new Parser().parse("-a 7 -t -r -o outfile input/Example.txt".split(" "));
//        String[] command  = new String[5];
//        command[0] = "-r";
//        command[1] = "-t";
//        command[2] = "-a 7";
//        command[3] = "-o outfile";
//        command[4] = "input/Example.txt";
        new Parser().parse(args);
    }

    public void parse(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            System.out.println(r);
            System.out.println(t);
            System.out.println(num);
            System.out.println(outfile);
            Transpose.trans(r, t, num.substring(3), inputFile, outfile.substring(3));
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        }
    }
}

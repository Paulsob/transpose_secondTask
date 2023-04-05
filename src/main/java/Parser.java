// [-a num] [-t] [-r] [-o outfile] [file]

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Parser {
    @Argument(metaVar = "inputFile.txt")
    private String inputFile;
    @Option(name = "-o", usage = "name of output file")
    private String outFile;
    @Option(name = "-a", usage = "number of symbols")
    private int num;
    @Option(name = "-t", usage = "for superfluous symbols")
    private boolean t;
    @Option(name = "-r", usage = "alignment of text")
    private boolean r;

    public static void main(String[] args) {
        String[] command  = new String[5];
        command[0] = "-a number";
        command[1] = "-t";
        command[2] = "-r";
        command[3] = "-o outfile";
        command[4] = "inputFile";
        new Parser().parse(command);
    }

    public void parse(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            System.out.println();
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        }
        transpose.trans(r, t, num, outFile);
    }

}

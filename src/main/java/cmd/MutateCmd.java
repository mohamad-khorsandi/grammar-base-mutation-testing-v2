package cmd;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import picocli.CommandLine;

import static picocli.CommandLine.*;

import java.io.File;

@Command(name = "mutate", description = "mutate given code")
public class MutateCmd implements Runnable {
    @Parameters(index = "0", description = "Path to the file")
    private File file;

    @Override
    public void run() {
        System.out.println("Mutate command executed with file: " + file.getAbsolutePath());
    }
}

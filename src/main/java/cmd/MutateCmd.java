package cmd;

import config.Config;
import mutation.Mutation;
import mutation.MutationResult;

import static picocli.CommandLine.*;
import static statics.HelperMethods.printUpTo;

import java.io.IOException;

@Command(name = "mutate", description = "mutate given code")
public class MutateCmd implements Runnable {
    @Parameters(index = "0", description = "Path to the file")
    private String file;

    @Override
    public void run() {
        try {
            Mutation mutation = new Mutation(new Config(), file);
            MutationResult result = mutation.mutate();

            printUpTo(result.groundString, result.startLine, result.startColumn);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Mutate command executed with file:");
    }
}

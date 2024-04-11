package cmd;

import picocli.CommandLine;
import picocli.CommandLine.*;

import static statics.staticObjects.log;

@Command(name = "")
public class MainCmd {
    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new MainCmd());

        commandLine.addSubcommand(new ConfigCmd());
        commandLine.addSubcommand(new MutateCmd());
        commandLine.execute(args);
    }
}

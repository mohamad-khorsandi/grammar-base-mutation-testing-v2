package cmd;

import ch.qos.logback.core.util.FileUtil;

import java.io.*;
import java.net.URISyntaxException;
import static statics.staticObjects.log;
import static picocli.CommandLine.Command;
import static statics.HelperMethods.copyFile;

@Command(name = "config",
        description = "create a default config file in the current directory")
public class ConfigCmd implements Runnable {

    @Override
    public void run() {
        String sourceFileName = "config.yaml";
        try (InputStream inputStream = FileUtil.class.getResourceAsStream("/" + sourceFileName)) {

            if (inputStream != null) {
                String jarDirectory = new File(FileUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent();
                String destinationFilePath = jarDirectory + File.separator + sourceFileName;
                copyFile("/" + sourceFileName, destinationFilePath);
            } else {
                log.error("File not found in the root of the project: " + sourceFileName);
                System.exit(0);
            }
        } catch (IOException | URISyntaxException e) {
            e.getStackTrace();
        }

    }
}

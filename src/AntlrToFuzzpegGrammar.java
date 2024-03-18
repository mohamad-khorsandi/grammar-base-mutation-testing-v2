import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AntlrToFuzzpegGrammar {

    String convert(String antlrGrammarPath, String fuzzPegGrammarPath) throws IOException {
        String content = Files.readString(Paths.get(antlrGrammarPath));
        String regex = "[a-zA-Z]+(?=\\s*\\n?\\s*:)";
        Matcher matcher = Pattern.compile(regex).matcher(content);

        while (matcher.find()) {
            if (hasLowercase(matcher.group())) {
                content = content.replaceAll(matcher.group(), matcher.group().toLowerCase());
            }
        }

        Files.writeString(Paths.get(fuzzPegGrammarPath))
        return content;
    }

    private boolean hasLowercase(String in) {
        for (byte aByte : in.getBytes()) {
            if ('a'< aByte && aByte < 'z')
                return true;
        }
        return false;
    }
}

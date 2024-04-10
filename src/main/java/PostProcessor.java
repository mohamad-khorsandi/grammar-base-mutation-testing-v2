import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.DefaultPrettyPrinter;

public class PostProcessor {
    public static void analyzeSyntax(ParseResult<CompilationUnit> parseResult) {
        if (parseResult.isSuccessful()) {
//            log.info("generated code is syntactically correct.");//todo add log
        } else {
            parseResult.getProblems().forEach(System.err::println);
            System.exit(0);
        }
    }

    public static String prettify(ParseResult<CompilationUnit> parseResult) {

        CompilationUnit cu = parseResult.getResult().orElseThrow(() -> new RuntimeException("Failed to parse code"));

        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();

        return printer.print(cu);
    }
}

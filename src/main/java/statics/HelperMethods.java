package statics;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.DefaultPrettyPrinter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.Java8Lexer;
import parser.Java8Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class HelperMethods {
    private static Java8Parser getParser(String path) throws IOException {
        CharStream in = CharStreams.fromFileName(path);
        Java8Lexer lexer = new Java8Lexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new Java8Parser(tokens);
    }

    public static ParseTree getParsTree(String path) throws IOException {
        return getParser(path).compilationUnit();
    }

    public static void printParserRules(String path) throws IOException {
        Java8Parser parser = getParser(path);
        for (String ruleName : parser.getRuleNames()) {
            System.out.println("        " + ruleName + ": Yes");
        }
    }

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

    public static void copyFile(String sourceFilePath, String destinationFilePath) throws IOException {
        Path sourcePath = Paths.get(sourceFilePath);
        Path destinationPath = Paths.get(destinationFilePath);

        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }
}

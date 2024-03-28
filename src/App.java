
import i2.act.main.FuzzPEG;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.*;

public class App
{
    public static void main( String[] args ) throws IOException {
        ParseTree entireTree = getParseTree("resources/example.java");

        NodeSelector listener = new NodeSelector(0, 10);
        new ParseTreeWalker().walk(listener, entireTree);

        ParserRuleContext mutationTar = listener.result.get(new Random().nextInt(listener.result.size()));

        for(ParserRuleContext a : listener.result) {
            System.out.println(a.getText());
        }
        System.out.println();
    }

    private static ParseTree getParseTree(String path) throws IOException {
        CharStream in = CharStreams.fromFileName(path);
        Java8Lexer lexer = new Java8Lexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java8Parser parser = new Java8Parser(tokens);
        return parser.compilationUnit();
    }

    static private Pa
}

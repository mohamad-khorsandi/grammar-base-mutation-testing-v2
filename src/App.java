
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
//        CharStream in = CharStreams.fromFileName("resources/example.java");
//        Java8Lexer lexer = new Java8Lexer(in);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        Java8Parser parser = new Java8Parser(tokens);
//        ParseTree parseTree = parser.compilationUnit();
//
//        // listener
//        TestListener listener = new TestListener(0, 10);
//        new ParseTreeWalker().walk(listener, parseTree);
//
//        ParserRuleContext mutationTar = listener.result.get(new Random().nextInt(listener.result.size()));
////        for(ParserRuleContext a : listener.result) {
////            System.out.println(a.getText());
////        }
//        System.out.println();
////        mutationTar.getRuleContext()

        String[] newArgs = {"--grammar", "resources/fuzz_peg_grammar.txt"};

//        FuzzPEG.main(newArgs);
        new AntlrToFuzzpegGrammar().convert("resources/fuzz_peg_grammar.txt");
    }
}

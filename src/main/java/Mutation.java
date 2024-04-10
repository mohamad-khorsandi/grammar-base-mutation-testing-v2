
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import java.io.IOException;
import parser.*;

public class Mutation {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java GreetingTool <name>");
            return;
        }

        String name = args[0];
        System.out.println("Hello, " + name + "!");
//        System.out.println(Config.MAX_DEPTH);
//
//        ParseTree entireTree = getParseTree("resources/example_java");
//
//        NodeSelector listener = new NodeSelector(0, 10);
//        new ParseTreeWalker().walk(listener, entireTree);
//
//        ParserRuleContext mutationTar = listener.result.get(new Random().nextInt(listener.result.size()));
//
//        for(ParserRuleContext a : listener.result) {
//            System.out.println(a.getText());
//        }

    }

    private static ParseTree getParseTree(String path) throws IOException {
        CharStream in = CharStreams.fromFileName(path);
        Java8Lexer lexer = new Java8Lexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java8Parser parser = new Java8Parser(tokens);
        return parser.compilationUnit();
    }
}

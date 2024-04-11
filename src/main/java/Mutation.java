import config.Config;
import config.FuzzerConfig;
import config.SelectorConfig;
import fuzzer.AntlrFuzzer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;

import java.io.*;
import static statics.staticObjects.log;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import utils.RandUtil;
import static statics.HelperMethods.getParsTree;

public class Mutation {
    private final String javaGrammar = "src/main/resources/Java8.g4";
    private final RandUtil rand;
    private final Config config;
    private final ParseTree parsTree;
    private final ParseTreeWalker walker;

    public Mutation(Config config, String src) throws IOException {
        this.rand = RandUtil.by(config.getRandomSeed());
        this.config = config;
        parsTree = getParsTree(src);
        walker = new ParseTreeWalker();
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("config.yaml");
        Config config = new Yaml().loadAs(inputStream, Config.class);
        new Mutation(config, "src/main/resources/example_java").mutate();
    }

    public MutationResult mutate() throws IOException {
        SelectorConfig sc = new SelectorConfig();
        NodeSelector listener = new NodeSelector(sc.getMinHeight(), sc.getMaxHeight());
        walker.walk(listener, parsTree);
        ParserRuleContext mutationTar = rand.randElem(listener.result);

        for(ParserRuleContext a : listener.result) {
            log.trace(a.getText());
        }

        AntlrFuzzer fuzzer = new AntlrFuzzer(javaGrammar, config.getRandomSeed());
        FuzzerConfig fc = config.getFuzzer();
        String mutant = fuzzer.fuzz(mutationTar.getClass().getSimpleName(), fc.getMaxDepth(), fc.getPlusStarGaussianSigma(), fc.getQuestionBernoulliProp());

        return new MutationResult(mutationTar.start, mutationTar.stop, mutant);
    }

}

import org.antlr.v4.runtime.ParserRuleContext;
import parser.Java8BaseListener;

import java.util.ArrayList;

public class NodeSelector extends Java8BaseListener {
    public NodeSelector(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    private int depth = 0;
    private int branchDepth = 0;
    private final int minHeight;
    private final int maxHeight;
    ArrayList<ParserRuleContext> result = new ArrayList<>();

    @Override
    public void enterEveryRule(ParserRuleContext var1) {
        branchDepth = depth;
        depth++;
    }

    @Override
    public void exitEveryRule(ParserRuleContext var1) {
        depth--;
        int height = getHeight();
        if (minHeight <= height && height <= maxHeight)
            result.add(var1);
    }

    private int getHeight() {
        return branchDepth - depth;
    }
}

import org.antlr.v4.runtime.Token;

public class MutationResult {
    public MutationResult(Token start, Token stop, String res) {
        this.startLine = start.getLine();
        this.startIndex = start.getStartIndex();

        this.stopLine = stop.getLine();
        this.stopIndex = stop.getStopIndex();

        this.newStr = res;
    }

    int startIndex;
    int startLine;
    int stopIndex;
    int stopLine;

    String newStr;
}

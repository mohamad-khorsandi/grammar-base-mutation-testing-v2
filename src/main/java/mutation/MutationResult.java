package mutation;

import org.antlr.v4.runtime.Token;

public class MutationResult {
    public MutationResult(Token start, Token stop, String groundString, String res) {
        this.startLine = start.getLine();
        this.startColumn = start.getStartIndex();

        this.stopLine = stop.getLine();
        this.stopColumn = stop.getStopIndex();
        this.groundString = groundString;

        this.generatedPart = res;
    }

    public final int startColumn;
    public final int startLine;
    public final int stopColumn;
    public final int stopLine;

    public final String groundString;
    public final String generatedPart;

    public String mutatedCode;
}

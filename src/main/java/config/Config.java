package config;


public class Config {
    private Integer randomSeed;
    private FuzzerConfig fuzzer;
    private SelectorConfig selector;

    // Getters and Setters

    public int getRandomSeed() {
        return randomSeed;
    }

    public void setRandomSeed(int randomSeed) {
        this.randomSeed = randomSeed;
    }

    public FuzzerConfig getFuzzer() {
        return fuzzer;
    }

    public void setFuzzer(FuzzerConfig fuzzer) {
        this.fuzzer = fuzzer;
    }

    public SelectorConfig getSelector() {
        return selector;
    }

    public void setSelector(SelectorConfig selector) {
        this.selector = selector;
    }
}

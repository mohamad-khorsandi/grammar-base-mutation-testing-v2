package config;

public class FuzzerConfig {
    private int maxDepth;
    private double plusStarGaussianSigma;
    private double questionBernoulliProp;

    // Getters and Setters

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public double getPlusStarGaussianSigma() {
        return plusStarGaussianSigma;
    }

    public void setPlusStarGaussianSigma(double plusStarGaussianSigma) {
        this.plusStarGaussianSigma = plusStarGaussianSigma;
    }

    public double getQuestionBernoulliProp() {
        return questionBernoulliProp;
    }

    public void setQuestionBernoulliProp(double questionBernoulliProp) {
        this.questionBernoulliProp = questionBernoulliProp;
    }
}

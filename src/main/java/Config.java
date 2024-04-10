import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.util.HashMap;

public class Config {
    private static final Configuration config;
//    public static final double HEIGHT;
//    public static final double ;

    public static final Integer SEED;
    public static final int MAX_DEPTH;
    public static final double PLUS_STAR_GAUSSIAN_SIGMA;
    public static final double QUESTION_BERNOULLI_PROP;

    static {
        try {
            config = new Configurations().properties(new File("src/main/resources/application.properties"));
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
        SEED = config.getInteger("SEED", Math.toIntExact(System.currentTimeMillis() % Integer.MAX_VALUE));

        MAX_DEPTH = config.getInt("MAX_DEPTH");
        PLUS_STAR_GAUSSIAN_SIGMA = config.getDouble("PLUS_STAR_GAUSSIAN_SIGMA");
        QUESTION_BERNOULLI_PROP = config.getDouble("QUESTION_BERNOULLI_PROP");
    }


}

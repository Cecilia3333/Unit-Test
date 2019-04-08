package tw.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.generator.RandomIntGenerator;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void should_give_error_info_when_digitmax_smaller_than_numbers_of_need() throws Exception {
        Integer digitmax = 3, numbersOfNeed = 4;
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        String errorMsg = "Can't ask for more numbers than are available";
        exception.expectMessage(errorMsg);
        randomIntGenerator.generateNums(digitmax,numbersOfNeed);
    }
}
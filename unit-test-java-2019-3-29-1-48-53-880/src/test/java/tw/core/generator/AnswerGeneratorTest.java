package tw.core.generator;

import org.junit.Test;
import tw.core.Answer;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Test
    public void should_generate_answer() throws Exception {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9,4)).thenReturn("1 2 3 4");
        Answer answer = Answer.createAnswer(randomIntGenerator.generateNums(9, 4));
        answer.validate();

        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        assertEquals(answerGenerator.generate().toString(),answer.toString());
    }
}
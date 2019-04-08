package tw.core;

import org.junit.Test;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    @Test
    public void should_give_guess_result() throws Exception {
        Answer inputAnswer = Answer.createAnswer("1 5 6 7");
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        Game game = new Game(new AnswerGenerator(randomIntGenerator));
        game.guess(inputAnswer);
        assertEquals(game.guessHistory().size(), 1);
    }

    @Test
    public void should_check_status_fail() throws Exception {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        Game game = new Game(new AnswerGenerator(randomIntGenerator));
        String[] inputs = new String[]{"1 5 6 7","2 4 7 8","0 3 2 4","5 6 7 8","4 3 2 1","1 6 8 4"};
        for (int i = 0; i < 6; i++) {
            Answer inputAnswer = Answer.createAnswer(inputs[i]);
            game.guess(inputAnswer);
        }
        assertEquals(game.checkStatus(), "fail");
    }

    @Test
    public void should_check_status_success() throws Exception {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        Game game = new Game(new AnswerGenerator(randomIntGenerator));
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");
        game.guess(inputAnswer);
        assertEquals(game.checkStatus(), "success");
    }

    @Test
    public void should_check_status_continue() throws Exception {
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        Game game = new Game(new AnswerGenerator(randomIntGenerator));
        assertEquals(game.checkStatus(), "continue");
    }
}

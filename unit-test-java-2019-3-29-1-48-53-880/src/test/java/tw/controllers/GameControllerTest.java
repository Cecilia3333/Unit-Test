package tw.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.views.GameView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_show_begin() throws Exception {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");

        Game game = new Game(new AnswerGenerator(randomIntGenerator));
        GameView gameView = new GameView();
        GameController gameController = new GameController(game, gameView);

        gameController.beginGame();
        assertEquals("------Guess Number Game, You have 6 chances to guess!  ------\r\n",outContent.toString());
    }

    @Test
    public void should_play() throws Exception {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");

        Game game = new Game(new AnswerGenerator(randomIntGenerator));
        GameView gameView = new GameView();
        GameController gameController = new GameController(game, gameView);

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input()).thenReturn(Answer.createAnswer("1 2 3 4"));

        gameController.play(inputCommand);
        String guessResult = "Guess Result: 4A0B\r\n"+"Guess History:\r\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 4A0B]\r\n"+"Game Status: success\r\n";
        assertEquals(guessResult,outContent.toString());
    }
}
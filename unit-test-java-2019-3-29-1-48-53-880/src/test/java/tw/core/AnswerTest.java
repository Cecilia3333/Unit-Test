package tw.core;

import org.junit.Test;
import tw.core.model.Record;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Test
    public void should_check_input_answer() throws Exception {
        Answer answer = Answer.createAnswer("1 2 3 4");
        Answer input = Answer.createAnswer("1 5 6 7");

        Record record = mock(Record.class);
        when(record.getValue()).thenReturn("1A0B");

        assertEquals(answer.check(input).getValue(),record.getValue());

    }

    @Test
    public void should_get_string_of_numlist() throws Exception {
        Answer answer = Answer.createAnswer("1 2 3 4");
        assertEquals(answer.toString(),"1 2 3 4");
    }

    @Test
    public void should_get_index_of_num() throws Exception {
        Answer answer = Answer.createAnswer("1 2 3 4");
        assertEquals(answer.getIndexOfNum("2"),1);
    }
}
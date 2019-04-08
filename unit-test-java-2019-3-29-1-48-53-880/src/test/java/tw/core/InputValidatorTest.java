package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    @Test
    public void should_validate_true() throws Exception{
        InputValidator inputValidator = new InputValidator();
        String numStr = "1 5 8 4";
        assertTrue(inputValidator.validate(numStr));
    }

    @Test
    public void should_validate_false() throws Exception{
        InputValidator inputValidator = new InputValidator();
        String numStr = "1 15 8 4";
        assertFalse(inputValidator.validate(numStr));
    }
}

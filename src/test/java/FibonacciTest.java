import org.junit.Test;

import static main.Main.fibonacci;
import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTest {

    @Test
    public void zeroEntryInFibonacciSequenceShouldBeZero() {
        assertThat(fibonacci(0)).isOne();
    }

    @Test
    public void firstEntryInFibonacciSequenceShouldBeOne() {
        assertThat(fibonacci(1)).isOne();
    }

    @Test
    public void secondEntryInFibonacciSequenceShouldBeOne() {
        assertThat(fibonacci(2)).isEqualTo(2);
        assertThat(fibonacci(3)).isEqualTo(3);
        assertThat(fibonacci(4)).isEqualTo(5);
        assertThat(fibonacci(5)).isEqualTo(8);
        assertThat(fibonacci(6)).isEqualTo(13);
        assertThat(fibonacci(7)).isEqualTo(21);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnErrorWhenNegativeNumberProvided() {
        fibonacci(-1);
    }

    @Test
    public void fibonacciNumberIsLargerThanMaximumInteger() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(fibonacci(80));
    }
}

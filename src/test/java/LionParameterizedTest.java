import com.example.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String lionSex;
    private final boolean hasMane;


    public LionParameterizedTest(String lionSex, boolean hasMane) {
        this.lionSex = lionSex;
        this.hasMane = hasMane;
    }

    @Mock
    Feline feline;
    @Parameterized.Parameters
    public static Object[][] setData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void checkLionSexSuccess() throws Exception {
        Lion lion = new Lion(feline, lionSex);

        boolean expectedResult = hasMane;
        boolean actualResult = lion.doesHaveMane();

        assertEquals(expectedResult, actualResult);
    }
}

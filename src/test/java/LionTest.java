import com.example.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private final String lionSex = "Самец";
    @Mock
    Feline feline;


    @Test
    public void checkGetKittensLion() throws Exception {
        Lion lion = new Lion(feline,lionSex);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(feline.getKittens(),lion.getKittens());
    }

    @Test
    public void checkGetFoodLion() throws Exception {
        Lion lion = new Lion(feline,lionSex);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(feline.getFood("Хищник"),lion.getFood());
    }
    @Test
    public void checkLionSexUndefinedThrowsExceptionSuccess() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, "Неорпделившийся лев"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

}

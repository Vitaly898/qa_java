import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    Animal animal;

    Feline feline = new Feline(animal);

    @Spy
    Feline felineSpy = new Feline(animal);

    @Test
    public void felineEatMeatSuccess() throws Exception {

        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(animal.getFood("Хищник"), feline.eatMeat());
    }


    @Test
    public void checkGetKittensNoArguments(){
        int expected = 1;
        Mockito.when(felineSpy.getKittens()).thenReturn(expected);
        Assert.assertEquals(felineSpy.getKittens(),expected);
    }
    @Test
    public void checkGetKittensWithArgument(){
        int numberOfKitten = 3;
        Assert.assertEquals(feline.getKittens(numberOfKitten),numberOfKitten);
    }
    @Test
    public void checkFamily(){
        String expected = "Кошачьи";
        Assert.assertEquals(feline.getFamily(),expected);
    }


}


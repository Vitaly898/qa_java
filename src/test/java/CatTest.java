import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    Cat cat;
    @Mock
    Feline feline;
    @Before
    public void setUp() {
        cat = new Cat(feline);
    }



    @Test
    public  void checkSound(){
        String expected = "Мяу";
        Assert.assertEquals(cat.getSound(),expected);
    }
    @Test
    public void checkGetFoodOfCat() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(cat.getFood(),feline.eatMeat());
    }



}

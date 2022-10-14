import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CalctlTest {
    @Mock
    Calcul calcMock;

    @org.junit.jupiter.api.Test
    void valueOf() {

    }


    @Test

    public void sum() {
        Calcul calc = Calcul.getInstance();
        double a = 10;
        double b = 4;

        double actualSum = calc.sum(a,b);
        double expectedSum = a + b;
        Assert.assertEquals(expectedSum, actualSum, 0.1);
    }


    @Test
    public void subtract() {
        Calcul calcul = Calcul.getInstance();
        double a = 10;
        double b = 4;

        double actualSub = calcul.subtract(a,b);
        double expectedSub = a - b;
        Assert.assertEquals(expectedSub, actualSub, 0.1);
    }


    @Test
    public void multiply() {
        Calcul calcul = Calcul.getInstance();
        double a = 10;
        double b = 4;

        double actualMul = calcul.multiply(a,b);
        double expectedMul = a * b;
        Assert.assertEquals(expectedMul, actualMul, 0.1);
    }

    public void divide() {
        Calcul calc = Calcul.getInstance();
        double a = 10;
        double b = 0;
        double actualDiv = calc.divide(a, b);
        double exp = a / b;
    }




    @Test
    public void getInstance() {
        Calcul calcul ;
        Calcul calcul1 = Calcul.getInstance();
        Assert.assertEquals(calcul = Calcul.getInstance(), calcul1);
    }


}
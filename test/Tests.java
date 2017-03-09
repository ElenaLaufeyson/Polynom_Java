import My_Polynom.Polynom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests {
    private double ar[] = new double[] {3, 1, 4, 4};
    private double ar1[] = new double[] {1, 2, 3};
    private double ar2[] = new double[] {3, 0, 2, 1};
    private double ar3[] = new double[] {3, 2, 6, 7};
    private double ar4[] = new double[] {3, 12, 0, 4, -9, 0};
    private double ar5[] = new double[] {3, 12, 3, 5, -5, 4};

    @Tag("Сумма двух полиномов")
    @Test
    public void sum() {
        assertEquals(new Polynom(ar),
                new Polynom(ar1).sum(new Polynom(ar2)));
        assertEquals(new Polynom(ar3),
                new Polynom(ar).sum(new Polynom(ar1)));
        assertEquals(new Polynom(ar5),
                new Polynom(ar).sum(new Polynom(ar4)));
    }

    @Tag("Разность двух полиномов")
    @Test
    public void dif() {
        double difar[] = new double[] {3, 0, 2, 1};
        double difar2[] = new double[] {-3, -12, 3, -3, 13, 4};
        double difar3[] = new double[] {2, 4, 6};
        assertEquals(new Polynom(difar),
                new Polynom(ar).dif(new Polynom(ar1)));
        assertEquals(new Polynom(difar2),
                new Polynom(ar).dif(new Polynom(ar4)));
        assertEquals(new Polynom(difar3),
                new Polynom(ar3).dif(new Polynom(ar2)));

    }

    @Tag("Рассчёт значения полинома при данном(целом) х")
    @Test
    public void whatx() {
        int x = 3, x1 = 5;
        assertEquals(106, new Polynom(ar).whatx(x));
        assertEquals(38, new Polynom(ar1).whatx(x1));
        assertEquals(1816, new Polynom(ar5).whatx(x));
    }

    @Tag("Умножение двух полиномов:")
    @Test
    public void multipl() {
        double multiplar[] = new double[] {3, 7, 15, 15, 20, 12};
        double multiplar2[] = new double[] {9, 36, 6, 39, -15, 8, -14, -9, 0};
        double multiplar3[] = new double[] {3, 8, 19, 25, 32, 21};
        assertEquals(new Polynom(multiplar),
                new Polynom(ar).multipl(new Polynom(ar1)));
        assertEquals(new Polynom(multiplar2),
                new Polynom(ar2).multipl(new Polynom(ar4)));
        assertEquals(new Polynom(multiplar3),
                new Polynom(ar1).multipl(new Polynom(ar3)));

    }

    private double divar[] = new double[] {3, -5};
    private double divar2[] = new double[] {5, 19};
    private double divar3[] = new double[] {1};
    private double divar4[] = new double[] {-3, -1, -4, -4};

    @Tag("Результат деления одного полинома на полином")
    @Test
    public void div() {
        assertEquals(new Polynom(divar),
                new Polynom(ar).div(new Polynom(ar1)));
        assertEquals(new Polynom(divar3),
                new Polynom(ar4).div(new Polynom(ar5)));
    }

    @Tag("Остаток от деления одного полинома на другой")
    @Test
    public void divost() {
        assertEquals(new Polynom(divar2),
                new Polynom(ar).divost(new Polynom(ar1)));
        assertEquals(new Polynom(divar4),
                new Polynom(ar4).divost(new Polynom(ar5)));

    }
}

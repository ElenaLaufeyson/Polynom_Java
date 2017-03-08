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
        assertEquals(new Polynom(3, ar),
                new Polynom(2, ar1).sum(new Polynom(3, ar2)));
        assertEquals(new Polynom(3, ar3),
                new Polynom(3,ar).sum(new Polynom(2, ar1)));
        assertEquals(new Polynom(5, ar5),
                new Polynom(3, ar).sum(new Polynom(5, ar4)));
    }

    @Tag("Разность двух полиномов")
    @Test
    public void dif() {
        double difar[] = new double[] {3, 0, 2, 1};
        double difar2[] = new double[] {-3, -12, 3, -3, 13, 4};
        double difar3[] = new double[] {2, 4, 6};
        assertEquals(new Polynom(3, difar),
                new Polynom(3, ar).dif(new Polynom(2, ar1)));
        assertEquals(new Polynom(5, difar2),
                new Polynom(3, ar).dif(new Polynom(5, ar4)));
        assertEquals(new Polynom(2, difar3),
                new Polynom(3, ar3).dif(new Polynom(3, ar2)));

    }

    @Tag("Рассчёт значения полинома при данном(целом) х")
    @Test
    public void whatx() {
        int x = 3, x1 = 5;
        assertEquals(106, new Polynom(3, ar).whatx(x));
        assertEquals(38, new Polynom(2, ar1).whatx(x1));
        assertEquals(1816, new Polynom(5, ar5).whatx(x));
    }

    @Tag("Умножение двух полиномов:")
    @Test
    public void multipl() {
        double multiplar[] = new double[] {3, 7, 15, 15, 20, 12};
        double multiplar2[] = new double[] {9, 36, 6, 39, -15, 8, -14, -9, 0};
        double multiplar3[] = new double[] {3, 8, 19, 25, 32, 21};
        assertEquals(new Polynom(5, multiplar),
                new Polynom(3, ar).multipl(new Polynom(2, ar1)));
        assertEquals(new Polynom(8, multiplar2),
                new Polynom(3, ar2).multipl(new Polynom(5, ar4)));
        assertEquals(new Polynom(5, multiplar3),
                new Polynom(2, ar1).multipl(new Polynom(3, ar3)));

    }

    private double divar[] = new double[] {3, -5};
    private double divar2[] = new double[] {5, 19};
    private double divar3[] = new double[] {1};
    private double divar4[] = new double[] {-3, -1, -4, -4};

    @Tag("Результат деления одного полинома на полином")
    @Test
    public void div() {
        assertEquals(new Polynom(1, divar),
                new Polynom(3, ar).div(new Polynom(2, ar1)));
        assertEquals(new Polynom(0, divar3),
                new Polynom(5, ar4).div(new Polynom(5, ar5)));
    }

    @Tag("Остаток от деления одного полинома на другой")
    @Test
    public void divost() {
        assertEquals(new Polynom(1, divar2),
                new Polynom(3, ar).divost(new Polynom(2, ar1)));
        assertEquals(new Polynom(3, divar4),
                new Polynom(5, ar4).divost(new Polynom(5, ar5)));

    }
}

package My_Polynom;

public class Main {

    public static void main(String[] args) {
        double ar[] = new double[]{3, 2, 1, 0};
        Polynom p = new Polynom(ar);
        System.out.print("p: ");
        p.show();
        double ar1[] = new double[]{1, 2, -1};
        Polynom p1 = new Polynom(ar1);
        System.out.print("p1: ");
        p1.show();
        if (p.equals(p1)) System.out.println("p=p1");
        else System.out.println("p!=p1");
        Polynom res = p.sum(p1);
        System.out.print("p+p1 = ");
        res.show();
        Polynom res2 = p.dif(p1);
        System.out.print("p-p1= ");
        res2.show();
        int x = -2;
        System.out.println("If x=" + x + ", p= " + p.whatx(x) +
                " and p1= " + p1.whatx(x));
        Polynom res3 = p.multipl(p1);
        System.out.print("p*p1= ");
        res3.show();
        Polynom res4 = p.div(p1);
        System.out.print("p/p1=");
        res4.show();
        Polynom res5 = p.divost(p1);
        System.out.print("Остаток от деления p/p1= ");
        res5.show();
        System.out.println("Искомый коэффициент: " + p.getCoefficient(3));
    }
}

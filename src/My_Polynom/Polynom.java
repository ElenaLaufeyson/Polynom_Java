package My_Polynom;

import java.util.Arrays;

/**
 * Created by Elena on 16.02.2017
 */

public class Polynom {
    private int deg;
            double array[];

    @Override
    public String toString() {
        String s = new String("");
        for (int i=this.deg; i>=0; i--) {
            if (this.array[i] == 0) continue;
            if ((this.array[i] > 0) && (i!=this.deg))
                s += "+";
            if ((int)this.array[i] == this.array[i]) s += (int)this.array[i];
            else s+= this.array[i];
            if (i == 1) s+= "x";
            else if (i != 0) s+= "x^" + i;
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Polynom polynom = (Polynom) o;

        if (deg != polynom.deg) return false;
        return Arrays.equals(array, polynom.array);

    }

    @Override
    public int hashCode() {
        int result = deg;
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    public Polynom(int deg, double[] array) {
        if (deg+1 != array.length) throw new IllegalArgumentException("Степень полинома " +
                "не равна числу коэффициентов!");
        this.deg = deg;
        this.array = new double [deg+1]; //или new int [array.lenght]
        for (int i=0;i<this.array.length;i++) {
            this.array[i] = array[array.length-1-i];
        }
    }

    public Polynom(int deg) {
        this.deg = deg;
        this.array = new double[this.deg+1];
    }

    public Polynom(Polynom p) {
        this.deg = p.deg;
        this.array = new double[this.deg+1];
        System.arraycopy(p.array, 0, this.array, 0, p.deg+1);
    }

    public void show() {
        System.out.println(this);
    }


    public Polynom sum(Polynom p2) {
        int max = Math.max(this.deg, p2.deg), min = Math.min(this.deg, p2.deg);
        Polynom res = new Polynom(max); //новый полином размера большего из складываемых полиномов
        for (int i=0; i<=min; i++) {
            res.array[i] = this.array[i] + p2.array[i];
        }
        if (this.deg > p2.deg) System.arraycopy(this.array, min+1, res.array, min+1, max-min);
        else if (p2.deg > this.deg) System.arraycopy(p2.array, min+1, res.array, min+1, max-min);
        res.cut0();
        return res;
    }

    public void invert() {
        for (int i=0; i<=this.deg; i++)
            this.array[i] = -this.array[i];
    }

    public Polynom dif(Polynom p2) {
          Polynom copyp2 = new Polynom(p2);
          copyp2.invert();
          Polynom res = this.sum(copyp2);
          return res;
    }

    public double whatx(int x) {
        double result = this.array[0];
        for (int i=1;i<=this.deg;i++) {
            result += this.array[i]*Math.pow((double)x, (double)i);
        }
        return result;
    }

    public void cut0() {
        if (this.deg == 0) return;
        int i;
        Polynom cutPol = new Polynom(this);
        for (i = this.deg; i >= 0; i--) {
            if (this.array[i] != 0) break;
        }
        if (i == this.deg || i == -1) return;
        this.deg = i;
        this.array = new double[this.deg + 1];
        System.arraycopy(cutPol.array, 0, this.array, 0, this.deg + 1);
        System.gc();
        return;
    }

    public Polynom multipl(Polynom p2){
        Polynom res = new Polynom(this.deg+p2.deg);
        for (int i=this.deg;i>=0;i--) {
            for (int j=p2.deg;j>=0;j--) {
                res.array[i+j] += this.array[i] * p2.array[j];
            }
        }
        res.cut0();
        return res;
    }

    public Polynom div (Polynom p2, boolean resb) {
        if (this.equals(p2)) {
            Polynom res = new Polynom(1);
            res.array[0] = 1;
            Polynom ost = new Polynom(1);
            ost.array[0] = 0;
            if (resb) return res;
            else return ost;
        }
        this.cut0(); p2.cut0();
        if (p2.array[p2.deg] == 0.0) throw new IllegalArgumentException("На ноль делить нельзя!");
        Polynom ost = new Polynom(this);
        Polynom res = new Polynom(this.deg);
        Polynom multipleres = new Polynom(p2.deg);
        Polynom mnog = new Polynom(this.deg);
        double mn;
        while (ost.deg >= p2.deg) {
            mn = ost.array[ost.deg] / p2.array[p2.deg];
            res.array[ost.deg - p2.deg] = mn;
            Arrays.fill(mnog.array, 0);
            mnog.array[ost.deg - p2.deg] = mn;
            multipleres = p2.multipl(mnog);
            ost = ost.dif(multipleres);
        }
        res.cut0();
        ost.cut0();
        if (resb) return res;
        else return ost;
    }
}

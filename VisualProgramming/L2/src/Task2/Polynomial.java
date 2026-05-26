package Task2;

public class Polynomial {
    int a,b,c,d,e,f;
    Polynomial(int a, int b, int c, int d, int e, int f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    public void display(){
        if(a!=0){
            System.out.println(a + "x^5");
        }
        if(b!=0){
            System.out.println(b + "x^4");
        }
        if(c!=0){
            System.out.println(c + "x^3");
        }
        if(d!=0){
            System.out.println(d + "x^2");
        }
        if(e!=0){
            System.out.println(e + "x");
        }
        if(f!=0){
            System.out.println(f);
        }
    }

    public void addition(Polynomial p1, Polynomial p2){
        int a = p1.a + p2.a;
        int b = p1.b + p2.b;
        int c = p1.c + p2.c;
        int d = p1.d + p2.d;
        int e = p1.e + p2.e;
        int f = p1.f + p2.f;
    }
    public void subtraction(Polynomial p1, Polynomial p2){
        int a = p1.a - p2.a;
        int b = p1.b - p2.b;
        int c = p1.c - p2.c;
        int d = p1.d - p2.d;
        int e = p1.e - p2.e;
        int f = p1.f - p2.f;
    }
    public void multiplication(Polynomial p1, Polynomial p2){
        int a = p1.a * p2.a;
        int b = p1.b * p2.b;
        int c = p1.c * p2.c;
        int d = p1.d * p2.d;
        int e = p1.e * p2.e;
        int f = p1.f * p2.f;
    }

}

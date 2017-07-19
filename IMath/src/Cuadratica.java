public class Cuadratica {
    double a;
    double b;
    double c;
    double x;
    double y;
    
    public Cuadratica(double a,double b,double c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        x=-b/(2*a);
        y=a*(x*x)+b*x+c;
    }
    
    public void getVertx ()
    {
        x=-b/(2*a);
        y=a*(x*x)+b*x+c;
        System.out.println("Vértice: ("+x+","+y+")");
    }
    
    public void printFunction(double x1, double x2)
    {
        for(double i=x1;i<=x2;i++)
        {
            x=i;
            y=a*(x*x)+b*x+c;
            System.out.println("("+x+","+y+")");
        }
        
    }
    public void getRaiz()
    {
        double delta=(b*b)-4*a*c;
        double r1,r2;
        if (delta>0)
        {
            r1=(-b+Math.sqrt(delta))/(2*a);
            r2=(-b-Math.sqrt(delta))/(2*a);
            System.out.println("Raíces: x1="+r1+" y  x2="+r2);
        }
        else if(delta==0)
        {
            r1=-b/(2*a);
            System.out.print("2 Raíces en R iguales: x="+r1);
        }
        else
        {
            System.out.println("No existen Raíces en R");
        }
        
    }
}

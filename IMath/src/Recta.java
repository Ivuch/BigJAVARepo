public class Recta {
    int m;
    int b;
    int x,y;
    
    public Recta(int x, int y, int x2, int y2)
    {
        if(x!=x2)
        {
            m=(y2-y)/(x2-x);
            b=y-(m*x);
            this.x=x;
            this.y=y;
        }
        else
        {
            System.out.println("A function cannot Repeat his Dom.");
        }
        
    }
    
    public Recta(int ordOrigen, int pendiente)
    {   
       m =pendiente;
       b=ordOrigen;
       x=0;
       y=b;
    }
    
    public void getPoint(int x)
    {
        this.x=x;
        y=m*x+b;
        System.out.println("("+x+","+y+")");
    }
    
    public void getRect(int x1, int x2)
    {
        for(int i=x1;i<=x2;i++)
        {
            x=i;
            y=m*x+b;
            System.out.print("("+x+","+y+")");
        }
        
        
    }
   
    public boolean tryPoint(int x1,int y1)
    {
        boolean pertenece;
        x=x1;
        y=m*x+b;
        if(y==y1)
        {
            pertenece=true;
        }
        else 
        {
            pertenece=false;
        }
        return(pertenece);
    }
}

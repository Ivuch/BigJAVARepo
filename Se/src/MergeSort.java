public class MergeSort {
    int[]A;
    public int[] ordenadaMerge(int[]L)
    {
        int m;
        int[]L1,L2;
        m=(int)Math.ceil(L.length/2.0);
        L1=new int[m];
        L2=new int[m];
        for(int i=0;i<m;i++)
        {
            L1[i]=L[i];
        }
        
        L=merge(ordenadaMerge(L1),ordenadaMerge(L2));
        return L;
    }
    
    public int[] merge(int[]L1,int[]L2)
    {
        int []L=new int[L1.length+L2.length];
        
        return L;
    }
}

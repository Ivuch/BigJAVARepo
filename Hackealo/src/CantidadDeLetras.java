
public class CantidadDeLetras {

	String letras = "PGdzAMUScaKumaRWXeiWHgLxtguDpygoDwEbceKAFBrAIyeDYokQvvCiKPIPArBTkwGkxbJDxtByndLAiVnRWDTHRbuybkYnNRlsSpWXsMxkfUvFuYSHEyKlnXSMuXhSEdLqqRlwhRHQNHjjupCmyGqWBtNVZanrQsdGwNrMjREuVdgoiUCTnowhAjWOaMaDGfokaTv";
	
	public CantidadDeLetras(){
	
		int a=0;
		int b=0;
		int c=0;
		int d=0;
		int e=0;
		int f=0;
		int g=0;
		int h=0;
		int i=0;
		int j=0;
		int k=0;
		int l=0;
		int m=0;
		int n=0;
		int ñ=0;
		int o=0;
		int p=0;
		int q=0;
		int r=0;
		int s=0;
		int t=0;
		int u=0;
		int v=0;
		int w=0;
		int x=0;
		int y=0;
		int z=0;
		
		String[] splited = letras.split("");
		for(String let: splited){
			
			if(let.toUpperCase().equals("A")|| let.toLowerCase().equals("a")){
				a++;
				let = null;
			}else if(let.toUpperCase().equals("B")|| let.toLowerCase().equals("b")){
				b++;
				let=null;
			}else if(let.toUpperCase().equals("C")|| let.toLowerCase().equals("c")){
				c++;
				let=null;
			}
			else if(let.toUpperCase().equals("D")|| let.toLowerCase().equals("d")){
				d++;
				let=null;
			}else if(let.toUpperCase().equals("E")|| let.toLowerCase().equals("e")){
				e++;
				let=null;
			}else if(let.toUpperCase().equals("F")|| let.toLowerCase().equals("f")){
				f++;
				let=null;
			}else if(let.toUpperCase().equals("G")|| let.toLowerCase().equals("g")){
				g++;
				let=null;
			}else if(let.toUpperCase().equals("H")|| let.toLowerCase().equals("h")){
				h++;
				let=null;
			}else if(let.toUpperCase().equals("I")|| let.toLowerCase().equals("i")){
				i++;
				let=null;
			}else if(let.toUpperCase().equals("J")|| let.toLowerCase().equals("j")){
				j++;
				let=null;
			}
			else if(let.toUpperCase().equals("K")|| let.toLowerCase().equals("k")){
				k++;
				let=null;
			}else if(let.toUpperCase().equals("L")|| let.toLowerCase().equals("l")){
				l++;
				let=null;
			}else if(let.toUpperCase().equals("M")|| let.toLowerCase().equals("m")){
				m++;
				let=null;
			}else if(let.toUpperCase().equals("N")|| let.toLowerCase().equals("N")){
				n++;
				let=null;
			}else if(let.toUpperCase().equals("Ñ")|| let.toLowerCase().equals("ñ")){
				ñ++;
				let=null;
			}else if(let.toUpperCase().equals("O")|| let.toLowerCase().equals("o")){
				o++;
				let=null;
			}else if(let.toUpperCase().equals("P")|| let.toLowerCase().equals("p")){
				p++;
				let=null;
			}else if(let.toUpperCase().equals("Q")|| let.toLowerCase().equals("q")){
				q++;
				let=null;
			}else if(let.toUpperCase().equals("R")|| let.toLowerCase().equals("r")){
				r++;
				let=null;
			}else if(let.toUpperCase().equals("S")|| let.toLowerCase().equals("s")){
				s++;
				let=null;
			}else if(let.toUpperCase().equals("T")|| let.toLowerCase().equals("t")){
				t++;
				let=null;
			}else if(let.toUpperCase().equals("U")|| let.toLowerCase().equals("u")){
				u++;
				let=null;
			}else if(let.toUpperCase().equals("V")|| let.toLowerCase().equals("v")){
				v++;
				let=null;
			}else if(let.toUpperCase().equals("W")|| let.toLowerCase().equals("w")){
				w++;
				let=null;
			}else if(let.toUpperCase().equals("X")|| let.toLowerCase().equals("x")){
				x++;
				let=null;
			}else if(let.toUpperCase().equals("Y")|| let.toLowerCase().equals("y")){
				y++;
				let=null;
			}else if(let.toUpperCase().equals("Z")|| let.toLowerCase().equals("z")){
				z++;
				let=null;
			}
		}
		System.out.println(a+"-"+b+"-"+c+"-"+d+"-"+e+"-"+f+"-"+g+"-"+h+"-"+i+"-"+j+"-"+k+"-"+l+"-"+m+"-"+n+"-"+ñ+"-"+o+"-"+p+"-"+q+"-"+r+"-"+s+"-"+t+"-"+u+"-"+v+"-"+w+"-"+x+"-"+y+"-"+z);
		adrwknugybhsxemtvilopqcjfz
	}
	
	public static void main(String[] args) {
		CantidadDeLetras c= new CantidadDeLetras();
	}
}

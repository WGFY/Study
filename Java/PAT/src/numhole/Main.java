package numhole;


import java.util.Scanner;

public class Main {
	public static int reverse(int num){
		String s=Integer.toString(num);
		int count=1;
		int k=0;
		for(int i=0;i<s.length();i++)
		{
			k=k + ((int)s.charAt(i)-'0')*count;
			count*=10;
		}
		return k;
	}
	public static int down(int num){
		String s=Integer.toString(num);
		int[] n = new int[s.length()];
		for(int i=0;i<s.length();i++)
		{
			n[i]=(int)(s.charAt(i)-'0');
		}
		n=bubblesort(n);
		int k=0;
		int count=1;
		for(int i=n.length-1;i>=0;i--)
		{
			k=k+n[i]*count;
			count*=10;
		}
		return k;
	}
	public static int[] bubblesort(int[] N){
		out:
		for(int i=0;i<N.length;i++){
			int count=0;
			for(int j=0;j<N.length-1;j++){
				if(N[j]<N[j+1]){
					int temp =N[j+1];
					N[j+1]=N[j];
					N[j]=temp;
					count++;
				}
			}
			if(count==0)
			{
				break out;
			}
		}
	return N;
	}
	
	public static void printhole(int num){
		System.out.printf("%04d - %04d = %04d\n",down(num),reverse(down(num)),down(num)-reverse(down(num)));
		if(reverse(down(num))!=down(num)&&down(num)-reverse(down(num))!=6174){
			printhole(down(num)-reverse(down(num)));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N=in.nextInt();
		printhole(N);
	}

}
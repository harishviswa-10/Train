import java.util.*;
public class Display {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
        int n=102;
        int m=n/6;
        String arr[][]=new String[6][m];
        int l=6;
        for(int j=0;j<m;j++){
        	if(j%2==1) l+=7;
        	else if(j!=0 && j%2==0) l+=5;
        	for(int i=0;i<6;i++){
        		if(j%2==0){
        			if(l<10){
        				String s="0"+String.valueOf(l);
        				arr[i][j]=s;
        			}
        			else arr[i][j]=String.valueOf(l);
        			l--;
        		}
        		else{
        			if(l<10){
        				String s="0"+String.valueOf(l);
        				arr[i][j]=s;
        			}
        			else  arr[i][j]=String.valueOf(l);
        			l++;
        		}
        	}
        }
        while(true){
        System.out.println("------\nEnter 1 to display\nEnter 2 to view seat details\nEnter 3 to shortest path\nEnter 4 to exit\n-------");
		int choose=sc.nextInt();
        if(choose==1){
        	System.out.println("Enter no of seats to display");
        	int d=sc.nextInt();
        	int a=d/6;
        	int b=d%6;
        	if(b>0) a+=1;
         for(int i=0;i<6;i++){
        	if(i==3){
        		for(int k=0;k<a;k++){
        			if(k%2==0) System.out.print(" .");
        			else  System.out.print(" . .");
        		}
        		System.out.print("\n");
        	}
        	for(int j=0;j<a;j++){
        		if(j%2==0) System.out.print("|");
        		else System.out.print("-");
        		if(Integer.parseInt(arr[i][j])>d) System.out.print("*");
        		else System.out.print(arr[i][j]);
        		if(j%2==1 && j==a-1) System.out.print("|");
        		else if(j%2==0 && j==a-1) System.out.print("-");
        	}
        	System.out.print("\n");
         }
		}
        else if(choose==2){
        	System.out.println("Enter Seat No to show Details");
        	String search=sc.next();
        	if(Integer.parseInt(search)<10) search="0"+search;
        	String type="normal",cb="",adj_seat="",row="left";
        	for(int j=0;j<m;j++){
        		for(int i=0;i<6;i++){
        			if(arr[i][j].equals(search)){
        				if(i==0 || i==5) type="window";
        				if(j%2==1) row="right";
        				int c=(j/2)+1;
        				int b=1;
        				if(i<3) b=2;
        				cb="C"+c+"-B"+b;
        				String s="";
        				if(j==0) s="0,"+arr[i][j+1];
        				else if(j==m-1) s=arr[i][j-1]+",0";
        				else s=arr[i][j-1]+","+arr[i][j+1];
        				adj_seat=s;
        			}
        		}
        	}
        	System.out.println("Type of Seat:"+type);
        	System.out.println("Compartment-Block:"+cb);
        	System.out.println("Adjacent seats:"+adj_seat);
        	System.out.println("Row:"+row);
        }
        else if(choose==3){
        	System.out.println("Enter source seat:");
        	String s=sc.next();
        	if(Integer.parseInt(s)<10) s="0"+s;
        	System.out.println("Enter destination seat:");
        	String des=sc.next();
        	if(Integer.parseInt(des)<10) des="0"+des;
        	int a=0,b=0,c=1,d=1,x=0,y=0;
        	for(int j=0;j<m;j++){
        		for(int i=0;i<6;i++){
        			if(arr[i][j].equals(s)){
        				a=(j/2)+1;
        				if(i<3) c=2;
        				x=i;
        			}
        			if(arr[i][j].equals(des)){
        				b=(j/2)+1;
        				if(i<3) d=2;
        				y=i;
        			}
        		}
        	}
        	int step=0;
        	if(a!=b){
        		step+=4;
        		step+=(Math.abs(a-b)-1)*3;
        		if(x==2 || x==3) step+=1;
        	    else if(x==1 || x==4) step+=2;
        	    else step+=3;
        	    if(y==2 || y==3) step+=1;
        	    else if(y==1 || y==4) step+=2;
        	    else step+=3;
        	}
        	else if(a==b && c!=d){
        		step=1;
        		if(x==2 || x==3) step+=1;
        	    else if(x==1 || x==4) step+=2;
        	    else step+=3;
        	    if(y==2 || y==3) step+=1;
        	    else if(y==1 || y==4) step+=2;
        	    else step+=3;
        	}
        	else if(a==b && c==d){
        		if(x==y) step=1;
        		else step=Math.abs(x-y)+1;
        	}
        	System.out.println(step+" steps");
        }
        else break;
        }
	}

}

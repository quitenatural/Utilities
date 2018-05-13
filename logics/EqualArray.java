package HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EqualArray {
// Find the minimum non negative number X in the array such that there exist an index j where u can replace A[j] by A[J]+X ,
// and the sum of the array from index 1 to j and j+1 to N becomes equal , where 1<= j<=N-1 . Assume array to be 1-indexed.
//If there is no possible X print -1 in separate line .(DELL EMC)        
public static void main(String[] args) throws NumberFormatException,
IOException {
// TODO Auto-generated method stub
int t,n;
int a[] ;
String arr[] = null ;
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t= Integer.parseInt(br.readLine());
        for (int i =0 ; i <t ;i ++) {
        n= Integer.parseInt(br.readLine());
        a= new int [n];
        arr=br.readLine().split(" ");
        for (int y = 0 ; y <n;y++) {
        a[y]=Integer.parseInt(arr[y]);
        }
        if (a.length==2&&a[0]<a[1]) {
        System.out.println(a[1]-a[0]);
        continue;
        }
        else if (a.length==2&&a[0]>a[1]) {
        System.out.println(-1);
        continue;
        }
        int mid ,L,R;
        if (n%2==0) {
        mid=n/2;
        }
        else {
        mid=(n+1)/2;
        }
        L=R=0;
        for (int y =0 ;y<mid;y++) {
        L+=a[y];
        }
        for (int y =mid; y<n;y++) {
        R+=a[y];
        }
        //System.out.println(L+" "+R);

        int tempL=0, tempR=0,flag =-1;
        for (int y = mid ; L<=R&&y<n;y++) {
        if (L==R) {
        System.out.println(0);
        continue;
        }
        tempL=L;
        tempR=R;
        L=L+a[y];
        R=R-a[y];
        flag=1;
        }
        if (flag==1) {

        System.out.println(tempR-tempL);
        continue;
        }

        //System.out.println(L+" "+R);
        for(int y = mid-1;R<=L&&y>0;y--) {
        if (L==R) {
        System.out.println(0);
        continue;
        }
        R=R+a[y];
        L=L-a[y];
        flag=0;
        }

        //System.out.println(L+" "+R);

        if (flag==0) {
        if (L>R) {
                System.out.println(-1);
                continue;
                }
            System.out.println(R-L);
            continue;
        }


        }
}

}

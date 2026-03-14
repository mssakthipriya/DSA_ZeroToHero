package I.BinarySearch.Answers;

public class RoseBoquet {
    public static int getBoquetCount(int[] arr,int mid,int n){
        int count=0;
        int boq=0;
        for(int i=0;i< arr.length;i++){
            if(arr[i]<=mid) {
                count++;
            }
            else {
                boq+=(count/n);
                System.out.println(count/n);
                count=0;
            }
        }
        
        boq+=(count/n);
        
     return boq;
    }
    public static int roseBoquet(int[] arr,int m,int n){
        int l=Integer.MAX_VALUE;
        int r=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            l=Math.min(l,arr[i]);
            r=Math.max(r,arr[i]);
        }
        while(l<=r){
            int mid =(l+r)/2;
            int boq=getBoquetCount(arr,mid,n);
            System.out.println("Boquet:"+boq +" Mid: "+mid);
            if(boq<m){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
    	int[] arr={7, 7, 7, 7, 13, 11, 12, 7};
        int m=2;
        int n=3;
        System.out.println("Number of days: "+roseBoquet(arr,m,n));

	}
    
}


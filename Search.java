public class Search {


    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target)
                return i;

        return -1;
    }
    public static boolean contains(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target)
                return true;

        return false;
    }
    public static int [] find(int [] [] arr,int target){
        for(int row = 0; row<arr.length;row++){
            for(int col = 0;col<arr[row].length;col++){
                if(arr[row][col]==target)
                return new int [] {row ,col};
            }
        }
        return new int [] {-1,-1};
    }


    public static int binarySearch(int [] arr , int target){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;

        while(low<=high){
            mid = (low+high)/2;

            if(arr[mid]==target){
                return mid;
            } else if(arr[mid]>target){
                high =mid-1;
            } else if(arr[mid]<target){
                low=mid+1;
            }
            
        }
        return -1;
    }

        
}

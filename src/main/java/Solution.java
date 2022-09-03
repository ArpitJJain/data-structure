import java.util.*;

class Solution {

    LinkedHashMap<String, Integer> HUP = new LinkedHashMap<> ();
    LinkedHashMap<Integer,String> HDOWN = new LinkedHashMap<> ();

    LinkedHashMap<Integer,String> M2E = new LinkedHashMap<> ();

    public Solution(){

    }
    public static void main(String[] args) {
        Solution s= new Solution();
        s.hasArrayTwoCandidates(new int[]{1 ,2, 5, 6, 7},5,4);

    }

    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        Set<Integer> a = new HashSet<>();
        Arrays.stream(arr).forEach(i -> a.add(i));
        int count = 0;
        for(int i = 0; i < arr.length;i++){
            if(a.contains(x-arr[i])){
                count++;
            }
        }
        if(count >=2){
            return true;
        }
        return false;
    }

}

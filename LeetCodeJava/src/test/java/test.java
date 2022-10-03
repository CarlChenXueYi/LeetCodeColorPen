import java.util.*;

public class test {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String a=in.nextLine();
//        a=a.toLowerCase(Locale.ROOT);
//        char[] out=a.toCharArray();
//        int len=out.length;
//        char[] newOut= new char[len];
//        int count=0;
//        for (int i=0;i<len;i++){
//            if ((out[i]>='0'&&out[i]<='9')||(out[i]>='a'&&out[i]<='z')||(out[i]>='A'&&out[i]<='Z')){
//                newOut[count]=out[i];
//                count++;
//            }
//        }
//        int end=count;
//        for(int i=0;i<count/2;i++){
//            if (newOut[i]!=newOut[end-1-i]){
//                System.out.println(false);
//                return;
//            }
//        }
//        System.out.println(true);
        int[] arr = new int[]{2, 4, 3, 5, 1};
        Arrays.stream(arr).sorted();
//        int sum=0;
//        for(int i=arr.length-1;i>=0;i--){
//            if (sum>=0) {
//                sum = sum - arr[i];
//            }else{
//                sum=sum+arr[i];
//            }
//        }
        int sum = Arrays.stream(arr).sum();
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            sum = sum - 2 * arr[i];
            if (sum < 0) {
                break;
            }
        }
        System.out.println(arr[i]);
        System.out.println(sum);
    }
}

import java.util.LinkedHashMap;
import java.util.Map;
class Solution {

    LinkedHashMap<String, Integer> HUP = new LinkedHashMap<> ();
    LinkedHashMap<Integer,String> HDOWN = new LinkedHashMap<> ();

    LinkedHashMap<Integer,String> M2E = new LinkedHashMap<> ();

    public Solution(){
        HUP.put("Billion",1000000000);
        HUP.put("Million",1000000);
        HUP.put("Thousand",1000);
        HUP.put("Hundred",100);
        HUP.put("Tens",10);

        HDOWN.put(9,"Ninety");
        HDOWN.put(8,"Eighty");
        HDOWN.put(7,"Seventy");
        HDOWN.put(6,"Sixty");
        HDOWN.put(5,"Fifty");
        HDOWN.put(4,"Forty");
        HDOWN.put(3,"Thirty");
        HDOWN.put(2,"Twenty");


        M2E.put(1,"One");
        M2E.put(2,"Two");
        M2E.put(3,"Three");
        M2E.put(4,"Four");
        M2E.put(5,"Five");
        M2E.put(6,"Six");
        M2E.put(7,"Seven");
        M2E.put(8,"Eight");
        M2E.put(9,"Nine");
        M2E.put(10,"Ten");
        M2E.put(11,"Eleven");
        M2E.put(12,"Twelve");
        M2E.put(13,"Thirteen");
        M2E.put(14,"Fourteen");
        M2E.put(15,"Fifteen");
        M2E.put(16,"Sixteen");
        M2E.put(17,"Seventeen");
        M2E.put(18,"Eighteen");
        M2E.put(19,"Nineteen");


    }

    public String numberToWords(int num) {
        {
            if (num == 0) {
                return "Zero";
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> e : HUP.entrySet()) {
                int temp = num / e.getValue();
                if ((temp == 0 && !e.getKey().equals("Tens")) || (e.getKey().equals("Tens") && num % e.getValue() == 0 && temp == 0)) {
                    continue;
                }

                if (e.getKey().equals("Tens")) {
                    boolean isTeenNumber = HDOWN.containsKey(temp);
                    if (isTeenNumber) {
                        String appender = M2E.get(num % e.getValue());
                        sb.append(HDOWN.get(temp)).append(" ");
                        if(appender!=null){
                            sb.append(appender).append(" ");
                        }
                        break;
                    } else {
                        sb.append(M2E.get(num));
                        break;
                    }
                } else {
                    String text = M2E.get(temp);
                    if (text == null) {
                        text = this.numberToWords(temp);
                    }
                    sb.append(text).append(" ").append(e.getKey());
                }
                //if(temp > 1){
                //    sb.append("s");
                //}
                sb.append(" ");
                num = num % e.getValue();
            }

            //System.out.println(num);
            return sb.toString().trim();
        }
    }
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.numberToWords(Integer.MAX_VALUE));
    }

}

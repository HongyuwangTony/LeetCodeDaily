import java.util.HashMap;

public class Q166_FractionToRecurringDecimal {
    static class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) return "0";
            StringBuilder sb = new StringBuilder();
            if (numerator > 0 != denominator > 0) sb.append('-');
            long num = Math.abs((long) numerator);
            long den = Math.abs((long) denominator);
            sb.append(num / den);
            num = num % den;
            if (num == 0) return sb.toString();
            sb.append('.');
            HashMap<Long, Integer> map = new HashMap<>();
            map.put(num, sb.length());
            while (num != 0) {
                num *= 10;
                sb.append(num / den);
                num = num % den;
                if (map.containsKey(num)) {
                    sb.insert(map.get(num), "(");
                    sb.append(')');
                    break;
                }
                map.put(num, sb.length());
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(1, 2));
        System.out.println("Expected: 0.5\n");

        System.out.println(new Solution().fractionToDecimal(2, 1));
        System.out.println("Expected: 2\n");

        System.out.println(new Solution().fractionToDecimal(2, 3));
        System.out.println("Expected: 0.(6)\n");

        System.out.println(new Solution().fractionToDecimal(-1, 2));
        System.out.println("Expected: -0.5\n");

        System.out.println(new Solution().fractionToDecimal(-2, 1));
        System.out.println("Expected: -2\n");

        System.out.println(new Solution().fractionToDecimal(-2, 3));
        System.out.println("Expected: -0.(6)\n");

        System.out.println(new Solution().fractionToDecimal(4, 333));
        System.out.println("Expected: -0.(012)\n");

        System.out.println(new Solution().fractionToDecimal(0, 3));
        System.out.println("Expected: 0\n");

        System.out.println(new Solution().fractionToDecimal(0, -5));
        System.out.println("Expected: 0\n");

        System.out.println(new Solution().fractionToDecimal(-1, -2147483648));
        System.out.println("Expected: 0.0000000004656612873077392578125\n");
    }
}

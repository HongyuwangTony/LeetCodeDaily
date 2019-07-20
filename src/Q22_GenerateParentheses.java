import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q22_GenerateParentheses {
    static class Solution {
        public void generateParenthesis(int left_rem, int right_rem, int curr_status, String header, List<String> acc) {
            if (left_rem < 0 || right_rem < 0 || curr_status < 0) return;
            if (left_rem == 0 && right_rem == 0) {
                acc.add(header + ')');
                return;
            }
            generateParenthesis(left_rem - 1, right_rem, curr_status + 1, header + '(', acc);
            generateParenthesis(left_rem, right_rem - 1, curr_status - 1, header + ')', acc);
        }

        public List<String> generateParenthesis(int n) {
            List<String> ret = new LinkedList<>();
            generateParenthesis(n - 1, n - 1, 1, "(", ret);
            return ret;
        }
    }
}

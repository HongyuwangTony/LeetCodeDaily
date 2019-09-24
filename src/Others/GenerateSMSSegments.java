package Others;

import java.util.LinkedList;
import java.util.List;

public class GenerateSMSSegments {
    class Solution {
        public String generateSMS(String input) {
            List<String> segments = new LinkedList<>();
            int currSegLen = 0;
            final int maxSegLen = 160;
            StringBuilder sb = new StringBuilder();
            for (String word : input.split(" ")) {
                int wordLen = word.length();
                if (currSegLen + wordLen > 160) {
                    if (currSegLen + 1 > maxSegLen) {
                        segments.add(sb.toString());
                        sb = new StringBuilder(" ");
                        currSegLen = 1;
                    } else {
                        sb.append(' ');
                        segments.add(sb.toString());
                        sb = new StringBuilder();
                        currSegLen = 0;
                    }
                } else sb.append(" ");
                sb.append(word);
                currSegLen += wordLen;
            }
            String lastSegment = sb.toString();
            if (!lastSegment.isEmpty()) segments.add(lastSegment);

            sb = new StringBuilder();
            int numSegments = segments.size();
            for (int i = 1; i <= numSegments; i++) {
                sb.append(segments.get(i - 1));
                sb.append("(" + i + "/" + numSegments + ")\n");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {

    }

}

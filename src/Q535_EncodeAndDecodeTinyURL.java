import java.util.HashMap;

public class Q535_EncodeAndDecodeTinyURL {
    public static class Codec {
        private long next = 1;
        private HashMap<String, String> long_to_short = new HashMap<>();
        private HashMap<String, String> short_to_long = new HashMap<>();


        private String generateNextString() {
            StringBuilder sb = new StringBuilder();
            while (next != 0) {
                int rem = (int)(next % 62);
                if (rem <= 10) sb.append((char)('0' + (rem-1)));
                else sb.append((char)('A' + (rem-11)));
                next /= 62;
            }
            return sb.toString();
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String shortUrl = long_to_short.get(longUrl);
            if (shortUrl == null) {
                shortUrl = "http://tinyurl.com/" + generateNextString();
                next++;
                long_to_short.put(longUrl, shortUrl);
                short_to_long.put(shortUrl, longUrl);
            }
            return shortUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return short_to_long.get(shortUrl);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}

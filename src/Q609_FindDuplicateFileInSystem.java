import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q609_FindDuplicateFileInSystem {
    static class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            HashMap<String, String> map_content = new HashMap<>();
            HashMap<String, List<String>> map_duplicate = new HashMap<>();
            for (String path : paths) {
                String[] info = path.split(" ");
                String dir = info[0] + "/";
                int numFiles = info.length - 1;
                for (int i = 1; i < numFiles + 1; i++) {
                    String fileInfo = info[i];
                    int split = fileInfo.indexOf('(');
                    String fileName = fileInfo.substring(0, split);
                    String content = fileInfo.substring(split + 1, fileInfo.length() - 1);

                    String value_content = map_content.get(content);
                    List<String> value_duplicate = map_duplicate.get(content);
                    if (value_content == null) map_content.put(content, dir + fileName);
                    else if (value_duplicate == null) {
                        List<String> list = new ArrayList<>();
                        list.add(value_content);
                        list.add(dir + fileName);
                        map_duplicate.put(content, list);
                    } else value_duplicate.add(dir + fileName);
                }
            }
            return new ArrayList<>(map_duplicate.values());
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
        System.out.println(new Solution().findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"}));
    }
}

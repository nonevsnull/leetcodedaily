import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LC68h {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i < n;i++){
            words[i] = st.nextToken();
        }
        int maxWidth = Integer.parseInt(br.readLine());

        List<String> lst = new ArrayList<>();

        int count = 0;
        int wordscount = 0;
        List<String> row = new ArrayList<>();
        for(int i = 0;i < words.length;i++){
            row.add(words[i]);
            count += words[i].length();
            wordscount += words[i].length();
            if(i + 1 < words.length && count + 1 + words[i + 1].length() > maxWidth){
                String r = processRow(row, maxWidth, wordscount);
                lst.add(r);
                count = 0;
                wordscount = 0;
                row.clear();
            } else if(i == words.length - 1) {
                String r = processLast(row, maxWidth, wordscount);
                lst.add(r);
            } else {
                count++;
            }
        }
        for(String s : lst){
            System.out.println(s);
        }

    }
    static String processLast(List<String> lst, int maxWidth, int wordscount) {
        int spacecount = maxWidth - wordscount;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < lst.size();i++){
            sb.append(lst.get(i));
            if(spacecount > 0){
                sb.append(" ");
                spacecount--;
            } 
        }
        if(spacecount > 0){
            sb.append(" ".repeat(spacecount));
        }
        
        return sb.toString();
    }
    static String processRow(List<String> lst, int maxWidth, int wordscount){
        int spacecount = maxWidth - wordscount;
        StringBuilder sb = new StringBuilder();
        if(lst.size() == 1){
            sb.append(lst.get(0));
            sb.append(" ".repeat(spacecount));
            return sb.toString();
        } else {
            int plus = spacecount % (lst.size() - 1);
            int space = spacecount / (lst.size() - 1);
            
            for(int i = 0;i < lst.size();i++){
                sb.append(lst.get(i));
                if(i != lst.size() - 1){
                    sb.append(" ".repeat(space));
                    if(plus > 0){
                        sb.append(" ");
                        plus--;
                    }
                }
            } 
            return sb.toString();
        }
        
        
    }
}

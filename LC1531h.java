import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC1531h {
    static List<HashMap<Integer, Integer>> map = new ArrayList<>();
    static int min = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        String s = br.readLine();
        int k = Integer.parseInt(br.readLine());

        List<CharCount> lst = new ArrayList<>();
        int count = 0;
        char pre = s.charAt(0);
        for(int i = 0;i < s.length();i++){
            char cur = s.charAt(i);
            if(cur == pre){
                count++;
            } else {
                lst.add(new CharCount(pre, count));
                pre = cur;
                count = 1;
            }
        }
        lst.add(new CharCount(pre, count));
        dfs(lst, 0, k);
        System.out.println(min);
        // for(CharCount ss : lst){
        //     System.out.println(ss.c + " " + ss.count);
        // }
        // System.out.println("");
        // System.out.println(count(lst));
        // k = removeBridge(lst, k);
        // if(k > 0){
        //     k = removeLower(lst, k);
        // }
        // if(k > 0){
        //     downgrade(lst, k);
        // }

        // int sum = 0;
        // for(CharCount ss : lst){
        //     String cc = ss.c + "";
        //     if(ss.count != 1){
        //         cc += Integer.toString(ss.count);
        //     }
            
        //     sum += cc.length();
        // }
        // System.out.println(sum);
        
    }

    static void dfs(List<CharCount> lst, int pos, int k){
        if(pos == lst.size()){
            if(k < 2){
                System.out.println(k);
            }
            if(k == 0){
                min = Math.min(min, count(lst));
            }
            return;
        }
        CharCount cur = lst.get(pos);
        if(cur.count <= k){
            int temp = cur.count;
            cur.count = 0;
            dfs(lst, pos + 1, k - temp);
            cur.count = temp;
        }
        dfs(lst, pos + 1, k);
        
        if(cur.count >= 10){
            if(cur.count - 10 + 1 <= k){
                int temp = cur.count;
                cur.count = 9;
                dfs(lst, pos + 1, k - (temp - 10 + 1));
                cur.count = temp;
            }
        } else if (cur.count > 1){
            if(cur.count - 1 <= k){
                int temp = cur.count;
                cur.count = 1;
                dfs(lst, pos + 1, k - (temp - 1));
                cur.count = temp;
            }
        }
    }


    static int count(List<CharCount> lst) {
        for(CharCount ss : lst){
            System.out.println(ss.c + " " + ss.count);
        }
        System.out.println("");
        CharCount pre = lst.get(0);
        int sum = 0;
        for(int i = 1;i < lst.size();i++){
            CharCount cur = lst.get(i);
            if(cur.count == 0){
                continue;
            }
            if(cur.c == pre.c){
                pre.count += cur.count;
            } else {
                String s = pre.c + "";
                if(pre.count != 1){
                    s += pre.count;
                }
                sum += s.length();
                pre = cur;
            }
        }
        String s = pre.c + "";
        if(pre.count != 1){
            s += pre.count;
        }
        sum += s.length();
        return sum;
    }

    static int removeBridge(List<CharCount> lst, int k) {
        int i = 1;
        while(i < lst.size() - 1 && k >= 0){
            CharCount pre = lst.get(i - 1);
            CharCount cur = lst.get(i);
            CharCount next = lst.get(i + 1);
            if(pre.c == next.c){
                if(cur.count <= k){
                    k -= cur.count;
                    lst.remove(i);
                }
                pre.count += next.count;
                lst.remove(i);
            } else {
                i++;
            }
            // for(CharCount ss : lst){
            //     System.out.println(ss.c + " " + ss.count);
            // }
            // System.out.println("");
        }
        return k;
    }

    static int removeLower(List<CharCount> lst, int k){
        int i = 0;
        while(i < lst.size() && k >= 0){
            CharCount cur = lst.get(i);
            if(cur.count <= k){
                k -= cur.count;
                lst.remove(i);
            } else {
                i++;
            }
            // for(CharCount ss : lst){
            //     System.out.println(ss.c + " " + ss.count);
            // }
            // System.out.println("");
        }
        return k;
    }

    static int downgrade(List<CharCount> lst, int k){
        for(int i = 0;i < lst.size();i++){
            if(k <= 0){
                break;
            }
            CharCount cur = lst.get(i);
            if(cur.count >= 10 && cur.count - k < 10){
                k -= cur.count - 10 + 1;
                cur.count = 9;
            }
        }
        return k;
    }

    static class CharCount {
        char c;
        int count;
        CharCount(char c, int count){
            this.c = c;
            this.count = count;
        }
        
    }
}

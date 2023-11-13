class Solution {
    public String sortVowels(String s) {
        List<Character> lst = new ArrayList<>();

        char[] arr = s.toCharArray();
        for(int i = 0;i < arr.length;i++){
            if("AEIOUaeiou".contains(Character.toString(arr[i]))){
                lst.add(arr[i]);
                arr[i] = '0';
            }
        }

        Collections.sort(lst);
        int pos = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == '0'){
                arr[i] = lst.get(pos);
                pos++;
            }
        }

        return new String(arr);
    }
}
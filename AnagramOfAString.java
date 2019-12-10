//Traverse the first string add this to hashmap
//Traverse the 2nd string string and if that character is present in the hashmap decrement the count
//Finally check if the hashmap is empty or not.

public static boolean check(String a,String b){
        //checking anagrams
        Map<Character,Integer> map = new HashMap<>();
        for(Character ch : a.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for(Character ch : b.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            } else {
                map.put(ch, -1);
            }
        }
        Set<Map.Entry<Character,Integer>> s = map.entrySet();
        for(Map.Entry<Character, Integer> entry : s){
            if(entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static int countNoOfAnagram(String a,String b){
        int count=0;
        //sliding window
        for(int i=0;i < a.length() - b.length() + 1 ;i++){
            if(check(a.substring(i,b.length() + i),b))
                count++;
        }
        return count;
    }

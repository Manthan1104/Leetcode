class Solution {
    public String sortVowels(String s) {
        char sarr[]=s.toCharArray();
        ArrayList<Character> storeVowels = new ArrayList<>();
        ArrayList<Integer> storeVowelsIndex=new ArrayList<>();
        String vowels="aeiouAEIOU";
        for(int i=0;i<sarr.length;i++){
            char a=sarr[i];
            if(vowels.indexOf(a) != -1){
                storeVowels.add(a);
                storeVowelsIndex.add(i);
            }
        }
        Collections.sort(storeVowels);
        for (int i = 0; i < storeVowels.size(); i++) {
            int idx = storeVowelsIndex.get(i);
            sarr[idx] = storeVowels.get(i);
        }
        return new String(sarr);
    }
}
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer,Integer> freq=new LinkedHashMap<>();
        for(int i : nums){
            freq.put(i,freq.getOrDefault(i,1)+1);
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int i : freq.keySet()){
            if(freq.get(i)!=2)list.add(i);
        }
        int result[]=new int[list.size()];
        int c=0;
        for(int i : list){
            result[c]=i;
            c++;
        }
        return result;
    }
}
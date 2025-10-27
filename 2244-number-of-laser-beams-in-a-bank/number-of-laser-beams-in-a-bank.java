class Solution {
    public int numberOfBeams(String[] bank) {
        ArrayList<Integer>list=new ArrayList<>();
        for(String i : bank){
            int count=0;
            for(char j : i.toCharArray()){
                if(j=='1')count++;
            }
            if(count>0)list.add(count);
        }
        int sum=0;
        for(int i=1;i<list.size();i++){
            int now=list.get(i-1)*list.get(i);
            sum+=now;
        }
        return sum;
    }
}
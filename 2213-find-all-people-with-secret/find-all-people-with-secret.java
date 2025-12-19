class Solution {
    int[] father;
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b)->Integer.compare(a[2], b[2]));
        father = new int[n];
        for(int i=0; i<n; i++)
            father[i] = i;
        father[firstPerson] = 0;
        int m = meetings.length;
        for(int i=0; i<m; i++){
            int j = i;
            while(j<m && meetings[j][2]==meetings[i][2]){
                int a = meetings[j][0];
                int b = meetings[j][1];
                if(findSet(a)!=findSet(b))
                    union(a, b);
                j++;
            }

            for(int k=i; k<j; k++){
                int a = meetings[k][0];
                int b = meetings[k][1];
                if(findSet(a)!=0 && findSet(b)!=0){
                    father[a] = a;
                    father[b] = b;
                }
            }
            i = j-1;
        }

        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(findSet(i)==0)
                ret.add(i);
        }
        return ret;
    }

    public int findSet(int a){
        if(a!=father[a])
            father[a] = findSet(father[a]);
        return father[a];
    }

    public void union(int a, int b){
        a = father[a];
        b = father[b];
        if(a<b)
            father[b] = a;
        else
            father[a] = b;
    }
}
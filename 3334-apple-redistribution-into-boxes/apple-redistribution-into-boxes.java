class Solution {

    public int minimumBoxes(int[] apple, int[] cap) {
        int sum = Arrays.stream(apple).sum();
        Integer[] boxes = Arrays.stream(cap).boxed().toArray(Integer[]::new);
        Arrays.sort(boxes, (a, b) -> b - a);

        int res = 0;
        while (sum > 0)
            sum -= boxes[res++];

        return res;
    }
}

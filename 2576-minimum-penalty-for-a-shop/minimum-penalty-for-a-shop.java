class Solution {
    public int bestClosingTime(String customers) {
        int maxScore = 0;
        int score = 0;
        int bestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            score += (customers.charAt(i) == 'Y') ? 1 : -1;

            if (score > maxScore) {
                maxScore = score;
                bestHour = i + 1;
            }
        }
        return bestHour;
    }
}
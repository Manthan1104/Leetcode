import java.util.*;

class FoodRatings {
    // Cuisine -> (Rating -> Foods)
    Map<String, TreeMap<Integer, TreeSet<String>>> ratingSystem = new HashMap<>();
    Map<String, String> foodToCuisine = new HashMap<>();
    Map<String, Integer> foodToRating = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            ratingSystem.putIfAbsent(cuisine, new TreeMap<>(Collections.reverseOrder()));
            ratingSystem.get(cuisine).putIfAbsent(rating, new TreeSet<>());
            ratingSystem.get(cuisine).get(rating).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        // Remove from old rating set
        TreeSet<String> oldSet = ratingSystem.get(cuisine).get(oldRating);
        oldSet.remove(food);
        if (oldSet.isEmpty()) {
            ratingSystem.get(cuisine).remove(oldRating);
        }

        // Update maps
        foodToRating.put(food, newRating);

        // Add to new rating set
        ratingSystem.get(cuisine).putIfAbsent(newRating, new TreeSet<>());
        ratingSystem.get(cuisine).get(newRating).add(food);
    }

    public String highestRated(String cuisine) {
        // First entry = highest rating (since reverse order)
        Map.Entry<Integer, TreeSet<String>> entry = ratingSystem.get(cuisine).firstEntry();
        return entry.getValue().first(); // lexicographically smallest food at that rating
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
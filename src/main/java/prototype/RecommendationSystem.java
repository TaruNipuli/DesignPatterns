package prototype;

import java.util.ArrayList;
import java.util.List;

// Holds all recommendations and allows cloning
public class RecommendationSystem {
    private List<Recommendation> recommendations;

    public RecommendationSystem() {
        this.recommendations = new ArrayList<>();
    }

    // Add a new recommendation
    public void addRecommendation(Recommendation recommendation) {
        recommendations.add(recommendation);
    }

    // Show all recommendations
    public void showRecommendations() {
        for (Recommendation r : recommendations) {
            System.out.println(r);
        }
    }

    // Clone recommendation at given index
    public Recommendation cloneAndModifyRecommendation(int index) {
        Recommendation original = recommendations.get(index);
        return original.clone(); 
    }
}

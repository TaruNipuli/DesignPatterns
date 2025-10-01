package prototype;

import java.util.ArrayList;
import java.util.List;

public class RecommendationSystem {
    private List<Recommendation> recommendations;

    public RecommendationSystem() {
        this.recommendations = new ArrayList<>();
    }

    public void addRecommendation(Recommendation recommendation) {
        recommendations.add(recommendation);
    }

    public void showRecommendations() {
        for (Recommendation r : recommendations) {
            System.out.println(r);
        }
    }

    // Getter to access a specific recommendation by index
    public Recommendation getRecommendation(int index) {
        return recommendations.get(index);
    }
}

package model;

import java.util.LinkedHashMap;
import java.util.Map;



public enum Category {

    ONES(1, null),
    TWOS(2, null),
    THREES(3, null),
    FOURS(4, null),
    FIVES(5, null),
    SIXES(6, null),
    SEVENS(7, null),
    EIGHTS(8, null),
    THREE_OF_A_KIND(null, null),
    FOUR_OF_A_KIND(null, null),
    FULL_HOUSE(null, Constants.SCORE_FULL_HOUSE),
    SMALL_STRAIGHT(null, Constants.SCORE_SMALL_STRAIGHT),
    ALL_DIFFERENT(null, Constants.SCORE_ALL_DIFFERENT),
    LARGE_STRAIGHT(null, Constants.SCORE_LARGE_STRAIGHT),
    SCHOONER(null, Constants.SCORE_SCHOONER),
    CHANCE(null, null);

    private final Integer faceValue;
    private final Integer definiteScore;

    Category(Integer faceValue, Integer distinctScore) {
        this.faceValue = faceValue;
        this.definiteScore = distinctScore;
    }

    public Integer getFaceValue() {
        return faceValue;
    }

    public Integer getDefiniteScore() {
        return definiteScore;
    }

    public int score(LinkedHashMap<Integer, Integer> freq) {
        switch (this) {
            case ONES, TWOS, THREES, FOURS, FIVES, SIXES, SEVENS, EIGHTS:
                return sumSelectedDice(this.faceValue, freq);
            case THREE_OF_A_KIND, FOUR_OF_A_KIND, CHANCE:
                return sumAllDice(freq);
            case FULL_HOUSE, SMALL_STRAIGHT, ALL_DIFFERENT, LARGE_STRAIGHT, SCHOONER:
                return this.definiteScore;
            default:
                return 0;
        }
    }

    public int sumAllDice(Map<Integer, Integer> freq) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            sum += (entry.getKey() * entry.getValue());
        }
        return sum;
    }

    public int sumSelectedDice(int value, Map<Integer, Integer> freq) {
        int sum = value * freq.getOrDefault(value, 0);
        return sum;
    }
}

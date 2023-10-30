package service;

import model.Category;

import java.util.*;


public class SchoonerDiceService implements SchoonerDIce {

    private LinkedHashMap<Integer, Integer> freq;


    @Override
    public int score(Enum category, List<Integer> diceRoll) {
        this.freq = new LinkedHashMap<>();
        try {
            Category eCategory = Category.valueOf(category.name());
            for (Integer i : diceRoll) {
                freq.put(i, freq.getOrDefault(i, 0) + 1);
            }
            return eCategory.score(freq);
        } catch (IllegalArgumentException e) {
            return 0;
        }

    }

    @Override
    public List<Enum> topCategories(List<Integer> diceRoll) {
        this.freq = new LinkedHashMap<>();
        for (Integer i : diceRoll) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        return new ArrayList<>(evaluateCategory(freq));
    }

    private List<Enum> evaluateCategory(LinkedHashMap<Integer, Integer> freq) {
        List<Enum> result = new ArrayList<>();

        if (freq.size() == 1 && freq.containsValue(5)) {
            result.add(Category.SCHOONER);
        } else if (freq.size() == 5) {
            if (hasSequential(5, freq)) {
                result.add(Category.LARGE_STRAIGHT);
            } else if (hasSequential(4, freq)) {
                result.add(Category.SMALL_STRAIGHT);
                result.add(Category.CHANCE);
            } else if (allDifferent(freq)) {
                result.add(Category.ALL_DIFFERENT);
            }
        } else if (freq.size() >= 2) {
            if (freq.containsValue(2) && freq.containsValue(3)) {
                result.add(Category.FULL_HOUSE);
            } else if (freq.containsValue(4)) {
                result.add(Category.FOUR_OF_A_KIND);
                result.add(Category.CHANCE);
            } else if (freq.containsValue(3)) {
                result.add(Category.THREE_OF_A_KIND);
                result.add(Category.CHANCE);
            }
        }

        if (result.isEmpty()) {
            result.add(Category.CHANCE);
        }
        return result;
    }

    private boolean hasSequential(int sequential, LinkedHashMap<Integer, Integer> freq) {
        Set<Integer> keySet = freq.keySet();
        Integer[] keyArray  = keySet.toArray(new Integer[0]);

        int diff = keyArray[0] - keyArray[1];
        for (int i = 0; i < sequential - 1; i++) {
            if (keyArray[i] - keyArray[i + 1] != diff) {
                return false;
            }
        }
        return true;
    }


    private boolean allDifferent(Map<Integer, Integer> freq) {
        for (Integer i : freq.values()) {
            if (i > 1) return false;
        }
        return true;
    }

}


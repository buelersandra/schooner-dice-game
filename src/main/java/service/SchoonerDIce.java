package service;

import java.util.List;

public interface SchoonerDIce {
    int score(Enum category, List<Integer> diceRoll);
    List<Enum> topCategories(List<Integer> diceRoll);
}

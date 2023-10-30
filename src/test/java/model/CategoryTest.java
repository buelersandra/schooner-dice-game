package model;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    public void test_category_face_value() {
        Assertions.assertEquals(1, Category.ONES.getFaceValue());
        Assertions.assertEquals(2, Category.TWOS.getFaceValue());
        Assertions.assertEquals(3, Category.THREES.getFaceValue());
        Assertions.assertEquals(4, Category.FOURS.getFaceValue());
        Assertions.assertEquals(5, Category.FIVES.getFaceValue());
        Assertions.assertEquals(6, Category.SIXES.getFaceValue());
        Assertions.assertEquals(7, Category.SEVENS.getFaceValue());
        Assertions.assertEquals(8, Category.EIGHTS.getFaceValue());

        Assertions.assertNull(Category.FULL_HOUSE.getFaceValue());
        Assertions.assertNull(Category.SMALL_STRAIGHT.getFaceValue());
        Assertions.assertNull(Category.ALL_DIFFERENT.getFaceValue());
        Assertions.assertNull(Category.LARGE_STRAIGHT.getFaceValue());
        Assertions.assertNull(Category.SCHOONER.getFaceValue());
        Assertions.assertNull(Category.THREE_OF_A_KIND.getFaceValue());
        Assertions.assertNull(Category.FOUR_OF_A_KIND.getFaceValue());
        Assertions.assertNull(Category.CHANCE.getFaceValue());
    }


    @Test
    public void test_category_constant_score() {
        Assertions.assertEquals(25, Category.FULL_HOUSE.getDefiniteScore());
        Assertions.assertEquals(30, Category.SMALL_STRAIGHT.getDefiniteScore());
        Assertions.assertEquals(35, Category.ALL_DIFFERENT.getDefiniteScore());
        Assertions.assertEquals(40, Category.LARGE_STRAIGHT.getDefiniteScore());
        Assertions.assertEquals(50, Category.SCHOONER.getDefiniteScore());

        Assertions.assertNull(Category.ONES.getDefiniteScore());
        Assertions.assertNull(Category.TWOS.getDefiniteScore());
        Assertions.assertNull(Category.THREES.getDefiniteScore());
        Assertions.assertNull(Category.FOURS.getDefiniteScore());
        Assertions.assertNull(Category.FIVES.getDefiniteScore());
        Assertions.assertNull(Category.SIXES.getDefiniteScore());
        Assertions.assertNull(Category.SEVENS.getDefiniteScore());
        Assertions.assertNull(Category.EIGHTS.getDefiniteScore());

        Assertions.assertNull(Category.THREE_OF_A_KIND.getDefiniteScore());
        Assertions.assertNull(Category.FOUR_OF_A_KIND.getDefiniteScore());
        Assertions.assertNull(Category.CHANCE.getDefiniteScore());
    }

    @Test
    public void test_sum_all_dice(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,3);
        map.put(8,1);
        map.put(2,1);
        Assertions.assertEquals(13,Category.CHANCE.sumAllDice(map));
    }

    @Test
    public void test_sum_selected_dice(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        map.put(8,1);
        map.put(2,1);
        Assertions.assertEquals(3,Category.CHANCE.sumSelectedDice(1,map));
    }

}

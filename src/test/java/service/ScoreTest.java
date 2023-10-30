package service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Category;
import model.ETest;

public class ScoreTest {
    SchoonerDiceService schoonerDice;
    List<Integer> list;
    List<Category> topCategories;


    @BeforeEach
    public void prep() {
        schoonerDice = new SchoonerDiceService();
        list = new ArrayList<Integer>();
        topCategories = new ArrayList<Category>();
    }

    @Test
    public void test_score_of_unqualifiedCategory() {
        list.add(1);
        list.add(1);
        list.add(6);
        list.add(8);
        list.add(1);
        Assertions.assertEquals(0, schoonerDice.score(ETest.ACTIVE, list));
    }

    @Test
    public void test_score_of_ONES() {
        list.add(1);
        list.add(1);
        list.add(6);
        list.add(8);
        list.add(1);
        Assertions.assertEquals(3, schoonerDice.score(Category.ONES, list));
    }

    @Test
    public void test_score_of_TWOS() {
        list.add(2);
        list.add(2);
        list.add(6);
        list.add(8);
        list.add(2);
        Assertions.assertEquals(6, schoonerDice.score(Category.TWOS, list));
    }

    @Test
    public void test_score_of_THREES() {
        list.add(3);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(3);
        Assertions.assertEquals(9, schoonerDice.score(Category.THREES, list));
    }

    @Test
    public void test_score_of_FOURS() {
        list.add(4);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(4);
        Assertions.assertEquals(12, schoonerDice.score(Category.FOURS, list));
    }

    @Test
    public void test_score_of_FIVES() {
        list.add(5);
        list.add(5);
        list.add(6);
        list.add(8);
        list.add(5);
        Assertions.assertEquals(15, schoonerDice.score(Category.FIVES, list));
    }

    @Test
    public void test_score_of_SIXES() {
        list.add(6);
        list.add(6);
        list.add(2);
        list.add(8);
        list.add(6);
        Assertions.assertEquals(18, schoonerDice.score(Category.SIXES, list));
    }

    @Test
    public void test_score_of_SEVENS() {
        list.add(7);
        list.add(7);
        list.add(2);
        list.add(8);
        list.add(7);
        Assertions.assertEquals(21, schoonerDice.score(Category.SEVENS, list));
    }

    @Test
    public void test_score_of_EIGHTS() {
        list.add(8);
        list.add(8);
        list.add(2);
        list.add(8);
        list.add(3);
        Assertions.assertEquals(24, schoonerDice.score(Category.EIGHTS, list));
    }

    @Test
    public void test_score_of_THREE_OF_A_KIND() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(7);
        list.add(7);
        Assertions.assertEquals(17, schoonerDice.score(Category.THREE_OF_A_KIND, list));
    }

    @Test
    public void test_score_of_FOUR_OF_A_KIND() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(7);

        Assertions.assertEquals(11, schoonerDice.score(Category.FOUR_OF_A_KIND, list));

    }

    @Test
    public void test_score_of_FULL_HOUSE() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(7);
        list.add(7);

        Assertions.assertEquals(25, schoonerDice.score(Category.FULL_HOUSE, list));
    }

    @Test
    public void test_score_of_SMALL_STRAIGHT() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(7);
        Assertions.assertEquals(30, schoonerDice.score(Category.SMALL_STRAIGHT, list));
    }

    @Test
    public void test_score_of_ALL_DIFFERENT() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(7);
        Assertions.assertEquals(35, schoonerDice.score(Category.ALL_DIFFERENT, list));
    }

    @Test
    public void test_score_of_LARGE_STRAIGHT() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Assertions.assertEquals(40, schoonerDice.score(Category.LARGE_STRAIGHT, list));
    }

    @Test
    public void test_score_of_SCHOONER() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        Assertions.assertEquals(50, schoonerDice.score(Category.SCHOONER, list));
    }

    @Test
    public void test_score_of_CHANCE() {
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(2);
        Assertions.assertEquals(21, schoonerDice.score(Category.CHANCE, list));
    }

}

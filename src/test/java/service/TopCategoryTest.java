package service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Category;


public class TopCategoryTest {

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
    public void test_topCategories_THREE_OF_A_KIND() {
        list.add(1);
        list.add(1);
        list.add(6);
        list.add(8);
        list.add(1);

        topCategories.add(Category.THREE_OF_A_KIND);
        topCategories.add(Category.CHANCE);

        Assertions.assertEquals(topCategories, schoonerDice.topCategories(list));
    }


    @Test
    public void test_topCategories_FOUR_OF_A_KIND() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(7);
        topCategories.add(Category.FOUR_OF_A_KIND);
        topCategories.add(Category.CHANCE);
        Assertions.assertEquals(topCategories, schoonerDice.topCategories(list));
    }

    @Test
    public void test_topCategories_FULL_HOUSE() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(7);
        list.add(7);

        topCategories.add(Category.FULL_HOUSE);

        Assertions.assertEquals(topCategories, schoonerDice.topCategories(list));
    }


    @Test
    public void test_topCategories_SMALL_STRAIGHT() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(8);

        topCategories.add(Category.SMALL_STRAIGHT);
        topCategories.add(Category.CHANCE);

        Assertions.assertEquals(topCategories, schoonerDice.topCategories(list));
    }

    @Test
    public void test_topCategories_LARGE_STRAIGHT() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        topCategories.add(Category.LARGE_STRAIGHT);
        Assertions.assertEquals(topCategories, schoonerDice.topCategories(list));
    }

    @Test
    public void test_topCategories_ALL_DIFFERENT() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(7);

        topCategories.add(Category.ALL_DIFFERENT);
        Assertions.assertEquals(topCategories, schoonerDice.topCategories(list));
    }


    @Test
    public void test_topCategories_SCHOONER() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        topCategories.add(Category.SCHOONER);
        Assertions.assertEquals(topCategories, schoonerDice.topCategories(list));
    }

    @Test
    public void test_topCategories_CHANCE() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(2);

        topCategories.add(Category.CHANCE);
        Assertions.assertEquals(topCategories, schoonerDice.topCategories(list));
    }

}

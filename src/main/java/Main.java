import java.util.Arrays;
import java.util.List;

import model.Category;
import service.SchoonerDiceService;

public class Main {

    public static void main(String[] args) {
        // write your code here

        SchoonerDiceService schoonerDice = new SchoonerDiceService();

        List<Integer> list = Arrays.asList(
                1, 1, 1, 7, 7
        );

        System.out.println(schoonerDice.score(Category.FULL_HOUSE, list));
        System.out.println(schoonerDice.topCategories(list));

        list = Arrays.asList(
                3, 3, 3, 6, 7
        );

        System.out.println(schoonerDice.topCategories(list));


    }


}

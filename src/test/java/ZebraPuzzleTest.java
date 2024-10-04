import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ZebraPuzzleTest {

    @Test
    public void residentWhoDrinksWater() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();
        assertThat(zebraPuzzle.getWaterDrinker()).isEqualTo(zebraPuzzle.NATIONALITY_NORWEGIAN);
    }

    @Test
    public void residentWhoOwnsZebra() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();
        assertThat(zebraPuzzle.getZebraOwner()).isEqualTo(zebraPuzzle.NATIONALITY_JAPANESE);
    }

    @Test
    void testGeneratePermutations() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();

        String[] colors = {zebraPuzzle.COLOR_RED, zebraPuzzle.COLOR_GREEN, zebraPuzzle.COLOR_BLUE};
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        zebraPuzzle.generatePermutations(colors, new ArrayList<>(), result, 0);

        assertEquals(6, result.size());  // 3! = 6 permutations
        assertTrue(result.contains(new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_RED, zebraPuzzle.COLOR_GREEN, zebraPuzzle.COLOR_BLUE))));
        assertTrue(result.contains(new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_RED, zebraPuzzle.COLOR_BLUE, zebraPuzzle.COLOR_GREEN))));
        assertTrue(result.contains(new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_GREEN, zebraPuzzle.COLOR_RED, zebraPuzzle.COLOR_BLUE))));
        assertTrue(result.contains(new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_GREEN, zebraPuzzle.COLOR_BLUE, zebraPuzzle.COLOR_RED))));
        assertTrue(result.contains(new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_BLUE, zebraPuzzle.COLOR_RED, zebraPuzzle.COLOR_GREEN))));
        assertTrue(result.contains(new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_BLUE, zebraPuzzle.COLOR_GREEN, zebraPuzzle.COLOR_RED))));
    }

    @Test
    void testGenerateCombinationsPermutations() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();

        // Example Input
        ArrayList<ArrayList<ArrayList<String>>> variables = new ArrayList<>();
        variables.add(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_BLUE, zebraPuzzle.COLOR_GREEN)), new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_GREEN, zebraPuzzle.COLOR_BLUE)))));
        variables.add(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(zebraPuzzle.DRINK_COFFEE, zebraPuzzle.DRINK_MILK)), new ArrayList<>(Arrays.asList(zebraPuzzle.DRINK_MILK, zebraPuzzle.DRINK_COFFEE)))));
        ArrayList<ArrayList<ArrayList<String>>> results = new ArrayList<>();
        zebraPuzzle.generateCombinationsPermutations(variables, results, new ArrayList<>(), 0, false);

        // Check Results
        assertEquals(zebraPuzzle.COLOR_BLUE, results.getFirst().getFirst().getFirst());
        assertEquals(zebraPuzzle.DRINK_COFFEE, results.getFirst().getFirst().get(1));
    }

    @Test
    void testIsValid() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();

        ArrayList<ArrayList<String>> validComplex = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_YELLOW, zebraPuzzle.DRINK_WATER, zebraPuzzle.HOBBY_PAINTING, zebraPuzzle.NATIONALITY_NORWEGIAN, zebraPuzzle.PET_FOX)), new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_BLUE, zebraPuzzle.DRINK_TEA, zebraPuzzle.HOBBY_READING, zebraPuzzle.NATIONALITY_UKRAINIAN, zebraPuzzle.PET_HORSE)), new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_RED, zebraPuzzle.DRINK_MILK, zebraPuzzle.HOBBY_DANCING, zebraPuzzle.NATIONALITY_ENGLISH, zebraPuzzle.PET_SNAIL)), new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_IVORY, zebraPuzzle.DRINK_ORANGE_JUICE, zebraPuzzle.HOBBY_FOOTBALL, zebraPuzzle.NATIONALITY_SPANISH, zebraPuzzle.PET_DOG)), new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_GREEN, zebraPuzzle.DRINK_COFFEE, zebraPuzzle.HOBBY_CHESS, zebraPuzzle.NATIONALITY_JAPANESE, zebraPuzzle.PET_ZEBRA))));
        assertTrue(zebraPuzzle.isValid(validComplex));

        ArrayList<ArrayList<String>> invalidComplex = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_YELLOW, zebraPuzzle.DRINK_WATER, zebraPuzzle.HOBBY_PAINTING, zebraPuzzle.NATIONALITY_JAPANESE, zebraPuzzle.PET_FOX)), new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_BLUE, zebraPuzzle.DRINK_TEA, zebraPuzzle.HOBBY_READING, zebraPuzzle.NATIONALITY_UKRAINIAN, zebraPuzzle.PET_HORSE)), new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_RED, zebraPuzzle.DRINK_MILK, zebraPuzzle.HOBBY_DANCING, zebraPuzzle.NATIONALITY_ENGLISH, zebraPuzzle.PET_SNAIL)), new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_IVORY, zebraPuzzle.DRINK_ORANGE_JUICE, zebraPuzzle.HOBBY_FOOTBALL, zebraPuzzle.NATIONALITY_SPANISH, zebraPuzzle.PET_DOG)), new ArrayList<>(Arrays.asList(zebraPuzzle.COLOR_GREEN, zebraPuzzle.DRINK_COFFEE, zebraPuzzle.HOBBY_CHESS, zebraPuzzle.NATIONALITY_NORWEGIAN, zebraPuzzle.PET_ZEBRA))));
        assertFalse(zebraPuzzle.isValid(invalidComplex));
    }
}

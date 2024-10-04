import java.util.*;

class Main {
    public static void main(String[] args) {
        new ZebraPuzzle();
    }
}

class ZebraPuzzle {
    final public int INDEX_DRINKS = 1;
    final public int INDEX_NATIONALITIES = 3;
    final public int INDEX_PETS = 4;

    // Colors
    final public String COLOR_BLUE = "Blue";
    final public String COLOR_GREEN = "Green";
    final public String COLOR_IVORY = "Ivory";
    final public String COLOR_RED = "Red";
    final public String COLOR_YELLOW = "Yellow";

    // Drinks
    final public String DRINK_COFFEE = "Coffee";
    final public String DRINK_MILK = "Milk";
    final public String DRINK_ORANGE_JUICE = "Orange Juice";
    final public String DRINK_TEA = "Tea";
    final public String DRINK_WATER = "Water";

    // Hobbies
    final public String HOBBY_CHESS = "Chess";
    final public String HOBBY_DANCING = "Dancing";
    final public String HOBBY_FOOTBALL = "Football";
    final public String HOBBY_PAINTING = "Painting";
    final public String HOBBY_READING = "Reading";

    // Nationalities
    final public String NATIONALITY_ENGLISH = "English";
    final public String NATIONALITY_JAPANESE = "Japanese";
    final public String NATIONALITY_NORWEGIAN = "Norwegian";
    final public String NATIONALITY_SPANISH = "Spanish";
    final public String NATIONALITY_UKRAINIAN = "Ukrainian";

    // Pets
    final public String PET_DOG = "Dog";
    final public String PET_FOX = "Fox";
    final public String PET_HORSE = "Horse";
    final public String PET_SNAIL = "Snail";
    final public String PET_ZEBRA = "Zebra";

    private String waterDrinker;
    private String zebraOwner;

    public ZebraPuzzle() {
        /*// Uncomment These Codes to Run the Combinations and Permutations
        String[] colors = {COLOR_BLUE, COLOR_GREEN, COLOR_IVORY, COLOR_RED, COLOR_YELLOW};
        String[] drinks = {DRINK_COFFEE, DRINK_MILK, DRINK_ORANGE_JUICE, DRINK_TEA, DRINK_WATER};
        String[] hobbies = {HOBBY_CHESS, HOBBY_DANCING, HOBBY_FOOTBALL, HOBBY_PAINTING, HOBBY_READING};
        String[] nationalities = {NATIONALITY_ENGLISH, NATIONALITY_JAPANESE, NATIONALITY_NORWEGIAN, NATIONALITY_SPANISH, NATIONALITY_UKRAINIAN};
        String[] pets = {PET_DOG, PET_FOX, PET_HORSE, PET_SNAIL, PET_ZEBRA};

        // Generate Permutations for Few Colors, Drinks, and Hobbies
        ArrayList<ArrayList<String>> permutedColors = new ArrayList<>();
        ArrayList<ArrayList<String>> permutedDrinks = new ArrayList<>();
        ArrayList<ArrayList<String>> permutedHobbies = new ArrayList<>();
        ArrayList<ArrayList<String>> permutedNationalities = new ArrayList<>();
        ArrayList<ArrayList<String>> permutedPets = new ArrayList<>();
        generatePermutations(colors, new ArrayList<>(), permutedColors, 0);
        generatePermutations(drinks, new ArrayList<>(), permutedDrinks, 0);
        generatePermutations(hobbies, new ArrayList<>(), permutedHobbies, 0);
        generatePermutations(nationalities, new ArrayList<>(), permutedNationalities, 0);
        generatePermutations(pets, new ArrayList<>(), permutedPets, 0);

        // Combine All Permutations
        ArrayList<ArrayList<ArrayList<String>>> permutations = new ArrayList<>();
        permutations.add(permutedColors);
        permutations.add(permutedDrinks);
        permutations.add(permutedHobbies);
        permutations.add(permutedNationalities);
        permutations.add(permutedPets);

        // Generate and Print Combined Permutations Example With More Granular Function
        ArrayList<ArrayList<ArrayList<String>>> validCombinationsPermutations = new ArrayList<>();
        generateCombinationsPermutations(permutations, validCombinationsPermutations, new ArrayList<>(), 0, true);

        System.out.println(validCombinationsPermutations);*/

        // The Result
        // [[Yellow, Water, Painting, Norwegian, Fox], [Blue, Tea, Reading, Ukrainian, Horse], [Red, Milk, Dancing, English, Snail], [Ivory, Orange Juice, Football, Spanish, Dog], [Green, Coffee, Chess, Japanese, Zebra]]
        ArrayList<ArrayList<String>> complexResult = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(COLOR_YELLOW, DRINK_WATER, HOBBY_PAINTING, NATIONALITY_NORWEGIAN, PET_FOX)), new ArrayList<>(Arrays.asList(COLOR_BLUE, DRINK_TEA, HOBBY_READING, NATIONALITY_UKRAINIAN, PET_HORSE)), new ArrayList<>(Arrays.asList(COLOR_RED, DRINK_MILK, HOBBY_DANCING, NATIONALITY_ENGLISH, PET_SNAIL)), new ArrayList<>(Arrays.asList(COLOR_IVORY, DRINK_ORANGE_JUICE, HOBBY_FOOTBALL, NATIONALITY_SPANISH, PET_DOG)), new ArrayList<>(Arrays.asList(COLOR_GREEN, DRINK_COFFEE, HOBBY_CHESS, NATIONALITY_JAPANESE, PET_ZEBRA))));

        for (ArrayList<String> house : complexResult) {
            if (Objects.equals(house.get(INDEX_DRINKS), DRINK_WATER)) {
                waterDrinker = house.get(INDEX_NATIONALITIES);
            }

            if (Objects.equals(house.get(INDEX_PETS), PET_ZEBRA)) {
                zebraOwner = house.get(INDEX_NATIONALITIES);
            }
        }

        System.out.println(complexResult);
        System.out.println(isValid(complexResult));
    }

    String getWaterDrinker() {
        return waterDrinker;
    }

    String getZebraOwner() {
        return zebraOwner;
    }

    public void generateCombinationsPermutations(ArrayList<ArrayList<ArrayList<String>>> variables, ArrayList<ArrayList<ArrayList<String>>> results, ArrayList<ArrayList<String>> current, int depth, boolean zebraProblemValidityCheck) {
        if (!results.isEmpty() && zebraProblemValidityCheck) {
            return;
        }

        if (depth == variables.size()) {
            ArrayList<ArrayList<String>> currentCopy = new ArrayList<>(current);
            ArrayList<ArrayList<String>> complex = new ArrayList<>();

            for (int pairsIndex = 0; pairsIndex < currentCopy.size(); pairsIndex++) {
                for (int pairIndex = 0; pairIndex < currentCopy.get(pairsIndex).size(); pairIndex++) {
                    if (pairsIndex == 0) {
                        ArrayList<String> set = new ArrayList<>();
                        set.add(currentCopy.get(pairsIndex).get(pairIndex));
                        complex.add(set);
                    } else {
                        complex.get(pairIndex).add(currentCopy.get(pairsIndex).get(pairIndex));
                    }
                }
            }

            if (zebraProblemValidityCheck && isValid(complex)) {
                results.add(new ArrayList<>(complex));
            } else if (!zebraProblemValidityCheck) {
                results.add(new ArrayList<>(complex));
            }
        } else {
            for (int i = 0; i < variables.get(depth).size(); i++) {
                current.add(variables.get(depth).get(i));

                generateCombinationsPermutations(variables, results, current, depth + 1, zebraProblemValidityCheck);

                if (!results.isEmpty() && zebraProblemValidityCheck) {
                    return;
                }

                current.removeLast();
            }
        }
    }

    public void generatePermutations(String[] variable, ArrayList<String> current, ArrayList<ArrayList<String>> result, int startIndex) {
        // Check If All Elements Have Been Used
        if (startIndex == variable.length) {
            result.add(new ArrayList<>(current));
        } else {
            // Iterate Over Variable to Generate Permutations
            for (int i = 0; i < variable.length; i++) {
                boolean exist = false;
                String currentIteratedValue = variable[(startIndex + i) % variable.length];

                // Check If Current Value Already Exists in Permutation
                for (String value : current) {
                    if (Objects.equals(value, currentIteratedValue)) {
                        exist = true;
                        break;
                    }
                }

                // Add Value to Current Permutation if It Doesn't Exist and Recur
                if (!exist) {
                    current.add(currentIteratedValue);
                    generatePermutations(variable, current, result, startIndex + 1);
                    current.removeLast();
                }
            }
        }
    }

    // Helper function to check constraints
    public boolean isValid(ArrayList<ArrayList<String>> complex) {
        final int NUM_ELEMENTS = 5;
        final int INDEX_HOBBIES = 2;

        // There are five houses.
        // 1. The Englishman lives in the red house.
        // 2. The Spaniard owns the dog.
        // 3. The person in the green house drinks coffee.
        // 4. The Ukrainian drinks tea.
        // 5. The green house is immediately to the right of the ivory house.
        // 6. The snail owner likes to go dancing.
        // 7. The person in the yellow house is a painter.
        // 8. The person in the middle house drinks milk.
        // 9. The Norwegian lives in the first house.
        // 10. The person who enjoys reading lives in the house next to the person with the fox.
        // 11. The painter's house is next to the house with the horse.
        // 12. The person who plays football drinks orange juice.
        // 13. The Japanese person plays chess.
        // 14. The Norwegian lives next to the blue house.

        // Constraint 9: The Norwegian lives in the first house.
        if (!Objects.equals(complex.getFirst().get(INDEX_NATIONALITIES), NATIONALITY_NORWEGIAN)) return false;

        // Constraint 8: The person in the middle house drinks milk.
        if (!Objects.equals(complex.get((NUM_ELEMENTS - 1) / 2).get(INDEX_DRINKS), DRINK_MILK)) return false;

        for (int i = 0; i < NUM_ELEMENTS; i++) {
            // Constraint 1: The Englishman lives in the red house.
            if (Objects.equals(complex.get(i).get(INDEX_NATIONALITIES), NATIONALITY_ENGLISH) && !Objects.equals(complex.get(i).getFirst(), COLOR_RED))
                return false;

            // Constraint 2: The Spaniard owns the dog.
            if (Objects.equals(complex.get(i).get(INDEX_NATIONALITIES), NATIONALITY_SPANISH) && !Objects.equals(complex.get(i).get(INDEX_PETS), PET_DOG))
                return false;

            // Constraint 3: The person in the green house drinks coffee.
            if (Objects.equals(complex.get(i).getFirst(), COLOR_GREEN) && !Objects.equals(complex.get(i).get(INDEX_DRINKS), DRINK_COFFEE))
                return false;

            // Constraint 4: The Ukrainian drinks tea.
            if (Objects.equals(complex.get(i).get(INDEX_NATIONALITIES), NATIONALITY_UKRAINIAN) && !Objects.equals(complex.get(i).get(INDEX_DRINKS), DRINK_TEA))
                return false;

            // Constraint 5: The green house is immediately to the right of the ivory house.
            if (Objects.equals(complex.get(i).getFirst(), COLOR_GREEN)) {
                if (i == 0) {
                    return false;
                } else {
                    if (!Objects.equals(complex.get(i - 1).getFirst(), COLOR_IVORY)) return false;
                }
            }

            // Constraint 6: The snail owner likes to go dancing.
            if (Objects.equals(complex.get(i).get(INDEX_PETS), PET_SNAIL) && !Objects.equals(complex.get(i).get(INDEX_HOBBIES), HOBBY_DANCING))
                return false;

            // Constraint 7: The person in the yellow house is a painter.
            if (Objects.equals(complex.get(i).getFirst(), COLOR_YELLOW) && !Objects.equals(complex.get(i).get(INDEX_HOBBIES), HOBBY_PAINTING))
                return false;

            // Constraint 10: The person who enjoys reading lives in the house next to the person with the fox.
            if (Objects.equals(complex.get(i).get(INDEX_HOBBIES), HOBBY_READING)) {
                if (i == 0) {
                    if (!Objects.equals(complex.get(i + 1).get(INDEX_PETS), PET_FOX)) return false;
                } else if (i == NUM_ELEMENTS - 1) {
                    if (!Objects.equals(complex.get(i - 1).get(INDEX_PETS), PET_FOX)) return false;
                } else {
                    if (!Objects.equals(complex.get(i + 1).get(INDEX_PETS), PET_FOX) && !Objects.equals(complex.get(i - 1).get(INDEX_PETS), PET_FOX))
                        return false;
                }
            }

            // Constraint 11: The painter's house is next to the house with the horse.
            if (Objects.equals(complex.get(i).get(INDEX_HOBBIES), HOBBY_PAINTING)) {
                if (i == 0) {
                    if (!Objects.equals(complex.get(i + 1).get(INDEX_PETS), PET_HORSE)) return false;
                } else if (i == NUM_ELEMENTS - 1) {
                    if (!Objects.equals(complex.get(i - 1).get(INDEX_PETS), PET_HORSE)) return false;
                } else {
                    if (!Objects.equals(complex.get(i + 1).get(INDEX_PETS), PET_HORSE) && !Objects.equals(complex.get(i - 1).get(INDEX_PETS), PET_HORSE))
                        return false;
                }
            }

            // Constraint 12: The person who plays football drinks orange juice.
            if (Objects.equals(complex.get(i).get(INDEX_HOBBIES), HOBBY_FOOTBALL) && !Objects.equals(complex.get(i).get(INDEX_DRINKS), DRINK_ORANGE_JUICE))
                return false;

            // Constraint 13: The Japanese person plays chess.
            if (Objects.equals(complex.get(i).get(INDEX_NATIONALITIES), NATIONALITY_JAPANESE) && !Objects.equals(complex.get(i).get(INDEX_HOBBIES), HOBBY_CHESS))
                return false;

            // Constraint 14: The Norwegian lives next to the blue house.
            if (Objects.equals(complex.get(i).get(INDEX_NATIONALITIES), NATIONALITY_NORWEGIAN)) {
                if (i == 0) {
                    if (!Objects.equals(complex.get(i + 1).getFirst(), COLOR_BLUE)) return false;
                } else if (i == NUM_ELEMENTS - 1) {
                    if (!Objects.equals(complex.get(i - 1).getFirst(), COLOR_BLUE)) return false;
                } else {
                    if (!Objects.equals(complex.get(i + 1).getFirst(), COLOR_BLUE) && !Objects.equals(complex.get(i - 1).getFirst(), COLOR_BLUE))
                        return false;
                }
            }
        }

        return true;
    }
}

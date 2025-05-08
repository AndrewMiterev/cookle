package harelins.co.il.cookle.init;

import harelins.co.il.cookle.model.Ingredient;
import harelins.co.il.cookle.model.Instruction;
import harelins.co.il.cookle.model.Recipe;
import harelins.co.il.cookle.model.RecipeIngredient;
import harelins.co.il.cookle.repository.IngredientRepository;
import harelins.co.il.cookle.repository.InstructionRepository;
import harelins.co.il.cookle.repository.RecipeIngredientRepository;
import harelins.co.il.cookle.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Component responsible for initializing the database with sample recipe data.
 * Implements {@link CommandLineRunner} to execute initialization logic on application startup.
 */
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final InstructionRepository instructionRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;

    /**
     * Initializes the database by clearing existing data and populating it with sample recipes.
     *
     * @param args command-line arguments
     * @throws Exception if an error occurs during initialization
     */
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Clear existing data
        recipeRepository.deleteAll();
        recipeIngredientRepository.deleteAll();
        ingredientRepository.deleteAll();
        instructionRepository.deleteAll();

        // Recipe 1: Spaghetti Carbonara
        Recipe carbonara = new Recipe();
        carbonara.setName("Spaghetti Carbonara");
        carbonara.setYield(2);

        Ingredient spaghetti = createIngredient("Spaghetti", 200);
        Ingredient pancetta = createIngredient("Pancetta", 150);
        Ingredient egg = createIngredient("Egg", 2);
        Ingredient parmesan = createIngredient("Parmesan", 50);
        Ingredient blackPepper = createIngredient("Black Pepper", 5);

        carbonara.setIngredients(Set.of(
                createRecipeIngredient(carbonara, spaghetti),
                createRecipeIngredient(carbonara, pancetta),
                createRecipeIngredient(carbonara, egg),
                createRecipeIngredient(carbonara, parmesan),
                createRecipeIngredient(carbonara, blackPepper)
        ));

        carbonara.setInstructions(Set.of(
                createInstruction(carbonara, 1, "Cook spaghetti in boiling salted water until al dente."),
                createInstruction(carbonara, 2, "Fry pancetta until crispy."),
                createInstruction(carbonara, 3, "Whisk eggs with grated parmesan and black pepper."),
                createInstruction(carbonara, 4, "Combine spaghetti with pancetta, then add egg mixture, stirring quickly.")
        ));
        recipeRepository.save(carbonara);

        // Recipe 2: Classic Omelette
        Recipe omelette = new Recipe();
        omelette.setName("Classic Omelette");
        omelette.setYield(1);

        Ingredient eggs = createIngredient("Eggs", 3);
        Ingredient milk = createIngredient("Milk", 30);
        Ingredient butter = createIngredient("Butter", 10);
        Ingredient salt = createIngredient("Salt", 2);

        omelette.setIngredients(Set.of(
                createRecipeIngredient(omelette, eggs),
                createRecipeIngredient(omelette, milk),
                createRecipeIngredient(omelette, butter),
                createRecipeIngredient(omelette, salt)
        ));

        omelette.setInstructions(Set.of(
                createInstruction(omelette, 1, "Whisk eggs with milk and salt."),
                createInstruction(omelette, 2, "Heat butter in a frying pan."),
                createInstruction(omelette, 3, "Pour in the egg mixture."),
                createInstruction(omelette, 4, "Cook for 3-5 minutes until set.")
        ));
        recipeRepository.save(omelette);

        // Recipe 3: Caesar Salad
        Recipe caesar = new Recipe();
        caesar.setName("Caesar Salad");
        caesar.setYield(2);

        Ingredient chickenBreast = createIngredient("Chicken Breast", 200);
        Ingredient romaine = createIngredient("Romaine Lettuce", 100);
        Ingredient croutons = createIngredient("Croutons", 50);
        Ingredient caesarDressing = createIngredient("Caesar Dressing", 30);
        Ingredient parmesanCheese = createIngredient("Parmesan Cheese", 40);

        caesar.setIngredients(Set.of(
                createRecipeIngredient(caesar, chickenBreast),
                createRecipeIngredient(caesar, romaine),
                createRecipeIngredient(caesar, croutons),
                createRecipeIngredient(caesar, caesarDressing),
                createRecipeIngredient(caesar, parmesanCheese)
        ));

        caesar.setInstructions(Set.of(
                createInstruction(caesar, 1, "Grill chicken breast until cooked through and slice."),
                createInstruction(caesar, 2, "Tear romaine lettuce into bite-sized pieces."),
                createInstruction(caesar, 3, "Combine lettuce, chicken, and croutons."),
                createInstruction(caesar, 4, "Toss with dressing and sprinkle with parmesan.")
        ));
        recipeRepository.save(caesar);

        // Recipe 4: Margherita Pizza
        Recipe pizza = new Recipe();
        pizza.setName("Margherita Pizza");
        pizza.setYield(4);

        Ingredient pizzaDough = createIngredient("Pizza Dough", 300);
        Ingredient tomatoSauce = createIngredient("Tomato Sauce", 100);
        Ingredient freshMozzarella = createIngredient("Fresh Mozzarella", 200);
        Ingredient freshBasil = createIngredient("Fresh Basil", 10);
        Ingredient oliveOil = createIngredient("Olive Oil", 20);

        pizza.setIngredients(Set.of(
                createRecipeIngredient(pizza, pizzaDough),
                createRecipeIngredient(pizza, tomatoSauce),
                createRecipeIngredient(pizza, freshMozzarella),
                createRecipeIngredient(pizza, freshBasil),
                createRecipeIngredient(pizza, oliveOil)
        ));

        pizza.setInstructions(Set.of(
                createInstruction(pizza, 1, "Preheat oven to 475°F (245°C)."),
                createInstruction(pizza, 2, "Roll out the dough and spread tomato sauce."),
                createInstruction(pizza, 3, "Add sliced mozzarella and bake for 10-12 minutes."),
                createInstruction(pizza, 4, "Garnish with fresh basil and drizzle with olive oil.")
        ));
        recipeRepository.save(pizza);

        // Recipe 5: Chocolate Mousse
        Recipe mousse = new Recipe();
        mousse.setName("Chocolate Mousse");
        mousse.setYield(4);

        Ingredient darkChocolate = createIngredient("Dark Chocolate", 200);
        Ingredient heavyCream = createIngredient("Heavy Cream", 200);
        Ingredient sugar = createIngredient("Sugar", 50);
        Ingredient eggWhites = createIngredient("Egg Whites", 3);

        mousse.setIngredients(Set.of(
                createRecipeIngredient(mousse, darkChocolate),
                createRecipeIngredient(mousse, heavyCream),
                createRecipeIngredient(mousse, sugar),
                createRecipeIngredient(mousse, eggWhites)
        ));

        mousse.setInstructions(Set.of(
                createInstruction(mousse, 1, "Melt chocolate over a double boiler."),
                createInstruction(mousse, 2, "Whip cream with half the sugar to soft peaks."),
                createInstruction(mousse, 3, "Beat egg whites with remaining sugar to stiff peaks."),
                createInstruction(mousse, 4, "Gently fold chocolate into cream, then fold in egg whites."),
                createInstruction(mousse, 5, "Chill for at least 2 hours before serving.")
        ));
        recipeRepository.save(mousse);

        // Recipe 6: Beef Burger
        Recipe burger = new Recipe();
        burger.setName("Classic Beef Burger");
        burger.setYield(2);

        Ingredient groundBeef = createIngredient("Ground Beef", 300);
        Ingredient burgerBuns = createIngredient("Burger Buns", 2);
        Ingredient lettuce = createIngredient("Lettuce", 30);
        Ingredient tomato = createIngredient("Tomato", 1);
        Ingredient onion = createIngredient("Onion", 0.5);
        Ingredient cheese = createIngredient("Cheddar Cheese", 60);

        burger.setIngredients(Set.of(
                createRecipeIngredient(burger, groundBeef),
                createRecipeIngredient(burger, burgerBuns),
                createRecipeIngredient(burger, lettuce),
                createRecipeIngredient(burger, tomato),
                createRecipeIngredient(burger, onion),
                createRecipeIngredient(burger, cheese)
        ));

        burger.setInstructions(Set.of(
                createInstruction(burger, 1, "Form ground beef into patties and season."),
                createInstruction(burger, 2, "Grill or fry patties for 4-5 minutes per side."),
                createInstruction(burger, 3, "Toast burger buns lightly."),
                createInstruction(burger, 4, "Assemble with lettuce, tomato, onion, and cheese.")
        ));
        recipeRepository.save(burger);

        // Recipe 7: Chicken Curry
        Recipe curry = new Recipe();
        curry.setName("Chicken Curry");
        curry.setYield(4);

        Ingredient chickenThighs = createIngredient("Chicken Thighs", 500);
        Ingredient curryPaste = createIngredient("Curry Paste", 50);
        Ingredient coconutMilk = createIngredient("Coconut Milk", 400);
        Ingredient onionCurry = createIngredient("Onion", 1);
        Ingredient garlic = createIngredient("Garlic", 3);
        Ingredient ginger = createIngredient("Ginger", 20);

        curry.setIngredients(Set.of(
                createRecipeIngredient(curry, chickenThighs),
                createRecipeIngredient(curry, curryPaste),
                createRecipeIngredient(curry, coconutMilk),
                createRecipeIngredient(curry, onionCurry),
                createRecipeIngredient(curry, garlic),
                createRecipeIngredient(curry, ginger)
        ));

        curry.setInstructions(Set.of(
                createInstruction(curry, 1, "Sauté chopped onion, garlic, and ginger."),
                createInstruction(curry, 2, "Add curry paste and cook for 1 minute."),
                createInstruction(curry, 3, "Add chicken and brown lightly."),
                createInstruction(curry, 4, "Pour in coconut milk and simmer for 20 minutes.")
        ));
        recipeRepository.save(curry);

        // Recipe 8: Apple Pie
        Recipe applePie = new Recipe();
        applePie.setName("Apple Pie");
        applePie.setYield(8);

        Ingredient pieCrust = createIngredient("Pie Crust", 2);
        Ingredient apples = createIngredient("Apples", 6);
        Ingredient cinnamon = createIngredient("Cinnamon", 10);
        Ingredient brownSugar = createIngredient("Brown Sugar", 100);
        Ingredient butterPie = createIngredient("Butter", 50);

        applePie.setIngredients(Set.of(
                createRecipeIngredient(applePie, pieCrust),
                createRecipeIngredient(applePie, apples),
                createRecipeIngredient(applePie, cinnamon),
                createRecipeIngredient(applePie, brownSugar),
                createRecipeIngredient(applePie, butterPie)
        ));

        applePie.setInstructions(Set.of(
                createInstruction(applePie, 1, "Preheat oven to 375°F (190°C)."),
                createInstruction(applePie, 2, "Mix sliced apples with cinnamon and sugar."),
                createInstruction(applePie, 3, "Line pie dish with crust, add filling, and dot with butter."),
                createInstruction(applePie, 4, "Cover with top crust and bake for 45 minutes.")
        ));
        recipeRepository.save(applePie);

        // Recipe 9: Greek Salad
        Recipe greekSalad = new Recipe();
        greekSalad.setName("Greek Salad");
        greekSalad.setYield(2);

        Ingredient cucumber = createIngredient("Cucumber", 1);
        Ingredient tomatoGreek = createIngredient("Tomato", 2);
        Ingredient redOnion = createIngredient("Red Onion", 0.5);
        Ingredient feta = createIngredient("Feta Cheese", 100);
        Ingredient olives = createIngredient("Kalamata Olives", 50);

        greekSalad.setIngredients(Set.of(
                createRecipeIngredient(greekSalad, cucumber),
                createRecipeIngredient(greekSalad, tomatoGreek),
                createRecipeIngredient(greekSalad, redOnion),
                createRecipeIngredient(greekSalad, feta),
                createRecipeIngredient(greekSalad, olives)
        ));

        greekSalad.setInstructions(Set.of(
                createInstruction(greekSalad, 1, "Chop cucumber, tomatoes, and red onion."),
                createInstruction(greekSalad, 2, "Combine vegetables in a bowl with olives."),
                createInstruction(greekSalad, 3, "Top with cubed feta cheese."),
                createInstruction(greekSalad, 4, "Drizzle with olive oil and oregano.")
        ));
        recipeRepository.save(greekSalad);

        // Recipe 10: Pancakes
        Recipe pancakes = new Recipe();
        pancakes.setName("Fluffy Pancakes");
        pancakes.setYield(8);

        Ingredient flour = createIngredient("Flour", 200);
        Ingredient milkPancakes = createIngredient("Milk", 300);
        Ingredient eggPancakes = createIngredient("Egg", 1);
        Ingredient bakingPowder = createIngredient("Baking Powder", 15);
        Ingredient sugarPancakes = createIngredient("Sugar", 30);

        pancakes.setIngredients(Set.of(
                createRecipeIngredient(pancakes, flour),
                createRecipeIngredient(pancakes, milkPancakes),
                createRecipeIngredient(pancakes, eggPancakes),
                createRecipeIngredient(pancakes, bakingPowder),
                createRecipeIngredient(pancakes, sugarPancakes)
        ));

        pancakes.setInstructions(Set.of(
                createInstruction(pancakes, 1, "Mix dry ingredients in one bowl."),
                createInstruction(pancakes, 2, "Whisk wet ingredients in another bowl."),
                createInstruction(pancakes, 3, "Combine mixtures without overmixing."),
                createInstruction(pancakes, 4, "Cook on a griddle until bubbles form, then flip.")
        ));
        recipeRepository.save(pancakes);
    }

    /**
     * Creates and saves an ingredient with the specified name and amount.
     *
     * @param name   the name of the ingredient
     * @param amount the amount of the ingredient (e.g., in grams or units)
     * @return the saved {@link Ingredient} entity
     */
    private Ingredient createIngredient(String name, Number amount) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setAmount(amount instanceof Integer ? (Integer) amount : amount.doubleValue());
        return ingredientRepository.save(ingredient);
    }

    /**
     * Creates and saves a relationship between a recipe and an ingredient.
     *
     * @param recipe     the {@link Recipe} to associate with the ingredient
     * @param ingredient the {@link Ingredient} to associate with the recipe
     * @return the saved {@link RecipeIngredient} entity
     */
    private RecipeIngredient createRecipeIngredient(Recipe recipe, Ingredient ingredient) {
        RecipeIngredient ri = new RecipeIngredient();
        ri.setRecipe(recipe);
        ri.setIngredient(ingredient);
        return recipeIngredientRepository.save(ri);
    }

    /**
     * Creates and saves an instruction for a recipe with the specified step and description.
     *
     * @param recipe      the {@link Recipe} to associate with the instruction
     * @param step        the step number of the instruction
     * @param description the description of the instruction
     * @return the saved {@link Instruction} entity
     */
    private Instruction createInstruction(Recipe recipe, int step, String description) {
        Instruction instruction = new Instruction();
        instruction.setRecipe(recipe);
        instruction.setStep(step);
        instruction.setDescription(description);
        return instructionRepository.save(instruction);
    }
}
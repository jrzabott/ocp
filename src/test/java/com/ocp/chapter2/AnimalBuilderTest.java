package com.ocp.chapter2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalBuilderTest {

    public static final List<String> DUCK_FAV_FOODS = Arrays.asList("grass", "fish");
    public static final String DUCK_SPECIES = "duck";
    public static final int DUCK_AGE = 4;
    public static final List<String> FLAMINGO_FAV_FOODS = Arrays.asList("algae", "insects");
    public static final String FLAMINGO_SPECIES = "flamingo";

    @Test
    void simpleBuilderTest(){
        AnimalBuilder duckBuilder = new AnimalBuilder();
        duckBuilder
                .setAge(4)
                .setSpecies("duck")
                .setFavoriteFoods(Arrays.asList("grass", "fish"));
        Animal duck = duckBuilder.build();

        assertEquals(DUCK_AGE, duck.getAge());
        assertEquals(DUCK_SPECIES, duck.getSpecies());
        assertEquals(DUCK_FAV_FOODS, duck.getFavoriteFoods());

        Animal flamingo = new AnimalBuilder()
                .setFavoriteFoods(Arrays.asList("algae", "insects"))
                .setSpecies("flamingo")
                .build();

        assertEquals(FLAMINGO_FAV_FOODS, flamingo.getFavoriteFoods());
        assertEquals(FLAMINGO_SPECIES, flamingo.getSpecies());

    }

}

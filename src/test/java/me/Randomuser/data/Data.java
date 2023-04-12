package me.Randomuser.data;

import java.util.ArrayList;
import java.util.Arrays;

@lombok.Data
public class Data {

    private final String maleGender = "male";
    private final String femaleGender = "female";
    private final String unCorrectGender = "Привет";
    private final String url = "https://randomuser.me/api";
    private final ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(-2, 0, 1, 2, 10));

}


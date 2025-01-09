package org.example.streamprac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

//        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        ArrayList<Integer> list = new ArrayList<>(List.of(3, 1, 2, 2));
        System.out.println(list);

        List<Integer> over1List = list.stream()
                .filter(x -> x> 1)
                .collect(Collectors.toList());


        System.out.println(over1List);



    }
}

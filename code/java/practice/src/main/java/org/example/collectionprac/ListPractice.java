package org.example.collectionprac;

import java.util.ArrayList;

public class ListPractice {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

//    data 삽입
        list.add(1);
        list.add((2));

        System.out.println(list);

        list.add(1, 100);
        System.out.println(list);

//        접근
        System.out.println(list.get(1));

//        수정
        list.set(1, 200);
        System.out.println(list);

//       배열 크기(길이)
        System.out.println(list.size());

        list.isEmpty();
        if (!list.isEmpty()) {
            list.get(0);
        }

        for (Integer i : list) {
            System.out.println(i);
        }

        ArrayList<String> strings = new ArrayList<>();
    }
}

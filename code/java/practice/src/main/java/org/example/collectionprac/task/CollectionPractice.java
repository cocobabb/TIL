package org.example.collectionprac.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionPractice {
    public static void main(String[] args) {
        System.out.println("------------ArrayList-------------");
        ArrayList <String> arrayString = new ArrayList<>();
        arrayString.add("a");
        arrayString.add(1,"b");
        System.out.println(arrayString);

        System.out.println(arrayString.get(0));
        arrayString.set(1,"c");
        System.out.println(arrayString);

        System.out.println(arrayString.size());
        System.out.println(arrayString.isEmpty());
        System.out.println(arrayString.contains("b"));
        arrayString.remove(1);
        System.out.println(arrayString);

        System.out.println("------------HashMap-------------");
        HashMap <String, String> hashMapString = new HashMap <> ();
        hashMapString.put("1", "a");
        hashMapString.put("2", "b");
        hashMapString.put("3", "c");
        System.out.println(hashMapString);

        hashMapString.put("1", "newA");
        System.out.println(hashMapString);

        System.out.println(hashMapString.get("4"));
        System.out.println(hashMapString.get("2"));
        System.out.println(hashMapString.getOrDefault("4","해당 값 없음"));
        System.out.println(hashMapString.size());
        System.out.println(hashMapString.containsKey("4"));
        System.out.println(hashMapString.containsValue("newA"));

        System.out.println(hashMapString);
        hashMapString.remove("1");
        System.out.println(hashMapString);

        for (String key : hashMapString.keySet()){
            System.out.println("key: " + key);
        }
        for(String value : hashMapString.values()){
            System.out.println("value: " + value);
        }

        System.out.println("------------HashSet-------------");
        HashSet<String> hashSetString = new HashSet<>();
        hashSetString.add("a");
        hashSetString.add("b");
        hashSetString.add("c");
        System.out.println(hashSetString);

        HashSet<String> hashSetSting2 = new HashSet<>();
        hashSetSting2.addAll(hashSetString);
        System.out.println(hashSetSting2);

        System.out.println(hashMapString.size());
        System.out.println(hashSetString.isEmpty());
        System.out.println(hashSetString.contains("b"));
        System.out.println(hashSetString);
        hashSetString.remove("a");
        System.out.println(hashSetString);

        System.out.println("------------ArrayList 합계와 평균-------------");
        ArrayList<Integer> arrList = new ArrayList<> ();
        arrList.add(30);
        arrList.add(20);
        arrList.add(10);
        System.out.println(arrList);
        int sum = 0;
        for(int el : arrList){
            sum += el;
        }
        System.out.println("합계: " + sum);
        System.out.println("평균: " + sum/arrList.size());
    }
}

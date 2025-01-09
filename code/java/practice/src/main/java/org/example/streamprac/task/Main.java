package org.example.streamprac.task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numers  = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        짝수만 필터링하여 리스트 반환
        List<Integer> evenNumber = numers.stream()
                .filter(el -> el % 2 == 0)
                .collect(Collectors.toList() );

        System.out.println("evenNumber: " + evenNumber);

//        모든 숫자에 2를 곱하여 리스트 반환
        System.out.println("mutiplication2: " +  numers.stream().map(el -> el * 2).collect(Collectors.toList()));

//        숫자들의 합계 계산
        System.out.println("sum: " + numers.stream().mapToInt(Integer::intValue).sum());

//        5보다 큰 숫자의 개수 계산
        System.out.println("countBigNumThan5: " + numers.stream().filter(el -> el>5).count());



        List<String> words = Arrays.asList("apple", "banana", "cherry", "fineapple", "apple");
//        길이가 5이상인 단어들만 필터링하여 리스트 반환
        System.out.println("length5: " + words.stream().filter(w -> w.length() >= 5).collect(Collectors.toList()));

//        모든 단어들을 대문자로 변환하여 리스트 반환
        System.out.println("UpperCaseWord: " + words.stream().map(String::toUpperCase).collect(Collectors.toList()));

//        중복된 단어 제거하고 알파벳 순 정렬하여 리스트 반환
        System.out.println("distinctSortedWord: " + words.stream().distinct().sorted().collect(Collectors.toList()));

//        각 단어의 길이를 리스트로 변환
        System.out.println("wordLength: " + words.stream().map(w -> w.length()).collect((Collectors.toList())));




        List<Product> products = Arrays.asList(
                new Product("notebook", 1200000, "SALE"),
                new Product("mouse", 50000, "SALE"),
                new Product("notebook", 150000, "SOLD_OUT"),
                new Product("notebook", 350000, "SOLD_OUT"),
                new Product("notebook", 400000, "SALE")
        );
//        상품들의 이름 리스트 반환
        System.out.println("ProductsName: " + products.stream().map(Product::getName).collect(Collectors.toList()));

//        20만원 이상인 상품들의 이름 리스트 반환
        System.out.println("product20: " + products.stream().filter(product -> product.getPrice() >= 200000).map(Product::getName).collect(Collectors.toList()));

//        판매중인 상품의 가격 합
        System.out.println("sumProductsPriceOnSale: " + products.stream().filter(product -> product.getStatus().equals("SALE")).mapToInt(Product::getPrice).sum());

//        판매 중이면서 20만원 이상인 상품들의 이름 리스트 반환
        System.out.println("ProductsPriceOnSale20: " + products.stream().filter(product -> product.getStatus().equals("SALE")).map(Product::getName).distinct().collect((Collectors.toList())));
    }
}

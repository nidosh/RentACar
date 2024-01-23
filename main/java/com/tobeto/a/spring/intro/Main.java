package com.tobeto.a.spring.intro;

import com.tobeto.a.spring.intro.entities.concretes.Statu;
import com.tobeto.a.spring.intro.services.dtos.statu.response.GetListStatuResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Statu>status = new ArrayList<>();

        Statu statu1 =  new Statu();
        statu1.setId(1);
        statu1.setName("Busy");
        status.add(statu1);

        Statu statu2 =  new Statu();
        statu2.setId(2);
        statu2.setName("Delivered");
        status.add(statu2);

        Statu statu3 = new Statu();
        statu3.setId(3);
        statu3.setName("Waiting");
        status.add(statu3);

        //Lambda Expression
        //Çoklu satırlara her zaman süslü parantez açılırken
        status.forEach((item) -> {
            String name = item.getName();
            System.out.println(item.getName());
        });

        //Tek satırlı kodlara süslü parantez açılmayabilir.(One Line Function)
        status.forEach((item)->System.out.println(item.getId()));

        //Stream API

        //Bir entity üzerinde işlem yapmak.(statu2'nin Id'sini 2 ile çarp)
        //koleksiyonlar üzeirnde işlem yapılmasını kolaylaştırır.
        List<GetListStatuResponse> result =
                 status
                .stream()
                .map((statu)-> new GetListStatuResponse(statu.getName(), statu.getId()))
                .toList();

        List<Statu> sortedStatus = status.stream().sorted( (s1, s2) -> s1.getName().compareTo(s2.getName()) ).toList();
        sortedStatus.forEach((statu) -> System.out.println(statu.getName()));

        System.out.println("*********************");
        List<Statu> sortedStatus2 = status.stream().sorted(Comparator.comparing(Statu::getName).thenComparing(Statu::getId)).toList();
        sortedStatus2.forEach((statu) -> System.out.println(statu.getName()));

        System.out.println("*********************");

        List<Statu> filteredStatus = status.stream().filter( (statu) -> statu.getName().length() > 4 ).toList();
        System.out.println(filteredStatus.size());


        List<Statu> filteredStatus2 = status.stream().filter((statu) -> {
            int minLength = 2;
            return statu.getId() > minLength && statu.getName().equals("Busy");
        }).toList();
        System.out.println(filteredStatus2.size());

        // Multiple Line lambda expressionlarda eğer method bir dönüş tipi bekliyor ise, return keywordu kullanılmalı.
    }
}


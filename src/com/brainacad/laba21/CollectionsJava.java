package com.brainacad.laba21;

import java.lang.reflect.Array;
import java.util.*;

public class CollectionsJava implements Comparable {


    public static void main(String[] args) {

        String[] mass1 = new String[]{"qwe", "asd", "zxc", "qaz", "wsx", "edc", "rfv", "rfv", "yhn", "ujm"};
        String[] mass2 = new String[]{"1", "8", "9", "2", "5", "3", "4", "6", "7", "0"};

        List<String> list1 = new ArrayList<>(Arrays.asList(mass1));
        List<String> list2 = new ArrayList<>(Arrays.asList(mass2));

        //Collections.add(list1, "play", "game", "hi", "world", "apple", "word", "work");
        list1.add(5, "ПРивет ");
        list1.add("как дела");
        if (list1.addAll(5, list2)){
            System.out.println("Лист 2 вставлен в Лист 1");
        }
        Collections.sort(list1);
        Collections.reverse(list1);


        ListIterator<String> iterator = list1.listIterator();


        System.out.println("---------------------Old List1 --------------------");
        for (Object str : list1) {
            System.out.println("List1 = " + str);
        }

        while (iterator.hasNext()){
            iterator.next();
            System.out.println(iterator.next());
            if(iterator.nextIndex()%2 == 0){
                iterator.remove();
            }
        }


        System.out.println("---------------------Last List1 --------------------");
        for (Object str : list1) {
            System.out.println("List1 = " + str);
        }

        for (String str : list2) {
            System.out.println("List2 " + str);
        }

        System.out.println("--------------SET---------------");

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new LinkedHashSet<>();

        set1.addAll(list1);
        set1.addAll(list2);

        set2.addAll(list1);
        set2.addAll(list2);

        System.out.println("--------------SET1---------------");
        for (String str : set1) {
            System.out.println(str);
        }
        System.out.println("--------------SET2---------------");
        for (String str : set2) {
            System.out.println(str);
        }

        System.out.println("--------------MAP---------------");
        Map<Integer, String> map1 = new LinkedHashMap<>();

        map1.put(1, "Январь");
        map1.put(2, "Февраль");
        map1.put(3, "Март");
        map1.put(4, "Апрель");
        map1.put(5, "Май");
        map1.put(6, "Июнь");
        map1.put(7, "Июль");
        map1.put(8, "Август");
        map1.put(9, "Сентябрь");
        map1.put(10, "Октябрь");
        map1.put(11, "Ноябрь");
        map1.put(12, "Декабрь");

        System.out.println(map1.get(1));
        System.out.println(map1.get(12));

        map1.put(6, "ОТПУСК");
        System.out.println(map1.get(6));

        Map<Integer, String> map2 = new HashMap<>();

        map2.putAll(map1);
        CollectionsJava.showAllMap(map1);
        CollectionsJava.showAllMap(map2);

        Map<String, List<String>> map3  = new HashMap<>();
        
        map3.put("Петров", Arrays.asList("telefon1", "skype1", "e-mail1"));
        map3.put("Сидоров", Arrays.asList("telefon2", "skype2", "e-mail2"));
        map3.put("Иванов", Arrays.asList("telefon3", "skype3", "e-mail3"));
        map3.put("Степанов", Arrays.asList("telefon4", "skype4", "e-mail4"));

        Set<User> userSet = new HashSet<>();

        User user1 = new User("Сергей", 18, "0551234567");
        User user2 = new User("Степан", 20, "0991234567");
        User user3 = new User("Сергей", 30, "0551234567");

        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);

        for (User user : userSet){
            System.out.println(user.toString());
        }

    }


    public static void showAllMap(Map map) {
        for (int i = 1; i <= map.size(); i++) {
            System.out.println("map" + i + "=" + map.get(i));

        }

    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
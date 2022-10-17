package com.lmh.user;




import java.util.*;
import java.util.function.Consumer;


public class MainTest {

//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("lmh");
//        list.add("wf");
//        list.add("beta");
//
//        list.stream()
////                .filter(item -> item.length() >= 3)
//                .map(item -> item + "&")
//                .forEach(item -> System.out.println(item));
//
//        List<Integer> ins = new ArrayList<>();
//        ins.add(10);
//        ins.add(5);
//        ins.add(2);
//        ins.add(105);
//        ins.add(18);
////        Integer max = ins.stream()
////                .reduce(Integer.MIN_VALUE, (result, ele) -> {
////                    return ele > result ? ele : result;
////                });
//        Optional<Integer> op = ins.stream()
//                .reduce((pre, next) -> {
//                    return pre > next ? pre : next;
//                });
//        System.out.println(op.get());
//    }

    public static void main(String[] args) {
//        Person person = getPerson();
//        System.out.println(person.getName());

        Optional<Person> optionalPerson = getOptionsPerson();
        optionalPerson.ifPresent(person -> System.out.println(person.getName()));
    }

    private static Optional<Person> getOptionsPerson() {
        Person person = getPerson();
        return Optional.ofNullable(person);
    }


    private static Person getPerson() {
        Person person = new Person("lmh", 20);
        return null;
//        return person;
    }
}


package edu.java8.practice.service.impl;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import edu.java8.practice.domain.Privilege;
import edu.java8.practice.domain.User;
import edu.java8.practice.service.UserService;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class UserServiceImpl implements UserService {

    @Override
    public List<String> getFirstNamesReverseSorted(List<User> users) {
        return users.stream().map(User::getFirstName)
                .sorted((p1, p2) -> -p1.compareTo(p2))
                .collect(toList());
    }

    @Override
    public List<User> sortByAgeDescAndNameAsc(final List<User> users) {
     return users.stream()
             .sorted((p1,p2) -> -p1.getAge().compareTo(p2.getAge()) != 0 ?
                             -p1.getAge().compareTo(p2.getAge()):
                     p1.getFirstName().compareTo(p2.getFirstName())).collect(toList());
    }

    @Override
    public List<Privilege> getAllDistinctPrivileges(final List<User> users) {
        return users.stream().flatMap(user -> user.getPrivileges().stream()).distinct().collect(toList());
    }

    @Override
    public Optional<User> getUpdateUserWithAgeHigherThan(final List<User> users, final int age) {

        return users.stream().
                filter(user -> user.getPrivileges()
                        .contains(Privilege.UPDATE) && user.getAge() > age).findAny();
    }

    @Override
    public Map<Integer, List<User>> groupByCountOfPrivileges(final List<User> users) {

        return users.stream().collect(Collectors.groupingBy(user -> user.getPrivileges().size()));

    }

    @Override
    public double getAverageAgeForUsers(final List<User> users) {
        return users.stream()
                .mapToDouble(User::getAge).average().orElse(-1.0);
    }

    @Override
    public Optional<String> getMostFrequentLastName(final List<User> users) {

        return users.stream()
                .collect(Collectors.groupingBy((User::getLastName),Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.groupingBy(entry -> entry.getValue(), Collectors.mapping(entry -> entry.getKey(), toList()) ))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .filter(val-> val.size() == 1)
                .map(list -> list.get(0));
    }

    @Override
    public List<User> filterBy(final List<User> users, final Predicate<User>... predicates) {

        return users.stream().filter(Arrays.stream(predicates).reduce(i -> true, Predicate::and)).collect(toList());

    }

    @Override
    public String convertTo(final List<User> users, final String delimiter, final Function<User, String> mapFun) {

        return users.stream()
                .map(mapFun)
                .collect(Collectors.joining(delimiter));
    }

    @Override
    public Map<Privilege, List<User>> groupByPrivileges(List<User> users) {
        Stream<Map.Entry<Privilege, User>> streamOfEntries = users.stream()
                .flatMap(user ->
                        user.getPrivileges().stream()
                                .collect(Collectors.toMap(Function.identity(), p -> user)).entrySet().stream());
        return streamOfEntries
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, toList())));
    }

    @Override
    public Map<String, Long> getNumberOfLastNames(final List<User> users) {
//        throw new UnsupportedOperationException("Not implemented");
  return users.stream().collect(Collectors.groupingBy(User::getLastName,Collectors.counting()));
    }
}

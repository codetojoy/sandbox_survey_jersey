package net.codetojoy.survey.service;

import net.codetojoy.survey.model.*;

import java.util.*;
import java.util.stream.*;

public class GreetingService {
    // This is obviously a toy example.
    private static Map<Long,Greeting> mockStorage = new HashMap<>();
    private static long nextId = 0L;

    static {
        mockStorage.put(111L, new Greeting(111L, "This is greeting 1"));
        mockStorage.put(222L, new Greeting(222L, "This is greeting 2"));
        mockStorage.put(333L, new Greeting(333L, "This is greeting 3"));
        nextId = 334;
    }

    public List<Greeting> getGreetings() {
        List<Greeting> greetings = mockStorage.entrySet()
                                              .stream()
                                              .map(Map.Entry::getValue)
                                              .collect(Collectors.toList());

        return greetings;
    }

    public Greeting getGreeting(long id) {
        Greeting greeting = mockStorage.get(id);
        return greeting;
    }

    public void createGreeting(Greeting greeting) {
        greeting.setId(nextId);
        mockStorage.put(nextId, greeting);
        nextId++;
    }

    public void updateGreeting(long id, Greeting greeting) {
        mockStorage.put(id, greeting);
    }
}

package com.ou.springcode.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Repository;

import com.ou.springcode.model.User;

import jakarta.annotation.PostConstruct;

@Repository
public class UserRepository {
    private final Map<Long, User> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @PostConstruct
    public void init() {
        User u1 = new User(null, "nva", "nva@gmail.com", "Nguyen Van A", null);
        User u2 = new User(null, "nvb", "nvb@gmail.com", "Nguyen Van B", null);
        User u3 = new User(null, "nvc", "nvc@gmail.com", "Nguyen Van C", null);

        save(u1);
        save(u2);
        save(u3);
    }
    
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(idGenerator.getAndIncrement());
            user.setCreatedAt(java.time.LocalDateTime.now());
        }
        store.put(user.getId(), user);
        return user;
    }

    public boolean existsById(Long id) {
        return store.containsKey(id);
    }

    public void deleteById(Long id) {
        store.remove(id);
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public User update(User user) {
        store.put(user.getId(), user);
        return user;
    }

    public User partialUpdate(User user) {
        store.put(user.getId(), user);
        return user;
    }

    public User updatePartial(User user) {
        store.put(user.getId(), user);
        return user;
    }
}

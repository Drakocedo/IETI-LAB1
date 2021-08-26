package edu.eci.Microservices.service.impl;

import edu.eci.Microservices.data.User;
import edu.eci.Microservices.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final HashMap<String, User> userMap = new HashMap<String, User>();

    @Override
    public User create(User user) {
        userMap.put(String.valueOf(user.getId()), user);
        return user;
    }

    @Override
    public User findById(String id) {
        if(userMap.containsKey(id)){
            return userMap.get(id);
        }
        return null;
    }

    @Override
    public List<User> all() {
        return (List<User>) userMap.values();
    }

    @Override
    public void deleteById(String id) {
        userMap.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        return null;
    }
}

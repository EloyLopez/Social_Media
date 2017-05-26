package edu.lasalle.ppro2.socialmedia.Repositories;

import java.util.List;

import edu.lasalle.ppro2.socialmedia.model.User;

/**
 * Created by eloy on 24-05-2017.
 */

public interface UsersDBRepo {
    void addUser(User u);
   List<User> getAllusers();
    void update(String name, String surname,int value);
}

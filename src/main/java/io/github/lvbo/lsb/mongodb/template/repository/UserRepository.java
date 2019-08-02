package io.github.lvbo.lsb.mongodb.template.repository;

import io.github.lvbo.lsb.mongodb.template.model.User;

public interface UserRepository {

    public void saveUser(User user);

    public User findUserByUserName(String userName);

    public long updateUser(User user);

    public void deleteUserById(Long id);

}

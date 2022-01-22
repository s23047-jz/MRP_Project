package pl.pjatk.mprProject.Jacob.User;

import java.util.List;
import java.util.Optional;

// import java.util.Optional;

import org.springframework.stereotype.Service;

@Service // Service permorms on the object
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void printUser(User user) {
        System.out.println(user);
    }

    public void changeName(User user, String name) {
        if (user.getName().equals(name)) {
            throw new IllegalArgumentException("You can't set your name on the same name!!!");
        } else {
            user.setName(name);
        }
    }

    public void changeSurName(User user, String surName) {
        if (user.getSurName().equals(surName)) {
            throw new IllegalArgumentException("You can't set your surname on the same surname!!!");
        } else {
            user.setName(surName);
        }
    }

    public void changeUserName(User user, String userName) {
        if (user.getUserName().equals(userName)) {
            throw new IllegalArgumentException("You can't set your username on the same username!!!");
        } else {
            user.setName(userName);
        }
    }

    public void changeEmail(User user, String email) {
        if (user.getUserName().equals(email)) {
            throw new IllegalArgumentException("You can't set your email on the same email!!!");
        } else if (email != email + "@domena.pl") {
            throw new IllegalArgumentException("Wrong email!!!");
        } else {
            user.setEmail(email);
        }
    }

    public void changePassword(User user, String password) {
        if (user.getPassword().equals(password)) {
            throw new IllegalArgumentException("You can't set your username on the same username!!!");
        } else if (password.length() < 8) {
            throw new IllegalArgumentException("Your password must have more than 8 characters");
        } else {
            user.setPassword(password);
        }
    }

    public void changeAge(User user, int age) {
        if (user.getAge() == age) {
            throw new IllegalArgumentException("You can't set your age on the same age!!!");
        } else {
            user.setAge(age);
        }
    }

    public User createUser(String name, String surName, String userName) {
        User user = new User(name, surName, userName, "Zelek@domena.pl", "123456", 20);
        return userRepository.save(user);
    }

    public User findById(Long id) {
        // Optional is protecting us from getting error. This can be the case when trying
        // to reference an element that does not exists.
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            // throw new IllegalArgumentException("User with id " + id + " does not exist!!!");
            return null;
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean isUserExists(Long id) {
        return userRepository.existsById(id);
    }

    public Long countUsers() {
        return userRepository.count();
    }

    public void deleleUser(Long id) {
        boolean isExists = isUserExists(id);
        if (!isExists) {
            throw new IllegalStateException("User with id " + id + " does not exists");
        } else {
            userRepository.deleteById(id);
        }
    }
}

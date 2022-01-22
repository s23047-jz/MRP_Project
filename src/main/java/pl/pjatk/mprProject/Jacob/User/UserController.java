package pl.pjatk.mprProject.Jacob.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;
    // dependency injection

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> printOK() {
        return ResponseEntity.ok("It works");
    }

    // ResponseEntity represents the whole HTTP response: status code, headers, and
    // body. As a result, we can use it to fully configure the HTTP response.
    @GetMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam String surName, @RequestParam String userName) {
        return ResponseEntity.ok(userService.createUser(name, surName, userName));
    }
    // We can use @RequestParam to extract query parameters, form parameters, and
    // even files from the request.

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
    // The @PathVariable annotation can be used to handle template variables in the
    // request URI mapping, and set them as method parameters.

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

// RestController will return raw data back to the cliect. Or simpler returns
// the data right in the HTTP response body.
// on screen in .
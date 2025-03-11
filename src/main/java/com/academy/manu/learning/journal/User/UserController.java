<<<<<<<< HEAD:src/main/java/com/academy/manu/learning/journal/UserController.java
package com.academy.manu.learning.journal;

========
package com.academy.manu.learning.journal.User;
>>>>>>>> origin/master:src/main/java/com/academy/manu/learning/journal/User/UserController.java
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
<<<<<<<< HEAD:src/main/java/com/academy/manu/learning/journal/UserController.java
    public final UserService userService;



========

    public final UserService userService;

>>>>>>>> origin/master:src/main/java/com/academy/manu/learning/journal/User/UserController.java
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> getUser() {
        return userService.findAll();
    }



    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }





}

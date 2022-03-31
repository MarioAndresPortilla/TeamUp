package teamup.p2backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teamup.p2backend.model.Event;
import teamup.p2backend.model.User;
import teamup.p2backend.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user1")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService){this.userService = userService;}

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    List<User> getUsers(){
        return userService.findAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("user_id1/{user_id}")
    public User getUserById(@PathVariable int user_id){
        return userService.findUserById(user_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("username1/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userService.findUserByUsername(username);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public User postUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping
    public void deleteUser(@RequestParam String username1){
        userService.deleteUser(username1);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PatchMapping
    public void updateUser(@RequestBody User user){userService.updateUser(user);}

}


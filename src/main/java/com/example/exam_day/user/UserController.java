package com.example.exam_day.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return userService.getUsersFromDto();
    }
    @PostMapping("/users")
    public UserDto saveUser(UserDto userDto){
        return userService.saveDtoToUser(userDto);
    }
    @PutMapping("/users/{id}")
    public UserDto updateUser(  @PathVariable("id") Long id,
                                UserDto userDto){
        return userService.updateUserFromDto(id, userDto);
    }
    @DeleteMapping("/users/{id}")
    public UserDto deleteUser(@PathVariable("id") Long id){
        return userService.deleteUserFromDto(id);
    }
    @GetMapping("/users/{id}")
    public UserDto getUserDtoFromUserId(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
}

package com.example.exam_day.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserDto> getUsersFromDto(){
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();
        for(User user : users) {
            UserDto userDto = new UserDto(user.getName(), user.getLastname());
            usersDto.add(userDto);
        }
        return usersDto;
    }
    public UserDto saveDtoToUser(UserDto userDto){
        userRepository.save(new User(userDto.getName(), userDto.getLastname()));
        return userDto;
    }
    public UserDto updateUserFromDto(Long id, UserDto userDto){
        User user = userRepository.getOne(id);
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        userRepository.save(user);
        return userDto;
    }
    public UserDto deleteUserFromDto(Long id){
        User user = userRepository.getOne(id);
        userRepository.delete(user);
        return new UserDto(user.getName(),user.getLastname());
    }
    public UserDto getUserById(Long id){
        User user = userRepository.getOne(id);
        return new UserDto(user.getName(),user.getLastname());
    }
}

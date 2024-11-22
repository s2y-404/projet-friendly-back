package com.friendly.friendly.Service;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.friendly.friendly.Dto.UserDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Mapper.UserMapper;
import com.friendly.friendly.Model.User;
import com.friendly.friendly.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserMapper userMapper;
    
    // @Autowired
    // private BCryptPasswordEncoder passwordEncoder;

    public Page<UserDto> findAll(int page, int size) {
        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Page and size must be greater than zero");
        }
        
        Page<User> users = userRepository.findAll(PageRequest.of(page, size));
        return users.map(userMapper::toDto);
    }

    public UserDto findById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userMapper.toDto(user);
    }

    public UserDto save(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new ResourceNotFoundException("Username already exists.");
        }
        User user = userMapper.toEntity(userDto);
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDto update(UserDto userDto) throws ResourceNotFoundException {
        User existingUser = userRepository.findById(userDto.getId())
                                          .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userDto.getId()));
        userDto.setId(existingUser.getId());
        userDto.setUsername(existingUser.getUsername());
        userDto.setPassword(existingUser.getPassword());
        userDto.setBirthdate(existingUser.getBirthdate());
        User userUpdated = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(userUpdated));
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User with ID " + id + " does not exist.");
        }
        userRepository.deleteById(id);
    }

    public UserDto register(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto login(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User userFound = userRepository.findByUsername(user.getUsername());
        // return userMapper.toDto(passwordEncoder.matches(
        //     user.getPassword(), userFound.getPassword()) ? userFound : null
        // );
        return userMapper.toDto(userDto.getPassword().equals(userFound.getPassword()) ? userFound : null);
    }
}

package com.example.securingWeb.service;

import com.example.securingWeb.model.User;
import com.example.securingWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Lưu user mới
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Mã hóa password
        return userRepository.save(user);
    }

    // Cập nhật user
    public User updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setPassword(passwordEncoder.encode(updatedUser.getPassword())); // Cập nhật password (nếu cần)
            user.setRoles(updatedUser.getRoles());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    // Xóa user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}

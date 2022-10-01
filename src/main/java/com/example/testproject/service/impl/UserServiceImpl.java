package com.example.testproject.service.impl;

import com.example.testproject.dao.UserRepo;
import com.example.testproject.microservice.FileServiceFeign;
import com.example.testproject.microservice.json.Response;
import com.example.testproject.model.User;
import com.example.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private FileServiceFeign fileServiceFeign;

    @Autowired
    private UserRepo userRepo;

    @Override
    public User save(User user) {

        return userRepo.save(user);
    }

    @Override
    public User getById(Long id) {

        return userRepo.findById(id).orElse(null);

    }

    @Override
    public User update(User user) {
        if (userRepo.existsById(user.getId())) {
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public User addUser(User user, MultipartFile file) {
        Response response = fileServiceFeign.upload(file);
        user.setImageUri(response.getDownloadUri());
        return save(user);
    }
}

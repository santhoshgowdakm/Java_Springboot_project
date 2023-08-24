package com.example.hotel_reservation_management.service;
import com.example.hotel_reservation_management.dao.RequestObject;
import com.example.hotel_reservation_management.model.User;
import com.example.hotel_reservation_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userrepository;

    public List<User> getAllUsers(){
        return this.userrepository.findAll();
    }
    public String addNewUser(RequestObject requestObject){
        User newUser= new User();
        newUser.setName(requestObject.getName());
        newUser.setEmail(requestObject.getEmail());
        this.userrepository.save(newUser);
        return "user added successfully";
    }
    public Optional<User> getUSer(Integer id){
        Optional<User> user = this.userrepository.findById(id);
        return user;
    }
    public Optional<User> deleteUser(Integer id){
        Optional<User> deleteduser=this.userrepository.findById(id);
        this.userrepository.deleteById(id);
        return deleteduser;
    }

}

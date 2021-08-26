package edu.eci.Microservices.controller;

import edu.eci.Microservices.data.User;
import edu.eci.Microservices.dto.UserDto;
import edu.eci.Microservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService )
    {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> all()
    {
        return new ResponseEntity<>(userService.all(), HttpStatus.OK);
    }

    @GetMapping( "/findById/{id}" )
    public ResponseEntity<User> findById(@PathVariable String id )
    {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);

    }


    @PostMapping("/create")
    public ResponseEntity<User> create( @RequestBody UserDto userDto )
    {
        return  null;
    }

    @PutMapping( "/update/{id}" )
    public ResponseEntity<User> update( @RequestBody User userDto, @PathVariable String id )
    {
        try{
            userService.update(userDto ,id);
            return new ResponseEntity("User updated.", HttpStatus.OK);
        } catch (Exception e ){
            return new ResponseEntity("User not updated.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping( "/deleteById/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        try{
            userService.deleteById(id);
            return new ResponseEntity("User deleted.",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("User not deleted.", HttpStatus.NOT_FOUND);
        }
    }
}


    package com.example.hotel_reservation_management.controller;
    import com.example.hotel_reservation_management.dao.RequestObject;
    import com.example.hotel_reservation_management.model.User;
    import com.example.hotel_reservation_management.service.UserService;
    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.media.Content;
    import io.swagger.v3.oas.annotations.responses.ApiResponse;
    import io.swagger.v3.oas.annotations.responses.ApiResponses;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;
    import java.util.Optional;

    @RestController
        @RequestMapping("/api/v1/users")
    public class UserController {
        @Autowired
        private UserService userService;
        @Operation(summary = "it fetches all registered users")
        @ApiResponses(value={
                @ApiResponse(responseCode = "200", description = "we will get all registered data", content={
                        @Content(mediaType = "application/json")
                }),
                @ApiResponse(responseCode = "404", description = "page not found", content={
                        @Content()
                }),
                @ApiResponse(responseCode = "500", description = "internal server error", content={
                        @Content()
                })
        })
        @GetMapping("/all")
        public List<User> getAll(){
            return this.userService.getAllUsers();
        }
        @PostMapping("/add")
        public String addNewUser(@RequestBody RequestObject requestObject){
            return this.userService.addNewUser(requestObject);
        }
        @GetMapping("/get/{id}")
        public Optional<User> getUserByid(@PathVariable Integer id) {
            return this.userService.getUSer(id);
        }
        @DeleteMapping("/delete/{id}")
        public Optional<User> deleteuser(@PathVariable Integer id){
            return this.userService.deleteUser(id);
        }
    }

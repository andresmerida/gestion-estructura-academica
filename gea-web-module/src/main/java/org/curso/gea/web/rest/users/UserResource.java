package org.curso.gea.web.rest.users;

import org.curso.gea.domain.users.User;
import org.curso.gea.service.users.UserService;
import org.curso.gea.web.rest.exceptions.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.curso.gea.domain.utils.constants.DBConstants.USER_TABLE_NAME_DB;
import static org.curso.gea.web.rest.exceptions.ErrorConstants.ID_EXISTS_BAD_REQUEST;

@RestController
@RequestMapping("/v1/users")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private final UserService userService;


    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<User> createCountry(@RequestBody User user) throws URISyntaxException {
        log.debug("REST request to create a User : {}", user);

        if (user.getId() != null) {
            throw new BadRequestAlertException("A new user cannot already have an ID", USER_TABLE_NAME_DB, ID_EXISTS_BAD_REQUEST);
        }

        User userDB = userService.save(user);

        return ResponseEntity.created(new URI("/v1/users/" + userDB.getId()))
                .body(userDB);
    }
}

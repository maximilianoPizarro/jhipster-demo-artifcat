package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Authority;
import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.service.dto.UserDTO;
import jakarta.inject.Singleton;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper for the entity {@link User} and its DTO called {@link UserDTO}.
 * <p>
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Singleton
public class UserMapper {

    public List<UserDTO> usersToUserDTOs(List<User> users) {
        return users.stream().filter(Objects::nonNull).map(this::userToUserDTO).collect(Collectors.toList());
    }

    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user);
    }

    public List<User> userDTOsToUsers(List<UserDTO> userDTOs) {
        return userDTOs.stream().filter(Objects::nonNull).map(this::userDTOToUser).collect(Collectors.toList());
    }

    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            User user = new User();
            user.id = userDTO.id;
            user.login = userDTO.login;
            user.firstName = userDTO.firstName;
            user.lastName = userDTO.lastName;
            user.email = userDTO.email;
            user.imageUrl = userDTO.imageUrl;
            user.activated = userDTO.activated;
            user.langKey = userDTO.langKey;
            Set<Authority> authorities = this.authoritiesFromStrings(userDTO.authorities);
            user.authorities = authorities;
            return user;
        }
    }

    private Set<Authority> authoritiesFromStrings(Set<String> authoritiesAsString) {
        Set<Authority> authorities = new HashSet<>();

        if (authoritiesAsString != null) {
            authorities = authoritiesAsString
                .stream()
                .map(string -> {
                    Authority auth = new Authority();
                    auth.name = string;
                    return auth;
                })
                .collect(Collectors.toSet());
        }

        return authorities;
    }

    public User userFromId(Long id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.id = id;
        return user;
    }
}

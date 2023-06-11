package lesson28.service;

import lesson28.repository.SpringDataUser;
import lesson28.repository.SpringDataUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final SpringDataUserRepository userRepository;

    public List<UserDto> findUsers() {
        return userRepository.findAll().stream()
                .map(this::mapUser)
                .toList();
    }

    public UserDto findUser(String id) {
        return userRepository.findByUid(id)
                .map(this::mapUser)
                .orElse(null);
    }

    public void deleteUser(String id) {
        var user = userRepository.findByUid(id).orElseThrow();
        userRepository.delete(user);
    }

    public UserDto updateUser(String uid, UserDto user) {
        var userToUpdate = userRepository.findByUid(uid).orElseThrow();
        userToUpdate.setName(user.name());
        return mapUser(userRepository.save(userToUpdate));
    }

    public UserDto createUser(UserDto userDto) {
        var savedUser = userRepository.save(SpringDataUser.builder()
                .uid(UUID.randomUUID().toString())
                .name(userDto.name())
                .email(userDto.email())
                .role(userDto.role())
                .build());
        return mapUser(savedUser);
    }

    private UserDto mapUser(SpringDataUser user) {
        return UserDto.builder()
                .id(user.getUid())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}

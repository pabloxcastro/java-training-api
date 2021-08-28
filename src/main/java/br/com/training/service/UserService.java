package br.com.training.service;

import br.com.training.dto.UserResponse;
import br.com.training.model.User;
import br.com.training.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(User user){
        User userNew = userRepository.save(user);
        return UserResponse.toDto(userNew);
    }

    public UserResponse getUser(String cpf){
        User user = userRepository.findByCpf(cpf);
        return UserResponse.toDto(user);
    }

    public UserResponse updateUser(String cpf, User user){
        User userAtual = userRepository.findByCpf(cpf);

        BeanUtils.copyProperties(user, userAtual, "id");

        User userUpdated = userRepository.save(userAtual);

        return UserResponse.toDto(userUpdated);

    }

    public void deleteUser(String cpf){
        User user = userRepository.findByCpf(cpf);
        userRepository.deleteById(user.getId());
    }

}

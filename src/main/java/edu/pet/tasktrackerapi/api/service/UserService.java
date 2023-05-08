package edu.pet.tasktrackerapi.api.service;

import edu.pet.tasktrackerapi.api.dto.UserDto;
import edu.pet.tasktrackerapi.api.model.User;
import edu.pet.tasktrackerapi.exception.BadCredentialsException;
import edu.pet.tasktrackerapi.exception.NotFoundException;
import edu.pet.tasktrackerapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDto getUserInfo(User user){
        return modelMapper.map(getUserEntity(user.getId()), UserDto.class);
    }

    protected User getUserEntity(Long id){
        //todo throw ex
        return userRepository.findById(id).orElseThrow((Supplier<NotFoundException>) NotFoundException::new);
    }
}

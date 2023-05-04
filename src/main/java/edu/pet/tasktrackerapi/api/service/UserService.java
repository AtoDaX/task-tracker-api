package edu.pet.tasktrackerapi.api.service;

import edu.pet.tasktrackerapi.api.dto.UserDto;
import edu.pet.tasktrackerapi.api.model.User;
import edu.pet.tasktrackerapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDto getUserInfo(User user){

        return modelMapper.map(getUserEntity(user.getId()), UserDto.class);
    }

    private User getUserEntity(Long id){
        //todo throw ex
        return userRepository.findById(id).orElseThrow();
    }
}

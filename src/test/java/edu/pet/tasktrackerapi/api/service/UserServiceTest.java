package edu.pet.tasktrackerapi.api.service;

import edu.pet.tasktrackerapi.api.dto.UserDto;
import edu.pet.tasktrackerapi.api.model.Role;
import edu.pet.tasktrackerapi.api.model.User;
import edu.pet.tasktrackerapi.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class UserServiceTest {
    @Mock
    private UserRepository testRepo;
    @Mock
    private ModelMapper modelMapper;

    private UserService underTest;


    private AutoCloseable autoCloseable;


    @BeforeEach
    void setUp() {
        underTest = new UserService(testRepo, modelMapper);
    }


    /*@Test
    void canGetUserInfo() {
        //given
        Long testId = 1L;
        User testUser = User.builder()
                .id(testId)
                .build();
        UserDto expected = new UserDto();
        expected.setId(testId);

        given(testRepo.findById(testId)).willReturn(Optional.of(testUser));

        given(underTest.getUserEntity(testId)).willReturn(testUser);


        //when
        UserDto actual = underTest.getUserInfo(testUser);
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        //then
        //assertThat(actual).isEqualTo(expected);
        verify(modelMapper).map(underTest.getUserEntity(argumentCaptor.capture()), UserDto.class);

    }*/

    @Test
    void canGetUserEntity() {
        //given
        Long testId = 1L;
        User testUser = new User();
        given(testRepo.findById(testId)).willReturn(Optional.of(testUser));

        //when
        underTest.getUserEntity(testId);

        //then
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(testRepo).findById(argumentCaptor.capture());

        Long actual = argumentCaptor.getValue();
        assertThat(actual).isEqualTo(testId);

    }
}
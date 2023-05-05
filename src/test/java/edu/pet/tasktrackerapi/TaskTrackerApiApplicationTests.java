package edu.pet.tasktrackerapi;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class   TaskTrackerApiApplicationTests {
    Calculator underTest = new Calculator();

    @Test
    void contextLoads() {
    }

    @Test
    void shouldAdd(){
        //given
        int n1 = 20;
        int n2 = 30;

        //when
        int res = underTest.add(n1, n2);

        assertThat(res).isEqualTo(50);
    }

    class Calculator{
        int add(int a, int b){
            return a+b;
        }
    }

}

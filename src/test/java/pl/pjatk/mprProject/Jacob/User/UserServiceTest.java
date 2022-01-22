package pl.pjatk.mprProject.Jacob.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    // The Mockito.mock() method allows us to create a mock(atrape) object of a
    // class or an interface.
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    // InjectMocks annotation to inject mock fields into the tested object.
    // automatically

    @Test
    void shouldPrintUser() {
        // given
        User user = new User("Judasz", "wszechmogacy", "judawszego", "judaszenko@domena.pl", "zaqwer", 25);
        // when
        userService.printUser(user);
        // then
        assertThat(user.getName())
                .isEqualTo("Judasz");
    }

    @Test
    void shouldChangeName() {
        User user = new User("Judasz", "wszechmogacy", "judawszego", "judaszenko@domena.pl", "zaqwer", 25);
        // when
        userService.changeName(user, "Marek");
        // then
        assertThat(user.getName())
                .isEqualTo("Marek");
    }

    @Test
    void shouldChangeSurName() {
        // given
        User user = new User("Judasz", "wszechmogacy", "judawszego", "judaszenko@domena.pl", "zaqwer", 25);
        // when
        userService.changeSurName(user, "Beczkowski");
        // then
        assertThat(user.getSurName())
                .isEqualTo("Beczkowski");
    }

    @Test
    void shouldChangeEmail() {
        // given
        User user = new User("Judasz", "wszechmogacy", "judawszego", "judaszenko@domena.pl", "zaqwer", 25);
        // when
        userService.changeEmail(user, "Judaszek@gmail.com");
        // then
        assertThat(user.getEmail())
                .isEqualTo("Judaszek@domena.pl");
    }

    @Test
    void shouldChangeAge() {
        // given
        User user = new User("Judasz", "wszechmogacy", "judawszego", "judaszenko@domena.pl", "zaqwer", 25);
        // when
        userService.changeAge(user, 18);
        // then
        assertThat(user.getAge())
                .isEqualTo(20);
    }

    @Test
    void shouldFindById() {
        Mockito.when(userRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.of(new User()));
        User user = userService.findById(1L);
        assertThat(user).isNotNull();
    }

    @Test
    void shouldCountUsers() {
        Mockito.when(userRepository.count()).thenReturn(20L);
        Long users = userService.countUsers();
        assertThat(users).isNotNull();
    }

    @Test
    void shouldDeleteUser() {
        Mockito.when(userRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.of(new User()));
        User user = userService.findById(1L);
        assertThat(user).isNotNull();
    }

}

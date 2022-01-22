package pl.pjatk.mprProject.Jacob.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @Test
    void shouldPrintOK() throws Exception {
        mockmvc.perform(get("/user"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("It works"));
    }

    @Test
    void shouldCreateUser() throws Exception {
        mockmvc.perform(get("/user/createUser")
                .param("name", "Ignacy")
                .param("surName", "Krasicky")
                .param("userName", "IgnoKrosik")
            ).andDo(print()).andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"Ignacy\",\"surName\":\"Krasicky\",\"userName\":\"IgnoKrosik\",\"email\":\"Zelek@domena.pl\",\"password\":\"123456\",\"age\":20}"));
    }
}

// Ideally, we should keep the integration tests separated from the unit tests
// and should not run along with the unit tests. We can do this by using a
// different profile to only run the integration tests. A couple of reasons for
// doing this could be that the integration tests are time-consuming and might
// need an actual database to execute.

// Integration tests focus on integrating different layers of the application.
// That also means no mocking is involved.

// We can use the webEnvironment attribute of @SpringBootTest to configure our
// runtime environment.

// Spring MVC test framework in order to write and run integration tests that
// test controllers without explicitly starting a Servlet container.

// ways of configuration: @AutoConfigureMockMvc,
// @ContextConfiguration(locations={""}), @WebAppConfiguration(value = "")
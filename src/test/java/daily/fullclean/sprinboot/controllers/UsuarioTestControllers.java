package daily.fullclean.sprinboot.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@AutoConfigureMockMvc
@SpringBootTest
public class UsuarioTestControllers {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
    public void shouldGetAllUsuarioResControllers() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/usuario/listar")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();

        int statusCode = result.getResponse().getStatus();
        assertThat(statusCode, anyOf(equalTo(204), equalTo(200)));
    }
	
	@Test
    public void shouldGetUsuarioResControllers() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/api/usuario/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();

        int statusCode = result.getResponse().getStatus();
        assertThat(statusCode, anyOf(equalTo(404), equalTo(200)));
    }
}

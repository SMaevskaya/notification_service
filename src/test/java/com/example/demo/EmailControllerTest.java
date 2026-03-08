package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmailController.class)
public class EmailControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmailService emailService;

    @Test
    void  testSendEmailOk() throws Exception{
        Email email = new Email("abc@mail.ru","abc","abc");
       doNothing().when(emailService).sendEmail("abc@mail.ru","abc","abc");

        mockMvc.perform(post("/email").contentType(MediaType.APPLICATION_JSON).content(
                """
                {
                    "toAddress": "abc@mail.ru",
                    "subject": "abc",
                    "text": "abc"
                }
                """))
                .andExpect(status().isOk());

    }

    @Test
    void  testSendEmailBadRequest() throws Exception{
        Email email = new Email("abc@mail.ru","abc","abc");
        doNothing().when(emailService).sendEmail("abc@mail.ru","abc","abc");

        mockMvc.perform(post("/email").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }


}

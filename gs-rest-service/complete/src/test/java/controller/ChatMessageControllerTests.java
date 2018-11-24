package controller;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.model.Message;
import com.model.MessageResponse;
import com.service.impl.MessageServiceImpl;

/**
 * 
 * @author sowjhanyaashok
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ChatMessageControllerTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Mock
	MessageServiceImpl messageService;
	
	@Test
    public void createMessage_success_test() throws Exception {
		
		String requestJSON = "{\"username\":\"lego\",\"text\":\"hello\"}";
		MessageResponse msgResponse = new MessageResponse();
		msgResponse.setOk(true);
		
		Message msg = new Message(1, "batman", 1542006263, "hello there!");
		
		when(messageService.createMessage(msg)).thenReturn(msgResponse);

        this.mockMvc.perform(post("/message").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        //verify(messageService, times(1)).createMessage(any(Message.class));
        
    }

    @Test
    public void getUsers_success_test() throws Exception {

        this.mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        verifyNoMoreInteractions(messageService);
        
    }
    
    @Test
    public void getMessages_success_test() throws Exception {

        this.mockMvc.perform(get("/messages")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        verifyNoMoreInteractions(messageService);
        
    }

}

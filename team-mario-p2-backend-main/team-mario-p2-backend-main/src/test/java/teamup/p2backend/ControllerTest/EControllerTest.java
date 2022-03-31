package teamup.p2backend.ControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import teamup.p2backend.controller.EventController;
import teamup.p2backend.model.Event;
import teamup.p2backend.repository.EventRepository;
import teamup.p2backend.service.EventService;



//import teamup.p2backend.service.SportService;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(EventController.class)
public class EControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @MockBean
    private EventRepository eventRepository;

    // @MockBean
    // private SportService sportService;

    private List<Event> eventList;

    @BeforeEach
    void setUp() {
        List<Event> eventList = new ArrayList<>();

        Event eve1 = new Event(999, "Ozy", "House", "April", "12", "expert", "Hockey", "Ozymandius");
        Event eve2 = new Event(998, "Billiam", "Park", "May", "12", "Beginner", "Basketball", "11DollarBill");

        eventList.add(eve1);
        eventList.add(eve2);
    }

    //-------------post testing
    @Test
    public void saveTest() throws Exception {
        Mockito.when(eventRepository.save(any(Event.class))).thenReturn(new Event(998, "Ozzy", "House", "April", "12", "expert", "Hockey", "Ozymandius"));
        this.mockMvc.perform(post("/event")
                        .content("{\"event_id\": 999, \"name\": \"Ozzy\", \"place\": \"House\", \"date\": \"date\", \"time\": \"12\", \"level\": \"expert\", \"sport\": \"Hockey\", \"username\": \"Ozymandius\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

//-----------get testing

    @Test
    public void getAllTest() throws Exception {
        Mockito.when(eventRepository.findAll()).thenReturn(eventList);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/event"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getEventBySport() throws Exception {

        Mockito.when(eventService.findEventBySport(any(String.class))).thenReturn(new Event(998, "Ozzy", "House", "April", "12", "expert", "Soccer", "Ozymandius"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/event/sport/soccer"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"event_id\": 998, \"name\": \"Ozzy\", \"place\": \"House\", \"date\": \"April\", \"time\": \"12\", \"level\": \"expert\", \"sport\":\"Soccer\", \"username\": \"Ozymandius\"}"));

    }

    @Test
    public void getEventByName() throws Exception {

        Mockito.when(eventService.findEventByName(any(String.class))).thenReturn(new Event(998, "Ozzy", "House", "April", "12", "expert", "Hockey", "Ozymandius"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/event/name/Ozzy"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"event_id\": 998, \"name\": \"Ozzy\", \"place\": \"House\", \"date\": \"April\", \"time\": \"12\", \"level\": \"expert\", \"sport\": \"Hockey\", \"username\": \"Ozymandius\"}"));

    }

    @Test
    public void getEventByLevel() throws Exception {


        Mockito.when(eventService.findEventByLevel(any(String.class))).thenReturn(new Event(998, "Ozzy", "House", "April", "12", "expert", "Hockey", "Ozymandius"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/event/level/expert"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"event_id\": 998, \"name\": \"Ozzy\", \"place\": \"House\", \"date\": \"April\", \"time\": \"12\", \"level\": \"expert\", \"sport\": \"Hockey\", \"username\": \"Ozymandius\"}"));
    }
    @Test
    public void getEventByUsername() throws Exception {
        Mockito.when(eventService.findEventByUser(any(String.class))).thenReturn(new Event(998, "Ozzy", "House", "April", "12", "expert", "Hockey", "Ozymandius"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/event/username/Ozymandius"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"event_id\": 998, \"name\": \"Ozzy\", \"place\": \"House\", \"date\": \"April\", \"time\": \"12\", \"level\": \"expert\", \"sport\": \"Hockey\", \"username\": \"Ozymandius\"}"));
    }

    @Test
    public void getEventByPlace() throws Exception {
        Mockito.when(eventService.findEventByPlace(any(String.class))).thenReturn(new Event(998, "Ozzy", "House", "April", "12", "expert", "Hockey", "Ozymandius"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/event/place/place"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"event_id\": 998, \"name\": \"Ozzy\", \"place\": \"House\", \"date\": \"April\", \"time\": \"12\", \"level\": \"expert\", \"sport\": \"Hockey\", \"username\": \"Ozymandius\"}"));
    }

    @Test
    public void delete() throws Exception {
        Mockito.when(eventRepository.findByName("Ozzy")).thenReturn(new Event(998, "Ozzy", "House", "April", "12", "expert", "Hockey", "Ozymandius"));

        eventRepository.deleteByName("Ozzy");

        verify(eventRepository, times(1)).deleteByName("Ozzy");
    }

    @Test
    public void update() throws Exception {
        Mockito.when(eventRepository.findByName("Ozzy")).thenReturn(new Event(998, "Ozzy", "House", "April", "12", "expert", "Hockey", "Ozymandius"));
        this.mockMvc.perform(patch("/event")
                        .content("{\"event_id\": 999, \"name\": \"Ozzy\", \"place\": \"House\", \"date\": \"date\", \"time\": \"12\", \"level\": \"expert\", \"sport\":\"Hockey\", \"username\": \"Ozymandius\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}




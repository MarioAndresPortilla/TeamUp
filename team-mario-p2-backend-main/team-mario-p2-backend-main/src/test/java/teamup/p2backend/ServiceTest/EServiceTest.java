package teamup.p2backend.ServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import teamup.p2backend.controller.SportController;
import teamup.p2backend.controller.EventController;
import teamup.p2backend.model.Event;
//import teamup.p2backend.model.Sport;
import teamup.p2backend.repository.EventRepository;
import teamup.p2backend.service.EventService;
//import teamup.p2backend.service.SportService;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
//@WebMvcTest(EventController.class)
@ExtendWith(MockitoExtension.class)
public class EServiceTest {
    @MockBean
    EventRepository eventRepository;

    //@MockBean
    //SportService sportService;

    @InjectMocks
    EventService eventService;

    @BeforeEach
    void setUp() {
        eventService = new EventService(eventRepository);
    }

    @Test
    public void saveTest() {
        Event eve1 = new Event(999, "Ozy", "House", "April", "12", "expert", "JumpRope", "Ozymandius");

        eventService.saveEvent(eve1);

        verify(eventRepository, times(1)).save(any(Event.class));

    }

    @Test
    public void findTest() {
        Event eve1 = new Event(999, "Ozy", "House", "April", "12", "expert", "JumpRope", "Ozymandius");
        eventService.saveEvent(eve1);
        eventService.findEventByName("Ozy");

        verify(eventRepository, times(1)).findByName("Ozy");

    }

    @Test
    public void deleteTest() {
        Event eve1 = new Event(999, "Ozy", "House", "April", "12", "expert", "JumpRope", "Ozymandius");
        eventService.saveEvent(eve1);
        eventService.deleteEvent("Ozy");

        verify(eventRepository, times(1)).deleteByName("Ozy");
    }

    @Test
    public void updateTest() {
        Event eve2 = new Event(999, "Bob", "Park", "April", "12", "expert", "JumpRope", "Ozymandius");
        eventService.updateEvent(eve2);

        verify(eventRepository, times(1)).updateEvent("Bob","Park","April","12","expert", "JumpRope", 999);
    }
}
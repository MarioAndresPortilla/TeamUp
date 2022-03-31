package teamup.p2backend.Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import teamup.p2backend.model.Event;

import teamup.p2backend.repository.EventRepository;


//import teamup.p2backend.model.Sport;
import teamup.p2backend.repository.EventRepository;
//import teamup.p2backend.repository.SportRepository;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class EventRepositoryTest {


    /*Sport sp1;
    Sport sp2;

    Sport sp1;
    Sport sp2; */

    @Autowired
    private EventRepository eventRepository;

   /* @Autowired
    private SportRepository sportRepository;*/

    @BeforeEach
    void TestCase() {
        /*Sport sp1 = new Sport("Hockey");
        Sport sp2 = new Sport("BasketBall");
        sportRepository.save(sp1); */
        List<Event> eventList = Arrays.asList(
                new Event(999,"Ozy","House","date","12","expert","Hockey","Ozymandius"));
        eventRepository.saveAll(eventList);
    }

    @AfterEach
    public void remove(){
        eventRepository.deleteAll();
    }

    @Test
    void saveAll() {
        List<Event> eventList = Arrays.asList(

                new Event(998,"William","Park","date","12","expert","Hockey","noWill"),
                new Event(997,"Billiam","Gym","date","12","expert","Basketball","2Bill")
        );

        Iterable<Event> allEvent = eventRepository.saveAll(eventList);

        AtomicInteger validIdFound = new AtomicInteger();
        allEvent.forEach(event -> {
            if(event.getEvent_id()>0){
                validIdFound.getAndIncrement();
            }
        });
        assertThat(validIdFound.intValue()).isEqualTo(2);
    }

    @Test
    void findAll(){
        List<Event> allEvent = eventRepository.findAll();
        assertThat(allEvent.size()).isGreaterThanOrEqualTo(1);}

}



package teamup.p2backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import teamup.p2backend.model.Event;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface EventRepository extends JpaRepository<Event, Integer> {

    Event save(Event event);

    List<Event> findAll();

    Event findByName(String name);

    //works
    @Query(value= "Select * from event where event.sport=:sport", nativeQuery = true)
    Event findBySport(String sport);

    //works
    @Query(value = "Select * from event where event.place=:place", nativeQuery = true)
    Event findByPlace(String place);

    //works
    @Query(value = "Select * from event where event.level=:level", nativeQuery = true)
    Event findByLevel(String level);

    @Query(value = "Select * from event where event.username=:username", nativeQuery = true)
    Event findByUser(String username);

    //this is delete method
    @Modifying
    @Query(value = "delete from event where event.name=:name", nativeQuery = true)
    void deleteByName(String name);

    //this is an update(patch method)
    @Modifying
    @Query(value = "update event set event.name=:name, event.place=:place, event.date=:date, event.time=:time," +
            " event.level=:level, event.sport=:sport where event.event_id=:event_id", nativeQuery = true)
    void updateEvent(String name, String place, String date, String time, String level, String sport, int event_id);

}


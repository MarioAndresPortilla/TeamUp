//Discover page - it will lead to create and update. Main source of web API functionality
//buttons for create/update
//lists events
//search bar for events
//search by each variable?
// import { eventNumberContext } from "../../App";
import { useContext } from "react";
import EventList from "../page elements/EventList";
import loginContext from "../page elements/loginContext";
// import SearchBar from "../page elements/SearchBar"
export default function Discover() {
    const {user, setUser} = useContext(loginContext);
    // const [currentEventNumber] = useContext(eventNumberContext);
    return (
        <section class="general" id="discover">
        <div class="max-width">
            <div class="general-content">
            <div class="title">Discover</div>
            <div class="event-buttons">
            <button class="btn" id="create-button"><a href="/create">Create Event</a></button>
            {
                user !== "Guest" &&
            <span>
                    <button class="btn" id="update-button"><a href="/update">Update Event</a></button>
          </span>
            }
          <EventList />
          <div>
          </div>
          <span>
              {/* <SearchBar /> */}
          </span>
          </div>   
                </div>
        </div>
    </section> 
    );
  }
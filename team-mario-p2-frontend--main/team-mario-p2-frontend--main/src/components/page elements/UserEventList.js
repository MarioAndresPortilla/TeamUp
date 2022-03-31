//specifically for update page with update/delete mappings
//returns what events are created by the user
//backlog of functionality, should take from eventlist mapping js file, but not work for guest
import axios from "axios";
import React from "react";
import { useContext } from "react";
import { eventContext, eventNumberContext } from "../../App";
import { useEffect } from "react";
import loginContext from "./loginContext";
export default class EventList extends React.Component {
    constructor(props) {
        super(props);
        this.state= {
            'type': "Event",
            'username': "",
            'name': "",
            'sport': "",
            'level': "",
            'date': "",
            'time': "",
            'place': "",
            eventList: []
        }
    }
    static contextType = loginContext;
    DeleteEventButton(){
        /* if(currentEventNumber > 0) */ {
            let url = "http://localhost:9000/event/" + this.eventName; 
            axios.delete(url).then(
                    response => { 
                        alert("Event Deleted!")
                        // setEventNumber(currentEventNumber-1);
                    }
                )
            }
    }
    generateUserEvents(){
        let url = 'http://localhost:9000/event/username/' + this.context.user
        axios.get(url).then(
            response => { 
                let userEvents = response.data;
                this.setState({eventList: userEvents});
            }
        )
    }
    render() {
        return (
            <>                  
            <span><button class="btn" id="find-button" onClick={() => this.generateUserEvents()}>Find Events</button></span>
            <div>
            <ul class="eventwrapper">
            {
                this.state.eventList.map(eventList =>  
                 <div class = "eventlisting">
                    <ul class="eventinfo">
                    <li key={eventList.name}>Event: {eventList.name}</li>
                    <li key={eventList.username}>Host: {eventList.username}</li>
                    <li key={eventList.sport}>Sport: {eventList.sport}</li>
                    <li key={eventList.level}>Skill level: {eventList.level}</li>
                    <li key={eventList.date}>Date: {eventList.date}</li>
                    <li key={eventList.time}>Time: {eventList.time}</li>
                    <li key={eventList.place}>Location: {eventList.place}</li>
                    </ul>
                    <ul class="modifyeventbuttons">
                        <li><button class="btn" id="update-button"><a href="/updateEvent">Update Event</a></button></li>
                        <li><button class="btn" id="delete-event-button" onClick={() => this.DeleteEventButton()}>Delete Event</button></li>    
                        </ul>
                    <img class="event-image" alt="A bunch of balls from various sports." src = "data:image/jpeg;base64,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" />
                                        </div>)
            }
            </ul>
        </div>
        </>
    )
   }
}
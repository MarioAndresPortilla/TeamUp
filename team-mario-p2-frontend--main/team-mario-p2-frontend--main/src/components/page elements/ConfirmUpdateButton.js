import * as React from 'react';
import axios from 'axios';
//ADD SPECIFIC ID FUNCTIONALITY TO BUTTON THAT LEADS HERE
//Updates events via put mapping
export default function ConfirmUpdateButton() {
    function updateEvent() {
        const updatedEvent =
        {
            'name': document.getElementById("posteventnamefield").value,
            'sport': document.getElementById("postsportfield").value,
            'date': document.getElementById("postdatefield").value,
            'place': document.getElementById("postlocationfield").value,
            'time': document.getElementById("posttimefield").value,
            'level': document.getElementById("postskilllevelfield").value
        };
        axios.put("http://localhost:9000/event" /*ADD URL TO SPECIFIC EVENT */, updatedEvent);
        alert("Event updated!");
    }
    return (
<div class="btn" onClick={() => updateEvent()}>Update Event</div>
    )    
}
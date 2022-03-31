//Update page. Part of core web API functionality
//Lists current events by the user
import React from "react";
import UserEventList from "../page elements/UserEventList";
export default function Update() {
        return (
            <section class="general" id="discover">
            <div class="max-width">
                <div class="general-content">
                <div class="title">Update</div>
             <UserEventList />
            </div>
        </div>
    </section> 
    );
  }
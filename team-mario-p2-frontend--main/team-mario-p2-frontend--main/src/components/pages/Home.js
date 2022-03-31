import React from 'react';
import loginContext from '../page elements/loginContext';
import { useContext, useState } from 'react';
//Home Page
//Dynamically updates with a welcome message if signed in
export default function Home() {
    const {user, setUser} = useContext(loginContext);
    if (user == "Guest" )
        {
            return (
            <section class="home" id="home">  
            <div class="max-width">
            <div class="home-content">
                <div class="text-1">Welcome to</div>
                <div class="text-2">Team<span>Up</span></div>
                <div class="text-3">A sport application...</div>
                <a href="/about">Learn More</a>
            </div>
        </div>
        </section>
            )
        }
        else if (user !== "Guest" )
        {
            return (
            <section class="loggedhome" id="loggedhome">  
            <div class="max-width">
            <div class="home-content">
                <div class="text-1">Welcome to</div>
                <div class="text-2">Team<span>Up</span></div>
                <div class="text-3">A sport application...</div>
                <a href="/about">Learn More</a>
            </div>
        </div>
             <div class="profile">Hello<span>&nbsp;{user}</span>!</div>
            </section>
            )
        }
    }
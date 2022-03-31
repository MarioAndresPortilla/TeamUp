import React from "react";
import loginContext from "./loginContext";
import { useContext, useState } from "react";
export default function Navbar() {
const {user, setUser} = useContext(loginContext);

//sets the user as guest
function SignOut() {
    setUser("Guest");
}    
//checks which navbar to show, signed in or signed out
if (user == "Guest")
        {
    return (
<nav class="navbar">
<div class="max-width">
    <div class="logo"><a href="/">Team<span>Up</span></a></div>
    <ul class="menu">
        <li><a href ="/login" class="menu-btn">Log In</a></li>
        <li><a href ="/signup" class="menu-btn">Sign Up</a></li>
        <li><a href ="/discover" class="menu-btn">Discover</a></li>
    </ul>
    <div class="menu-btn">
        <i class="fas fa-bars"></i>
    </div>
</div>
</nav>
)
    }
    else if (user !== "Guest" )
        {
            //debugging purposes
            console.log(user + "not guest");
            return (
                <nav class="navbar">
                <div class="max-width">
                    <div class="logo"><a href="/">Team<span>Up</span></a></div>
                    <ul class="menu">
                        <li class="menu-btn">{user}</li>
                        <li onClick={() => SignOut()}><a href="/" class="menu-btn">Sign Out</a></li>
                        <li><a href ="/discover" class="menu-btn">Discover</a></li>
                    </ul>
                    <div class="menu-btn">
                        <i class="fas fa-bars"></i>
                    </div>
                </div>
                </nav>
            )
        } 
}
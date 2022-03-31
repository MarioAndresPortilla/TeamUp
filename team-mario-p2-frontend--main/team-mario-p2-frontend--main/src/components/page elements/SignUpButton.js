import * as React from 'react';
import axios from 'axios';
//Adds a new user in the user table
//change to vm
export default function SignUpButton() {
    function signUp() {
        //if statement checks if passwords match
        if(document.getElementById("passwordfield").value === document.getElementById("confirmpasswordfield").value)
        {
            //takes all the data from the sign up form and posts it to the database;
            const newUser =
        {
            'fullname1': document.getElementById("fullnamefield").value,
            'email1': document.getElementById("emailfield").value,
            'username1': document.getElementById("usernamefield").value,
            'password1': document.getElementById("passwordfield").value, 
        };
        axios.post("http://localhost:9000/user1", newUser);
        alert("Welcome to TeamUp!");
        }
        else{
            alert("Your passwords do not match.")
        }
    }
    return (
        <div class="btn" onClick={() => signUp()}>Sign Up</div>
    )    
}
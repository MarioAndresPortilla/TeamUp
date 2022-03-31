// Login Page
import React from "react";
import { useContext } from "react";
import { AllLoginsContext } from "../../App";
import { useRef } from "react";
import { useEffect } from "react";
import { useState } from "react";
import loginContext from "../page elements/loginContext";
export default function Login() {
    const usernameInput = useRef();
    const passwordInput = useRef();
    const {user, setUser} = useContext(loginContext);
    const ContextLogins = useContext(AllLoginsContext);
    const [AllLogins, setLogins] = useState();
    
//sets all logins
    useEffect(() => {
    setLogins(ContextLogins);
    }, [ContextLogins])

    //function to log in when you press the button
    function LoginButton(e)
    {
        //full login goes through or not at all
        e.preventDefault();
        let inputtedUser = usernameInput.current.value;
        let inputtedPassword = passwordInput.current.value;
        let match = AllLogins.filter(user => user.username1 == inputtedUser);
        if (match.length === 0)
        {
            //checks if there's a user with the inputted username
            alert("Incorrect username or password");
        }
        else if (match[0].password1 !== inputtedPassword)
        {
            //checks if your password matches with the user's password in the database
            alert("Incorrect username or password");
        }
        else if (match[0].password1 == inputtedPassword)
        {
            setUser(match[0].username1);
            alert("Welcome back to TeamUp!")
            //login user
            // provide functionality to events
            // set the home page display to the user
            // change the navbar to user, 'sign out', 'discover'
        }
    }
        return (
        <section className="general" id="login">
            <div className="wrapper login" id="wrapper">
                <div className="container">
                    <div className="tabs">
                        <ul>
                            <li className="sign_in_li">Sign in</li>
                        </ul>
                    </div>
                    <div className="input_field">
                        <input  className="input" placeholder="username" type="text" id="name" ref={usernameInput}/>
                    </div>
                    <div className="input_field">
                        <input className="input" placeholder="password" type="Password" id="loginpassword" ref={passwordInput} />
                    </div>
                    <div class="btn" onClick={(e) => LoginButton(e)}>Log In</div>
                    <li><a href="/signup" className="next-page">Not a user? Sign Up</a></li>
                </div>
            </div>
        </section>
    )
    }

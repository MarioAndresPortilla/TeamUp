import './index.css';
import { useState } from 'react';
import { createContext } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Navbar from './components/page elements/Navbar';
import Home from './components/pages/Home';
import SignUp from './components/pages/Sign Up';
import Create from './components/pages/Create';
import Discover from './components/pages/Discover';
import Update from './components/pages/Update';
import About from './components/pages/About';
import UpdateEvent from './components/pages/UpdateEvent';
import { Footer } from './components/page elements/Footer';
import Login from './components/pages/Login';
import loginContext from './components/page elements/loginContext';

export const AllLoginsContext = createContext();
export const eventNumberContext = createContext();
export const eventContext = createContext();
export default function App() {
  const [AllLogins, setLogins] = useState()
  const [currentUser, setCurrentUser] = useState("Guest");
  // const [currentEventNumber, setEventNumber] = useState();
  const [eventList, setEventList] = useState();
  //grabs all logins from the database
  useEffect(() => {
    getAllLogins()
    }, [])
    //grabs all events from the database
    useEffect(() => {
      generateEvents()
    }, [])
   function getAllLogins(){
     axios.get('http://localhost:9000/user1/')
     .then(response => {
       let returnedUsers = response.data;
       setLogins(returnedUsers);
     })
   }
  function generateEvents(){
    axios.get('http://localhost:9000/event/')
    .then(response => { 
          let userEvents = response.data;
          setEventList(userEvents);
        }
    )
   }
  return (
    <>
    {/* provides context and routing for all the pages in the application */}
      <eventContext.Provider value = {eventList}>
      <AllLoginsContext.Provider value = {AllLogins}>
      <loginContext.Provider value ={{user: currentUser, setUser: setCurrentUser}}>
      {/* <eventNumberContext.Provider value ={[0, setEventNumber]}> */}
    <BrowserRouter>
    <Navbar />
       <Routes>
       <Route path="/" element={<Home />} />
       <Route path="login" element={<Login />} />
       <Route path="signup" element={<SignUp />} />
       <Route path="create" element={<Create />} />
       <Route path="discover" element={<Discover />} />
       <Route path="update" element={<Update />} />
       <Route path="about" element={<About />} />
       <Route path="UpdateEvent" element={<UpdateEvent />} />
     </Routes>
     <Footer />
   </BrowserRouter>
    {/* </eventNumberContext.Provider> */}
    </loginContext.Provider>
    </AllLoginsContext.Provider>
    </eventContext.Provider>
    </>
  );
}


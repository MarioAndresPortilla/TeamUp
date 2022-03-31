import { createContext } from "react";
//used to create a user context for the entire site
const loginContext = createContext({
  currentUser: "Guest",
  setCurrentUser: (currentUser) => {}
});

export default loginContext;

import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Users from "./Users.js";
import UpdateUser from "./UpdateUser.js";
import AddUser from "./AddUser.js";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Users />} />
        <Route path="/UpdateUser" element={<UpdateUser />} />
        <Route path="/AddUser" element={<AddUser />} />
      </Routes>
    </Router>
  );
}

export default App;

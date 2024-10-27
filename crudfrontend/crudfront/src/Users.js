import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import './Users.css'; // Import the CSS file

function Users() {
  const [userData, setUserData] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get("http://localhost:2609/api/");
        setUserData(response.data);
      } catch (error) {
        console.error("Error while fetching user data: ", error);
      }
    };

    fetchData();
  }, []);

  const updateBtnFunction = (user) => {
    return () => {
      navigate("./UpdateUser", { state: { user } }); // Pass the individual user data
    };
  };

  const deleteBtnFunction = (user) => {
    return async () => {
      const id = user.id;
      try {
        await axios.delete(`http://localhost:2609/api/delete/${id}`);
        setUserData(userData.filter((u) => u.id !== id)); // Update the state to reflect deletion
      } catch (error) {
        console.log("Error while deleting user", error);
      }
    };
  };

  const addUserClicked = () => {
    navigate("./AddUser"); // Navigate to AddUser
  };

  return (
    <div className="container">
      <h2>User List</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Contact</th>
            <th>City</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {userData.length > 0 ? (
            userData.map((user) => (
              <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.firstName}</td>
                <td>{user.lastName}</td>
                <td>{user.emailId}</td>
                <td>{user.contact}</td>
                <td>{user.city}</td>
                <td className="action-buttons">
                  <button onClick={updateBtnFunction(user)}>Update</button>
                  <button onClick={deleteBtnFunction(user)}>Delete</button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="7">No users found</td>
            </tr>
          )}
        </tbody>
      </table>
      <button className="add-user-button" onClick={addUserClicked}>Add User</button>
    </div>
  );
}

export default Users;

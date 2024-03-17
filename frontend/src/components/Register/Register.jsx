import { useState } from "react";
import axios from "axios";

function Register() {
  
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");


    async function save(event) {
        event.preventDefault();
        try {
          await axios.post("http://localhost:8080/register", {
          username: username,
          email: email,
          password: password,
          });
          alert("User Registation Successfully");

        } catch (err) {
          alert(err);
        }
      }
  
    return (
    <div>
    <div className="container mt-4" >
    <div className="card">
            <h1>USer Registation</h1>
    
    <form>
        <div className="form-group">
          <label>Employee name</label>
          <input type="text"  className="form-control" id="username" placeholder="Enter Name"
          
          value={username}
          onChange={(event) => {
            setUsername(event.target.value);
          }}
          />

        </div>

        <div className="form-group">
          <label>email</label>
          <input type="email"  className="form-control" id="email" placeholder="Enter Email"
          
          value={email}
          onChange={(event) => {
            setEmail(event.target.value);
          }}
          
          />
 
        </div>

        <div className="form-group">
            <label>password</label>
            <input type="password"  className="form-control" id="password" placeholder="Enter password"
            
            value={password}
            onChange={(event) => {
              setPassword(event.target.value);
            }}
            
            />
          </div>

        <button type="submit" className="btn btn-primary mt-4" onClick={save} >Save</button>
       
      </form>
    </div>
    </div>
     </div>
    );
  }
  
  export default Register;

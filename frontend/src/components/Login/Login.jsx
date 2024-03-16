import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";

function Login() {
   
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    
    async function login(event) {
        event.preventDefault();
        try {
            const response = await axios.post("http://localhost:8080/login", {
                email: email,
                password: password,
            });
            
            console.log(response.data);
            
            if (response.data.message === "Email not exist") {
                alert("Email not exits");
            } else if(response.data.message === "Login success") { 
                navigate('/home');
            } else { 
                alert("Incorrect Email and Password not match");
            }
        } catch (err) {
            console.error(err); // Log the error
            alert("An error occurred during login. Please try again."); // Display an error message to the user
        }
    }
    
    return (
        <div>
            <div className="container">
                <div className="row">
                    <h2>Login</h2>
                    <hr />
                </div>
                <div className="row">
                    <div className="col-sm-6">
                        <form>
                            <div className="form-group">
                                <label>Email</label>
                                <input
                                    type="email"
                                    className="form-control"
                                    id="email"
                                    placeholder="Enter Name"
                                    value={email}
                                    onChange={(event) => {
                                        setEmail(event.target.value);
                                    }}
                                />
                            </div>
                            <div className="form-group">
                                <label>Password</label>
                                <input
                                    type="password"
                                    className="form-control"
                                    id="password"
                                    placeholder="Enter Password"
                                    value={password}
                                    onChange={(event) => {
                                        setPassword(event.target.value);
                                    }}
                                />
                            </div>
                            <button
                                type="submit"
                                className="btn btn-primary"
                                onClick={login}
                            >
                                Login
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;

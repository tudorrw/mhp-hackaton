import { useState } from "react";
import axios from "axios";
import { Container, Typography, TextField, Button, Box } from "@mui/material";


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

        <Container maxWidth="sm" sx={{ mt: 4 }}>
            <Typography variant="h4" gutterBottom>
                User Registration
            </Typography>

            <Box component="form" onSubmit={save} noValidate sx={{ mt: 1 }}>
                <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="username"
                    label="Employee Name"
                    name="username"
                    autoComplete="username"
                    autoFocus
                    value={username}
                    onChange={(event) => setUsername(event.target.value)}
                />

                <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="email"
                    label="Email Address"
                    name="email"
                    autoComplete="email"
                    value={email}
                    onChange={(event) => setEmail(event.target.value)}
                />

                <TextField
                    margin="normal"
                    required
                    fullWidth
                    name="password"
                    label="Password"
                    type="password"
                    id="password"
                    autoComplete="current-password"
                    value={password}
                    onChange={(event) => setPassword(event.target.value)}
                />

                <Button
                    type="submit"
                    fullWidth
                    variant="contained"
                    sx={{ mt: 3, mb: 2 }}
                >
                    Register
                </Button>
            </Box>
        </Container>
    );
  }
  
  export default Register;
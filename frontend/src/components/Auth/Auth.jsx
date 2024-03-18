import React from "react";
import { Link } from "react-router-dom";
import { Container, Typography, Button, Box } from "@mui/material";

export default function Home() {
    return (
        <Container maxWidth="md" style={{ height: '100vh', display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center' }}>
            <Typography variant="h2" component="h1" gutterBottom align="center">
                Welcome to Masa mea!
            </Typography>
            <Box mt={4} style={{ textAlign: 'center' }}>

                <Button component={Link} to="/login" variant="outlined" color="primary" style={{ marginRight: '20px' }}>
                    Login
                </Button>
                <Button component={Link} to="/register" variant="contained" color="success">
                    Register
                </Button>
            </Box>
        </Container>
    );
}
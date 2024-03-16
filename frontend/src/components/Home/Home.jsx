import React, {useEffect, useState} from 'react'
import {ReactComponent as ReactLogo} from './logo.svg';
import { ReactComponent as FloorPlanSVG } from './mhp_floor_final.svg';
import Typography from "@mui/material/Typography";
import {AppBar, Card, CardActionArea, CardContent, CardMedia, Popover, Toolbar} from "@mui/material";
import {useNavigate} from "react-router-dom";
import Button from "@mui/material/Button";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";



function Home() {
    const [anchorEl, setAnchorEl] = useState(null);
    const [selectedDesk, setSelectedDesk] = useState('');
    // Define a click handler for buttons
    const handleButtonClick = (event, buttonId) => {
        setAnchorEl(event.currentTarget);
        setSelectedDesk(buttonId);
        console.log(`Button ${buttonId} was clicked.`);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    const open = Boolean(anchorEl);
    const id = open ? 'simple-popover' : undefined;


    useEffect(() => {
        const buttonIds = Array.from({ length: 140 }, (_, i) => `Desk ${i + 1}`);
        buttonIds.forEach((buttonId) => {
            const buttonElement = document.getElementById(buttonId);
            if (buttonElement) {
                buttonElement.addEventListener('click', (event) => handleButtonClick(event, buttonId));
            }
        });

        // Cleanup function to remove event listeners
        return () => {
            buttonIds.forEach(buttonId => {
                const buttonElement = document.getElementById(buttonId);
                if (buttonElement) {
                    buttonElement.removeEventListener('click', handleButtonClick);
                }
            });
        };
    }, []); // The empty array ensures this effect runs only once after initial render

    return (
        <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', height: '100vh' }}>
            <Typography variant="h4" component="h1" gutterBottom>
                Desk Managing System
            </Typography>
            <FloorPlanSVG style={{ maxWidth: '100%', height: 'auto' }} />
            <Popover
                id={id}
                open={open}
                anchorEl={anchorEl}
                onClose={handleClose}
                anchorOrigin={{
                    vertical: 'bottom',
                    horizontal: 'left',
                }}
            >
                <Typography sx={{ p: 2 }}>Selected Desk: {selectedDesk}</Typography>
                <Button onClick={handleClose}>Close</Button>
            </Popover>
        </Box>
    );
}


export default Home

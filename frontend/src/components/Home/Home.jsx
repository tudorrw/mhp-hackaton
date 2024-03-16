import React, { useEffect, useState } from 'react';
import { ReactComponent as FloorPlanSVG } from './mhp_floor_final.svg';
import Typography from "@mui/material/Typography";
import { Popover, Button, Box } from "@mui/material";
import { LocalizationProvider } from '@mui/x-date-pickers';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs'
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import dayjs from "dayjs";
import TextField from "@mui/material/TextField";

function Home() {
    const [anchorEl, setAnchorEl] = useState(null);
    const [selectedDesk, setSelectedDesk] = useState('');
    const userId = 'placeholderUserId'; // Placeholder for user ID
    const [selectedDate, setSelectedDate] = useState(dayjs());

    const handleButtonClick = (event, buttonId) => {
        setAnchorEl(event.currentTarget);
        setSelectedDesk(buttonId);
        console.log(`Button ${buttonId} was clicked.`);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    const handleReserveClick = () => {
        console.log(`Reserving Desk: ${selectedDesk} for User ID: ${userId} on Date: ${selectedDate.format("YYYY-MM-DD")}`);
        // Here you could also call a function to send reservation data to your backend
        handleClose(); // Close the popover after clicking reserve
    };

    const open = Boolean(anchorEl);
    const id = open ? 'simple-popover' : undefined;

    useEffect(() => {
        const itemIds = [
            ...Array.from({ length: 140 }, (_, i) => `Desk ${i + 1}`),
            "Pit-Lane", "Quick 8", "Dry-Lane", "Joker Lap", "Pole Position", "Cockpit"
        ];

        itemIds.forEach((itemId) => {
            const itemElement = document.getElementById(itemId);
            if (itemElement) {
                itemElement.addEventListener('click', (event) => handleButtonClick(event, itemId));
            }
        });

        return () => {
            itemIds.forEach(itemId => {
                const itemElement = document.getElementById(itemId);
                if (itemElement) {
                    itemElement.removeEventListener('click', handleButtonClick);
                }
            });
        };
    }, []);

    return (
        <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', height: '100vh' }}>
            <Typography variant="h4" component="h1" gutterBottom>
                Desk Managing System
            </Typography>

            <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DatePicker
                    label="Select Reservation Date"
                    value={selectedDate}
                    minDate={dayjs()}
                    onChange={(newValue) => {
                        setSelectedDate(newValue);
                    }}
                    renderInput={(params) => <TextField {...params} />}
                />
            </LocalizationProvider>

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
                <Box sx={{ p: 2 }}>
                    <Typography>Selected Desk: {selectedDesk}</Typography>
                    <Button onClick={handleClose} sx={{ mt: 1 }}>Close</Button>
                    <Button onClick={handleReserveClick} color="primary" variant="contained" sx={{ mt: 1, ml: 1 }}>
                        Reserve
                    </Button>
                </Box>
            </Popover>
        </Box>
    );
}

export default Home;

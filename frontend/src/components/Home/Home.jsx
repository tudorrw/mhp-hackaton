import React, { useEffect, useState } from 'react';
import { ReactComponent as FloorPlanSVG } from './mhp_floor_final.svg';
import Typography from "@mui/material/Typography";
import { Popover, Button, Box } from "@mui/material";
import { LocalizationProvider } from '@mui/x-date-pickers';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs'
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import dayjs from "dayjs";
import TextField from "@mui/material/TextField";
import axios from 'axios';

function Home() {
    const [anchorEl, setAnchorEl] = useState(null);
    const [selectedDesk, setSelectedDesk] = useState(null);
    const userId = 11; // Placeholder for user ID
    const [selectedDate, setSelectedDate] = useState(dayjs());
    const [reservedDesks, setReservedDesks] = useState([]);

    const handleButtonClick = (event, buttonId) => {
        setAnchorEl(event.currentTarget);
        setSelectedDesk(parseInt(buttonId));
        console.log(`Button ${buttonId} was clicked.`);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    const handleReserveClick = async () => {
        try {
            const response = await axios.post("http://localhost:8080/booking", {
                userId: userId,
                deskId: selectedDesk,
                date: selectedDate.format("YYYY-MM-DD"),
            });
            // Add the reserved desk to the list
            setReservedDesks(prevDesks => [...prevDesks, selectedDesk]);
            console.log(response);
            if(response.data.message === "Desk booked successfully.") {
              alert("Desk booked successfully.");
            } else if(response.data.message === "Desk is not available for booking at the specified date and time.") {
              alert("Desk is not available for booking at the specified date and time.");
            } else {
              alert("User already has a booking at the specified date and time.");
            }
        } catch (error) {
            console.error("Error booking desk:", error);
        }
        console.log(`Reserving Desk: ${selectedDesk} for User ID: ${userId} on Date: ${selectedDate.format("YYYY-MM-DD")}`);
        handleClose(); // Close the popover after clicking reserve
    };

    const open = Boolean(anchorEl);
    const id = open ? 'simple-popover' : undefined;


    useEffect(() => {
      // Ensure selectedDate is not null or undefined before fetching reserved desks
      if (selectedDate) {
          // Fetch reserved desks for the selected date
          const fetchReservedDesks = async () => {
              try {
                  const response = await axios.get(`http://localhost:8080/booking/${selectedDate.format("YYYY-MM-DD")}`);
                  // Update the reserved desks state
                  setReservedDesks(response.data, reservedDesks);
              } catch (error) {
                  console.error("Error fetching reserved desks:", error);
              }
          };
  
          // Call the fetchReservedDesks function
          fetchReservedDesks();
      }
  }, [selectedDate]); // Add selectedDate as a dependency to rerun the effect whenever it changes
  

    useEffect(() => {
        const itemIds = [
            ...Array.from({ length: 140 }, (_, i) => `${i + 1}`),
            "Pit-Lane", "Quick 8", "Dry-Lane", "Joker Lap", "Pole Position", "Cockpit"
        ];

        const reservedDeskIds = reservedDesks.map(reservedDesk => reservedDesk.deskId);

        itemIds.forEach((itemId) => {
            const itemElement = document.getElementById(itemId);
            if (itemElement) {
                itemElement.addEventListener('click', (event) => handleButtonClick(event, itemId));
                itemElement.setAttribute('fill', reservedDeskIds.includes(parseInt(itemId)) ? "#CF1325" : "#B6CE72");
                console.log(reservedDesks);
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
    }, [reservedDesks]);

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
            <FloorPlanSVG style={{ maxWidth: '100%', height: 'auto' }}/>

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

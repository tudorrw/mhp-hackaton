import React from 'react';
import { Route, Routes } from 'react-router-dom';

import Login from './components/Login/Login';
import Home from './components/Home/Home';
import Auth from "./components/Auth/Auth";
import Register from "./components/Register/Register"

// import {Routes} from "react-router";

function App() {
  return (
      <div className="wrapper">
        {/*<h1>Application</h1>*/}
          <Routes>
              <Route path="/" element={<Auth />} />
              <Route path="/login" element={<Login />} />
              <Route path="/register" element={<Register />} />
              <Route path="/booking" element={<Home />} />

          </Routes>
      </div>
  );
}

export default App;
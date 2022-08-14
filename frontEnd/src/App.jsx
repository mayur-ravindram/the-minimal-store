import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddProduct from "./components/AddProduct";
import Checkout from "./components/checkout";
import Home from "./components/home";
import Login from "./components/login";
import ProductDescription from "./components/productDescription";
import ProductList from "./components/ProductList";
import Registration from "./components/registration";

function App() {
    return (
        <Router>
            {/* Routes to different pages */}
            <Routes>
                <Route exact path="/home" element={<Home />}></Route>
                <Route exact path="/add" element={<AddProduct />}></Route>
                <Route exact path="/example" element={<ProductList />}></Route>
                <Route path="/" element={<Login />}></Route>
                <Route path="/register" element={<Registration />}></Route>
                <Route
                    path="/product/:id"
                    element={<ProductDescription />}
                />{" "}
                <Route path="/checkout" element={<Checkout />} />
            </Routes>
        </Router>
    );
}

export default App;
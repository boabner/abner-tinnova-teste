import React from "react";
import Veiculo from "./components/VeiculoApp";
import Menu from "./components/Menu";
import './App.css'

export default (props) => {
    return (
        <div className="App">
            <Menu />
            <Veiculo/>
        </div>
    );
}
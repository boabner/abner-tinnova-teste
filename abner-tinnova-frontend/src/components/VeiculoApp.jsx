import React from "react";
import ListVeiculosComponent from "./ListVeiculosComponent";
import VeiculoComponent from "./VeiculoComponent";

import { BrowserRouter as Router } from 'react-router-dom';
import {Route, Switch} from 'react-router-dom';
import ListVeiculosNaoVendidosComponent from "./ListVeiculosNaoVendidosComponent";

export default (props) => {
    return (
        <>
            <h3>Tinnova Veículos</h3>
            <Router>
                <>
                    <Switch>
                        <Route path="/" exact component={ListVeiculosComponent} />
                        <Route path="/veiculos" exact component={ListVeiculosComponent} />
                        <Route path="/veiculos/create" exact component={VeiculoComponent} />
                        <Route path="/veiculos/naovendidos" exact component={ListVeiculosNaoVendidosComponent} />
                        <Route path="/veiculos/porano" exact component={ListVeiculosNaoVendidosComponent} />
                        <Route path="/veiculos/:id" exact component={VeiculoComponent} />
                    </Switch>
                </>
            </Router>
        </>
    )
}
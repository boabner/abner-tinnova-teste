import React, { Component }from "react";
import Message from "./Message";
import SchoolDataService from "../service/VeiculoDataService";
import ListVeiculosBodyComponent from "./ListVeiculosBodyComponent";
import ListVeiculosBaseComponent from "./ListVeiculosBaseComponent";

class ListVeiculosNaoVendidosComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            veiculos: [],
            message: null
        }
        this.refreshVeiculosNaoVendidos = this.refreshVeiculosNaoVendidos.bind(this)
    }

    componentDidMount() {
        this.refreshVeiculosNaoVendidos();
    }

    refreshVeiculosNaoVendidos() {
        SchoolDataService.retrieveVeiculosNaoVendidos()
            .then(
                response => {
                    console.log(response.data)
                    this.setState({veiculos: response.data})
                }
            )
    }

    render() {
        return (
            <>
                <div className="container">
                    <h3>Veículos não vendidos</h3>
                    <Message/>
                    <div className="container">
                        <ListVeiculosBodyComponent veiculos={this.state.veiculos}  disabled={true}  />
                    </div>
                </div>
            </>
        )
    }
}
export default ListVeiculosNaoVendidosComponent

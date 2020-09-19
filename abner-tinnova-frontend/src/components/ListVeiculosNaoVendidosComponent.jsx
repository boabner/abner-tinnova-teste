import React, { Component }from "react";
import Message from "./Message";
import ListVeiculosBaseComponent from "./ListVeiculosBaseComponent";

class ListVeiculosNaoVendidosComponent extends Component {



    render() {
        return (
            <>
                <div className="container">
                    <h3>Veículos não vendidos</h3>
                    <Message/>
                    <div className="container">
                        <table className="table">
                            <thead className="thead-dark">
                            <tr>
                                <th>Id</th>
                                <th>Descrição</th>
                                <th>Marca</th>
                                <th>Ano</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.veiculos.map(
                                    veiculo =>
                                        <tr key={veiculo.id}>
                                            <td>{veiculo.id}</td>
                                            <td>{veiculo.descricao}</td>
                                            <td>{veiculo.marca}</td>
                                            <td>{veiculo.ano}</td>
                                        </tr>
                                )
                            }
                            </tbody>
                        </table>
                    </div>
                </div>
            </>
        )
    }
}
export default ListVeiculosNaoVendidosComponent

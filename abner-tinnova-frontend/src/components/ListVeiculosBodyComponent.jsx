import React, { Component } from "react";

class ListVeiculosBodyComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            veiculos: props.veiculos,
            message: null
        }
    }

    render() {
        return (
            <>
                <table className="table">
                    <thead className="thead-dark">
                    <tr>
                        <th>Id</th>
                        <th>Descrição</th>
                        <th>Ações</th>
                        <th>Marca</th>
                        <th>Ano</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.props.veiculos.map(
                            veiculo =>
                                <tr key={veiculo.id}>
                                    <td>{veiculo.id}</td>
                                    <td>{veiculo.descricao}</td>
                                    <td>{veiculo.marca}</td>
                                    <td>{veiculo.ano}</td>
                                    <td>
                                        <button className="btn btn-primary" disabled={this.props.disabled}
                                                onClick={() => this.updateVeiculoClicked(veiculo.id)}>Update
                                        </button>
                                        <button className="btn btn-danger"  disabled={this.props.disabled}
                                                onClick={() => this.deleteVeiculoClicked(veiculo.id)}>Delete
                                        </button>
                                    </td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </>
        )
    }
}
export default ListVeiculosBodyComponent
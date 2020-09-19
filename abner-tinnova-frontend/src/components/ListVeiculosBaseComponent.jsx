import React, {Component} from "react";
import SchoolDataService from "../service/VeiculoDataService";
import ListVeiculosBodyComponent from "./ListVeiculosBodyComponent";

class ListVeiculosBaseComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            veiculos: [],
            message: null
        }
        this.deleteVeiculoClicked = this.deleteVeiculoClicked.bind(this)
        this.updateVeiculoClicked = this.updateVeiculoClicked.bind(this)
        this.addVeiculoClicked = this.addVeiculoClicked.bind(this)
        this.refreshVeiculos = this.refreshVeiculos.bind(this)
        this.getNaoVendidosClicked = this.getNaoVendidosClicked.bind(this)
    }

    componentDidMount() {
        this.refreshVeiculos();
    }

    refreshVeiculos() {
        SchoolDataService.retrieveAllVeiculos()
            .then(
                response => {
                    this.setState({veiculos: response.data})
                }
            )
    }

    getNaoVendidosClicked() {
        this.props.history.push(`/veiculos/naovendidos`)
    }

    addVeiculoClicked() {
        this.props.history.push(`/veiculos/create`)
    }

    updateVeiculoClicked(id) {
        this.props.history.push(`/veiculos/${id}`)
    }

    deleteVeiculoClicked(id) {
        SchoolDataService.deleteVeiculo(id)
        .then(
            response => {
                this.setState({ message: `Veículo ${id} removido com sucesso.` })
                this.refreshVeiculos()
            }
        )
    }

    render() {
        return (
            <>
                <div className="row">
                    <button className="btn btn-success" onClick={this.addVeiculoClicked}>
                        Adicionar Veículo
                    </button>
                    <button className="btn btn-primary" onClick={this.getNaoVendidosClicked}>
                        Listar não vendidos
                    </button>
                </div>
                <br/>
                <ListVeiculosBodyComponent veiculos={this.state.veiculos} />
            </>
        )
    }
}
export default  ListVeiculosBaseComponent;
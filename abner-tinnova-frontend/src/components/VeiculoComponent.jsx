import React, { Component } from "react";
import { Formik, Form, Field } from 'formik';
import "react-datepicker/dist/react-datepicker.css";
import SchoolDataService from "../service/VeiculoDataService";
import Message from "./Message";

class VeiculoComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            descricao: '',
            ano: 0,
            vendido: "true",
            marca: '',
            created: '',
            updated: ''
        }
        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
    }

    componentDidMount() {
        console.log(this.state.id)
        SchoolDataService.retrieveVeiculo(this.state.id)
            .then(response =>
                this.setState({
                    id: response.data.id,
                    descricao: response.data.descricao,
                    ano: response.data.ano,
                    vendido: response.data.vendido,
                    marca: response.data.marca,
                    created: response.data.created,
                    updated: response.data.updated
                })
            )
    }

    validate(values) {
        let errors = {}
        if (!values.descricao) {
            errors.descricao = 'Informe a descrição do veículo.'
        } else if (values.descricao.length < 5) {
            errors.descricao = 'Min. 5 characters in the name'
        }
        return errors
    }

    onSubmit(values) {
        console.log(this.state.id)
        let veiculo = values.id > 0 ?
            {
                id: this.state.id,
                descricao: values.descricao,
                ano: values.ano,
                vendido: values.vendido,
                marca: values.marca,
            } :
            {
                descricao: values.descricao,
                ano: values.ano,
                vendido: values.vendido,
                marca: values.marca,
            }
        if (values.id > 0) {
            SchoolDataService.updateVeiculo(this.state.id, veiculo)
                .then(() => this.props.history.push('/veiculos'))
        }
        else {
            SchoolDataService.createVeiculo(veiculo)
                .then(() => this.props.history.push('/veiculos'))
        }
        console.log(veiculo);
    }

    render() {
        let { id, descricao, ano, vendido, marca, created, updated} = this.state
        return(
            <>
                <h1>Informações do veículo</h1>
                <div>
                    <div className="container">
                        <Formik
                            initialValues={{ id, descricao, ano, vendido, marca, created, updated}}
                            onSubmit={this.onSubmit}
                            validateOnChange={false}
                            validateOnBlur={false}
                            validate={this.validate}
                            enableReinitialize={true}
                        >
                            {
                                (props, setFieldValue) => (
                                    <Form>
                                        <Message/>
                                        <fieldset className="form-group">
                                            <label>Id</label>
                                            <Field className="form-control" type="text" name="id" disabled/>
                                        </fieldset>
                                        <fieldset className="form-group">
                                            <label>Descrição</label>
                                            <Field className="form-control" type="text" name="descricao"/>
                                        </fieldset>
                                        <fieldset className="form-group">
                                            <label>Marca</label>
                                            <Field className="form-control" type="text" name="marca"/>
                                        </fieldset>
                                        <fieldset className="form-group">
                                            <label>Ano</label>
                                            <Field className="form-control" type="text" name="ano"/>
                                        </fieldset>
                                        <fieldset className="form-group">
                                            <label>Vendido</label>
                                            <Field className="form-control" type="text" name="vendido" as="select">
                                                <option value="true">Sim</option>
                                                <option value="false">Não</option>
                                            </Field>
                                        </fieldset>
                                        <fieldset className="form-group">
                                            <label htmlFor="updated">Data Ins.</label>
                                            <br/>
                                            <Field className="form-control" type="text" name="created" disabled/>
                                        </fieldset>
                                        <fieldset className="form-group">
                                            <label htmlFor="updated">Data Alt.</label>
                                            <br/>
                                            <Field className="form-control" type="text" name="updated" disabled/>
                                        </fieldset>
                                        <button className="btn btn-success" type="submit">Salvar</button>
                                    </Form>
                                )
                            }
                        </Formik>
                    </div>
                </div>
            </>
        )
    }
}

export default VeiculoComponent
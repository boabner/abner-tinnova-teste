import React, { Component }from "react";
import Message from "./Message";
import ListVeiculosBaseComponent from "./ListVeiculosBaseComponent";

class ListVeiculosComponent extends Component {

    render() {
        return (
            <>
                <div className="container">
                    <h3>List Veiculos</h3>
                    <Message/>
                    <div className="container">
                        <ListVeiculosBaseComponent history={this.props.history} />
                    </div>
                </div>
            </>
        )
    }
}
export default ListVeiculosComponent

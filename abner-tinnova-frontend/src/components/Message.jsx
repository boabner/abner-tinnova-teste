import React from "react";

export default (props) => {

    return (
        <>
            {props.message && <div className="alert alert-success">{props.message}</div>}
        </>
    )
}
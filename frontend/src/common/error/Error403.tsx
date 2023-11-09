import React from "react";

const Error403 = () => {

    return (
        <div className="padding-top-big d-flex flex-column align-items-center">
            <h1 className={"error-color"}>!</h1>
            <h4 className={"error-color"}>403 Forbidden</h4>
            <p>You don't have the permission to access this page.</p>
        </div>
    );
}

export default Error403;
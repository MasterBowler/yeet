import React, {ReactNode} from "react";
import "./cta.css";
import "../../utils/css/styles.css";
import {Col, Row} from "react-bootstrap";

type Props = {
    title: string,
    text: string,
    icon: ReactNode,
    path: string
}

const CTA = ({title, text, icon, path}: Props) => {

    return (
        <a onClick={() => window.location.href = path}>
            <Row className={"cta-box"}>
                <Col xl={1} xs={12} className={"no-padding-left"}>
                    <div className={"cta-box-icon"}>{icon}</div>
                </Col>
                <Col xl={11} xs={12} className={"no-padding-left"}>
                    <div className={"cta-box-title"}><h5>{title}</h5></div>
                    <div className={"cta-box-text half-opacity"}><p>{text}</p></div>
                </Col>
            </Row>
        </a>
    );
}

export default CTA;
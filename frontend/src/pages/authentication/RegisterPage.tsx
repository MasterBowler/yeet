import React, {useState} from "react";
import {Col, Row, Container} from "react-bootstrap";
import Logo from "../../utils/resources/Logo";
import "./authentication.css";
import RadioInputField from "../../common/form/RadioInputField";
import StudentRegisterFields from "./components/fields/StudentRegisterFields";
import HighschoolProfessorRegisterFields from "./components/fields/HighschoolProfessorRegisterFields";
import {useAtom} from "jotai";
import {userAtom} from "../../common/atom/UserAtom";
import {Navigate} from "react-router-dom";
import {lastPageAtom} from "../../common/atom/LastPageAtom";

const RegisterPage = () => {

    const [userGroup, setUserGroup] = useState<string>("Student");

    const [currentLastPage,] = useAtom(lastPageAtom);
    const [currentUser,] = useAtom(userAtom);

    if (currentUser) {

        if (currentLastPage !== undefined && currentLastPage.url !== undefined) {

            return (<Navigate to={currentLastPage.url}/>);

        } else {

            return (<Navigate to={"/"}/>);
        }

    } else {

        return (
            <>
                <section>
                    <Container>
                        <Row className={"content-padding content"}>
                            <Col xl={{span: 8, offset: 2}} lg={{span: 10, offset: 1}}>
                                <div className="register-form">
                                    <div className="d-flex justify-content-center form-logo">
                                        <Logo/>
                                    </div>
                                    <div className="d-flex justify-content-center mb-3">
                                        <h4>Register</h4>
                                    </div>
                                    <Row className={"mb-3"}>
                                        <div className="d-flex justify-content-center">
                                            <p className={"skin-color"}><strong>User Group</strong></p>
                                        </div>
                                        <Col md={3} sm={4} xs={12}>
                                            <RadioInputField fieldName={"userGroup"} fieldId={"student"}
                                                             fieldValue={"Student"}
                                                             checkedValue={userGroup}
                                                             setCheckedValue={setUserGroup}/>
                                        </Col>
                                        <Col md={3} sm={4} xs={12}>
                                            <RadioInputField fieldName={"userGroup"} fieldId={"highschoolProfessor"}
                                                             fieldValue={"Highschool Professor"}
                                                             checkedValue={userGroup}
                                                             setCheckedValue={setUserGroup}/>
                                        </Col>
                                    </Row>
                                    {
                                        userGroup === "Student" &&
                                        <StudentRegisterFields/>
                                    }
                                    {
                                        userGroup === "Highschool Professor" &&
                                        <HighschoolProfessorRegisterFields/>
                                    }
                                </div>
                                <div className="d-flex justify-content-center">
                                    <p><span className="half-opacity">Already have an account? </span><a
                                        href="/login">Sign in now</a><span
                                        className="half-opacity">.</span></p>
                                </div>
                            </Col>
                        </Row>
                    </Container>
                </section>
            </>
        );
    }
};

export default RegisterPage;
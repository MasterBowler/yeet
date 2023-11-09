import React, {useState} from "react";
import {Col, Row, Container, Button} from "react-bootstrap";
import Logo from "../../utils/resources/Logo";
import RegularInputField from "../../common/form/RegularInputField";
import "./authentication.css";
import {useAtom} from "jotai";
import {userAtom} from "../../common/atom/UserAtom";
import {Navigate} from "react-router-dom";
import {studentAtom} from "../../common/atom/StudentAtom";
import {highschoolProfessorAtom} from "../../common/atom/HighschoolProfessorAtom";
import {lastPageAtom} from "../../common/atom/LastPageAtom";

const LoginPage = () => {

    const [message, setMessage] = useState<string>();
    const [emailAddress, setEmailAddress] = useState<string>();
    const [password, setPassword] = useState<string>();

    const [currentLastPage,] = useAtom(lastPageAtom);
    const [currentUser, setCurrentUser] = useAtom(userAtom);
    const [, setCurrentStudent] = useAtom(studentAtom);
    const [, setCurrentHighschoolProfessor] = useAtom(highschoolProfessorAtom);

    const handleLogin = () => {

        if (emailAddress === "mihai.manolache@info.uaic.ro" && password === "passtest") {

            setCurrentUser({
                id: 1,
                emailAddress: "mihai.manolache@info.uaic.ro",
                firstName: "Mihai",
                lastName: "Manolache",
                creationDate: new Date(),
                passwordHash: "passtest",
                groupName: "Student",
                phoneNumber: "112"
            });

            setCurrentStudent({
                sid: "MIHAISID",
                universityName: "UAIC",
                degreeName: "FII",
                year: "III",
                groupCode: "A2",
                specialtyName: "Computer Science"
            });

            setCurrentHighschoolProfessor(undefined);

        } else if (emailAddress === "emanuela.cerchez@gmail.com" && password === "passtest") {

            setCurrentUser({
                id: 1,
                emailAddress: "emanuela.cerchez@gmail.com",
                firstName: "Emanuela",
                lastName: "Cerchez",
                creationDate: new Date(),
                passwordHash: "passtest",
                groupName: "Highschool Professor",
                phoneNumber: "112"
            });

            setCurrentHighschoolProfessor({
                highschoolName: "Emil Racovita Iasi",
                teachingDegree: "PhD.",
                startDate: new Date()
            });

            setCurrentStudent(undefined);

        } else {

            setMessage("Invalid credentials!");
        }

    };

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
                            <Col xl={{span: 4, offset: 4}} lg={{span: 6, offset: 1}}>
                                <div className="login-form">
                                    <div className="d-flex justify-content-center form-logo">
                                        <Logo/>
                                    </div>
                                    <div className="d-flex justify-content-center">
                                        <h4>Sign in</h4>
                                    </div>
                                    <Col xs={12} className={"mb-3"}>
                                        <RegularInputField fieldName={"E-mail Address"} fieldValue={""}
                                                           setFieldValue={setEmailAddress}
                                                           fieldAreaLabel={"emailAddress"}/>
                                    </Col>
                                    <Col xs={12} className={"mb-3"}>
                                        <RegularInputField fieldName={"Password"} fieldValue={""}
                                                           setFieldValue={setPassword}
                                                           fieldAreaLabel={"password"}
                                                           isHidden={true}/>
                                    </Col>
                                    <Col xs={12} className={"mb-3 d-flex justify-content-center"}>
                                        <Button
                                            className="button btn-form"
                                            variant="primary"
                                            onClick={() => handleLogin()}>
                                            Login
                                        </Button>
                                    </Col>
                                </div>
                                <div className="d-flex justify-content-center">
                                    <p><span className="half-opacity">Don’t have an account? </span><a
                                        href="/register">Register now</a><span
                                        className="half-opacity">.</span></p>
                                </div>
                                <Row className="no-padding-left">
                                    <Col className="no-padding-left no-padding-right">
                                        {
                                            message && (
                                                <div className="form-group">
                                                    <div
                                                        className="alert alert-success d-flex justify-content-center"
                                                        role="alert">
                                                        {message}
                                                    </div>
                                                </div>
                                            )
                                        }
                                    </Col>
                                </Row>
                            </Col>
                        </Row>
                    </Container>
                </section>
            </>
        );
    }
};

export default LoginPage;
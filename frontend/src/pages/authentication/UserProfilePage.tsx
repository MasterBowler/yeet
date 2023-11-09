import React from "react";
import {Col, Row, Container} from "react-bootstrap";
import "./authentication.css";
import StudentProfile from "./components/profile/StudentProfile";
import HighschoolProfessorProfile from "./components/profile/HighschoolProfessorProfile";
import NavBar from "../../common/navigation/NavBar";
import Header from "../../common/header/Header";
import ReportIcon from "../../utils/resources/icon/ReportIcon";
import {useAtom} from "jotai";
import {userAtom} from "../../common/atom/UserAtom";
import {Navigate} from "react-router-dom";
import {lastPageAtom} from "../../common/atom/LastPageAtom";
import {studentAtom} from "../../common/atom/StudentAtom";
import {highschoolProfessorAtom} from "../../common/atom/HighschoolProfessorAtom";

const UserProfilePage = () => {

    const [currentUser,] = useAtom(userAtom);
    const [currentStudent,] = useAtom(studentAtom);
    const [currentHighschoolProfessor,] = useAtom(highschoolProfessorAtom);
    const [, setCurrentLastPage] = useAtom(lastPageAtom);

    if (currentUser === undefined) {

        setCurrentLastPage({
            url: "/user-profile"
        });
        return (<Navigate to={"/login"}/>);

    } else {

        return (
            <>
                <section>
                    <Container fluid>
                        <Row>
                            <Col xl={{span: 2}} lg={{span: 3}} className="no-padding-left no-padding-right">
                                <NavBar currentPage="/user-profile"/>
                            </Col>
                            <Col xl={{span: 10}} lg={{span: 9}} className="no-padding-right no-padding-left">
                                <Row>
                                    <Header icon={<ReportIcon/>} text={"User Profile"}/>
                                </Row>
                                <Row>
                                    <div className="content-padding content">
                                        <Col xl={{span: 8, offset: 2}} lg={{span: 6, offset: 3}}
                                             className="padding-top-smaller">
                                            <Row className={"mb-3"}>
                                                {
                                                    currentStudent &&
                                                    <StudentProfile/>
                                                }
                                                {
                                                    currentHighschoolProfessor &&
                                                    <HighschoolProfessorProfile/>
                                                }
                                            </Row>
                                        </Col>
                                    </div>
                                </Row>
                            </Col>
                        </Row>
                    </Container>
                </section>
            </>
        );
    }
};

export default UserProfilePage;
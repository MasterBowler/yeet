import {Col, Container, Row} from "react-bootstrap";
import React, {useState} from "react";
import NavBar from "../../common/navigation/NavBar";
import Header from "../../common/header/Header";
import FolderIcon from "../../utils/resources/icon/FolderIcon";
import {useAtom} from "jotai";
import {userAtom} from "../../common/atom/UserAtom";
import {Navigate} from "react-router-dom";
import {lastPageAtom} from "../../common/atom/LastPageAtom";
import Error403 from "../../common/error/Error403";
import HighschoolProfessorReportsTable from "./components/table/HighschoolProfessorReportsTable";
import {highschoolProfessorAtom} from "../../common/atom/HighschoolProfessorAtom";
import {
    highschoolProfessorReport1,
    highschoolProfessorReport2,
    highschoolProfessorReport3
} from "./HighschoolProfessorReportList";
import {HighschoolProfessorReport} from "../../common/model/HighschoolProfessorReport";

const HighschoolProfessorReportsPage = () => {

    const [currentUser,] = useState(userAtom);
    const [currentHighschoolProfessor,] = useState(highschoolProfessorAtom);

    const reports = Array.of(highschoolProfessorReport1, highschoolProfessorReport2, highschoolProfessorReport3);
    const [reportsList, ] = useState<Array<HighschoolProfessorReport> | undefined>(reports);
    const [displayReportsList, ] = useState(true);

    const [, setCurrentLastPage] = useAtom(lastPageAtom);

    if (currentUser === undefined) {

        setCurrentLastPage({
            url: "/highschool-professor-reports"
        });
        return (<Navigate to={"/login"}/>);

    } else {

        return (
            <>
                <section>
                    <Container fluid>
                        <Row>
                            <Col xl={{span: 2}} lg={{span: 3}} className="no-padding-left no-padding-right">
                                <NavBar currentPage="/highschool-professor-reports"/>
                            </Col>
                            <Col xl={{span: 10}} lg={{span: 9}} className="no-padding-right no-padding-left">
                                <Row>
                                    <Header icon={<FolderIcon/>} text={"Highschool Professor Reports"}/>
                                </Row>
                                <Row>
                                    <div className="content-padding content">
                                        {
                                            currentHighschoolProfessor ?
                                                displayReportsList &&
                                                <HighschoolProfessorReportsTable reportsList={reportsList!}/> :
                                                <Error403/>
                                        }
                                    </div>
                                </Row>
                            </Col>
                        </Row>
                    </Container>
                </section>
            </>
        );
    }
}

export default HighschoolProfessorReportsPage;
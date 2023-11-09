import {Col, Container, Row} from "react-bootstrap";
import React, {useState} from "react";
import NavBar from "../../common/navigation/NavBar";
import Header from "../../common/header/Header";
import FolderIcon from "../../utils/resources/icon/FolderIcon";
import StudentReportsTable from "./components/table/StudentReportsTable";
import {useAtom} from "jotai";
import {userAtom} from "../../common/atom/UserAtom";
import {Navigate} from "react-router-dom";
import {lastPageAtom} from "../../common/atom/LastPageAtom";
import {studentAtom} from "../../common/atom/StudentAtom";
import Error403 from "../../common/error/Error403";
import {StudentReport} from "../../common/model/StudentReport";
import {studentReport1, studentReport2, studentReport3, studentReport4} from "./StudentReportList";

const StudentReportsPage = () => {

    const [currentUser,] = useState(userAtom);
    const [currentStudent,] = useState(studentAtom);

    const reports = Array.of(studentReport1, studentReport2, studentReport3, studentReport4);
    const [reportsList, ] = useState<Array<StudentReport> | undefined>(reports);
    const [displayReportsList, ] = useState(true);

    const [, setCurrentLastPage] = useAtom(lastPageAtom);

    if (currentUser === undefined) {

        setCurrentLastPage({
            url: "/student-reports"
        });
        return (<Navigate to={"/login"}/>);

    } else {

        return (
            <>
                <section>
                    <Container fluid>
                        <Row>
                            <Col xl={{span: 2}} lg={{span: 3}} className="no-padding-left no-padding-right">
                                <NavBar currentPage="/student-reports"/>
                            </Col>
                            <Col xl={{span: 10}} lg={{span: 9}} className="no-padding-right no-padding-left">
                                <Row>
                                    <Header icon={<FolderIcon/>} text={"Student Reports"}/>
                                </Row>
                                <Row>
                                    <div className="content-padding content">
                                        {
                                            currentStudent ?
                                                displayReportsList &&
                                                <StudentReportsTable reportsList={reportsList!}/> :
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

export default StudentReportsPage;
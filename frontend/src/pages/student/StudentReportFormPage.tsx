import React, {useState} from "react";
import {Button, Col, Container, Row} from "react-bootstrap";
import NavBar from "../../common/navigation/NavBar";
import Header from "../../common/header/Header";
import RegularInputField from "../../common/form/RegularInputField";
import ReportIcon from "../../utils/resources/icon/ReportIcon";
import {useAtom} from "jotai";
import {userAtom} from "../../common/atom/UserAtom";
import {Navigate, useParams} from "react-router-dom";
import {lastPageAtom} from "../../common/atom/LastPageAtom";
import {studentAtom} from "../../common/atom/StudentAtom";
import Error403 from "../../common/error/Error403";

const StudentReportFormPage = () => {

    const {id} = useParams<{ id: string }>();

    const [currentUser,] = useAtom(userAtom);
    const [, setCurrentLastPage] = useAtom(lastPageAtom);
    const [currentStudent,] = useAtom(studentAtom);

    const [message, setMessage] = useState<string>();

    const [month, setMonth] = useState<string>();
    const [transportationMeans, setTransportationMeans] = useState<string>();
    const [assistance, setAssistance] = useState<string>();
    const [date, setDate] = useState<string>();
    const [extracurriculars, setExtracurriculars] = useState<string>();
    const [portfolio, setPortfolio] = useState<string>();
    const [teachingProject, setTeachingProject] = useState<string>();
    const [timeframe, setTimeframe] = useState<string>();
    const [workshop, setWorkshop] = useState<string>();

    const handleSaveAndSubmit = () => {

        setMessage("month: " + month + " transportationMeans: " + transportationMeans + " assistance: " + assistance + " date: " + date + " extracurriculars: " + extracurriculars + " portfolio: " +
            portfolio + " teachingProject: " + teachingProject + " timeframe: " + timeframe + " workshop: " + workshop);
    }

    if (currentUser === undefined) {

        setCurrentLastPage({
            url: "/student-report-form/" + id
        });
        return (<Navigate to={"/login"}/>);

    } else {
        return (
            <>
                <section>
                    <Container fluid>
                        <Row>
                            <Col xl={{span: 2}} lg={{span: 3}} className="no-padding-left no-padding-right">
                                <NavBar currentPage="/student-report-form/add"/>
                            </Col>
                            <Col xl={{span: 10}} lg={{span: 9}} className="no-padding-right no-padding-left">
                                <Row>
                                    <Header icon={<ReportIcon/>} text={"Add New Student Report"}/>
                                </Row>
                                <Row>
                                    <div className="content-padding content">
                                        <Col xl={{span: 8, offset: 2}} lg={{span: 6, offset: 3}}
                                             className="padding-top-smaller">
                                            {currentStudent ?
                                                <div className={"form-field mb-3"}>
                                                    <Col className="form-label no-padding-left mb-2">
                                                        <h5 className={"skin-color"}>General</h5>
                                                    </Col>
                                                    <Row>
                                                        <Col className="d-flex gap-4 no-padding-left mb-3"
                                                             xs={{span: 12}}>
                                                            <RegularInputField fieldName={"Month"} fieldValue={""}
                                                                               setFieldValue={setMonth}
                                                                               fieldAreaLabel={"month"}/>
                                                            <RegularInputField fieldName={"Transportation Means"}
                                                                               fieldValue={""}
                                                                               setFieldValue={setTransportationMeans}
                                                                               fieldAreaLabel={"transportationMeans"}/>
                                                        </Col>
                                                    </Row>
                                                    <Col className="form-label no-padding-left mb-2 mt-2">
                                                        <h5 className={"skin-color"}>Details</h5>
                                                    </Col>
                                                    <Row>
                                                        <Col className="d-flex gap-4 no-padding-left mb-3"
                                                             xs={{span: 12}}>
                                                            <RegularInputField fieldName={"Assistance"} fieldValue={""}
                                                                               setFieldValue={setAssistance}
                                                                               fieldAreaLabel={"assistance"}/>
                                                            <RegularInputField fieldName={"Date"} fieldValue={""}
                                                                               setFieldValue={setDate}
                                                                               fieldAreaLabel={"date"}/>
                                                        </Col>
                                                        <Col className="d-flex gap-4 no-padding-left mb-3"
                                                             xs={{span: 12}}>
                                                            <RegularInputField fieldName={"Extracurriculars"}
                                                                               fieldValue={""}
                                                                               setFieldValue={setExtracurriculars}
                                                                               fieldAreaLabel={"extracurriculars"}/>
                                                        </Col>
                                                        <Col className="d-flex gap-4 no-padding-left mb-3"
                                                             xs={{span: 12}}>
                                                            <RegularInputField fieldName={"Portfolio"} fieldValue={""}
                                                                               setFieldValue={setPortfolio}
                                                                               fieldAreaLabel={"portfolio"}/>
                                                        </Col>
                                                        <Col className="d-flex gap-4 no-padding-left mb-3"
                                                             xs={{span: 12}}>
                                                            <RegularInputField fieldName={"Teaching Project"}
                                                                               fieldValue={""}
                                                                               setFieldValue={setTeachingProject}
                                                                               fieldAreaLabel={"teachingProject"}/>
                                                            <RegularInputField fieldName={"Timeframe"} fieldValue={""}
                                                                               setFieldValue={setTimeframe}
                                                                               fieldAreaLabel={"timeframe"}/>
                                                        </Col>
                                                        <Col className="d-flex gap-4 no-padding-left mb-3"
                                                             xs={{span: 12}}>
                                                            <RegularInputField fieldName={"Workshop"} fieldValue={""}
                                                                               setFieldValue={setWorkshop}
                                                                               fieldAreaLabel={"workshop"}/>
                                                        </Col>
                                                    </Row>
                                                    <Row>
                                                        <Col className="no-padding-left content-align-end">
                                                            <Button
                                                                className="button"
                                                                variant="primary"
                                                                onClick={() => handleSaveAndSubmit()}>
                                                                Save & Submit
                                                            </Button>
                                                        </Col>
                                                    </Row>
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
                                                </div> : <Error403/>}
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
}

export default StudentReportFormPage;
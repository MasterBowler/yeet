import React, {useState} from "react";
import {Button, Col, Container, Row} from "react-bootstrap";
import NavBar from "../../common/navigation/NavBar";
import Header from "../../common/header/Header";
import RegularInputField from "../../common/form/RegularInputField";
import ScheduleIcon from "../../utils/resources/icon/ScheduleIcon";
import {useAtom} from "jotai";
import {userAtom} from "../../common/atom/UserAtom";
import {Navigate, useParams} from "react-router-dom";
import {lastPageAtom} from "../../common/atom/LastPageAtom";
import {highschoolProfessorAtom} from "../../common/atom/HighschoolProfessorAtom";
import Error403 from "../../common/error/Error403";

const ScheduleFormPage = () => {

    const {id} = useParams<{ id: string }>();

    const [message, setMessage] = useState<string>();

    const [className, setClassName] = useState<string>();
    const [coordinatorName, setCoordinatorName] = useState<string>();
    const [startDateAndTime, setStartDateAndTime] = useState<string>();
    const [endDateAndTime, setEndDateAndTime] = useState<string>();
    const [attendance, setAttendance] = useState<string>();
    const [maximumAttendance, setMaximumAttendance] = useState<string>();
    const [description, setDescription] = useState<string>();

    const [currentUser,] = useAtom(userAtom);
    const [currentHighschoolProfessor,] = useAtom(highschoolProfessorAtom);

    const handleSaveAndSubmit = () => {

        setMessage("schedule form");
        console.log(message);
    }

    const [, setCurrentLastPage] = useAtom(lastPageAtom);

    if (currentUser === undefined) {

        setCurrentLastPage({
            url: "/schedule-form/" + id
        });
        return (<Navigate to={"/login"}/>);

    } else {

        return (
            <>
                <section>
                    <Container fluid>
                        <Row>
                            <Col xl={{span: 2}} lg={{span: 3}} className="no-padding-left no-padding-right">
                                <NavBar currentPage="/schedule-form/add"/>
                            </Col>
                            <Col xl={{span: 10}} lg={{span: 9}} className="no-padding-right no-padding-left">
                                <Row>
                                    <Header icon={<ScheduleIcon/>} text={"Schedule New Class"}/>
                                </Row>
                                <Row>
                                    <div className="content-padding content">
                                        <Col xl={{span: 8, offset: 2}} lg={{span: 6, offset: 3}}
                                             className="padding-top-smaller">
                                            {currentHighschoolProfessor ?
                                                <div className={"form-field mb-3"}>
                                                    <Row>
                                                        <Col className="d-flex gap-4 no-padding-left mb-3"
                                                             xs={{span: 12}}>
                                                            <RegularInputField fieldName={"Class Name"} fieldValue={""}
                                                                               setFieldValue={setClassName}
                                                                               fieldAreaLabel={"className"}/>
                                                            <RegularInputField fieldName={"Coordinator Name"}
                                                                               fieldValue={""}
                                                                               setFieldValue={setCoordinatorName}
                                                                               fieldAreaLabel={"coordinatorName"}/>
                                                        </Col>
                                                        <Col className="d-flex gap-4 no-padding-left mb-3"
                                                             xs={{span: 12}}>
                                                            <RegularInputField fieldName={"Start Date and Time"}
                                                                               fieldValue={""}
                                                                               setFieldValue={setStartDateAndTime}
                                                                               fieldAreaLabel={"startDateAndTime"}/>
                                                            <RegularInputField fieldName={"End Date and Time"}
                                                                               fieldValue={""}
                                                                               setFieldValue={setEndDateAndTime}
                                                                               fieldAreaLabel={"endDateAndTime"}/>
                                                        </Col>
                                                        <Col className="d-flex gap-4 no-padding-left mb-3"
                                                             xs={{span: 12}}>
                                                            <RegularInputField fieldName={"Attendance"} fieldValue={""}
                                                                               setFieldValue={setAttendance}
                                                                               fieldAreaLabel={"attendance"}/>
                                                            <RegularInputField fieldName={"Maximum Attendance"}
                                                                               fieldValue={""}
                                                                               setFieldValue={setMaximumAttendance}
                                                                               fieldAreaLabel={"maximumAttendance"}/>
                                                        </Col>
                                                        <Col className="d-flex gap-4 no-padding-left mb-3"
                                                             xs={{span: 12}}>
                                                            <RegularInputField fieldName={"Description"} fieldValue={""}
                                                                               setFieldValue={setDescription}
                                                                               fieldAreaLabel={"description"}/>
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
                                                </div> :
                                                <Error403/>}
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

export default ScheduleFormPage;
import React, {useEffect} from "react";
import {Col, Container, Row} from "react-bootstrap";
import CTA from "../../common/cta/CTA";
import ScheduleIcon from "../../utils/resources/icon/ScheduleIcon";
import NavBar from "../../common/navigation/NavBar";
import FolderIcon from "../../utils/resources/icon/FolderIcon";
import ReportIcon from "../../utils/resources/icon/ReportIcon";
import ClassScheduleBox from "../schedule/components/ClassScheduleBox";
import "./dashboard.css";
import Header from "../../common/header/Header";
import DashboardIcon from "../../utils/resources/icon/DashboardIcon";
import {useAtom} from "jotai";
import {userAtom} from "../../common/atom/UserAtom";
import {Navigate} from "react-router-dom";
import {lastPageAtom} from "../../common/atom/LastPageAtom";
import {ClassSchedule} from "../../common/model/ClassSchedule";
import {classSchedule1, classSchedule2, classSchedule3, classSchedule4} from "../schedule/ClassScheduleList";
import {studentAtom} from "../../common/atom/StudentAtom";
import {highschoolProfessorAtom} from "../../common/atom/HighschoolProfessorAtom";

const DashboardPage = () => {

    const [currentUser,] = useAtom(userAtom);
    const [, setCurrentLastPage] = useAtom(lastPageAtom);
    const [currentStudent,] = useAtom(studentAtom);
    const [currentHighschoolProfessor,] = useAtom(highschoolProfessorAtom);

    const classesList = Array.of(classSchedule1, classSchedule2, classSchedule3, classSchedule4);

    if (currentUser === undefined) {

        setCurrentLastPage({
            url: "/"
        });
        return (<Navigate to={"/login"}/>);

    } else {
        return (
            <>
                <section>
                    <Container fluid>
                        <Row>
                            <Col xl={{span: 2}} lg={{span: 3}} className="no-padding-left no-padding-right">
                                <NavBar currentPage="/"/>
                            </Col>
                            <Col xl={{span: 10}} lg={{span: 9}} className="no-padding-right no-padding-left">
                                <Row>
                                    <Header icon={<DashboardIcon/>} text={"Dashboard"}/>
                                </Row>
                                <Row className="content-padding content">
                                    <Col xl={{span: 12}} lg={{span: 12}} className={"no-padding-left no-padding-right"}>
                                        <Row className={"section-border-bottom pb-3 mb-4"}>
                                            <h5 className={"no-padding-left"}>Schedule</h5>
                                            {
                                                classesList.map((classSchedule: ClassSchedule, index) => {

                                                    return (
                                                        <Col key={index} xl={4} lg={6} xs={12} className={"no-padding-left"}>
                                                            <ClassScheduleBox
                                                                classSchedule={classSchedule}/>
                                                        </Col>
                                                    );
                                                })
                                            }
                                        </Row>
                                        <Row className={"section-border-bottom pb-3 mb-4"}>
                                            <h5 className={"no-padding-left"}>Quick Links</h5>
                                            <Col xl={4} lg={6} xs={12} className={"no-padding-left mt-3"}>
                                                <CTA
                                                    title={"Schedule"}
                                                    text={"View class schedules."}
                                                    path={"/schedule"}
                                                    icon={<ScheduleIcon/>}
                                                />
                                            </Col>
                                            {
                                                currentHighschoolProfessor &&
                                                <Col xl={4} lg={6} xs={12} className={"no-padding-left mt-3"}>
                                                    <CTA
                                                        title={"Schedule New Class"}
                                                        text={"Add a new class schedules."}
                                                        path={"/schedule-form/add"}
                                                        icon={<ScheduleIcon/>}
                                                    />
                                                </Col>
                                            }
                                            {
                                                currentStudent &&
                                                <Col xl={4} lg={6} xs={12} className={"no-padding-left mt-3"}>
                                                    <CTA
                                                        title={"Student Reports"}
                                                        text={"View list of student reports."}
                                                        path={"/student-reports"}
                                                        icon={<FolderIcon/>}
                                                    />
                                                </Col>
                                            }
                                            {
                                                currentStudent &&
                                                <Col xl={4} lg={6} xs={12} className={"no-padding-left mt-3"}>
                                                    <CTA
                                                        title={"Add New Student Report"}
                                                        text={"Complete and submit a student report."}
                                                        path={"/student-report-form/add"}
                                                        icon={<ReportIcon/>}
                                                    />
                                                </Col>
                                            }
                                            {
                                                currentHighschoolProfessor &&
                                                <Col xl={4} lg={6} xs={12} className={"no-padding-left mt-3"}>
                                                    <CTA
                                                        title={"Highschool Professor Reports"}
                                                        text={"View list of highschool professor reports."}
                                                        path={"/highschool-professor-reports"}
                                                        icon={<FolderIcon/>}
                                                    />
                                                </Col>
                                            }
                                            {
                                                currentHighschoolProfessor &&
                                                <Col xl={4} lg={6} xs={12} className={"no-padding-left mt-3"}>
                                                    <CTA
                                                        title={"Add New Highschool Professor Report"}
                                                        text={"Complete and submit a hs professor report."}
                                                        path={"/highschool-professor-form/add"}
                                                        icon={<ReportIcon/>}
                                                    />
                                                </Col>
                                            }
                                        </Row>
                                    </Col>
                                </Row>
                            </Col>
                        </Row>
                    </Container>
                </section>
            </>
        );
    }
}

export default DashboardPage;
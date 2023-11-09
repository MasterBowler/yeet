import React, {useState} from "react";
import {Col, Container, Row} from "react-bootstrap";
import NavBar from "../../common/navigation/NavBar";
import ClassScheduleBox from "./components/ClassScheduleBox";
import Header from "../../common/header/Header";
import ScheduleIcon from "../../utils/resources/icon/ScheduleIcon";
import "./schedule.css";
import FilteringBar from "./filtering/FilteringBar";
import {useAtom} from "jotai";
import {userAtom} from "../../common/atom/UserAtom";
import {Navigate} from "react-router-dom";
import {lastPageAtom} from "../../common/atom/LastPageAtom";
import {ClassSchedule} from "../../common/model/ClassSchedule";
import {classSchedule1, classSchedule2, classSchedule3, classSchedule4} from "./ClassScheduleList";

const SchedulePage = () => {

    const classesList = Array.of(classSchedule1, classSchedule2, classSchedule3, classSchedule4);
    const [classesListToDisplay, setClassesListToDisplay] = useState<Array<ClassSchedule>>(classesList);
    const [updatedClassesListToDisplay, setUpdatedClassesListToDisplay] = useState(false);
    const [currentClass, setCurrentClass] = useState<ClassSchedule>();

    const [currentUser,] = useAtom(userAtom);
    const [, setCurrentLastPage] = useAtom(lastPageAtom);

    if (currentUser === undefined) {

        setCurrentLastPage({
            url: "/schedule"
        });
        return (<Navigate to={"/login"}/>);

    } else {
        return (
            <>
                <section>
                    <Container fluid>
                        <Row>
                            <Col xl={{span: 2}} lg={{span: 3}} className="no-padding-left no-padding-right">
                                <NavBar currentPage="/schedule"/>
                            </Col>
                            <Col xl={{span: 10}} lg={{span: 9}} className="no-padding-right no-padding-left">
                                <Row>
                                    <Header icon={<ScheduleIcon/>} text={"Schedule"}/>
                                </Row>
                                <Row className="content-padding content">
                                    <Col xs={12} className={"no-padding-left no-padding-right"}>
                                        <FilteringBar classesListToDisplay={classesList}
                                                      setClassesListToDisplay={setClassesListToDisplay}
                                                      updatedClassesListToDisplay={updatedClassesListToDisplay}
                                                      setUpdatedClassesListToDisplay={setUpdatedClassesListToDisplay}/>
                                    </Col>
                                    <Col xs={12} className={"class-dictionary no-padding-left"}>
                                        <span className={"future-class class-box"}/> <span
                                        className={"half-opacity pe-3"}>Future classes (from one month from now in the future)</span>
                                        <span className={"current-class class-box"}/> <span
                                        className={"half-opacity pe-3"}>Current classes (from today to one month in the future)</span>
                                        <span className={"past-class class-box"}/> <span
                                        className={"half-opacity pe-3"}>Past classes (held before today)</span>
                                    </Col>
                                    {
                                        classesListToDisplay.map((classSchedule: ClassSchedule, index) => {

                                            return (
                                                <Col key={index} xl={4} lg={6} xs={12} className={"no-padding-left"}>
                                                    <ClassScheduleBox
                                                        classSchedule={classSchedule}/>
                                                </Col>
                                            );
                                        })
                                    }
                                </Row>
                            </Col>
                        </Row>
                    </Container>
                </section>
            </>
        );
    }
}

export default SchedulePage;
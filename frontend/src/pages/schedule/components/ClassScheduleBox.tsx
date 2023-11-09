import React, {useEffect, useState} from "react";
import {Button, Col, Row} from "react-bootstrap";
import "./classScheduleBox.css";
import {ClassSchedule} from "../../../common/model/ClassSchedule";
import {useAtom} from "jotai";
import {studentAtom} from "../../../common/atom/StudentAtom";
import {highschoolProfessorAtom} from "../../../common/atom/HighschoolProfessorAtom";

type Props = {
    classSchedule: ClassSchedule
}

const ClassScheduleBox = ({classSchedule}: Props) => {

    const [currentStudent,] = useAtom(studentAtom);
    const [currentHighschoolProfessor,] = useAtom(highschoolProfessorAtom);

    const [classState, setClassState] = useState<string>("normal");
    const currentDate = new Date();

    useEffect(() => {

        if (classSchedule.startDateAndTime.getTime() < Date.now()) {

            setClassState("old");

        } else if ((classSchedule.startDateAndTime.getTime() >= currentDate.getTime()) &&
            (classSchedule.startDateAndTime.getTime() <= (currentDate.setMonth(currentDate.getMonth() + 1)))) {

            setClassState("current");

        } else if (classSchedule.startDateAndTime.getTime() > (currentDate.setMonth(currentDate.getMonth() + 1))) {

            setClassState("future");
        }
    }, []);

    return (
        <div className={"class-schedule-box"}>
            <div className={"class-date-and-time"}>
                <span
                    className={"badge badge-" + classState}>{classSchedule.startDateAndTime.toUTCString()} - {classSchedule.endDateAndTime.toUTCString()}</span>
            </div>
            <div className={"class-title"}>
                {currentHighschoolProfessor && <a href={"/schedule-form/" + classSchedule.id}>{classSchedule.className}</a>}
                {currentStudent && <span className={"skin-color"}>{classSchedule.className}</span>}
            </div>
            <div className={"class-coordinator"}>
                {classSchedule.coordinatorName}
            </div>
            <div className={"class-description"}>
                {classSchedule.description}
            </div>
            <Row className={"class-attendance no-padding-left"}>
                <Col className={"class-participants no-padding-left"}>
                    {classSchedule.attendance} participants <span
                    className={"half-opacity"}>/ {classSchedule.maximumAttendance} (max)</span>
                </Col>
                {
                    currentStudent &&
                    ((classSchedule.attendance < classSchedule.maximumAttendance) && (classSchedule.startDateAndTime.getTime() > Date.now())) &&
                    <Col className={"class-enroll no-padding-left no-padding-right"}>
                        <Button
                            className="button"
                            variant="secondary"
                            onClick={() => {
                                console.log("enroll")
                            }}>
                            Enroll
                        </Button>
                    </Col>
                }
            </Row>
        </div>
    );
}

export default ClassScheduleBox;
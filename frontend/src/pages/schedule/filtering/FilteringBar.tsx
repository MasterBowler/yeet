import React, {useEffect, useState} from "react";
import {Button, Col, Row} from "react-bootstrap";
import PeriodFilter from "./filters/PeriodFilter";
import EnrollmentFilter from "./filters/EnrollmentFilter";
import SearchByTitleFilter from "./filters/SearchByTitleFilter";
import SearchByProfessorFilter from "./filters/SearchByProfessorFilter";
import {useAtom} from "jotai";
import {highschoolProfessorAtom} from "../../../common/atom/HighschoolProfessorAtom";
import {ClassSchedule} from "../../../common/model/ClassSchedule";

type Props = {
    classesListToDisplay: Array<ClassSchedule>,
    setClassesListToDisplay(classesListToDisplay: Array<ClassSchedule>): void,
    updatedClassesListToDisplay: boolean,
    setUpdatedClassesListToDisplay(updatedClassesListToDisplay: boolean): void
}

const FilteringBar = ({
                          classesListToDisplay,
                          setClassesListToDisplay,
                          updatedClassesListToDisplay,
                          setUpdatedClassesListToDisplay
                      }: Props) => {

    const [currentHighschoolProfessor,] = useAtom(highschoolProfessorAtom);

    const [titleFilteredClasses, setTitleFilteredClasses] = useState<Array<ClassSchedule>>(classesListToDisplay);
    const [professorFilteredClasses, setProfessorFilteredClasses] = useState<Array<ClassSchedule>>(classesListToDisplay);
    const [periodFilteredClasses, setPeriodFilteredClasses] = useState<Array<ClassSchedule>>(classesListToDisplay);
    const [enrollmentFilteredClasses, setEnrollmentFilteredClasses] = useState<Array<ClassSchedule>>(classesListToDisplay);

    const handleAdd = () => {

        window.open("/schedule-form/add", "_self");
    }

    const setMultipleFilteredClasses = () => {

        let multipleFilteredEntries = Array<ClassSchedule>();

        titleFilteredClasses.forEach(classSchedule => {

            if (professorFilteredClasses.includes(classSchedule) &&
                periodFilteredClasses.includes(classSchedule) &&
                enrollmentFilteredClasses.includes(classSchedule)) {

                multipleFilteredEntries.push(classSchedule);
            }
        })

        setClassesListToDisplay(multipleFilteredEntries);
    }

    useEffect(() => {

        setMultipleFilteredClasses();
        setUpdatedClassesListToDisplay(!updatedClassesListToDisplay);

    }, [periodFilteredClasses, enrollmentFilteredClasses, titleFilteredClasses, professorFilteredClasses]);

    return (
        <Row className="no-padding-left no-padding-right filtering-bar flex-grow-1 d-flex flex-row align-items-center mb-3">
            <Col xl={2} lg={3} sm={6} className="no-padding-left pe-2">
                <SearchByTitleFilter classesListToDisplay={classesListToDisplay}
                                     setClassesListToDisplay={setTitleFilteredClasses}
                                     updatedClassesListToDisplay={updatedClassesListToDisplay}
                                     setUpdatedClassesListToDisplay={setUpdatedClassesListToDisplay}/>
            </Col>
            <Col xl={2} lg={3} sm={6} className="no-padding-left pe-2">
                <SearchByProfessorFilter classesListToDisplay={classesListToDisplay}
                                         setClassesListToDisplay={setProfessorFilteredClasses}
                                         updatedClassesListToDisplay={updatedClassesListToDisplay}
                                         setUpdatedClassesListToDisplay={setUpdatedClassesListToDisplay}/>
            </Col>
            <Col xl={2} lg={3} sm={6} className="no-padding-left pe-2">
                <PeriodFilter classesListToDisplay={classesListToDisplay}
                              setClassesListToDisplay={setPeriodFilteredClasses}
                              updatedClassesListToDisplay={updatedClassesListToDisplay}
                              setUpdatedClassesListToDisplay={setUpdatedClassesListToDisplay}/>
            </Col>
            <Col xl={2} lg={3} sm={6} className="no-padding-left pe-2">
                <EnrollmentFilter classesListToDisplay={classesListToDisplay}
                                  setClassesListToDisplay={setEnrollmentFilteredClasses}
                                  updatedClassesListToDisplay={updatedClassesListToDisplay}
                                  setUpdatedClassesListToDisplay={setUpdatedClassesListToDisplay}/>
            </Col>
            {
                currentHighschoolProfessor &&
                <Col xl={{span: 2, offset: 2}} lg={3} sm={6} className="no-padding-left d-flex justify-content-end">
                    <Button
                        className="button mt-0"
                        variant="success"
                        onClick={() => handleAdd()}>
                        Schedule Class
                    </Button>
                </Col>
            }
        </Row>
    );
}

export default FilteringBar;
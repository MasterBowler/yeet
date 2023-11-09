import React from "react";
import {Col, Row} from "react-bootstrap";
import SearchByTeachingProjectFilter from "./filters/SearchByTeachingProjectFilter";
import {StudentReport} from "../../../../../common/model/StudentReport";

type Props = {
    reportsListToDisplay: Array<StudentReport>,
    setReportsListToDisplay(reportsListToDisplay: Array<StudentReport>): void,
    updatedReportsListToDisplay: boolean,
    setUpdatedReportsListToDisplay(updatedReportsListToDisplay: boolean): void
}

const FilteringBar = ({
                          reportsListToDisplay,
                          setReportsListToDisplay,
                          updatedReportsListToDisplay,
                          setUpdatedReportsListToDisplay
                      }: Props) => {

    return (
        <Row className="no-padding-left filtering-bar flex-grow-1 d-flex flex-row align-items-center mb-3">
            <Col xl={3} md={3} sm={6} className="no-padding-left me-2">
                <SearchByTeachingProjectFilter reportsListToDisplay={reportsListToDisplay}
                                               setReportsListToDisplay={setReportsListToDisplay}
                                               updatedReportsListToDisplay={updatedReportsListToDisplay}
                                               setUpdatedReportsListToDisplay={setUpdatedReportsListToDisplay}/>
            </Col>
        </Row>
    );
}

export default FilteringBar;
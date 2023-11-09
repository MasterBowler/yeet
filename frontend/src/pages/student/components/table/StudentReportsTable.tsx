import React, {useState} from "react";
import StudentReportsTableHeader from "./StudentReportsTableHeader";
import FilteringBar from "./filtering/FilteringBar";
import DownloadIcon from "../../../../utils/resources/icon/DownloadIcon";
import EditIcon from "../../../../utils/resources/icon/EditIcon";
import DeleteIcon from "../../../../utils/resources/icon/DeleteIcon";
import {StudentReport} from "../../../../common/model/StudentReport";
import {Button, Col, Container, Row} from "react-bootstrap";
import IconArrow from "../../../../utils/resources/icon/IconArrow";

type Props = {
    reportsList: Array<StudentReport>
}

const StudentReportsTable = ({reportsList}: Props) => {

    const [reportsListToDisplay, setReportsListToDisplay] = useState<Array<StudentReport>>(reportsList);
    const [updatedReportsListToDisplay, setUpdatedReportsListToDisplay] = useState(false);
    const [expandedRows, setExpandedRows] = useState<string[]>([]);

    const handleExpandRow = (event: any, reportId: string) => {

        const currentExpandedRows = expandedRows;
        const isRowExpanded = currentExpandedRows.includes(reportId);

        const newExpandedRows = isRowExpanded ?
            currentExpandedRows.filter(id => id !== reportId) :
            currentExpandedRows.concat(reportId);

        setExpandedRows(newExpandedRows);

        const rowToExpand = event.target.closest(".table-row");
        rowToExpand.classList.toggle("row-with-expanded-details");
    }

    const getButtonToExpandRow = (reportId: string) => {

        return (
            <Button
                className="btn-expand"
                variant="link"
                onClick={(event: any) => handleExpandRow(event, reportId)}>
                <IconArrow/>
            </Button>
        );
    }

    const getDownloadPdfFromReportButton = (report: StudentReport) => {

        return (
            <Button className="button mt-0"
                        variant="link"
                        onClick={() => console.log("download student report " + report.id)}>
                <DownloadIcon/>
            </Button>);
    }

    const getDeleteReportButton = (report: StudentReport) => {

        return (
            <Button className="button mt-0"
                        variant="link"
                        onClick={() => console.log("delete student report " + report.id)}>
                <DeleteIcon/>
            </Button>);
    }

    const getEditReportButton = (report: StudentReport) => {

        return (
            <Button className="button mt-0"
                    variant="link"
                    onClick={() => window.open("/student-report-form/" + report.id)}>
                <EditIcon/>
            </Button>);
    }

    const getControls = (report: StudentReport) => {

        return <div className={"d-flex flex-direction-row gap-4"} style={{textAlign: "left"}}>
            {getDownloadPdfFromReportButton(report)}
            {getEditReportButton(report)}
            {getDeleteReportButton(report)}
        </div>;
    }

    const displayReportDetailsRow = (report: StudentReport) => {

        return (
            <tr className="table-row expanded-details">
                <td colSpan={8} role="cell"
                    className="Table-body-cell details-cell">
                    <Container fluid className="mt-1 mb-3 details-box">
                        <Row>
                            <Col xs={12} md={4} className="mb-3">
                                <div className="details-label mb-1">Extracurriculars</div>
                                <div className="details-text">
                                    <strong>
                                        {report.extracurriculars}
                                    </strong>
                                </div>
                            </Col>
                            <Col xs={12} md={4} className="mb-3">
                                <div className="details-label mb-1">Portfolio
                                </div>
                                <div className="details-text">
                                    {report.portfolio}
                                </div>
                            </Col>
                            <Col xs={12} md={4} className="mb-3">
                                <div className="details-label mb-1">Timeframe</div>
                                <div className="details-text">
                                    {report.timeframe}
                                </div>
                            </Col>
                        </Row>
                        <Row>
                            <Col xs={12} md={4} className="mb-3">
                                <div className="details-label mb-1">Transportation Means</div>
                                <div className="details-text">
                                    {report.transportationMeans}
                                </div>
                            </Col>
                            <Col xs={12} md={4} className="mb-3">
                                <div className="details-label mb-1">Workshop
                                </div>
                                <div className="details-text">
                                    {report.workshop}
                                </div>
                            </Col>
                        </Row>
                        <Row>
                            <Col className="d-flex justify-content-end">
                                {getControls(report)}
                            </Col>
                        </Row>
                    </Container>
                </td>
            </tr>
        );
    }

    const displayTable = () => {

        return (
            <div>
                <FilteringBar reportsListToDisplay={reportsList}
                              setReportsListToDisplay={setReportsListToDisplay}
                              updatedReportsListToDisplay={updatedReportsListToDisplay}
                              setUpdatedReportsListToDisplay={setUpdatedReportsListToDisplay}/>
                <table className={"table"}>
                    <StudentReportsTableHeader reportsListToDisplay={reportsListToDisplay}
                                               setReportsListToDisplay={setReportsListToDisplay}
                                               updatedReportsListToDisplay={updatedReportsListToDisplay}
                                               setUpdatedReportsListToDisplay={setUpdatedReportsListToDisplay}/>
                    <tbody>
                    {
                        reportsListToDisplay?.map((report, index) => {

                            return (
                                <React.Fragment key={index}>
                                    <tr key={index} className={"table-row"}>
                                        <td className={"table-body-cell"}>{report.id}</td>
                                        <td className={"table-body-cell"}>{report.teachingProject}</td>
                                        <td className={"table-body-cell"}><strong>{report.assistance}</strong></td>
                                        <td className={"table-body-cell"}>{report.month}, {report.date.toLocaleDateString()}</td>
                                        <td className={"table-body-cell"}>
                                            <div className="d-flex justify-content-end">
                                                {getButtonToExpandRow(report.id.toString())}
                                            </div>
                                        </td>
                                    </tr>
                                    <>
                                        {
                                            expandedRows.includes(report.id.toString()) ?
                                                displayReportDetailsRow(report) :
                                                null
                                        }
                                    </>
                                </React.Fragment>
                            );
                        })
                    }
                    </tbody>
                </table>
            </div>
        );
    }

    return (
        <>{displayTable()}</>
    );
}

export default StudentReportsTable;
import React from "react";
import {Button} from "react-bootstrap";
import SortIcon from "../../../../utils/resources/icon/SortIcon";
import {StudentReport} from "../../../../common/model/StudentReport";

type Props = {
    reportsListToDisplay: Array<StudentReport>,
    setReportsListToDisplay(reportsListToDisplay: Array<StudentReport>): void,
    updatedReportsListToDisplay: boolean,
    setUpdatedReportsListToDisplay(updatedReportsListToDisplay: boolean): void
}

const StudentReportsTableHeader = ({
                                       reportsListToDisplay,
                                       setReportsListToDisplay,
                                       updatedReportsListToDisplay,
                                       setUpdatedReportsListToDisplay
                            }: Props) => {

    const updateTableWithSortedReportsList = (sortedReportsList: Array<any>, event: any) => {

        setReportsListToDisplay(sortedReportsList);
        setUpdatedReportsListToDisplay(!updatedReportsListToDisplay);

        const button = event.target;
        const iconToRotate = button.querySelector(".icon-sort");
        iconToRotate.classList.toggle("inverted");
    }

    const handleSortReportsListByDate = (event: any) => {

        const getSortedReportsByDate = () => {

            return updatedReportsListToDisplay ?
                reportsListToDisplay.sort(
                    (firstReport, secondReport) => {
                        return firstReport.date < secondReport.date ?
                            -1 : 1;
                    }) :
                reportsListToDisplay.sort(
                    (firstReport, secondReport) => {
                        return firstReport.date > secondReport.date ?
                            -1 : 1;
                    });
        }
        const sortedReportsListByDate = getSortedReportsByDate();
        setUpdatedReportsListToDisplay(!updatedReportsListToDisplay);
        updateTableWithSortedReportsList(sortedReportsListByDate, event);
    }

    return (
        <thead>
        <tr className={"table-header"}>
            <th className={"table-header-cell th-dimension"}>Id</th>
            <th className={"table-header-cell th-dimension"}>Teaching Project</th>
            <th className={"table-header-cell th-dimension"}>Assistance</th>
            <th className={"table-header-cell th-dimension"}>
                <Button
                    id="sort-by-date"
                    className="Table-header-cell btn-sort"
                    style={{textAlign: "left"}}
                    variant="link"
                    onClick={handleSortReportsListByDate}>
                    Month / Date
                    <SortIcon/>
                </Button>
            </th>
            <th className={"table-header-cell th-dimension"}></th>
        </tr>
        </thead>
    );
}

export default StudentReportsTableHeader;
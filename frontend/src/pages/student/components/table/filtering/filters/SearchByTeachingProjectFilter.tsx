import React from "react";
import {StudentReport} from "../../../../../../common/model/StudentReport";

type Props = {
    reportsListToDisplay: Array<StudentReport>,
    setReportsListToDisplay(reportsListToDisplay: Array<StudentReport>): void,
    updatedReportsListToDisplay: boolean,
    setUpdatedReportsListToDisplay(updatedReportsListToDisplay: boolean): void
}

const SearchByTeachingProjectFilter = ({
                                           reportsListToDisplay,
                                           setReportsListToDisplay,
                                           updatedReportsListToDisplay,
                                           setUpdatedReportsListToDisplay
                                       }: Props) => {

    const handleSearchStudentReportsByProject = (query: string) => {

        const foundReports = reportsListToDisplay.filter(report => query === "" || report.teachingProject.toLowerCase().includes(query.toLowerCase()));

        setReportsListToDisplay(foundReports);
        setUpdatedReportsListToDisplay(!updatedReportsListToDisplay);
    }

    return (
        <div className="form-field">
            <input
                placeholder={"Search by project..."}
                className={"form-control"}
                defaultValue={undefined}
                aria-label={"student-reports-search-by-project-filter"}
                onChange={event => {
                    handleSearchStudentReportsByProject(event.target.value)
                }}
            />
        </div>
    );
}

export default SearchByTeachingProjectFilter;

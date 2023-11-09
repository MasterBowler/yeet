import React from "react";
import {HighschoolProfessorReport} from "../../../../../../common/model/HighschoolProfessorReport";

type Props = {
    reportsListToDisplay: Array<HighschoolProfessorReport>,
    setReportsListToDisplay(reportsListToDisplay: Array<HighschoolProfessorReport>): void,
    updatedReportsListToDisplay: boolean,
    setUpdatedReportsListToDisplay(updatedReportsListToDisplay: boolean): void
}

const SearchBySidFilter = ({
                                           reportsListToDisplay,
                                           setReportsListToDisplay,
                                           updatedReportsListToDisplay,
                                           setUpdatedReportsListToDisplay
                                       }: Props) => {

    const handleSearchHighschoolProfessorReportsByProject = (query: string) => {

        const foundReports = reportsListToDisplay.filter(report => query === "" || report.sid.toLowerCase().includes(query.toLowerCase()));

        setReportsListToDisplay(foundReports);
        setUpdatedReportsListToDisplay(!updatedReportsListToDisplay);
    }

    return (
        <div className="form-field">
            <input
                placeholder={"Search by SID..."}
                className={"form-control"}
                defaultValue={undefined}
                aria-label={"hs-professor-reports-search-by-sid-filter"}
                onChange={event => {
                    handleSearchHighschoolProfessorReportsByProject(event.target.value)
                }}
            />
        </div>
    );
}

export default SearchBySidFilter;

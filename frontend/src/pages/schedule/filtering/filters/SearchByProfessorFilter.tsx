import React from "react";
import {ClassSchedule} from "../../../../common/model/ClassSchedule";

type Props = {

    classesListToDisplay: Array<ClassSchedule>,
    setClassesListToDisplay(classesListToDisplay: Array<ClassSchedule>): void,
    updatedClassesListToDisplay: boolean,
    setUpdatedClassesListToDisplay(updatedClassesListToDisplay: boolean): void
}

const SearchByProfessorFilter = ({
                                     classesListToDisplay,
                                     setClassesListToDisplay,
                                     updatedClassesListToDisplay,
                                     setUpdatedClassesListToDisplay
                                 }: Props) => {

    const handleSearchClassesByProfessor = (query: string) => {

        const foundClasses = classesListToDisplay.filter(classSchedule => query === "" || classSchedule.coordinatorName.toLowerCase().includes(query.toLowerCase()));

        setClassesListToDisplay(foundClasses);
        setUpdatedClassesListToDisplay(!updatedClassesListToDisplay);
    }

    return (
        <div className="form-field">
            <input
                className="form-control"
                aria-describedby="inputGroup-sizing-default"
                id="classes-search-by-professor-filter"
                placeholder={"Search by professor..."}
                onChange={event => {
                    handleSearchClassesByProfessor(event.target.value);
                }
                }
            />
        </div>
    );
}

export default SearchByProfessorFilter;

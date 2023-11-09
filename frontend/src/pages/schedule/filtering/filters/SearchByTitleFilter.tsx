import React from "react";
import {ClassSchedule} from "../../../../common/model/ClassSchedule";

type Props = {

    classesListToDisplay: Array<ClassSchedule>,
    setClassesListToDisplay(classesListToDisplay: Array<ClassSchedule>): void,
    updatedClassesListToDisplay: boolean,
    setUpdatedClassesListToDisplay(updatedClassesListToDisplay: boolean): void
}

const SearchByTitleFilter = ({
                                 classesListToDisplay,
                                 setClassesListToDisplay,
                                 updatedClassesListToDisplay,
                                 setUpdatedClassesListToDisplay
                             }: Props) => {

    const handleSearchClassesByTitle = (query: string) => {

        const foundClasses = classesListToDisplay.filter(classSchedule => query === "" || classSchedule.className.toLowerCase().includes(query.toLowerCase()));

        setClassesListToDisplay(foundClasses);
        setUpdatedClassesListToDisplay(!updatedClassesListToDisplay);
    }

    return (
        <div className="form-field">
            <input
                className="form-control"
                aria-describedby="inputGroup-sizing-default"
                id="classes-search-by-title-filter"
                placeholder={"Search by title..."}
                onChange={event => {
                    handleSearchClassesByTitle(event.target.value);
                }
                }
            />
        </div>
    );
}

export default SearchByTitleFilter;

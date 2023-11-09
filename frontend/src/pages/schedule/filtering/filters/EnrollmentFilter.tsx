import React, {useState} from "react";
import Select from "react-select";
import {ClassSchedule} from "../../../../common/model/ClassSchedule";

type Props = {
    classesListToDisplay: Array<ClassSchedule>,
    setClassesListToDisplay(classesListToDisplay: Array<ClassSchedule>): void,
    updatedClassesListToDisplay: boolean,
    setUpdatedClassesListToDisplay(updatedClassesListToDisplay: boolean): void
}

const EnrollmentFilter = ({
                              classesListToDisplay,
                              setClassesListToDisplay,
                              updatedClassesListToDisplay,
                              setUpdatedClassesListToDisplay
                          }: Props) => {

    const options = [
        {value: "All", label: "-- all --"},
        {value: "Can enroll", label: "Can enroll"},
        {value: "Cannot enroll", label: "Cannot enroll"}
    ];

    const initialFilterValue = "Enrollment";
    const [placeholderText, setPlaceholderText] = useState(initialFilterValue);

    const handleFilterClassesByEnrollment = (selectedOption: string) => {

        selectedOption === options[0].value ?
            setPlaceholderText(initialFilterValue) :
            setPlaceholderText(selectedOption);

        let foundClasses = classesListToDisplay;

        switch (selectedOption) {

            case options[1].value: {

                foundClasses = classesListToDisplay.filter(classSchedule => (classSchedule.attendance < classSchedule.maximumAttendance) && (classSchedule.startDateAndTime >= new Date()));
                break;
            }
            case options[2].value: {

                foundClasses = classesListToDisplay.filter(classSchedule => (classSchedule.attendance >= classSchedule.maximumAttendance) || (classSchedule.startDateAndTime < new Date()));
                break;
            }
            case options[0].value: {

                foundClasses = classesListToDisplay;
            }
        }

        setClassesListToDisplay(foundClasses);
        setUpdatedClassesListToDisplay(!updatedClassesListToDisplay);
    }

    return (
        <Select
            isMulti={false}
            isSearchable={false}
            id="classes-enrollment-filter"
            name="enrollment-type"
            placeholder={placeholderText}
            options={options}
            value={null}
            className="basic-multi-select"
            onChange={(event: any) => {
                handleFilterClassesByEnrollment(event.value)
            }}
        />
    );
}

export default EnrollmentFilter;
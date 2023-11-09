import React, {useState} from "react";
import Select from "react-select";
import {ClassSchedule} from "../../../../common/model/ClassSchedule";

type Props = {
    classesListToDisplay: Array<ClassSchedule>,
    setClassesListToDisplay(classesListToDisplay: Array<ClassSchedule>): void,
    updatedClassesListToDisplay: boolean,
    setUpdatedClassesListToDisplay(updatedClassesListToDisplay: boolean): void
}

const PeriodFilter = ({
                          classesListToDisplay,
                          setClassesListToDisplay,
                          updatedClassesListToDisplay,
                          setUpdatedClassesListToDisplay
                      }: Props) => {

    const options = [
        {value: "All", label: "-- all --"},
        {value: "Future", label: "Future"},
        {value: "Current", label: "Current"},
        {value: "Past", label: "Past"}
    ];

    const initialFilterValue = "Period";
    const [placeholderText, setPlaceholderText] = useState(initialFilterValue);

    const currentDate = new Date();

    const handleFilterClassesByPeriod = (selectedOption: string) => {

        selectedOption === options[0].value ?
            setPlaceholderText(initialFilterValue) :
            setPlaceholderText(selectedOption);

        let foundClasses = classesListToDisplay;

        switch (selectedOption) {

            case options[3].value: {

                foundClasses = classesListToDisplay.filter(classSchedule => classSchedule.startDateAndTime.getTime() < Date.now());
                break;
            }
            case options[2].value: {

                foundClasses = classesListToDisplay.filter(classSchedule => (classSchedule.startDateAndTime.getTime() >= currentDate.getTime()) &&
                    (classSchedule.startDateAndTime.getTime() <= (currentDate.setMonth(currentDate.getMonth() + 1))));
                break;
            }
            case options[1].value: {

                foundClasses = classesListToDisplay.filter(classSchedule => classSchedule.startDateAndTime.getTime() > (currentDate.setMonth(currentDate.getMonth() + 1)));
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
            id="classes-period-filter"
            name="period-type"
            placeholder={placeholderText}
            options={options}
            value={null}
            className="basic-multi-select"
            onChange={(event: any) => {
                handleFilterClassesByPeriod(event.value)
            }}
        />
    );
}

export default PeriodFilter;
import {ClassSchedule} from "../../common/model/ClassSchedule";

const classSchedule1: ClassSchedule = {

    id: 1,
    className: "Computer Science",
    coordinatorName: "Prof. Emanuela Cerchez",
    startDateAndTime: new Date("December 17, 2023 03:24:00"),
    endDateAndTime: new Date("December 17, 2023 04:24:00"),
    description: "This class will cover the subject of dynamic programming and will touch several classic problems. " +
        "For this class please bring a personal laptop with CodeBlocks installed and USB port for the video projector.",
    attendance: 2,
    maximumAttendance: 7
}

const classSchedule2: ClassSchedule = {

    id: 2,
    className: "Computer Science",
    coordinatorName: "Prof. Mihai Chelariu",
    startDateAndTime: new Date("June 5, 2023 03:24:00"),
    endDateAndTime: new Date("June 5, 2023 04:24:00"),
    attendance: 7,
    maximumAttendance: 7
}

const classSchedule3: ClassSchedule = {

    id: 3,
    className: "Computer Science",
    coordinatorName: "Prof. Emanuela Cerchez",
    startDateAndTime: new Date("June 7, 2023 03:24:00"),
    endDateAndTime: new Date("June 7, 2023 04:24:00"),
    description: "This class will cover the subject of OOP programming and will touch several OOP Design Patterns. " +
        "For this class please bring a personal laptop with CodeBlocks installed and USB port for the video projector.",
    attendance: 0,
    maximumAttendance: 2
}

const classSchedule4: ClassSchedule = {

    id: 4,
    className: "Mathematics",
    coordinatorName: "Prof. Doru Buzac",
    startDateAndTime: new Date("December 17, 2022 03:24:00"),
    endDateAndTime: new Date("December 17, 2022 04:24:00"),
    description: "This class will cover the subject of equations with simple integrals. " +
        "For this class thw whiteboard will be used, no laptop needed.",
    attendance: 2,
    maximumAttendance: 3
}

export {
    classSchedule1, classSchedule2, classSchedule3, classSchedule4
}
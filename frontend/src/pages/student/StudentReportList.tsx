import {StudentReport} from "../../common/model/StudentReport";

const studentReport1: StudentReport = {

    id: 1,
    month: "January",
    transportationMeans: "Bus",
    assistance: "Prof. Emanuela Cerchez",
    date: new Date(),
    extracurriculars: "CEX - Racovita",
    portfolio: "DP Homework, Backpack Problem Homework",
    teachingProject: "Programming Problems",
    timeframe: "January, 10th - January, 17th",
    workshop: "none"
}

const studentReport4: StudentReport = {

    id: 4,
    month: "February",
    transportationMeans: "Bus",
    assistance: "Prof. Emanuela Cerchez",
    date: new Date(),
    extracurriculars: "OOP",
    portfolio: "OOP Homework 1, OOP Homework 2",
    teachingProject: "OOP Principles",
    timeframe: "February, 10th - February, 17th",
    workshop: "none"
}

const studentReport2: StudentReport = {

    id: 2,
    month: "March",
    transportationMeans: "Bus",
    assistance: "Prof. Emanuela Cerchez",
    date: new Date(),
    extracurriculars: "OOP",
    portfolio: "OOP Homework 1, OOP Homework 2",
    teachingProject: "OOP Principles",
    timeframe: "March, 10th - March, 17th",
    workshop: "none"
}

const studentReport3: StudentReport = {

    id: 3,
    month: "May",
    transportationMeans: "Bus",
    assistance: "Prof. Doru Buzac",
    date: new Date("December 17, 2022 03:24:00"),
    extracurriculars: "Advanced Math",
    portfolio: "none",
    teachingProject: "Medium-level Algebra",
    timeframe: "May, 10th - May, 17th",
    workshop: "none"
}

export {
    studentReport1, studentReport2, studentReport3, studentReport4
}
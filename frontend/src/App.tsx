import React from 'react';
import {Provider} from "jotai";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";

import DashboardPage from "./pages/dashboard/DashboardPage";
import HighschoolProfessorFormPage from "./pages/highschool-professor/HighschoolProfessorFormPage";
import HighschoolProfessorReportsPage from "./pages/highschool-professor/HighschoolProfessorReportsPage";
import LoginPage from "./pages/authentication/LoginPage";
import RegisterPage from "./pages/authentication/RegisterPage";
import ScheduleFormPage from "./pages/schedule/ScheduleFormPage";
import SchedulePage from "./pages/schedule/SchedulePage";
import StudentReportFormPage from "./pages/student/StudentReportFormPage";
import StudentReportsPage from "./pages/student/StudentReportsPage";
import UserProfilePage from "./pages/authentication/UserProfilePage";

import "./utils/css/typography.css";
import "./utils/css/styles.css";
import "./utils/css/paddings.css";
import "./utils/css/forms.css";
import "./utils/css/table.css";

function App() {

    return (
        <Provider>
            <Router>
                <Routes>
                    <Route path={"login"} element={<LoginPage/>}/>
                    <Route path={"register"} element={<RegisterPage/>}/>

                    <Route index element={<DashboardPage/>}/>
                    <Route path={"highschool-professor-form/:id"} element={<HighschoolProfessorFormPage/>}/>
                    <Route path={"highschool-professor-reports"} element={<HighschoolProfessorReportsPage/>}/>
                    <Route path={"schedule-form/:id"} element={<ScheduleFormPage/>}/>
                    <Route path={"schedule"} element={<SchedulePage/>}/>
                    <Route path={"student-report-form/:id"} element={<StudentReportFormPage/>}/>
                    <Route path={"student-reports"} element={<StudentReportsPage/>}/>
                    <Route path={"user-profile"} element={<UserProfilePage/>}/>
                </Routes>
            </Router>
        </Provider>
    );
}

export default App;

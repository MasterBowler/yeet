import React, {useState} from "react";
import {Button, Col, Row} from "react-bootstrap";
import RegularInputField from "../../../../common/form/RegularInputField";
import {useAtom} from "jotai";
import {userAtom} from "../../../../common/atom/UserAtom";
import {studentAtom} from "../../../../common/atom/StudentAtom";

const StudentProfile = () => {

    const [currentUser,] = useAtom(userAtom);
    const [currentStudent,] = useAtom(studentAtom);

    const [emailAddress, setEmailAddress] = useState<string>(currentUser && currentUser.emailAddress ? currentUser.emailAddress : "");
    const [firstName, setFirstName] = useState<string>(currentUser && currentUser.firstName ? currentUser.firstName : "");
    const [lastName, setLastName] = useState<string>(currentUser && currentUser.lastName ? currentUser.lastName : "");
    const [password, setPassword] = useState<string>(currentUser && currentUser.passwordHash ? currentUser.passwordHash : "");
    const [phoneNumber, setPhoneNumber] = useState<string>(currentUser && currentUser.phoneNumber ? currentUser.phoneNumber : "");
    const [degreeName, setDegreeName] = useState<string>(currentStudent && currentStudent.degreeName ? currentStudent.degreeName : "");
    const [groupCode, setGroupCode] = useState<string>(currentStudent && currentStudent.degreeName ? currentStudent.degreeName : "");
    const [sid, setSid] = useState<string>(currentStudent && currentStudent.degreeName ? currentStudent.degreeName : "");
    const [specialtyName, setSpecialtyName] = useState<string>(currentStudent && currentStudent.specialtyName ? currentStudent.specialtyName : "");
    const [universityName, setUniversityName] = useState<string>(currentStudent && currentStudent.universityName ? currentStudent.universityName : "");
    const [year, setYear] = useState<string>(currentStudent && currentStudent.year ? currentStudent.year : "");

    const [message, setMessage] = useState<string>();

    const handleUpdateStudentInfo = () => {

        setMessage("update student info")
        console.log(message);
    }

    return (
        <Row>
            <div className={"form-field mb-3"}>
                <Col className="no-padding-left mb-2">
                    <h5 className={"skin-color"}><strong>Update your Info</strong></h5>
                </Col>
                <Row>
                    <Col className="d-flex gap-4 no-padding-left no-padding-right mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"E-mail Address"} fieldValue={emailAddress}
                                           setFieldValue={setEmailAddress}
                                           fieldAreaLabel={"emailAddress"}/>
                        <RegularInputField fieldName={"Password"} fieldValue={password}
                                           setFieldValue={setPassword}
                                           fieldAreaLabel={"password"}
                                           isHidden={true}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left no-padding-right mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"First Name"} fieldValue={firstName}
                                           setFieldValue={setFirstName}
                                           fieldAreaLabel={"firstName"}/>
                        <RegularInputField fieldName={"Last Name"} fieldValue={lastName}
                                           setFieldValue={setLastName}
                                           fieldAreaLabel={"lastName"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left no-padding-right mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"Phone Number"} fieldValue={phoneNumber}
                                           setFieldValue={setPhoneNumber}
                                           fieldAreaLabel={"phoneNumber"}/>
                        <RegularInputField fieldName={"SID"} fieldValue={sid}
                                           setFieldValue={setSid}
                                           fieldAreaLabel={"sid"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left no-padding-right mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"University Name"} fieldValue={universityName}
                                           setFieldValue={setUniversityName}
                                           fieldAreaLabel={"universityName"}/>
                        <RegularInputField fieldName={"Degree Name"} fieldValue={degreeName}
                                           setFieldValue={setDegreeName}
                                           fieldAreaLabel={"degreeName"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left no-padding-right mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"Year"} fieldValue={year}
                                           setFieldValue={setYear}
                                           fieldAreaLabel={"year"}/>
                        <RegularInputField fieldName={"Group Code"} fieldValue={groupCode}
                                           setFieldValue={setGroupCode}
                                           fieldAreaLabel={"groupCode"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left no-padding-right mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"Specialty Name"} fieldValue={specialtyName}
                                           setFieldValue={setSpecialtyName}
                                           fieldAreaLabel={"specialtyName"}/>
                    </Col>

                    <Col className="no-padding-left no-padding-right d-flex justify-content-end">
                        <Button
                            className="button"
                            variant="primary"
                            onClick={() => handleUpdateStudentInfo()}>
                            Save Changes
                        </Button>
                    </Col>
                </Row>
                <Row className="no-padding-left">
                    <Col className="no-padding-left no-padding-right">
                        {
                            message && (
                                <div className="form-group">
                                    <div
                                        className="alert alert-success d-flex justify-content-center"
                                        role="alert">
                                        {message}
                                    </div>
                                </div>
                            )
                        }
                    </Col>
                </Row>
            </div>
        </Row>);
};

export default StudentProfile;
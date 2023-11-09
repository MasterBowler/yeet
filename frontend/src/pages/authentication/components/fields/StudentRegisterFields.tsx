import React, {useState} from "react";
import {Button, Col, Row} from "react-bootstrap";
import RegularInputField from "../../../../common/form/RegularInputField";
import {useAtom} from "jotai";
import {userAtom} from "../../../../common/atom/UserAtom";
import {studentAtom} from "../../../../common/atom/StudentAtom";
import {highschoolProfessorAtom} from "../../../../common/atom/HighschoolProfessorAtom";

const StudentRegisterFields = () => {

    const [emailAddress, setEmailAddress] = useState<string>();
    const [firstName, setFirstName] = useState<string>();
    const [lastName, setLastName] = useState<string>();
    const [password, setPassword] = useState<string>();
    const [phoneNumber, setPhoneNumber] = useState<string>();
    const [degreeName, setDegreeName] = useState<string>();
    const [groupCode, setGroupCode] = useState<string>();
    const [sid, setSid] = useState<string>();
    const [specialtyName, setSpecialtyName] = useState<string>();
    const [universityName, setUniversityName] = useState<string>();
    const [year, setYear] = useState<string>();

    const [message, setMessage] = useState<string>();

    const [, setCurrentUser] = useAtom(userAtom);
    const [, setCurrentStudent] = useAtom(studentAtom);
    const [, setCurrentHighschoolProfessor] = useAtom(highschoolProfessorAtom);

    const handleRegisterStudent = () => {

        setMessage("registerStudent")

        setCurrentUser({
            id: 15,
            emailAddress: emailAddress,
            firstName: firstName,
            lastName: lastName,
            creationDate: new Date(),
            passwordHash: password,
            groupName: "Student",
            phoneNumber: phoneNumber
        });

        setCurrentStudent({
            sid: sid,
            universityName: universityName,
            degreeName: degreeName,
            year: year,
            groupCode: groupCode,
            specialtyName: specialtyName
        });

        setCurrentHighschoolProfessor(undefined);
    }

    return (
        <Row>
            <div className={"form-field mb-3"}>
                <Col className="no-padding-left mb-2 d-flex justify-content-center">
                    <p className={"skin-color"}><strong>Student Details</strong></p>
                </Col>
                <Row>
                    <Col className="d-flex gap-4 no-padding-left mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"E-mail Address"} fieldValue={""}
                                           setFieldValue={setEmailAddress}
                                           fieldAreaLabel={"emailAddress"}/>
                        <RegularInputField fieldName={"Password"} fieldValue={""}
                                           setFieldValue={setPassword}
                                           fieldAreaLabel={"password"}
                                           isHidden={true}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"First Name"} fieldValue={""}
                                           setFieldValue={setFirstName}
                                           fieldAreaLabel={"firstName"}/>
                        <RegularInputField fieldName={"Last Name"} fieldValue={""}
                                           setFieldValue={setLastName}
                                           fieldAreaLabel={"lastName"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"Phone Number"} fieldValue={""}
                                           setFieldValue={setPhoneNumber}
                                           fieldAreaLabel={"phoneNumber"}/>
                        <RegularInputField fieldName={"SID"} fieldValue={""}
                                           setFieldValue={setSid}
                                           fieldAreaLabel={"sid"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"University Name"} fieldValue={""}
                                           setFieldValue={setUniversityName}
                                           fieldAreaLabel={"universityName"}/>
                        <RegularInputField fieldName={"Degree Name"} fieldValue={""}
                                           setFieldValue={setDegreeName}
                                           fieldAreaLabel={"degreeName"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"Year"} fieldValue={""}
                                           setFieldValue={setYear}
                                           fieldAreaLabel={"year"}/>
                        <RegularInputField fieldName={"Group Code"} fieldValue={""}
                                           setFieldValue={setGroupCode}
                                           fieldAreaLabel={"groupCode"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"Specialty Name"} fieldValue={""}
                                           setFieldValue={setSpecialtyName}
                                           fieldAreaLabel={"specialtyName"}/>
                    </Col>

                    <Col className="no-padding-left no-padding-right d-flex justify-content-center">
                        <Button
                            className="button"
                            variant="primary"
                            onClick={() => handleRegisterStudent()}>
                            Register
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
        </Row>
    );
}

export default StudentRegisterFields;

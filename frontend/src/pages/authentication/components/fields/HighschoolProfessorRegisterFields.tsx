import React, {useState} from "react";
import {Button, Col, Row} from "react-bootstrap";
import RegularInputField from "../../../../common/form/RegularInputField";
import {useAtom} from "jotai";
import {userAtom} from "../../../../common/atom/UserAtom";
import {studentAtom} from "../../../../common/atom/StudentAtom";
import {highschoolProfessorAtom} from "../../../../common/atom/HighschoolProfessorAtom";

const HighschoolProfessorRegisterFields = () => {

    const [emailAddress, setEmailAddress] = useState<string>();
    const [firstName, setFirstName] = useState<string>();
    const [lastName, setLastName] = useState<string>();
    const [password, setPassword] = useState<string>();
    const [phoneNumber, setPhoneNumber] = useState<string>();
    const [highschoolName, setHighschoolName] = useState<string>();
    const [teachingDegree, setTeachingDegree] = useState<string>();
    const [startDate, setStartDate] = useState<string>();

    const [message, setMessage] = useState<string>();

    const [, setCurrentUser] = useAtom(userAtom);
    const [, setCurrentStudent] = useAtom(studentAtom);
    const [, setCurrentHighschoolProfessor] = useAtom(highschoolProfessorAtom);

    const handleRegisterHighschoolProfessor = () => {

        setMessage("registerHighschoolProfessor")

        setCurrentUser({
            id: 15,
            emailAddress: emailAddress,
            firstName: firstName,
            lastName: lastName,
            creationDate: new Date(),
            passwordHash: password,
            groupName: "Highschool Professor",
            phoneNumber: phoneNumber
        });

        setCurrentStudent(undefined);

        setCurrentHighschoolProfessor({
            highschoolName: highschoolName,
            teachingDegree: teachingDegree,
            startDate: new Date()
        });
    }

    return (
        <Row>
            <div className={"form-field mb-3"}>
                <Col className="no-padding-left mb-2 d-flex justify-content-center">
                    <p className={"skin-color"}><strong>Highschool Professor Details</strong></p>
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
                    <Col className="d-flex gap-4 no-padding-left mb-3" md={6} xs={{span: 12}}>
                        <RegularInputField fieldName={"Phone Number"} fieldValue={""}
                                           setFieldValue={setPhoneNumber}
                                           fieldAreaLabel={"phoneNumber"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"Highschool Name"} fieldValue={""}
                                           setFieldValue={setHighschoolName}
                                           fieldAreaLabel={"highschoolName"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"Teaching Degree"} fieldValue={""}
                                           setFieldValue={setTeachingDegree}
                                           fieldAreaLabel={"teachingDegree"}/>
                        <RegularInputField fieldName={"Start Date"} fieldValue={""}
                                           setFieldValue={setStartDate}
                                           fieldAreaLabel={"startDate"}/>
                    </Col>

                    <Col className="no-padding-left no-padding-right  d-flex justify-content-center">
                        <Button
                            className="button"
                            variant="primary"
                            onClick={() => handleRegisterHighschoolProfessor()}>
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

export default HighschoolProfessorRegisterFields;

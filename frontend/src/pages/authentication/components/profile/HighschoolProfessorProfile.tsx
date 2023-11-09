import React, {useState} from "react";
import {Button, Col, Row} from "react-bootstrap";
import RegularInputField from "../../../../common/form/RegularInputField";
import {useAtom} from "jotai";
import {userAtom} from "../../../../common/atom/UserAtom";
import {highschoolProfessorAtom} from "../../../../common/atom/HighschoolProfessorAtom";

const HighschoolProfessorProfile = () => {

    const [currentUser,] = useAtom(userAtom);
    const [currentHighschoolProfessor,] = useAtom(highschoolProfessorAtom);

    const [emailAddress, setEmailAddress] = useState<string>(currentUser && currentUser.emailAddress ? currentUser.emailAddress : "");
    const [firstName, setFirstName] = useState<string>(currentUser && currentUser.firstName ? currentUser.firstName : "");
    const [lastName, setLastName] = useState<string>(currentUser && currentUser.lastName ? currentUser.lastName : "");
    const [password, setPassword] = useState<string>(currentUser && currentUser.passwordHash ? currentUser.passwordHash : "");
    const [phoneNumber, setPhoneNumber] = useState<string>(currentUser && currentUser.phoneNumber ? currentUser.phoneNumber : "");
    const [highschoolName, setHighschoolName] = useState<string>(currentHighschoolProfessor && currentHighschoolProfessor.highschoolName ? currentHighschoolProfessor.highschoolName : "");
    const [teachingDegree, setTeachingDegree] = useState<string>(currentHighschoolProfessor && currentHighschoolProfessor.teachingDegree ? currentHighschoolProfessor.teachingDegree : "");
    const [startDate, setStartDate] = useState<string>(currentHighschoolProfessor && currentHighschoolProfessor.startDate ? currentHighschoolProfessor.startDate.toLocaleString() : "");

    const [message, setMessage] = useState<string>();

    const handleUpdateHighschoolProfessorInfo = () => {

        setMessage("update highschool prof info")
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
                    <Col className="d-flex gap-4 no-padding-left no-padding-right mb-3" md={6} xs={{span: 12}}>
                        <RegularInputField fieldName={"Phone Number"} fieldValue={phoneNumber}
                                           setFieldValue={setPhoneNumber}
                                           fieldAreaLabel={"phoneNumber"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left no-padding-right mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"Highschool Name"} fieldValue={highschoolName}
                                           setFieldValue={setHighschoolName}
                                           fieldAreaLabel={"highschoolName"}/>
                    </Col>
                    <Col className="d-flex gap-4 no-padding-left no-padding-right mb-3" xs={{span: 12}}>
                        <RegularInputField fieldName={"Teaching Degree"} fieldValue={teachingDegree}
                                           setFieldValue={setTeachingDegree}
                                           fieldAreaLabel={"teachingDegree"}/>
                        <RegularInputField fieldName={"Start Date"} fieldValue={startDate}
                                           setFieldValue={setStartDate}
                                           fieldAreaLabel={"startDate"}/>
                    </Col>

                    <Col className="no-padding-left no-padding-right  d-flex justify-content-end">
                        <Button
                            className="button"
                            variant="primary"
                            onClick={() => handleUpdateHighschoolProfessorInfo()}>
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
        </Row>
    );
}

export default HighschoolProfessorProfile;

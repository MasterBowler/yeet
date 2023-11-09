import React from "react";

type Props = {
    username?: string,
    email?: string
    role?: string
}

const UserInfo = ({username, email, role}: Props) => {

    return (
        <div className="user-info">
            <div className={"user-info-role"}>
                <span className={"badge"}>{role}</span>
            </div>
            <div className="user-info-title">
                <a href={"/user-profile"}>{username}</a>
            </div>
            <div className="user-info-details">
                {email}
            </div>
        </div>
    );
}

export default UserInfo;
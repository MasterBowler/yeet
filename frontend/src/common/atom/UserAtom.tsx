import React from "react";
import {atomWithStorage} from "jotai/utils";

interface User {
    id?: number,
    emailAddress?: string,
    firstName?: string,
    lastName?: string,
    passwordHash?: string,
    phoneNumber?: string,
    groupName?: string,
    creationDate?: Date
}

export const userAtom = atomWithStorage<User | undefined>("user", undefined);

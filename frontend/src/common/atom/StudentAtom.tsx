import React from "react";
import {atomWithStorage} from "jotai/utils";

interface Student {
    sid?: string;
    universityName?: string;
    degreeName?: string;
    year?: string;
    groupCode?: string;
    specialtyName?: string;
}

export const studentAtom = atomWithStorage<Student | undefined>("student", undefined);

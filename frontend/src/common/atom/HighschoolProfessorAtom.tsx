import React from "react";
import {atomWithStorage} from "jotai/utils";

interface HighschoolProfessor {
    highschoolName?: string;
    teachingDegree?: string;
    startDate?: Date;
}

export const highschoolProfessorAtom = atomWithStorage<HighschoolProfessor | undefined>("highschoolProfessor", undefined);

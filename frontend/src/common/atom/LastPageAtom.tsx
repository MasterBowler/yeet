import React from "react";
import {atomWithStorage} from "jotai/utils";

interface LastPage {
    url?: string
}

export const lastPageAtom = atomWithStorage<LastPage | undefined>("lastPage", undefined);

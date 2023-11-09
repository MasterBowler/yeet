export interface ClassSchedule {

    id: number;
    className: string;
    coordinatorName: string;
    startDateAndTime: Date;
    endDateAndTime: Date;
    attendance: number;
    maximumAttendance: number;
    description?: string;
}
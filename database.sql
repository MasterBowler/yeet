/*
    This file contains the SQL code for creating the database and its tables.
    It is not meant to be run as a script, but rather to be used as a reference
    for the database structure.

    user_group to user: A user_group has many users, and a user belongs to one user_group. This is modeled by the user_group_id foreign key in the user table that references the id in the user_group table.

    permission_set to user_group: A permission_set can be associated with many user_groups. The permission_set_id in the user_group table serves as a foreign key to the permission_set table.

    user to student and highschool_professor: Both student and highschool_professor tables have a user_id foreign key that references the id in the user table, indicating that each student and each highschool professor is also a user.

    highschool_professor to class: A highschool_professor can teach many classes, and a class is taught by one highschool_professor. This is modeled by the highschool_professor_id foreign key in the class table.

    class to schedule: A class can have many schedules, and a schedule belongs to one class. This relationship is represented by the class_name_id foreign key in the schedule table.

    report to student_report and highschool_professor_report: Both student_report and highschool_professor_report have a report_id that references the id in the report table.

    student_report to student_report_details: A student_report can have many details entries, and student_report_details belongs to one student_report. This is shown by the student_report_id foreign key in the student_report_details table.

    highschool_professor_report to highschool_professor_report_details: A highschool_professor_report can have many details entries, and highschool_professor_report_details belongs to one highschool_professor_report. This is shown by the highschool_professor_report_id foreign key in the highschool_professor_report_details table.
*/

/*

Normalization: Ensure that your tables are normalized to avoid redundant data. For example, the highschool_professor_report_details and student_report_details tables seem to have overlapping fields (classes, extracurriculars, portfolio, teaching_project, workshop). If these fields are common and can be normalized, consider creating a separate table that both report types can reference.

Foreign Key References: There seems to be a typo in the highschool_professor_report_details table's foreign key reference. It should reference highschool_professor_report(id) instead of highschool.

Data Types: Ensure that the data types chosen for each field are appropriate for the data they will hold. For example, VARCHAR(255) for permissions in the permission_set table might not be sufficient if you plan to store a list of permissions. Consider using a different structure or increasing the size.

User Roles: It seems like you're using a combination of user_group and permission_set to handle user roles and permissions. Make sure that this setup is flexible enough to handle the different types of actors in your system and their respective permissions.

Indexes: Make sure to index foreign keys and other columns that you'll frequently query against to improve performance.

Class and Schedule: The relationship between class and schedule is good, but ensure that the schedule table can handle multiple schedules for the same class if needed.

Reports: The connection between report and student_report/highschool_professor_report is not entirely clear. Ensure that the report table's structure supports the necessary details for both types of reports.

*/


-- Users Table
CREATE TABLE user
(
    id BIGINT PRIMARY KEY,
    creation_date DATETIME,
    email_address VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password_hash VARCHAR(255),
    phone_number VARCHAR(255),
    user_group_id BIGINT,
    FOREIGN KEY (user_group_id) REFERENCES user_group(id)
);

-- User Group Table
CREATE TABLE user_group
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    permission_set_id BIGINT,
    FOREIGN KEY (permission_set_id) REFERENCES permission_set(id)
);

-- Permission Set Table
CREATE TABLE permission_set
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    permissions VARCHAR(255)
);

-- Highschool Professor Table
CREATE TABLE highschool_professor
(
    id BIGINT PRIMARY KEY,
    highschool_name VARCHAR(255),
    start_date DATETIME,
    teaching_degree VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

-- Highschool Professor Report Table
CREATE TABLE highschool_professor_report
(
    id BIGINT PRIMARY KEY,
    month VARCHAR(255),
    class_name_id BIGINT,
    highschool_professor_id BIGINT,
    report_id BIGINT,
    FOREIGN KEY (highschool_professor_id) REFERENCES highschool_professor(id),
    FOREIGN KEY (class_name_id) REFERENCES class(id),
    FOREIGN KEY (report_id) REFERENCES report(id)
);

-- Highschool Professor Report Details Table
CREATE TABLE highschool_professor_report_details
(
    id BIGINT PRIMARY KEY,
    classes VARCHAR(255),
    criterion_number VARCHAR(255),
    date DATETIME,
    extracurriculars VARCHAR(255),
    portfolio VARCHAR(255),
    teaching_project VARCHAR(255),
    workshop VARCHAR(255),
    highschool_professor_report_id BIGINT,
    student_id BIGINT,
    FOREIGN KEY (highschool_professor_report_id) REFERENCES highschool,
    FOREIGN KEY (student_id) REFERENCES student(id)

    -- Student Table
    CREATE TABLE student
    (
        id BIGINT PRIMARY KEY,
        degree_name VARCHAR(255),
        group_code VARCHAR(255),
        sid VARCHAR(255),
        specialty_name VARCHAR(255),
        university_name VARCHAR(255),
        year VARCHAR(255),
        user_id BIGINT,
        FOREIGN KEY (user_id) REFERENCES user(id)
    );

    -- Student Report Table
    CREATE TABLE student_report
    (
        id BIGINT PRIMARY KEY,
        month VARCHAR(255),
        transportation_means VARCHAR(255),
        report_id BIGINT,
        student_id BIGINT,
        FOREIGN KEY (report_id) REFERENCES report(id),
        FOREIGN KEY (student_id) REFERENCES student(id)
    );

    -- Student Report Details Table
    CREATE TABLE student_report_details
    (
        id BIGINT PRIMARY KEY,
        assistance VARCHAR(255),
        class_teaching VARCHAR(255),
        date DATETIME,
        extracurriculars VARCHAR(255),
        portfolio VARCHAR(255),
        teaching_project VARCHAR(255),
        timeframe VARCHAR(255),
        workshop VARCHAR(255),
        student_report_id BIGINT,
        FOREIGN KEY (student_report_id) REFERENCES student_report(id)
    );

    -- Class Table
    CREATE TABLE class
    (
        id BIGINT PRIMARY KEY,
        description VARCHAR(255),
        maximum_attendance INT(11),
        name VARCHAR(255),
        highschool_professor_id BIGINT,
        FOREIGN KEY (highschool_professor_id) REFERENCES highschool_professor(id)
    );

    -- Schedule Table
    CREATE TABLE schedule
    (
        id BIGINT PRIMARY KEY,
        description VARCHAR(255),
        end_date_and_time DATETIME,
        start_date_and_time DATETIME,
        class_name_id BIGINT,
        FOREIGN KEY (class_name_id) REFERENCES class(id)
    );

    -- Hibernate Sequence Table (This is usually used for managing unique identifier generation in Hibernate, not usually manually created in SQL)
    CREATE TABLE hibernate_sequence
    (
        next_val BIGINT
    );

    -- Report Table (Assuming its structure from the relations, as it's not fully visible in the image)
    CREATE TABLE report
    (
        id BIGINT PRIMARY KEY,
        user_id BIGINT,
        FOREIGN KEY (user_id) REFERENCES user(id)
    );

INSERT INTO authorities (authority_id, name) VALUES (1, 'ADMIN');
INSERT INTO authorities (authority_id, name) VALUES (2, 'STANDARD');

INSERT INTO auth_user (user_id, username, password) VALUES (1, "admin", "$2a$10$ff9d1NpluXieAXmzJ7WWD.mwT.NGtZZy7dsq6eu4e..YgURwkFIfG");
INSERT INTO auth_user (user_id, username, password) VALUES (2, "marko", "$2a$10$ff9d1NpluXieAXmzJ7WWD.mwT.NGtZZy7dsq6eu4e..YgURwkFIfG");

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);

INSERT INTO admins(admin_username, admin_password) VALUES ("admin", "admin");
INSERT INTO admins(admin_username, admin_password) VALUES ("marko", "markovic");

INSERT INTO study_programmes(study_programme_name) VALUES ("Softverske i informacione tehnologije");
INSERT INTO study_programmes(study_programme_name) VALUES ("Energetika i elektronika");
INSERT INTO study_programmes(study_programme_name) VALUES ("Racunarstvo i automatika");
INSERT INTO study_programmes(study_programme_id, study_programme_name) VALUES (-1, "Zamrznute studije");

INSERT INTO students(student_username, student_password, student_index,student_first_name,student_last_name, student_JMBG, student_enrollment_year, student_financing, student_year_of_study,student_time_enrolled, student_giro, student_personal_refernce_number, student_balance, study_programme) VALUES ("tina", "tinic", "sf25/2017", "Valentina", "Mackovic", "0711997825199", 2017, 0, 3, 1, "01929201", "718281299", 0, 1);
INSERT INTO students(student_username, student_password, student_index,student_first_name,student_last_name, student_JMBG, student_enrollment_year, student_financing, student_year_of_study,student_time_enrolled, student_giro, student_personal_refernce_number, student_balance, study_programme) VALUES ("marko", "markovic", "sf26/2017", "Marko", "Markovic", "0712497825199", 2017, 0, 3, 1, "012459201", "24454281299", 2, 1);
INSERT INTO students(student_username, student_password, student_index,student_first_name,student_last_name, student_JMBG, student_enrollment_year, student_financing, student_year_of_study,student_time_enrolled, student_giro, student_personal_refernce_number, student_balance, study_programme) VALUES ("pera", "peric", "sf27/2017", "Pera", "Peric", "0711997825198", 2017, 0, 3, 1, "019678201", "718289599", 200, 2);
INSERT INTO students(student_username, student_password, student_index,student_first_name,student_last_name, student_JMBG, student_enrollment_year, student_financing, student_year_of_study,student_time_enrolled, student_giro, student_personal_refernce_number, student_balance, study_programme) VALUES ("mitra", "mitric", "sf28/2017", "Mitra", "Mitric", "0231997825199", 2017, 0, 3, 1, "019465701", "712345299", 0, 2);

INSERT INTO professors(professor_email,professor_username, professor_password, professor_first_name,professor_last_name, professor_JMBG) VALUES ("nikola@gmail.com","nikola", "nikolic", "Nikola", "Nikolic", "0231999825199");
INSERT INTO professors(professor_email,professor_username, professor_password, professor_first_name,professor_last_name, professor_JMBG) VALUES ("sinisa@gmail.com","sinisa", "snisic", "Sinisa", "Sinisic", "0231299825199");
INSERT INTO professors(professor_email,professor_username, professor_password, professor_first_name,professor_last_name, professor_JMBG) VALUES ("dunja@gmail.com","dunja", "dunjic", "Dunja", "Dunjic", "0231889825199");

INSERT INTO courses(course_name, course_code, ECTS, lectures, practical_classes, study_programme_courses) VALUES ("Matematika 1", "SF89", 180, 30, 10, 1);
INSERT INTO courses(course_name, course_code, ECTS, lectures, practical_classes, study_programme_courses) VALUES ("Osnove web programiranja", "SF99", 240, 40, 20, 1);
INSERT INTO courses(course_name, course_code, ECTS, lectures, practical_classes, study_programme_courses) VALUES ("Bonita", "EE77", 240, 40, 30, 2);
INSERT INTO courses(course_name, course_code, ECTS, lectures, practical_classes, study_programme_courses) VALUES ("Osnove Elektronike", "RA89", 180, 30, 10, 3);
INSERT INTO courses(course_name, course_code, ECTS, lectures, practical_classes, study_programme_courses) VALUES ("Programski jezici i strukture podataka", "RA99", 240, 40, 20, 3);
INSERT INTO courses(course_name, course_code, ECTS, lectures, practical_classes, study_programme_courses) VALUES ("Fizika", "EE51", 240, 40, 30, 2);

INSERT INTO enrollments(enrollment_start_date, enrollment_end_date, student, course) VALUES ("2017-08-24", "2019-08-24", 1, 1);
INSERT INTO enrollments(enrollment_start_date, enrollment_end_date, student, course) VALUES ("2017-09-24", "2019-09-24", 3, 1);
INSERT INTO enrollments(enrollment_start_date, enrollment_end_date, student, course) VALUES ("2017-07-24", "2019-07-24", 2, 2);

INSERT INTO exam_periods(exam_name, start_date, end_date, payment_amount) VALUES (0, "2020-01-20", "2020-01-30", 200);
INSERT INTO exam_periods(exam_name, start_date, end_date, payment_amount) VALUES (1, "2020-02-01", "2020-02-13", 200);
INSERT INTO exam_periods(exam_name, start_date, end_date, payment_amount) VALUES (2, "2020-04-15", "2020-04-20", 200);
INSERT INTO exam_periods(exam_name, start_date, end_date, payment_amount) VALUES (3, "2020-06-20", "2020-06-30", 200);
INSERT INTO exam_periods(exam_name, start_date, end_date, payment_amount) VALUES (4, "2020-07-01", "2020-07-15", 200);
INSERT INTO exam_periods(exam_name, start_date, end_date, payment_amount) VALUES (5, "2020-09-01", "2020-08-15", 200);
INSERT INTO exam_periods(exam_name, start_date, end_date, payment_amount) VALUES (6, "2020-10-05", "2020-10-10", 200);

INSERT INTO exams(exam_points, lab_points, exam_date, class_room, course, period) VALUES (80, 20, "2020-01-22 12:30:00", 0, 1, 1);
INSERT INTO exams(exam_points, lab_points, exam_date, class_room, course, period) VALUES (50, 50, "2020-04-16 12:30:00", 0, 2, 3);
INSERT INTO exams(exam_points, lab_points, exam_date, class_room, course, period) VALUES (70, 30, "2020-02-10 12:30:00", 0, 3, 2);
INSERT INTO exams(exam_points, lab_points, exam_date, class_room, course, period) VALUES (0, 0, "2020-06-23 12:30:00", 0, 1, 4);
INSERT INTO exams(exam_points, lab_points, exam_date, class_room, course, period) VALUES (0, 0, "2020-07-07 12:30:00", 0, 4, 5);
INSERT INTO exams(exam_points, lab_points, exam_date, class_room, course, period) VALUES (0, 0, "2020-07-07 12:30:00", 0, 1, 5);
INSERT INTO exams(exam_points, lab_points, exam_date, class_room, course, period) VALUES (0, 0, "2020-09-07 12:30:00", 0, 5, 6);
INSERT INTO exams(exam_points, lab_points, exam_date, class_room, course, period) VALUES (0, 0, "2020-10-07 12:30:00", 0, 6, 2);

INSERT INTO financial_cards(financial_card_payment_date, financial_card_payment_description, financial_card_payment_amount, financial_card_payment_exception, financial_card_initial_state, financial_card_total_payment, financial_card_total_cost, student_financial_card) VALUES ("2019-04-26", "opis uplate 1", 2000.00, 50.00, 1000.00, 2000.00, 1000.00, 1);
INSERT INTO financial_cards(financial_card_payment_date, financial_card_payment_description, financial_card_payment_amount, financial_card_payment_exception, financial_card_initial_state, financial_card_total_payment, financial_card_total_cost, student_financial_card) VALUES ("2020-01-22", "opis uplate 2", 2000.00, 50.00, 1000.00, 2000.00, 1000.00, 1);
INSERT INTO financial_cards(financial_card_payment_date, financial_card_payment_description, financial_card_payment_amount, financial_card_payment_exception, financial_card_initial_state, financial_card_total_payment, financial_card_total_cost, student_financial_card) VALUES ("2020-06-12", "opis uplate 3", 2000.00, 50.00, 1000.00, 2000.00, 1000.00, 2);

INSERT INTO exam_registrations(status, final_grade, exam_period, student, exam, checked) VALUES (0, 10, 1, 1, 1, 0);
INSERT INTO exam_registrations(status, final_grade, exam_period, student, exam, checked) VALUES (1, 6, 1, 1, 2, 0);
INSERT INTO exam_registrations(status, final_grade, exam_period, student, exam, checked) VALUES (2, 0, 1, 1, 5, 0);
INSERT INTO exam_registrations(status, final_grade, exam_period, student, exam, checked) VALUES (2, 0, 1, 1, 4, 0);
INSERT INTO exam_registrations(status, final_grade, exam_period, student, exam, checked) VALUES (2, 0, 1, 1, 6, 0);
INSERT INTO exam_registrations(status, final_grade, exam_period, student, exam, checked) VALUES (2, 0, 1, 1, 4, 0);
INSERT INTO exam_registrations(status, final_grade, exam_period, student, exam, checked) VALUES (1, 8, 2, 2, 3, 0);
INSERT INTO exam_registrations(status, final_grade, exam_period, student, exam, checked) VALUES (2, 0, 6, 2, 6, 0);

INSERT INTO professors_courses(course_id, professor_id) VALUES (1, 1);
INSERT INTO professors_courses(course_id, professor_id) VALUES (2, 1);
INSERT INTO professors_courses(course_id, professor_id) VALUES (3, 2);

INSERT INTO student_docs(student_docs_name, student_docs_mime_type, student_docs_path, student_docs_date, student_docs) VALUES ("dokument 1", "tip dokumenta 1", "putanja dokumenta 1", "2017-07-04", 1);
INSERT INTO student_docs(student_docs_name, student_docs_mime_type, student_docs_path, student_docs_date, student_docs) VALUES ("dokument 2", "tip dokumenta 2", "putanja dokumenta 2", "2017-07-05", 1);
INSERT INTO student_docs(student_docs_name, student_docs_mime_type, student_docs_path, student_docs_date, student_docs) VALUES ("dokument 3", "tip dokumenta 3", "putanja dokumenta 3", "2017-07-06", 2);
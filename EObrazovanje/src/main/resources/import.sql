INSERT INTO admins(admin_username, admin_password) VALUES ("admin", "admin")
INSERT INTO admins(admin_username, admin_password) VALUES ("marko", "markovic")

INSERT INTO study_programmes(study_programme_name) VALUES ("program 1")
INSERT INTO study_programmes(study_programme_name) VALUES ("program 2")
INSERT INTO study_programmes(study_programme_name) VALUES ("program 3")

INSERT INTO students(student_username, student_password, student_index,student_first_name,student_last_name, student_JMBG, student_enrollment_year, student_financing, student_year_of_study,student_time_enrolled, student_giro, student_personal_refernce_number, student_balance, study_programme) VALUES ("tina", "tinic", "sf25/2017", "Valentina", "Mackovic", "0711997825199", 2017, 0, 3, 1, "01929201", "718281299", 0, 1)
INSERT INTO students(student_username, student_password, student_index,student_first_name,student_last_name, student_JMBG, student_enrollment_year, student_financing, student_year_of_study,student_time_enrolled, student_giro, student_personal_refernce_number, student_balance, study_programme) VALUES ("marko", "markovic", "sf26/2017", "Marko", "Markovic", "0712497825199", 2017, 0, 3, 1, "012459201", "24454281299", 2, 1)
INSERT INTO students(student_username, student_password, student_index,student_first_name,student_last_name, student_JMBG, student_enrollment_year, student_financing, student_year_of_study,student_time_enrolled, student_giro, student_personal_refernce_number, student_balance, study_programme) VALUES ("pera", "peric", "sf27/2017", "Pera", "Peric", "0711997825198", 2017, 0, 3, 1, "019678201", "718289599", 200, 2)
INSERT INTO students(student_username, student_password, student_index,student_first_name,student_last_name, student_JMBG, student_enrollment_year, student_financing, student_year_of_study,student_time_enrolled, student_giro, student_personal_refernce_number, student_balance, study_programme) VALUES ("mitra", "mitric", "sf28/2017", "Mitra", "Mitric", "0231997825199", 2017, 0, 3, 1, "019465701", "712345299", 0, 2)

INSERT INTO professors(professor_email,professor_username, professor_password, professor_first_name,professor_last_name, professor_JMBG) VALUES ("nikola@gmail.com","nikola", "nikolic", "Nikola", "Nikolic", "0231999825199")
INSERT INTO professors(professor_email,professor_username, professor_password, professor_first_name,professor_last_name, professor_JMBG) VALUES ("sinisa@gmail.com","sinisa", "snisic", "Sinisa", "Sinisic", "0231299825199")
INSERT INTO professors(professor_email,professor_username, professor_password, professor_first_name,professor_last_name, professor_JMBG) VALUES ("dunja@gmail.com","dunja", "dunjic", "Dunja", "Dunjic", "0231889825199")

INSERT INTO courses(course_name, course_code, ECTS, lectures, practical_classes, study_programme_courses) VALUES ("Softverske i informacione tehnologije", "SF", 180, 30, 10, 1)
INSERT INTO courses(course_name, course_code, ECTS, lectures, practical_classes, study_programme_courses) VALUES ("Energetika i elektronika", "EE", 240, 40, 20, 1)
INSERT INTO courses(course_name, course_code, ECTS, lectures, practical_classes, study_programme_courses) VALUES ("Racunarstvo i automatika", "RA", 240, 40, 30, 2)

INSERT INTO enrollments(enrollment_start_date, enrollment_end_date, student, course) VALUES ("2017-08-24", "2019-08-24", 1, 1)
INSERT INTO enrollments(enrollment_start_date, enrollment_end_date, student, course) VALUES ("2017-09-24", "2019-09-24", 1, 1)
INSERT INTO enrollments(enrollment_start_date, enrollment_end_date, student, course) VALUES ("2017-07-24", "2019-07-24", 2, 2)

INSERT INTO exam_periods(exam_name, start_date, end_date) VALUES ("Matematika 1", "2019-08-24", "2019-08-24")
INSERT INTO exam_periods(exam_name, start_date, end_date) VALUES ("Osnove web programiranja", "2019-08-24", "2019-08-24")
INSERT INTO exam_periods(exam_name, start_date, end_date) VALUES ("Bonita", "2019-08-24", "2019-08-24")

INSERT INTO exams(exam_points, lab_points, course_date, ND, course, period, student) VALUES (80, 20, "2020-04-04", 0, 1, 1, 1)
INSERT INTO exams(exam_points, lab_points, course_date, ND, course, period, student) VALUES (50, 50, "2020-06-23", 0, 2, 3, 1)
INSERT INTO exams(exam_points, lab_points, course_date, ND, course, period, student) VALUES (70, 30, "2020-05-07", 0, 3, 2, 2)

INSERT INTO financial_cards(financial_card_payment_date, financial_card_payment_description, financial_card_payment_amount, financial_card_payment_exception, financial_card_initial_state, financial_card_total_payment, financial_card_total_cost, student_financial_card) VALUES ("2019-04-26", "opis uplate 1", 2000.00, 50.00, 1000.00, 2000.00, 1000.00, 1)
INSERT INTO financial_cards(financial_card_payment_date, financial_card_payment_description, financial_card_payment_amount, financial_card_payment_exception, financial_card_initial_state, financial_card_total_payment, financial_card_total_cost, student_financial_card) VALUES ("2020-01-22", "opis uplate 2", 2000.00, 50.00, 1000.00, 2000.00, 1000.00, 1)
INSERT INTO financial_cards(financial_card_payment_date, financial_card_payment_description, financial_card_payment_amount, financial_card_payment_exception, financial_card_initial_state, financial_card_total_payment, financial_card_total_cost, student_financial_card) VALUES ("2020-06-12", "opis uplate 3", 2000.00, 50.00, 1000.00, 2000.00, 1000.00, 2)

INSERT INTO exam_registrations(payment_amount, registered, exam_period, financial_card) VALUES (200, 1, 1, 1)
INSERT INTO exam_registrations(payment_amount, registered, exam_period, financial_card) VALUES (200, 1, 1, 1)
INSERT INTO exam_registrations(payment_amount, registered, exam_period, financial_card) VALUES (200, 1, 2, 2)

INSERT INTO student_docs(student_docs_name, student_docs_mime_type, student_docs_path, student_docs_date, student_docs) VALUES ("dokument 1", "tip dokumenta 1", "putanja dokumenta 1", "2017-07-04", 1)
INSERT INTO student_docs(student_docs_name, student_docs_mime_type, student_docs_path, student_docs_date, student_docs) VALUES ("dokument 2", "tip dokumenta 2", "putanja dokumenta 2", "2017-07-05", 1)
INSERT INTO student_docs(student_docs_name, student_docs_mime_type, student_docs_path, student_docs_date, student_docs) VALUES ("dokument 3", "tip dokumenta 3", "putanja dokumenta 3", "2017-07-06", 2)
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentServiceService } from 'src/app/services/student/student.service';
import { Exam } from 'src/app/types/exam';
import { ExamRegistration } from 'src/app/types/exam-registration';

const mockDataUnregistration = [
  {
    id: 3,
    course: {
      name: 'Prijavljen',
      courseCode: '12SIT',
    },
    examDate: '12.12.2020.',
    examRegistration: {
      paymentAmount: 200,
    },
    professor: {
      name: 'Sinisa Nikolic',
    },
  },
];

@Component({
  selector: 'app-student-exams-active',
  templateUrl: './student-exams-active.component.html',
  styleUrls: ['./student-exams-active.component.css'],
})
export class StudentExamsActiveComponent implements OnInit {
  registration;
  exams;
  selectedExams = [];
  userAccountBalance = 1000;
  selectedExamsCost = 0;
  newUserAccountBalance = 1000;

  constructor(
    private router: Router,
    private studentService: StudentServiceService
  ) {}

  ngOnInit(): void {
    const registration = !this.router.url.toString().includes('unregister');
    this.registration = registration;
    this.getExams(registration);
  }

  getExams(registration: boolean) {
    registration
      ? this.studentService.getCurrentExams(1).subscribe((exams: Exam[]) => {
          this.exams = exams;
        })
      : this.studentService
          .getCurrentExamRegistrations(1)
          .subscribe((exams: ExamRegistration[]) => {
            this.exams = exams;
          });
  }

  selectExam(exam: any) {
    const alreadySelected = this.selectedExams.find((e) => exam.id === e.id);

    if (alreadySelected === undefined) {
      this.selectedExams.push(exam);
      this.selectedExamsCost += exam.paymentAmount;
    } else {
      const filteredSelectedExams = this.selectedExams.filter(
        (e) => e.id !== alreadySelected.id
      );
      this.selectedExams = filteredSelectedExams;
      this.selectedExamsCost -= exam.paymentAmount;
    }

    this.calculateAccountBalance();
  }

  calculateAccountBalance() {
    this.registration
      ? (this.newUserAccountBalance =
          this.userAccountBalance - this.selectedExamsCost)
      : (this.newUserAccountBalance =
          this.userAccountBalance + this.selectedExamsCost);
  }

  isExamSelected(examId: string) {
    return this.selectedExams.find((e) => examId === e.id);
  }

  handleSubmit() {
    if (this.registration) {
      this.selectedExams.forEach((e) => {
        this.studentService.registerExam(1, e.id).subscribe((data) => {
          console.log(data);
        });
      });
      console.log('register');
    } else if (!this.registration) {
      this.selectedExams.forEach((e) => {
        this.studentService
          .unregisterExam(1, e.id)
          .subscribe((exams: ExamRegistration[]) => {
            this.exams = exams;
          });
      });
    }
  }
}

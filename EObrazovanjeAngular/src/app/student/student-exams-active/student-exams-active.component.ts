import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentServiceService } from 'src/app/services/student/student.service';
import { Exam } from 'src/app/types/exam';
import { ExamRegistration } from 'src/app/types/exam-registration';
import { Student } from 'src/app/types/student';

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
  userAccountBalance = 0;
  selectedExamsCost = 0;
  newUserAccountBalance = 0;

  constructor(
    private router: Router,
    private studentService: StudentServiceService
  ) {}

  ngOnInit(): void {
    const registration = !this.router.url.toString().includes('unregister');
    this.registration = registration;
    this.getExams(registration);
    this.getAccountBalance();
  }

  getAccountBalance() {
    this.studentService.getStudenById().subscribe((student: Student) => {
      this.userAccountBalance = student.accountBalance;
      this.newUserAccountBalance = student.accountBalance;
    });
  }

  getExams(registration: boolean) {
    registration
      ? this.studentService.getCurrentExams().subscribe((exams: Exam[]) => {
          this.exams = exams;
        })
      : this.studentService
          .getCurrentExamRegistrations()
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
      if (this.newUserAccountBalance > 0) {
        this.selectedExams.forEach((e) => {
          this.studentService.registerExam(e.id).subscribe((data) => {
            console.log(data);
          });
        });
        window.location.reload();
      }
    } else if (!this.registration) {
      this.selectedExams.forEach((e) => {
        this.studentService
          .unregisterExam(e.id)
          .subscribe((exams: ExamRegistration[]) => {
            this.exams = exams;
          });
      });
    }
  }
}

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminAddUserComponent } from './admin-add-user/admin-add-user.component';
import { AdminProfessorsListComponent } from './admin-professors-list/admin-professors-list.component';
import { AdminScreenComponent } from './admin-screen/admin-screen.component';
import { AdminStudentsListComponent } from './admin-students-list/admin-students-list.component';
import { LoginComponent } from './login/login.component';
import { CourseInsertScreenComponent } from './professor/course-insert-screen/course-insert-screen.component';
import { CoursesScreenComponent } from './professor/courses-screen/courses-screen.component';
import { ProfessorDataEditComponent } from './professor/professor-data-edit/professor-data-edit.component';
import { ProfessorProfileDetailsComponent } from './professor/professor-profile-details/professor-profile-details.component';
import { ProfessorScreenComponent } from './professor/professor-screen/professor-screen.component';
import { StudentCourseInsertScreenComponent } from './professor/student-course-insert-screen/student-course-insert-screen.component';
import { StudentExamHistoryComponent } from './student/student-exam-history/student-exam-history.component';
import { StudentExamsActiveComponent } from './student/student-exams-active/student-exams-active.component';
import { StudentFinancingComponent } from './student/student-financing/student-financing.component';
import { StudentProfileDetailsComponent } from './student/student-profile-details/student-profile-details.component';
import { StudentScreenComponent } from './student/student-screen/student-screen.component';
import { AdminCoursesListComponent } from './admin-courses-list/admin-courses-list.component';
import { AdminExamsListComponent } from './admin-exams-list/admin-exams-list.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  {
    path: 'student',
    component: StudentScreenComponent,
    children: [
      { path: '', component: StudentProfileDetailsComponent },
      { path: 'exams/register', component: StudentExamsActiveComponent },
      { path: 'exams/unregister', component: StudentExamsActiveComponent },
      { path: 'exams/passed', component: StudentExamHistoryComponent },
      { path: 'exams/failed', component: StudentExamHistoryComponent },
      { path: 'exams/history', component: StudentExamHistoryComponent },
      { path: 'financing', component: StudentFinancingComponent },
    ],
  },
  {
    path: 'professor',
    component: ProfessorScreenComponent,
    children: [
      { path: '', component: ProfessorProfileDetailsComponent },
      { path: 'edit', component: ProfessorDataEditComponent },
      { path: 'courses', component: CoursesScreenComponent },
      { path: 'addCourse', component: CourseInsertScreenComponent },
      {
        path: 'addStudentAtCourse',
        component: StudentCourseInsertScreenComponent,
      },
    ],
  },
  {
    path: 'admin',
    component: AdminScreenComponent,
    children: [
      { path: 'students', component: AdminStudentsListComponent },
      { path: 'professors', component: AdminProfessorsListComponent },
      { path: 'users/add/student', component: AdminAddUserComponent },
      { path: 'users/add/professor', component: AdminAddUserComponent },
      { path: 'courses', component: AdminCoursesListComponent },
      { path: 'exams', component: AdminExamsListComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

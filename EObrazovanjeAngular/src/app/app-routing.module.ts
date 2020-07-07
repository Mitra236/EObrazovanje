import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminAddProgrammeComponent } from './admin/admin-add-programme/admin-add-programme.component';
import { AdminAddUserComponent } from './admin/admin-add-user/admin-add-user.component';
import { AdminBookingListComponent } from './admin/admin-booking-list/admin-booking-list.component';
import { AdminBooking2ListComponent } from './admin/admin-booking2-list/admin-booking2-list.component';
import { AdminBooking3ListComponent } from './admin/admin-booking3-list/admin-booking3-list.component';
import { AdminCoursesListComponent } from './admin/admin-courses-list/admin-courses-list.component';
import { AdminExamsListComponent } from './admin/admin-exams-list/admin-exams-list.component';
import { AdminPeriodsListComponent } from './admin/admin-periods-list/admin-periods-list.component';
import { AdminPeriods2ListComponent } from './admin/admin-periods2-list/admin-periods2-list.component';
import { AdminProfessorsListComponent } from './admin/admin-professors-list/admin-professors-list.component';
import { AdminProgrammeListComponent } from './admin/admin-programme-list/admin-programme-list.component';
import { AdminScreenComponent } from './admin/admin-screen/admin-screen.component';
import { AdminStudentsListComponent } from './admin/admin-students-list/admin-students-list.component';
import { LoginComponent } from './login/login.component';
import { ActiveExamRegistrationsComponent } from './professor/active-exam-registrations/active-exam-registrations.component';
import { CoursesScreenComponent } from './professor/courses-screen/courses-screen.component';
import { InsertExamPointsComponent } from './professor/insert-exam-points/insert-exam-points.component';
import { ProfessorCourseDetailsComponent } from './professor/professor-course-details/professor-course-details.component';
import { ProfessorDataEditComponent } from './professor/professor-data-edit/professor-data-edit.component';
import { ProfessorExamsComponent } from './professor/professor-exams/professor-exams.component';
import { ProfessorProfileDetailsComponent } from './professor/professor-profile-details/professor-profile-details.component';
import { ProfessorScreenComponent } from './professor/professor-screen/professor-screen.component';
import { StudentCourseInsertScreenComponent } from './professor/student-course-insert-screen/student-course-insert-screen.component';
import { AuthService as AuthGuard } from './services/auth.service';
import { StudentExamHistoryComponent } from './student/student-exam-history/student-exam-history.component';
import { StudentExamsActiveComponent } from './student/student-exams-active/student-exams-active.component';
import { StudentFinancingComponent } from './student/student-financing/student-financing.component';
import { StudentProfileDetailsComponent } from './student/student-profile-details/student-profile-details.component';
import { StudentScreenComponent } from './student/student-screen/student-screen.component';
import { AdminAllCoursesListComponent } from './admin/admin-all-courses-list/admin-all-courses-list.component';
import { AdminAddCourseComponent } from './admin/admin-add-course/admin-add-course.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  {
    path: 'student',
    component: StudentScreenComponent,
    children: [
      {
        path: '',
        component: StudentProfileDetailsComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'exams/register',
        component: StudentExamsActiveComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'exams/unregister',
        component: StudentExamsActiveComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'exams/passed',
        component: StudentExamHistoryComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'exams/failed',
        component: StudentExamHistoryComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'exams/history',
        component: StudentExamHistoryComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'financing',
        component: StudentFinancingComponent,
        canActivate: [AuthGuard],
      },
    ],
  },
  {
    path: 'professor/:id',
    component: ProfessorScreenComponent,
    children: [
      {
        path: '',
        component: ProfessorProfileDetailsComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'edit',
        component: ProfessorDataEditComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'courses',
        component: CoursesScreenComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'courseDetails/:id2',
        component: ProfessorCourseDetailsComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'exams',
        component: ProfessorExamsComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'activeExams',
        component: ActiveExamRegistrationsComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'addStudentAtCourse/:id2',
        component: StudentCourseInsertScreenComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'insertPoints/:id2',
        component: InsertExamPointsComponent,
        canActivate: [AuthGuard],
      },
    ],
  },
  {
    path: 'admin',
    component: AdminScreenComponent,
    children: [
      {
        path: 'students',
        component: AdminStudentsListComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'professors/professorsForAdmin',
        component: AdminProfessorsListComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'users/add/student',
        component: AdminAddUserComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'users/add/professor',
        component: AdminAddUserComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'users/edit/professor/:id',
        component: AdminAddUserComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'studyProgrammes',
        component: AdminCoursesListComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'studyProgrammes/programme/:id',
        component: AdminProgrammeListComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'exams',
        component: AdminExamsListComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'periods',
        component: AdminPeriodsListComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'examPeriod',
        component: AdminPeriods2ListComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'bookings',
        component: AdminBookingListComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'bookings/courseBooking/:id',
        component: AdminBooking2ListComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'bookings/examBooking/:id',
        component: AdminBooking3ListComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'addProgramme',
        component: AdminAddProgrammeComponent,
        canActivate: [AuthGuard],
      },
      { path: 'courses', component: AdminAllCoursesListComponent, canActivate: [AuthGuard] },
      { path: 'addCourse', component: AdminAddCourseComponent, canActivate: [AuthGuard] },
      { path: 'addCourse/:id', component: AdminAddCourseComponent, canActivate: [AuthGuard] },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

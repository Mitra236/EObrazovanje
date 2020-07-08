import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
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
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { LoginComponent } from './login/login.component';
import { ActiveExamRegistrationsComponent } from './professor/active-exam-registrations/active-exam-registrations.component';
import { CourseInsertScreenComponent } from './professor/course-insert-screen/course-insert-screen.component';
import { CoursesScreenComponent } from './professor/courses-screen/courses-screen.component';
import { InsertExamPointsComponent } from './professor/insert-exam-points/insert-exam-points.component';
import { ProfessorCourseDetailsComponent } from './professor/professor-course-details/professor-course-details.component';
import { ProfessorDataEditComponent } from './professor/professor-data-edit/professor-data-edit.component';
import { ProfessorExamsComponent } from './professor/professor-exams/professor-exams.component';
import { ProfessorProfileDetailsComponent } from './professor/professor-profile-details/professor-profile-details.component';
import { ProfessorScreenComponent } from './professor/professor-screen/professor-screen.component';
import { StudentCourseInsertScreenComponent } from './professor/student-course-insert-screen/student-course-insert-screen.component';
import { StudentExamHistoryComponent } from './student/student-exam-history/student-exam-history.component';
import { StudentExamsActiveComponent } from './student/student-exams-active/student-exams-active.component';
import { StudentFinancingComponent } from './student/student-financing/student-financing.component';
import { StudentProfileDetailsComponent } from './student/student-profile-details/student-profile-details.component';
import { StudentScreenComponent } from './student/student-screen/student-screen.component';
import { AdminAllCoursesListComponent } from './admin/admin-all-courses-list/admin-all-courses-list.component';
import { AdminAddCourseComponent } from './admin/admin-add-course/admin-add-course.component';
import { AdminCourseListComponent } from './admin/admin-course-list/admin-course-list.component';
import { AdminAddStudentComponent } from './admin/admin-add-student/admin-add-student.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentScreenComponent,
    LoginComponent,
    SidebarComponent,
    StudentProfileDetailsComponent,
    StudentExamHistoryComponent,
    StudentExamsActiveComponent,
    ProfessorScreenComponent,
    ProfessorProfileDetailsComponent,
    ProfessorDataEditComponent,
    CoursesScreenComponent,
    CourseInsertScreenComponent,
    StudentCourseInsertScreenComponent,
    StudentFinancingComponent,
    AdminScreenComponent,
    AdminStudentsListComponent,
    AdminProfessorsListComponent,
    AdminAddUserComponent,
    AdminCoursesListComponent,
    AdminExamsListComponent,
    AdminPeriodsListComponent,
    AdminPeriods2ListComponent,
    AdminBookingListComponent,
    AdminBooking2ListComponent,
    AdminBooking3ListComponent,
    ProfessorCourseDetailsComponent,
    ProfessorExamsComponent,
    ActiveExamRegistrationsComponent,
    InsertExamPointsComponent,
    AdminProgrammeListComponent,
    AdminAddProgrammeComponent,
    AdminAllCoursesListComponent,
    AdminAddCourseComponent,
    AdminCourseListComponent,
    AdminAddStudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

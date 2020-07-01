import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
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
import { AdminScreenComponent } from './admin-screen/admin-screen.component';
import { AdminStudentsListComponent } from './admin-students-list/admin-students-list.component';
import { AdminProfessorsListComponent } from './admin-professors-list/admin-professors-list.component';
import { AdminAddUserComponent } from './admin-add-user/admin-add-user.component';
import { AdminCoursesListComponent } from './admin-courses-list/admin-courses-list.component';
import { AdminExamsListComponent } from './admin-exams-list/admin-exams-list.component';
import { AdminPeriodsListComponent } from './admin-periods-list/admin-periods-list.component';
import { AdminPeriods2ListComponent } from './admin-periods2-list/admin-periods2-list.component';
import { AdminBookingListComponent } from './admin-booking-list/admin-booking-list.component';
import { AdminBooking2ListComponent } from './admin-booking2-list/admin-booking2-list.component';
import { AdminBooking3ListComponent } from './admin-booking3-list/admin-booking3-list.component';

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
    AdminBooking3ListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

import { Injectable } from '@angular/core';
import { baseUrl } from './url';
import { HttpClient, HttpErrorResponse, HttpResponse, HttpHeaders  } from '@angular/common/http';
import { throwError, Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Course } from 'src/app/types/course';
import { Enrollment } from '../types/enrollment';
import { StudentProfileDetailsComponent } from '../student/student-profile-details/student-profile-details.component';
import { Student } from '../types/student';
import { StudentServiceService } from './student/student.service';
import { EnrollmentAdd } from '../types/enrollment-add';


@Injectable({
  providedIn: 'root'
})
export class CourseService {
  coursesUrl = baseUrl + 'courses';
  courseToAddUrl = this.coursesUrl + '/addCourse';
  name = String;
  courseCode = String;
  ECTS = Number;
  lectures = Number;
  practicalClasses = Number;
  courses: [];

  constructor(private http: HttpClient, private studentService: StudentServiceService) { }

  getCourses() {
    return this.courses.splice;
  }

  getListOfCourses(): Observable<Course[]>{
    return this.http.get<Course[]>(this.coursesUrl);
  }

  getCourse(courseId: number) : Observable<Course> {
    let url = this.coursesUrl + "/getCourse/" + courseId;
    console.log(url);
    return this.http.get<Course>(url);
  }

  
  getCourseEnrollments(courseId: Number) {
    return this.http.get<Enrollment[]>(this.coursesUrl + '/courseEnrollments/' + courseId);
  }

  getAvailableStudents(courseId: Number) {
    return this.http.get<Student[]>(this.studentService.studentsUrl + 'notEnrolledStudents/' + courseId);
  }

  saveCourse(course: Course){
    return this.http.post(this.courseToAddUrl, course)
      .subscribe((response) => console.log(response),
      (error) => console.log(error));
  }
  editCourse(course: Course){
    return this.http.put(this.coursesUrl, course)
      .subscribe((response) => console.log(response),
      (error) => console.log(error));
  }

  removeCourse(courseId: number){
    let url = this.coursesUrl + '/' + courseId;
    console.log(url);
    return this.http.delete(url)
      .subscribe((response) => console.log(response),
                  (error) => console.log(error));
  }
  
  addEnrollment(enrollment: EnrollmentAdd) {
    return this.http.post<EnrollmentAdd>(baseUrl + 'enrollment', enrollment)
          .subscribe((response) => console.log(response),
                (error) => console.log(error));
  }

  
  removeStudentFromCourse(enrollmentId: Number) {
    return this.http.delete<Enrollment>(baseUrl + 'enrollment/' + enrollmentId ,
    {}).subscribe(
      (response) => console.log(response),
      (error) => console.log(error));
  }

 
}

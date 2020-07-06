import { Injectable } from '@angular/core';
import { baseUrl } from './url';
import { HttpClient, HttpErrorResponse, HttpResponse, HttpHeaders  } from '@angular/common/http';
import { throwError, Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Course } from 'src/app/types/course';


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

  constructor(private http: HttpClient) { }

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

  /*removeStudentFromCourse(courseId: Number, student: Student) {
    return this.http.delete<Course>(this.studyProgrammesUrl + '/programmeCourse/delete/' + course.id + '/' + programmeId,
    {}).subscribe(
      (response) => console.log(response),
      (error) => console.log(error)
    )
  }*/

 
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { baseUrl } from '../url';
import { Professor } from 'src/app/types/professor';
import { throwError, Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AdminProfessorService {
  professorsUrl = baseUrl + 'professors/';

  constructor(private http: HttpClient) { }

  getProfessor(id: number) : Observable<Professor> {
    return this.http.get<Professor>(this.professorsUrl + "professor?id=" + id)
  }

  addProfessor(professor: Professor) : Observable<Professor> {
    return this.http.post<Professor>(this.professorsUrl, professor)
            .pipe(catchError(this.handleError))
  }

  editProfessorData(professor: Professor) : Observable<Professor> {
    return this.http.put<Professor>(this.professorsUrl + "all-data/",  professor)
            .pipe(catchError(this.handleError));
  }

  deleteProfessor(id: number) : Observable<{}> {
    return this.http.delete(this.professorsUrl + id)
            .pipe(catchError(this.handleError))
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error';

    error.error instanceof ErrorEvent ?
    errorMessage = `Error: ${error.error.message}` :
    errorMessage = `Error code: ${error.status}\nMessage: ${error.message}`

    window.alert(errorMessage)
    return throwError(errorMessage)
  }

}

import { Injectable } from '@angular/core';

interface StudyProgramme {
  id: number;
  programmeName: string;
}

@Injectable({
  providedIn: 'root'
})
export class StudyProgrammeService {

  constructor() { }
}

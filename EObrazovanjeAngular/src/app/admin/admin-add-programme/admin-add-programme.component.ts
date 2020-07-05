import { Component, OnInit, Output } from '@angular/core';
import { StudyProgramme } from 'src/app/types/study.programme';
import { StudyProgrammeService } from '../../services/study.programme.service';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-admin-add-programme',
  templateUrl: './admin-add-programme.component.html',
  styleUrls: ['./admin-add-programme.component.css']
})
export class AdminAddProgrammeComponent implements OnInit {
  @Output()
  saveProgramme = new EventEmitter<StudyProgramme>();

  newProgramme:StudyProgramme;
  name:string;
  constructor(private studyProgrammeService : StudyProgrammeService) { }

  ngOnInit() {
    this.newProgramme = {
      name: ''
    }as StudyProgramme
  }

  saveStudyProgramme(){
    if(this.newProgramme.name.length < 3)
    {
      alert("Morate uneti naziv programa!");
      return;
    }
    this.studyProgrammeService.saveStudyProgramme(this.newProgramme);

    this.saveProgramme.emit(this.newProgramme);
    this.newProgramme = {
      name: ''
    }as StudyProgramme
  }

}

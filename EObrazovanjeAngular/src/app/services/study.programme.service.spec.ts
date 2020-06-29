import { TestBed } from '@angular/core/testing';

import { StudyProgrammeService } from './study.programme.service';

describe('Study.ProgrammeService', () => {
  let service: StudyProgrammeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudyProgrammeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

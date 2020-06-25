import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorDataEditComponent } from './professor-data-edit.component';

describe('ProfessorDataEditComponent', () => {
  let component: ProfessorDataEditComponent;
  let fixture: ComponentFixture<ProfessorDataEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfessorDataEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorDataEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

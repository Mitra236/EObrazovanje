import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminBooking2ListComponent } from './admin-booking2-list.component';

describe('AdminBooking2ListComponent', () => {
  let component: AdminBooking2ListComponent;
  let fixture: ComponentFixture<AdminBooking2ListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminBooking2ListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminBooking2ListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddObjetComponent } from './add-objet.component';

describe('AddObjetComponent', () => {
  let component: AddObjetComponent;
  let fixture: ComponentFixture<AddObjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddObjetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddObjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

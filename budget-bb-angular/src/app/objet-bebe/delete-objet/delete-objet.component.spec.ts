import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteObjetComponent } from './delete-objet.component';

describe('DeleteObjetComponent', () => {
  let component: DeleteObjetComponent;
  let fixture: ComponentFixture<DeleteObjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteObjetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteObjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

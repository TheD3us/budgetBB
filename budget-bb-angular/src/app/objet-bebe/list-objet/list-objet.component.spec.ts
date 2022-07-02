import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListObjetComponent } from './list-objet.component';

describe('ListObjetComponent', () => {
  let component: ListObjetComponent;
  let fixture: ComponentFixture<ListObjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListObjetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListObjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

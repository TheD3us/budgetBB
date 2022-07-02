import { TestBed } from '@angular/core/testing';

import { ObjetPourBebeService } from './objet-pour-bebe.service';

describe('ObjetPourBebeService', () => {
  let service: ObjetPourBebeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ObjetPourBebeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

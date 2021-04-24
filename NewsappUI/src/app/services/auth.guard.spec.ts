import { TestBed, ComponentFixture } from '@angular/core/testing';

import { AuthGuard } from './auth.guard';

describe('AuthGuard', () => {
  let guard: AuthGuard;
  let fixture: ComponentFixture<AuthGuard>

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthGuard);
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthGuard);
  });


});

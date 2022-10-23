import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-modal',
  template: `
  <div class="modal-header">
    <h4 class="modal-title" id="modal-title">Profile deletion</h4>
    <button type="button" class="btn-close" aria-describedby="modal-title" (click)="modal.dismiss('Cross click')"></button>
  </div>
  <div class="modal-body">
  <p>{{ confirmMessage }}</p>
    
  </div>
  <div class="modal-footer">
    <button type="button" class="btn btn-outline-secondary" (click)="confirmResponse.emit(false)">Cancel</button>
    <button type="button" class="btn btn-danger" (click)="confirmResponse.emit(true)">Ok</button>
  </div>
  `,
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit {

  @Input() public confirmMessage! : string;
  @Output() public confirmResponse : EventEmitter<boolean> = new EventEmitter<boolean>();
  constructor(public modal: NgbActiveModal) { }

  ngOnInit(): void {
  }

}

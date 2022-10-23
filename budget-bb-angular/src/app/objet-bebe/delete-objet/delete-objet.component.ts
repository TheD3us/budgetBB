import { Component, OnInit } from '@angular/core';
import { ObjetPourBebeService } from '../service/objet-pour-bebe.service';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from 'src/app/core/modal/modal.component';

@Component({
  selector: 'app-delete-objet',
  templateUrl: './delete-objet.component.html',
  styleUrls: ['./delete-objet.component.scss']
})
export class DeleteObjetComponent implements OnInit {
  id! : number;
  constructor(private objetBebeService : ObjetPourBebeService,
    private route : ActivatedRoute,
    private modalService : NgbModal,
    private router: Router   ) { }

  ngOnInit(): void {
    
   const id = this.route.snapshot.paramMap.get('id');
   console.log(id)
   const modalRef : NgbModalRef = this.modalService.open(ModalComponent);
   const componentInstance : ModalComponent = modalRef.componentInstance;
    componentInstance.confirmMessage = "Etes vous sur de vouloir supprimer la ressource ?";
    componentInstance.confirmResponse.subscribe((b: boolean) => {
      if(b == true){
        this.objetBebeService.SuppObjetBebe(this.id);;
      }
      this.router.navigate(['list']);
      modalRef.close();
    })
  }
 

}

import { Component, Input } from '@angular/core';
import { ModalService } from 'src/app/core/services/modal.service';
import { ApiService } from 'src/app/core/services/api.service';
import { userID } from 'src/global';
import { AlertService } from 'src/app/core/services/alert.service';
import { HonourAward } from 'src/app/core/models/honour-award.model';

@Component({
    selector: 'card-ha',
    templateUrl: './honour-award.component.html',
    styleUrls: ['../cv.component.css']
})

export class HonourAwardComponent {

    constructor(
        public modalService: ModalService,
        private apiService: ApiService,
        private alertService: AlertService
    ) { }

    @Input() classname: string
    @Input() title: string;
    @Input() data: HonourAward[];

    editForm(item: HonourAward) {
        this.modalService.openModal(this.classname, false, item)
    }

    addForm() {
        this.modalService.openModal(this.classname, true)
    }

    deleteForm(object_id: string) {
        this.apiService.delete(userID, this.classname, object_id)
          .subscribe(() => {
            this.alertService.success("Successfully deleted!");
          })
    }
}

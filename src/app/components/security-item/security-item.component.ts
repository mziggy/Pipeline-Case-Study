import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Security } from 'src/app/models/security';
import { SecurityService } from '../../services/security.service';

@Component({
  selector: 'app-security-item',
  templateUrl: './security-item.component.html',
  styleUrls: ['./security-item.component.css']
})
export class SecurityItemComponent implements OnInit {
  @Input() security: Security;
  @Output() deleteSecurity: EventEmitter<Security> = new EventEmitter();
  constructor(private securityService: SecurityService) { }

  ngOnInit() {
  }
   // Set Dynamic classes
   setClasses() {
    let classes = {
      security: true,
      'is-complete': this.security.completed
    }

    return classes;
  }

  onToggle(security) {
    // toggle in ui
    console.log('toggle');
    security.completed = !security.completed;

    // toggle on server
    this.securityService.toggleCompleted(security).subscribe(security =>
      console.log(security));

  }

  onDelete(security) {
    this.deleteSecurity.emit(security);
  }

}

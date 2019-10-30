import { Component, OnInit, Input } from '@angular/core';
import { StorageService } from '../storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-broker',
  templateUrl: './broker.component.html',
  styleUrls: ['./broker.component.css']
})
export class BrokerComponent implements OnInit {

  customers: { name: string,   cid: string } [] = [
    { name: 'Shaughn Seepaul', cid: 'c121'},
    { name: 'Molly Vonada',    cid: 'c213'},
    { name: 'Dre Will',        cid: 'c654'},
    { name: 'Briana Mayes',    cid: 'c524'},
    { name: 'Ali Fallah',      cid: 'c575'},
    { name: 'Claire Betz',     cid: 'c426'},
    { name: 'Sumra Gil',       cid: 'c347'}
  ];
  constructor( private service: StorageService,
               public router: Router) { }


  ngOnInit() {
    console.log('Broker Id: ' + this.service.getBId());
  }

  openCust(i) {
    this.service.setCId(this.customers[i].cid);
    this.router.navigate(['/portfolio']);
  }

  myFunction() {
    // tslint:disable-next-line: one-variable-per-declaration
    let input, filter, table, tr, td, i, txtValue;
    let exists;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    table = document.getElementById('port-table');
    tr = table.getElementsByTagName('tr');

  // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
      exists = false;
      td = tr[i].getElementsByTagName('td')[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          exists = true;
        }
      }
      td = tr[i].getElementsByTagName('td')[1];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          exists = true;
        }
      }
      console.log(tr[i].className);
      if (exists || tr[i].className === 'header') {
        // search exists in table and the element isn't the header
        tr[i].style.display = '';
      } else {
        tr[i].style.display = 'none';
      }
    }
  }

}

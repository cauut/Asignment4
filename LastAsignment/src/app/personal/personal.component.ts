import { Component, OnInit } from '@angular/core';
import { DataService } from "../services/data.service";
@Component({
  selector: 'app-personal',
  templateUrl: './personal.component.html',
  styleUrls: ['./personal.component.css']
})
export class PersonalComponent implements OnInit {
  person: Personal;
  people: Personal[];
  peopleSearch: Personal[];
  showModifiedForm = false;
  titleButtonModifiedForm = 'Show Input';
  nameActiveButton='Add Person';

  constructor(private dataService: DataService) {
    this.person={
      "id":null,
      "name": '',
      "birthday": null,
      "address": ''
    }
  }
  eventClickInput() {
    this.showModifiedForm = !this.showModifiedForm;
    if (this.showModifiedForm == false) this.titleButtonModifiedForm = 'Show Input';
    else {
    this.titleButtonModifiedForm = 'Hide Input';
      if (this.person.id == null) this.nameActiveButton = 'Add Person';
      else this.nameActiveButton = 'Update Person';
    }
  }
  updateBtn(person){
    this.person = person;
    if(this.showModifiedForm==false)
    this.eventClickInput();
  }

  modifiedData() {
    if (this.person.id == null) {
      var personCreate = {
        "name": this.person.name,
        "birthday": this.person.birthday,
        "address": this.person.address,
        
      };
      this.createPerson(personCreate);
    }
    else this.updatePerson(this.person);
    this.person={
      "id":null,
      "name": '',
      "birthday": null,
      "address": ''
    }
    this.eventClickInput();
  }


  ngOnInit() {
    this.getAllPersonal();
    // this.searchPersonal('TaoLaViet');
  }
  getAllPersonal() {
    this.dataService.getPersonal().subscribe((personal) => {
      this.people = personal;
      console.log(this.people);
    })
  }

  updatePerson(person) {
    this.dataService.editPersonal(person);
    this.ngOnInit();
  }

  createPerson(person) {
    this.dataService.addPersonal(this.person);
    this.ngOnInit();
  }
  deletePerson(id) {
    this.dataService.deletePersonal(id);
    this.ngOnInit();
  }

  // searchPersonal(key){
  //   var pattern= '%';
  //   for(var x=0; x < key.length; x++)
  //   pattern+= key[x] + '%';
  //   this.peopleSearch = this.people;
  //   for(var i =0; i < this.people.length; i++){
  //     var t = this.people[i].name.match(pattern);
  //     if(t!=null && t)console

  //   }


  //   console.log(pattern);
  // }
}

interface Personal {
  "id": Number,
  "name": string,
  "birthday": Date,
  "address": string
}

import { Component, OnInit } from '@angular/core';
import { RouterModule,Router,ActivatedRoute } from '@angular/router';
import { DataService} from '../services/data.service';
@Component({
  selector: 'app-timesheets',
  templateUrl: './timesheets.component.html',
  styleUrls: ['./timesheets.component.css']
})
export class TimesheetsComponent implements OnInit {
  person: Personal;
  people: Personal[];
  peopleShow: Personal[];
  project: Project;
  constructor(private router: Router,private route:ActivatedRoute,private dataService: DataService) {
    this.people=[];
    this.getAllPersonal();
    this.filterPeople('duct');
    // console.log(this.peopleShow);

    // this.peopleShow = this.people;
   }

  ngOnInit() {
    this.project = this.dataService.project;
    this.dataService.project = null;
    console.log(this.project);
  }
  getAllPersonal() {
    this.dataService.getPersonal().subscribe((person)=>{
      this.people = person;
      this.peopleShow = person;
      // console.log(this.people);
    })
  }
  filterPeople(key){
    console.log(this.people.length);
    if(this.people.length!=null && this.people.length>0)
    for(var i = 0 ; i <this.people.length; i++){
      if(this.regexPattern(key, this.people[i].name)){
        this.peopleShow.push(this.people[i]);
        console.log('true');
      }
    }
  }
  regexPattern(key, object){
    var pattern ='';

    for(var i=0; i < key.length; i++)
    pattern += '['+key[i] + ']*';
    var thunghiem = 'hung viet';
    // console.log(pattern);
    var test = object.match(pattern);
    // console.log(test);  
    if(test!=null && test){
      return true;
    }else return false
  }
  

}
interface Project{
  description:string,
  id:Number,
  name:string,
  startDate: Date,
  endDate: Date
}
interface Personal {
  "id": Number,
  "name": string,
  "birthday": Date,
  "address": string
}

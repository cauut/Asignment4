import { Injectable } from '@angular/core';
import { Http,Response,Headers } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class DataService {
  project: any;
  personal: any;
  private header = new Headers({'Content-Type': 'application/json'});

  constructor(public http:Http) {
    console.log('Service run');
  }
  getUser(){
    return this.http.get('http://localhost:8080/AsignmentFresher12/api/personal')
    .map(res=>res.json());
  }
  addUser(userObj){
    this.http.post('http://localhost:8080/AsignmentFresher12/api/personal/',userObj).subscribe((res:Response)=>{
      // this.isAdded=true;
      // this.route.navigate("/");
      });
  }
  editUser(user){

    const url =`${"http://localhost:8080/AsignmentFresher12/api/personal/"}/${user.id}`;
    this.http.put(url, JSON.stringify(user), {headers:this.header}).toPromise()
    .then(()=>{
      console.log("updated");
    });
  }

  /////////////////////////service for Project:

  getProject(){
    return this.http.get('http://localhost:8080/AsignmentFresher12/api/project')
    .map(res=>res.json());
  }
  addProject(userObj){
    this.http.post('http://localhost:8080/AsignmentFresher12/api/project/',userObj).subscribe((res:Response)=>{
      // this.isAdded=true;
      // this.route.navigate("/");
      });
  }
  editProject(user){

    const url =`${"http://localhost:8080/AsignmentFresher12/api/project/"}/${user.id}`;
    this.http.put(url, JSON.stringify(user), {headers:this.header}).toPromise()
    .then(()=>{
      console.log("updated");
    });
  }
  deleteProject(id){

  }
  ///////////////////////////////////////////////////
  /// service personal
  getPersonal(){
    return this.http.get('http://localhost:8080/AsignmentFresher12/api/personal')
    .map(res=>res.json());
  }
  addPersonal(userObj){
    this.http.post('http://localhost:8080/AsignmentFresher12/api/personal/',userObj).subscribe((res:Response)=>{
      // this.isAdded=true;
      // this.route.navigate("/");
      });
  }
  editPersonal(personal){

    const url =`${"http://localhost:8080/AsignmentFresher12/api/personal/"}/${personal.id}`;
    this.http.put(url, JSON.stringify(personal), {headers:this.header}).toPromise()
    .then(()=>{
      console.log("updated");
    });
  }

  deletePersonal(id){
    if(confirm('Are you sure???')){
      const url =`${"http://localhost:8080/AsignmentFresher12/api/personal"}/${id}`;
      return this.http.delete(url,{headers:this.header}).toPromise()
      .then(()=>{
        console.log('deleted '+ id);
      })
    }
  }

  //////////////////////////service for time sheet////////////////////////////////////////

  getTimeSheet(){
    return this.http.get('http://localhost:8080/AsignmentFresher12/api/personal')
    .map(res=>res.json());
  }
  addTimeSheet(userObj){
    this.http.post('http://localhost:8080/AsignmentFresher12/api/personal/',userObj).subscribe((res:Response)=>{
      // this.isAdded=true;
      // this.route.navigate("/");
      });
  }
  editTimeSheet(personal){

    const url =`${"http://localhost:8080/AsignmentFresher12/api/personal/"}/${personal.id}`;
    this.http.put(url, JSON.stringify(personal), {headers:this.header}).toPromise()
    .then(()=>{
      console.log("updated");
    });
  }

  deleteTimeSheet(id){
    if(confirm('Are you sure???')){
      const url =`${"http://localhost:8080/AsignmentFresher12/api/personal"}/${id}`;
      return this.http.delete(url,{headers:this.header}).toPromise()
      .then(()=>{
        console.log('deleted '+ id);
      })
    }
  }
}


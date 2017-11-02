import { Component, OnInit } from '@angular/core';
import {DataService} from '../services/data.service';
import { RouterModule,Router } from '@angular/router';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
  project: Project;
  projectList: Project[];
  showModifiedForm = false;
  titleButtonModifiedForm = 'Show Input';
  nameActiveButton='Add Project';

  constructor(private dataService: DataService, private router: Router) {
    this.project={
      "id":null,
      "name": '',
      "description": '',
      "startDate": null,
      "endDate": null,
    }
  }
  eventClickInput() {
    this.showModifiedForm = !this.showModifiedForm;
    if (this.showModifiedForm == false) this.titleButtonModifiedForm = 'Show Input';
    else {
    this.titleButtonModifiedForm = 'Hide Input';
      if (this.project.id == null) this.nameActiveButton = 'Add Project';
      else this.nameActiveButton = 'Update Project';
    }
  }
  updateBtn(project){
    this.project = project;
    if(this.showModifiedForm==false)
    this.eventClickInput();
  }

  modifiedData() {
    if (this.project.id == null) {
      var projectCreate = {
        "name": this.project.name,
        "description": this.project.description,
        "startDate": this.project.startDate,
        "endDate": this.project.endDate,
        
      };
      this.createProject(projectCreate);
    }
    else this.updateProject(this.project);
    this.eventClickInput();
  }


  ngOnInit() {
    this.getAllProject();
  }
  getAllProject() {
    this.dataService.getProject().subscribe((project) => {
      this.projectList = project;
      console.log(this.projectList);
    })
  }

  updateProject(project) {
    this.dataService.editProject(project);
    this.ngOnInit();
  }

  createProject(project) {
    this.dataService.addProject(project);
    this.ngOnInit();
  }
  deleteProject(id) {
    this.dataService.deleteProject(id);
    this.ngOnInit();
  }
  navigateToTimeSheet(project){
    this.dataService.project = project;
    this.router.navigate(['/timesheet']);
  }
}
interface Project{
  description:string,
  id:Number,
  name:string,
  startDate: Date,
  endDate: Date
}

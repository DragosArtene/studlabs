import {Component, Input, OnInit} from '@angular/core';
import {QuestionService} from '../../services/question-service/question.service';
import {Question} from '../../model/question';
import {MatDialogConfig, MatExpansionModule} from '@angular/material';
import {MatDialog} from '@angular/material';
import {QuestionDialogComponent} from '../qestion-dialog/question-dialog.component';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {
  @Input() idQuiz: number
  questions: Question[];
  questionToBeAdded: Question;
  newid: number;

  constructor(private questionService: QuestionService, public dialog: MatDialog) { }

  ngOnInit(){
    this.update();
  }
  update(){
    this.questionService.getAllQuestionsOfQuiz(this.idQuiz).subscribe(questions => {
      this.questions = questions;
      console.log(" a intrat in  in ng init in ts"+ this.questions[0]);
    });


  }

  openDialog(){
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    let questionDialog=this.dialog.open(QuestionDialogComponent,dialogConfig);

    questionDialog.afterClosed().subscribe(questionToBeAdded=>{
      this.questionToBeAdded=questionToBeAdded;
       console.log("received question: "+this.questionToBeAdded.category+"  "+this.questionToBeAdded.deprecated+" "+ this.questionToBeAdded.difficulty);
       //TODO adds just a question , create function that assignes;
      this.questionService.addQuestion(questionToBeAdded).subscribe(newid=>{
        console.log("id is after add question   "+newid);
        this.newid=newid;
        console.log("new id is : "+this.newid)
        this.questionService.assignQuestion( this.newid, this.idQuiz).subscribe(()=>{
          this.update();
        })
       // this.update();
      });

    });
  }


  }




import {Component, OnInit} from '@angular/core';
import {Question} from '../../model/question';
import {MatDialogRef} from '@angular/material';
import {QuestionDifficulty} from '../../model/questionDifficulty';

@Component({
  selector: 'app-question-dialog',
  templateUrl: './question-dialog.component.html',
  styleUrls: ['./question-dialog.component.css']
})
export class QuestionDialogComponent implements OnInit {
 question: Question;
  levels: string[]=["EASY","MODERATE","HARD"];
  description: string;
  category : string;
  difficulty: string;
  deprecated: boolean;
  newid: number;
  constructor(private dialogRef: MatDialogRef<QuestionDialogComponent>,) { }

  ngOnInit() {

  }
  closeD(){
    if (this.difficulty=="EASY"){
      this.question={idQuestion: -1, description: this.description, category: this.category, difficulty: QuestionDifficulty.EASY, deprecated: this.deprecated};
    }else if(this.difficulty=="HARD"){
      this.question={idQuestion: -1, description: this.description, category: this.category, difficulty: QuestionDifficulty.HARD, deprecated: this.deprecated};

    }else{
       this.question={idQuestion: -1, description: this.description, category: this.category, difficulty: QuestionDifficulty.MODERATE, deprecated: this.deprecated};
    }
    this.dialogRef.close(this.question);
 }
}

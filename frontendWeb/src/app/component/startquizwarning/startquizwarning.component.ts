import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogConfig, MatDialogRef} from '@angular/material';
import {QuestionDialogComponent} from '../qestion-dialog/question-dialog.component';
import {QuestionDifficulty} from '../../model/questionDifficulty';

@Component({
  selector: 'app-startquizwarning',
  templateUrl: './startquizwarning.component.html',
  styleUrls: ['./startquizwarning.component.css']
})
export class StartquizwarningComponent implements OnInit {
  yesno: boolean
  constructor(private dialogRef: MatDialogRef<StartquizwarningComponent>,@Inject(MAT_DIALOG_DATA) public data:any) { }

  ngOnInit() {
  }
  closeDY(){
    this.yesno=true;
    this.dialogRef.close(this.yesno);
  }
  closeDN(){
    this.yesno=false;
    this.dialogRef.close(this.yesno);
  }
}

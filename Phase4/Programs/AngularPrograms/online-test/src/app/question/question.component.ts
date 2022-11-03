import { Component, Injectable, OnInit } from '@angular/core';
import { CompletionTriggerKind } from 'typescript';
import { Question } from '../question'
import { Answer } from '../answer'
import { QuestionService } from '../question.service'

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})

export class QuestionComponent implements OnInit {
  questionsInfo:Array<Question>=[]
  answerInfo:Array<Answer>=[] ;
  questionIndex:number ;
  questionCount:number ;
  nextEnable:boolean ;
  prevEnable:boolean ;

  constructor( public qs:QuestionService) 
  { 
    this.questionIndex = 1 ;
    this.prevEnable=false ;
    this.nextEnable=true ;
    this.questionCount= 0 ;
  }
  myAnswer = new Map ;
  ngOnInit(): void {
    this.qs.loadAnswers().subscribe({
      next:(data:any)=>this.answerInfo=data.answers,
      error:(error:any)=>console.log(error) ,
      complete:()=>console.log("done")     })
  }
  loadQuestionDetails()
  {
    this.qs.loadAllQuestion().subscribe({
      next:(data:any)=>this.questionsInfo=data.questions,
      error:(error:any)=>console.log(error) ,
      complete:()=>{console.log("done") ; this.questionCount = this.questionsInfo.length ; } 
    })
  }
  onSubmitTest(): void
  {

  }
  onNextQuestion(): void
  {
    this.prevEnable=true ;
    if ( this.questionIndex < this.questionsInfo.length) 
      ++this.questionIndex ;
    else this.nextEnable=false ;
  }
  onPreviousQuestion() : void
  {
    this.nextEnable=true ;
    if ( this.questionIndex > 1 )
      --this.questionIndex ;
    else this.prevEnable=false ;
  }
  storAns( qid:any, ans:any )
  {
    this.myAnswer.set( qid, ans ) ;
    console.log( this.myAnswer ) ;
  }
  submitExam()
  {
    console.log( this.myAnswer) ;
    console.log( this.answerInfo)
  }

}

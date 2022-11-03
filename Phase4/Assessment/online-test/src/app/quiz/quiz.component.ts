import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HighlightSpanKind } from 'typescript';
import { Question } from '../question'
//import { Answer } from '../answer'
import { QuestionService } from '../question.service'


@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})

export class QuizComponent implements OnInit {
  questionsInfo:Array<Question>=[]
  //answerInfo:Array<Answer>=[] ;
  questionIndex:number ;
  questionCount:number ;
  answerCount:number ;
  nextEnable:boolean ;
  prevEnable:boolean ;
  submitEnable:boolean ;
  inProgress:boolean ;

  uAnswer:string ;

  constructor( public qs:QuestionService, public router:Router) 
  { 
    this.questionIndex = 1 ;
    this.prevEnable=false ;
    this.nextEnable=true ;
    this.submitEnable=false ;
    this.questionCount= 0 ;
    this.answerCount = 0 ;
    this.uAnswer='' ;
    this.inProgress = false ;
  }
  userAnswer = new Map ;
  ngOnInit(): void {
    //this.qs.loadAnswers().subscribe({
    //  next:(data:any)=>this.answerInfo=data.answers,
     // error:(error:any)=>console.log(error) ,
     // complete:()=>console.log("done")     })
  }
  loadQuestionDetails()
  {
    this.qs.loadQuestions().subscribe({
      next:(data:any)=>this.questionsInfo=data.questions,
      error:(error:any)=>console.log(error) ,
      complete:()=>{
        console.log("done") ; 
        this.questionCount = this.questionsInfo.length ; 
        this.inProgress = true ;
      } 
    })
  }
  
  
  replacer(key:any, value:any) {
    if(value instanceof Map) {
      return {
        dataType: 'Map',
        value: Array.from(value.entries()) 
      };
    } else {
      return value;
    }
  }

  JsonString:string = "" ;
  onSubmitTest(): void
  {
    this.inProgress = false ;
    this.JsonString = JSON.stringify( Array.from(this.userAnswer.entries()) ) ; 
    localStorage.setItem( "user_answers", this.JsonString ) ;
    
    //Array.from( this.userAnswer ) ;
    this.router.navigate(["result"]) ;
    
  }
  onNextQuestion(): void
  {
    this.prevEnable=true ;
    if ( this.questionIndex < this.questionsInfo.length) 
      ++this.questionIndex ;
    else this.nextEnable=false ;
    this.uAnswer = this.userAnswer.get( this.questionIndex ) ;
  }
  onPreviousQuestion() : void
  {
    this.nextEnable=true ;
    if ( this.questionIndex > 1 )
      --this.questionIndex ;
    else this.prevEnable=false ;
    this.uAnswer = this.userAnswer.get( this.questionIndex ) ;
  }
  storAns( qid:any, ans:any )
  {
    this.userAnswer.set( qid, ans ) ;
    this.answerCount = this.userAnswer.size ;
    this.submitEnable = ( this.userAnswer.size < this.questionsInfo.length ? false : true ) ;
    console.log( this.userAnswer ) ;
  }
}

import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../question.service';
import { Question } from '../question'

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  uAnswer:string ;
  userAnswerMap:Map<number,string> ;
  userAnswerArray:Array<[number, string]> = [] ;
  questionCount:number ;
  questionIndex:number ;
  questionsInfo:Array<Question>=[] ;
  userScore:number ;
  constructor( public qs:QuestionService) 
  { 
      this.uAnswer='' ; 
      this.questionIndex=1 ;
      this.questionCount=0 ;
      this.userAnswerMap = new Map() ;
      this.userScore = 0 ;
  }

  ngOnInit(): void {
    this.qs.loadQuestions().subscribe({
      next:(data:any)=>this.questionsInfo=data.questions,
      error:(error:any)=>console.log(error) ,
      complete:()=>{console.log("done") ; this.onQuestionsLoaded() ; } 
    }) ;
  }
  restoreUserAnswers() : void
  {
    let str:any = localStorage.getItem( 'user_answers' ) ;
    console.log( str ) ;
    
    this.userAnswerArray = JSON.parse( str ) ;
    console.log( this.userAnswerArray ) ;
  }
  calculateUserScore() : number 
  {
    let correctCount:number = 0 ;
    let index:number = 0 ;
    while( index < this.questionCount )
    { 
      if( this.questionsInfo[index].answer == this.userAnswerArray[index][1] )
        ++correctCount ;
      ++index ;
    }
    return ( correctCount / this.questionCount ) * 100 ;
  }
  onQuestionsLoaded()
  {
    this.questionCount = this.questionsInfo.length ;
    this.restoreUserAnswers() ;
    this.userScore = this.calculateUserScore() ;
  }
}

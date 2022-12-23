import {Component, OnInit} from '@angular/core';
import {Word} from "./word";
import {WordService} from "./word.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public words: Word[] | undefined;
  constructor(private wordService: WordService) { }
  ngOnInit(): void {
    this.getWords();
  }

  public getWords(): void{
    this.wordService.getWords().subscribe(
      (response:Word[]) =>{
        this.words = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}

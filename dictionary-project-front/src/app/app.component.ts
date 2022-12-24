import {Component, OnInit} from '@angular/core';
import {Word} from "./word";
import {WordService} from "./word.service";
import {HttpErrorResponse} from "@angular/common/http";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  closeResult:string = '';
  public words: Word[] | undefined;
  constructor(private wordService: WordService,
              private modalService: NgbModal) { }
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
  public onOpenModal(word: Word | any, mode: string): void{

    const container = document.getElementById('main-container')

    const button = document.createElement('button');

    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if(mode === 'add'){
      button.setAttribute('data-target', '#addWordModal');
    }
    if(mode === 'edit'){
      button.setAttribute('data-target', '#editWordModal');
    }
    if(mode === 'delete'){
      button.setAttribute('data-target', '#deleteWordModal');
    }

    container?.appendChild(button);
    button.click();
  }


}

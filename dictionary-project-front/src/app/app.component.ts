import {Component, OnInit} from '@angular/core';
import {Word} from "./word";
import {WordService} from "./word.service";
import {HttpErrorResponse} from "@angular/common/http";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NgForm} from "@angular/forms";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  closeResult: string = '';
  public words: Word[] | undefined;
  constructor(private wordService: WordService) {
  }

  ngOnInit(): void {
    this.getWords();
  }

  public getWords(): void {
    this.wordService.getWords().subscribe(
      (response: Word[]) => {
        this.words = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public editWord: Word;
  public deleteWord: Word;
  public onAddWord(addForm: NgForm): void {
    document.getElementById('add-word-form')?.click()
    this.wordService.addWord(addForm.value).subscribe(
      (response: Word) => {
        console.log(response);
        this.getWords();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public onEditWord(word: Word): void {

    this.wordService.updateWord(word).subscribe(
      (response: Word) => {
        console.log(response);
        this.getWords();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteWord(wordId: number): void {

    this.wordService.deleteWord(wordId).subscribe(
      (response: void) => {
        console.log(response);
        this.getWords();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(word: Word | any, mode: string): void {

    const container = document.getElementById('main-container')

    const button = document.createElement('button');

    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'add') {
      button.setAttribute('data-target', '#addWordModal');
    }
    if (mode === 'update') {
      this.editWord = word;
      button.setAttribute('data-target', '#editWordModal');
    }
    if (mode === 'delete') {
      this.deleteWord = word;
      button.setAttribute('data-target', '#deleteWordModal');
    }

    container?.appendChild(button);
    button.click();
  }
}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-questionaire',
  templateUrl: './questionaire.component.html',
  styleUrls: ['./questionaire.component.css']
})
export class QuestionaireComponent {
  donorId: number =0;
  questions = [
    { question: 'Da li ste primili vakcinu u poslednjih 12 meseci?', key: 'isVaccinatedRecently', answer: '' },
    { question: 'Da li ste u protekla 2-3 dana uzimali brufen?', key: 'takingMedicine', answer: '' },
    { question: 'Da li ste uzimali aspirin u proteklih 5 dana?', key: 'hadAspirin', answer: '' },
    { question: 'Da li ste pili alkohol u proteklih 6 sati?', key: 'hasDrunkAlcohol', answer: '' },
    { question: 'Da li ste imali ubode krpelja u proteklih 12 meseci?', key: 'hadTickLymeDisease', answer: '' },
    { question: 'Da li ste imali kijavicu, prehladu, temperaturu preko 38C u proteklih 10 dana?', key: 'hadFever', answer: '' },
    { question: 'Da li ste imali akupunkturu, pirsing ili tetovazu u proteklih 6 meseci?', key: 'didTattoosOrPiercing', answer: '' },
    { question: 'Da li ste primili krv ili imali neku operaciju u proteklih 6 meseci?', key: 'recievedBloodorOperated', answer: '' },
    { question: 'Da li ste bolovali ili bolujete od hepatitisa A,B ili C?', key: 'hasHepatitis', answer: '' },
    { question: 'Da li mislite da postojala mogucnost da se zarazite HIV-om?', key: 'hasHIV', answer: '' },
    { question: 'Da li ste ikada koristili bilo koju vrstu droge?', key: 'hasTakenDrugs', answer: '' }
  ];

  isFormValid = true;
  isSubmitted = false;

  submitAnswers() {
    this.isFormValid = this.questions.every(q => q.answer !== '');
    if (this.isFormValid) {
      const data: Questionnaire = {
        donorId: this.donorId,
        isVaccinatedRecently: this.questions.find(q => q.key === 'isVaccinatedRecently')?.answer === 'Yes',
        takingMedicine: this.questions.find(q => q.key === 'takingMedicine')?.answer === 'Yes',
        hadAspirin: this.questions.find(q => q.key === 'hadAspirin')?.answer === 'Yes',
        hasDrunkAlcohol: this.questions.find(q => q.key === 'hasDrunkAlcohol')?.answer === 'Yes',
        hadTickLymeDisease: this.questions.find(q => q.key === 'hadTickLymeDisease')?.answer === 'Yes',
        hadFever: this.questions.find(q => q.key === 'hadFever')?.answer === 'Yes',
        didTattoosOrPiercing: this.questions.find(q => q.key === 'didTattoosOrPiercing')?.answer === 'Yes',
        recievedBloodorOperated: this.questions.find(q => q.key === 'recievedBloodorOperated')?.answer === 'Yes',
        hasHepatitis: this.questions.find(q => q.key === 'hasHepatitis')?.answer === 'Yes',
        hasHIV: this.questions.find(q => q.key === 'hasHIV')?.answer === 'Yes',
        hasTakenDrugs: this.questions.find(q => q.key === 'hasTakenDrugs')?.answer === 'Yes'
      };
      console.log(data);
      this.isSubmitted = true;
    }
  }
}

export interface Questionnaire {
  donorId: number;
  isVaccinatedRecently: boolean;
  takingMedicine: boolean;
  hadAspirin: boolean;
  hasDrunkAlcohol: boolean;
  hadTickLymeDisease: boolean;
  hadFever: boolean;
  didTattoosOrPiercing: boolean;
  recievedBloodorOperated: boolean;
  hasHepatitis: boolean;
  hasHIV: boolean;
  hasTakenDrugs: boolean;
}
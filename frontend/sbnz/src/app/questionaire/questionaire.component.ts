import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-questionaire',
  templateUrl: './questionaire.component.html',
  styleUrls: ['./questionaire.component.css']
})
export class QuestionaireComponent {


  constructor(private http: HttpClient, private router: Router){

  }

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
  donor: Donor | undefined;
  sample: BloodSampleDto | undefined;

  resetQuestionaire(){
    window.location.reload();
  }

  isString(value: any): boolean {
    return typeof value === 'string';
  }

  donateBlood() {
    this.http.post<BloodSampleDto>(`http://localhost:8080/giveBlood`, this.sample).subscribe();
    window.location.reload();
  }

  testSample() {
    this.http.get<BloodSampleDto>(`http://localhost:8080/testBlood/${this.donor!.id}`).subscribe({
      next: (result)=> {
        if(result.canDonate == false){
          const bannedUntilDate = new Date(result.bannedUntil[0],result.bannedUntil[1]-1,result.bannedUntil[2]);
          const currentDate = new Date();
          if(bannedUntilDate.getTime() - currentDate.getTime() < 100 * 365 * 24 * 60 * 60 * 1000){
            result.bannedUntil = bannedUntilDate;
          }
          else{
            result.bannedUntil = "Zauvek"
          }
        }
        this.sample = result
        console.log(this.sample);
      }
    })
  }

  submitAnswers() {
    this.isFormValid = this.questions.every(q => q.answer !== '');
    if (this.isFormValid) {
      const data: Questionnaire = {
        donorId: this.donorId,
        vaccinatedRecently: this.questions.find(q => q.key === 'isVaccinatedRecently')?.answer === 'Yes',
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
      this.http.post<Donor>("http://localhost:8080/questionaire",data).subscribe({
        next: (result) => {console.log(result)
          if(result.canDonate == false){
            const bannedUntilDate = new Date(result.bannedUntil[0],result.bannedUntil[1]-1,result.bannedUntil[2]);
            const currentDate = new Date();
            if(bannedUntilDate.getTime() - currentDate.getTime() < 100 * 365 * 24 * 60 * 60 * 1000){
              result.bannedUntil = bannedUntilDate;
            }
            else{
              result.bannedUntil = "Zauvek"
            }
          }
          this.donor = result;
        }
      })
    }
  }
}

export interface Questionnaire {
  donorId: number;
  vaccinatedRecently: boolean;
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
export interface Donor {
  id:number,
  numberOfDonations:number,
  canDonate:boolean,
  lastDonated:any,
  bannedUntil:any}

export interface BloodSampleDto {
    id: number;
    donorId: number;
    bloodType: string;
    rhD: boolean;
    rhPhenotype: string;
    hivPositive: boolean;
    hepatitisBPositive: boolean;
    hepatitisCPositive: boolean;
    syphilisPositive: boolean;
    useEritrocitesOnly: boolean;
    canDonate: boolean;
    bannedUntil: any; 
}

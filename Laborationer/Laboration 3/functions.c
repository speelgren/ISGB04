//
//  functions.c
//  Laboration 3
//
//  Created by
//  Robin Johansson Speelgren
//  Anna-Maria Paleczek
//  on 2022-11-26.
//

#include "header.h"

void randomWrite(FILE *fp, int rows) {
    
    srand((int)time(NULL));
    
    int lottery[7]; // reserverar rätt antal platser i lottery.
    char lotteryStr[3]; //varje tal i vektorn lottery sparas som 3 tecken (se %2i på rad 46).
    
    for(int i = 0; i < rows; i++) {
        
        for(int j = 0; j < 7; j++) {
         
            lottery[j] = rand() % 35 + 1;
        }

        // Algoritm för att hantera dubbletter.
        for(int k = 0; k < 7; k++) {
            
            for(int l = 0; l < 7; l++) {
                
                int temp = lottery[k];
                lottery[k] = 0;
                
                while(temp == lottery[l]) {
                    
                    temp = rand() % 35 + 1; // varje dubblett tilldelas ett nytt random tal.
                }
                
                lottery[k] = temp;
            }
        }
        
        for(int m = 0; m < 7; m++) {
            
            sprintf(lotteryStr, "%2i", lottery[m]); // använder sprintf för att omvandla och lagra en int från lottery till char i lotteryStr.
            printf("%s ", lotteryStr);
            
            fputs(lotteryStr, fp); // skriver lotteryStr till fil.
            fputs(" ", fp);
            
            if((m + 1) % 7 == 0) {
                
                printf("\n");
                fputc('\n', fp); // lägger till ett nyradstecken vid var 7:e tal.
            }
        }
    }
}

FILE *openfile(char fileName[]) {
    
  FILE *fp;
  if ((fp = fopen(fileName, "r+")) == NULL)
    if ((fp = fopen(fileName, "w+")) == NULL) {
        
      printf("Could not read file\n");
      return NULL;
  }
    
  return fp;
}

void readFile(FILE *fp) {
    
    char t;
    t = fgetc(fp);
    
    while(!feof(fp)) {
        
        printf("%c", t);
        t = fgetc(fp);
    }
}
